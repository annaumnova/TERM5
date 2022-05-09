package lab4.model

import lab4.model.Cell.* // ... .Cell. ...
//import lab4.model.MovesDirectons.*
import lab4.model.State.*
import java.io.File

//# (x), - (empty), P (position), E (exit)
enum class Cell(private val textValue: String) {

    POS("P"), EXit("E"), WAlls("#"), EMPTY("-");

    //output
    override fun toString(): String = textValue
}

//move, win
enum class State(private val textValue: String) {
    MoVE("move!"), WIN("win!")
}

//moves and directions
enum class MovesDirectons(private val textValue: String) {
    LEFT("A"), UP("W"), DOWN("S"), RIGHT("D")
}

//4. for changes
interface ModelChangeListener {
    fun onModelChanged()
}

class Model {

    //1. create the play board "Labyrinth"
    val board: MutableList<MutableList<Cell>> = initBoard() //board
    var posPlayer = Pair(0, 0) //start position

    //parameters for board (columns and rows)
    var columns = 0
    var rows = 0

    //form the board with file
    private fun initBoard(): MutableList<MutableList<Cell>> {

        val labyrinth = File("src/main/kotlin/lab4/labyrint").readLines()

        //parameters for board (columns and rows)
        columns = labyrinth[0].length
        rows = labyrinth.size

        //create board for starting (all board is empty)
        val labyrinthBoard = MutableList(rows) { MutableList(columns) { EMPTY } }

        //filling the board with symbols
        for (i in 0 until rows)
            for (j in 0 until columns) {
                when (labyrinth[i][j]) { //4 cases:
                    //exit?
                    'E' -> labyrinthBoard[i][j] = EXit
                    //walls?
                    '#' -> labyrinthBoard[i][j] = WAlls
                    //position?
                    'P' -> {
                        labyrinthBoard[i][j] = POS
                        posPlayer = Pair(i, j)
                    }
                    else -> EMPTY
                }
            }

        return labyrinthBoard //the created play board
    }

    //2. do moves and change states
    var stateGame: State = MoVE
        private set

    fun doMove(direction: String) {
        //requires
        require(stateGame != WIN) { "game over" }

        //directions, 4 cases:
        when (direction) {
            "A" -> { //LEFT
                if (posPlayer.second > 0) {
                    when (board[posPlayer.first][posPlayer.second - 1]) {
                        EMPTY -> {
                            board[posPlayer.first][posPlayer.second] = EMPTY
                            board[posPlayer.first][posPlayer.second - 1] = POS
                            posPlayer = Pair(posPlayer.first, posPlayer.second - 1)
                        }
                        EXit -> {
                            board[posPlayer.first][posPlayer.second] = EMPTY
                            board[posPlayer.first][posPlayer.second - 1] = POS
                            stateGame = WIN
                        }
                        else -> {}
                    }
                }
            }
            "W" -> { //UP
                if (posPlayer.first > 0) {
                    when (board[posPlayer.first - 1][posPlayer.second]) {
                        EMPTY -> {
                            board[posPlayer.first][posPlayer.second] = EMPTY
                            board[posPlayer.first - 1][posPlayer.second] = POS
                            posPlayer = Pair(posPlayer.first - 1, posPlayer.second)
                        }
                        EXit -> {
                            board[posPlayer.first][posPlayer.second] = EMPTY
                            board[posPlayer.first - 1][posPlayer.second] = POS
                            stateGame = WIN
                        }
                        else -> {}
                    }
                }
            }
            "S" -> { //DOWN
                if (posPlayer.first > 0) {
                    when (board[posPlayer.first + 1][posPlayer.second]) {
                        EMPTY -> {
                            board[posPlayer.first][posPlayer.second] = EMPTY
                            board[posPlayer.first + 1][posPlayer.second] = POS
                            posPlayer = Pair(posPlayer.first + 1, posPlayer.second)
                        }
                        EXit -> {
                            board[posPlayer.first][posPlayer.second] = EMPTY
                            board[posPlayer.first + 1][posPlayer.second] = POS
                            stateGame = WIN
                        }
                        else -> {}
                    }
                }
            }
            "D" -> { //RIGHT
                if (posPlayer.second > 0) {
                    when (board[posPlayer.first][posPlayer.second + 1]) {
                        EMPTY -> {
                            board[posPlayer.first][posPlayer.second] = EMPTY
                            board[posPlayer.first][posPlayer.second + 1] = POS
                            posPlayer = Pair(posPlayer.first, posPlayer.second + 1)
                        }
                        EXit -> {
                            board[posPlayer.first][posPlayer.second] = EMPTY
                            board[posPlayer.first][posPlayer.second + 1] = POS
                            stateGame = WIN
                        }
                        else -> {}
                    }
                }
            }
            "E" -> stateGame = WIN //EXIT
            //wrong
//            LEFT -> playerMove(rows, columns - 1)
//            UP -> playerMove(rows - 1, columns)
//            DOWN -> playerMove(rows + 1, columns)
//            RIGHT -> playerMove(rows, columns + 1)
        }
        //call listeners?
        notifyListeners()
    }

//wrong
//    //player's moves
//    private fun playerMove(x: Int, y: Int) {
//        if ((x >= 0 && x <= board.size) && (y >= 0 && y <= board[0].size) &&
//            (board[x][y] == EMPTY || board[x][y] == EXit)
//        ) {
//            board[rows][columns] = EMPTY
//            board[x][y] = POS
//            rows = x
//            columns = y
//        } else println("impossible!")
//    }

    //3.output console
    override fun toString(): String {
        return buildString {
            append(stateGame).appendLine()
            board.forEach { append(it).appendLine() }
        }
    }

    //4. for changes
    private val listeners = mutableListOf<ModelChangeListener>()

    //after move in doMove
    private fun notifyListeners() = listeners.forEach { it.onModelChanged() }

    //for add
    fun addModelChangeListener(listener: ModelChangeListener) = listeners.add(listener)

    //for remove
    fun removeModelChangeListener(listener: ModelChangeListener) = listeners.remove(listener)

    //

    //5.

}