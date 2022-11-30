class CyclicSort {

    fun cyclicSort(input:MutableList<Int>) : MutableList<Int> {

        var i = 0
        while (i < input.size) {
            var correctIndex = input[i] - 1
            if (input[i] != input[correctIndex]) {
                swapValues(input, i, correctIndex)
            } else {
                i++
            }
        }
       return input
    }

    fun findMissingNumber(input: MutableList<Int>) : Int {
        var i = 0
        while (i < input.size) {
            if (input[i] != input.size && input[i] != input[input[i]]) {
                swapValues(input, i, input[i])
            } else {
                i ++
            }
        }

        for (i in input.indices) {
            if (input[i] != i) {
                return i
            }
        }
        return 0
    }

    fun findAllMissingValues(input:MutableList<Int>) : MutableList<Int> {
        var i = 0
        var result = mutableListOf<Int>()

        while (i < input.size) {
            var correctIndex = input[i] - 1 // 3* 2 4 1
            if (input[i] != input[correctIndex]) {
                swapValues(input, i, correctIndex)
            } else {
                i++
            }
        }
        for (i in input.indices) {
            if (input[i] != i + 1) {
                result.add(i+1)
            }
        }
        return result
    }



    private fun swapValues(input: MutableList<Int>, i: Int, correctIndex: Int) {
        val temp = input[i]
        input[i] = input[correctIndex]
        input[correctIndex] = temp
    }
}