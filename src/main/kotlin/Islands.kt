import java.util.*

class Islands {

    fun numberOfIslandsDfs(matrix: MutableList<MutableList<Int>>) : Int {
        val rows = matrix.size
        val cols = matrix[0].size
        var totalIslands = 0

        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if (matrix[i][j] == 1) {
                    totalIslands++
                    visitIslandsBfs(matrix, i, j)
                }
            }
        }
        return totalIslands
    }

    private fun visitIslandsDfs(matrix: MutableList<MutableList<Int>>, x:Int, y: Int) {
        if (x < 0 || x >= matrix.size || y < 0 || y >= matrix[0].size ) {
            return
        } else if (matrix[x][y] == 0 ) {
            return
        }

        matrix[x][y] = 0

        visitIslandsDfs(matrix, x + 1, y)
        visitIslandsDfs(matrix, x - 1, y)
        visitIslandsDfs(matrix, x, y+1)
        visitIslandsDfs(matrix, x, y-1)

    }

    private fun visitIslandsBfs(matrix: MutableList<MutableList<Int>>, x: Int, y: Int) {
        var queue = LinkedList<Pair<Int, Int>>()
        queue.add(Pair(x,y))

        while (queue.isNotEmpty()) {
            val row = queue.peek().first
            val col = queue.peek().second
            queue.remove()

            if (row < 0 || row >= matrix.size || col < 0 || col >= matrix[0].size) {
                continue
            } else if (matrix[row][col] == 0) {
                continue
            }

            matrix[row][col] = 0

            queue.add(Pair(row + 1, col))
            queue.add(Pair(row -1 , col))
            queue.add(Pair(row, col+1))
            queue.add(Pair(row, col -1))
        }

    }

    fun biggestIsland(matrix: MutableList<MutableList<Int>>): Int {
        val rows = matrix.size
        val cols = matrix[0].size
        var biggestIsland = 0

        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if (matrix[i][j] == 1) {
                    biggestIsland = Math.max(biggestIsland, bigIslandVisitDfs(matrix, i, j))
                }
            }
        }
    return biggestIsland
    }

    fun bigIslandVisitDfs(matrix: MutableList<MutableList<Int>>, x: Int, y: Int) : Int {

        if (x < 0 || x >= matrix.size || y < 0 || y >= matrix[0].size) {
            return 0
        } else if (matrix[x][y] == 0 ) {
            return 0
        }
        matrix[x][y] = 0

        var area = 1
        area += bigIslandVisitDfs(matrix, x+ 1, y)
        area += bigIslandVisitDfs(matrix, x-1, y)
        area += bigIslandVisitDfs(matrix, x, y+1)
        area += bigIslandVisitDfs(matrix, x+ 1, y-1)
        return area
    }

//    fun bigIslandVisitBfs(matrix: MutableList<MutableList<Int>>, x:Int, y:Int) : Int {
//        var queue = LinkedList<Pair<Int, Int>>()
//
//        queue.add(Pair(x,y))
//
//        while (queue.isNotEmpty()) {
//            val row = queue.peek().first
//            val col = queue.peek().second
//            queue.remove()
//
//            if (row < 0 || row >= matrix.size|| col< 0 || col>= matrix[0].size) {
//                return 0
//            } else if (matrix[row][col] == 0 ) {
//                return 0
//            }
//
//            matrix[row][col] = 0
//
//
//
//            queue.add(Pair(row + 1, col))
//            queue.add(Pair(row - 1, col))
//            queue.add(Pair(row, col + 1))
//            queue.add(Pair(row, col - 1))
//        }
//
//
//    }

    fun floodFill(
        matrix: MutableList<MutableList<Int>>,
        startIndex: Pair<Int, Int>,
        newColor: Int
    ): MutableList<MutableList<Int>>  {
        val startRow = startIndex.first
        val startCol = startIndex.second
        val rows = matrix.size
        val cols = matrix[0].size
        val colorToChange = matrix[startRow][startCol]

        fun floodFillDfs(matrix: MutableList<MutableList<Int>>,x:Int, y:Int) {
            if (x < 0 || x >= matrix.size || y < 0 || y >= matrix.size) {
                return
            } else if (matrix[x][y] != colorToChange) {
                return
            }
            matrix[x][y] = newColor

            floodFillDfs(matrix, x+1, y)
            floodFillDfs(matrix,x-1, y)
            floodFillDfs(matrix, x, y+1)
            floodFillDfs(matrix,x, y-1)
        }


        for (i in startRow until rows) {
            for (j in startCol until cols) {
                if (matrix[i][j] == colorToChange) {
                    floodFillDfs(matrix, i, i)
                }
            }
        }
        return matrix
    }

    fun numberOfClosedIslands(matrix: MutableList<MutableList<Int>>) : Int {
        var count = 0
        var rows = matrix.size
        var cols = matrix[0].size

        for (i in 1 until rows -1) {
            for (j in 1 until cols - 1) {
                if (matrix[i][j] == 1) {
                    if (isClosedIsland(matrix, i, j)) {
                        count++
                    }
                }
            }
        }
        return count
    }

    private fun isClosedIsland(matrix: MutableList<MutableList<Int>>, x:Int, y: Int): Boolean {

        if (isPerimeter(matrix, x, y)) {
            return false
        } else if (matrix[x][y] == -1 || matrix[x][y] == 0) {
            return true
         }

        matrix[x][y] = -1

        val down = isClosedIsland(matrix, x + 1,y)
        val up = isClosedIsland(matrix, x -1,y)
        val right = isClosedIsland(matrix, x,y+1)
        val left = isClosedIsland(matrix, x ,y-1)

        return right && left && up && down
    }

    private fun isPerimeter(matrix: MutableList<MutableList<Int>>, x:Int, y:Int): Boolean {
        return x ==0 || x == matrix.size-1 || y==0 || y == matrix[0].size - 1
    }


}