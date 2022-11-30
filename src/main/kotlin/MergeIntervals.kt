class MergeIntervals {

    fun mergeIntervals(input: MutableList<MutableList<Int>>) : MutableList<MutableList<Int>> {
        var result = mutableListOf<MutableList<Int>>()

        input.sortBy{ it.first()}// sort this correctly
//        result.add(input[0])
//
//        for (i in 1 .. input.size) {
//            if (input[i][0] <= result.last()[1]) {
//                result.last()[1] = Math.max(result.last()[1], input[i][0])
//            } else {
//             result.add(input[i])
//            }
//        }
    return result
    }

    fun insertIntervals(
        input: MutableList<MutableList<Int>>,
        newInterval: MutableList<Int>
    ): MutableList<MutableList<Int>> {
        var i = 0
        var result = mutableListOf<MutableList<Int>>()

        while (i < input.size && input[i][1] < newInterval[0] ) {
            result.add(input[i])
            i++
        }

        while (i < input.size && input[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(input[i][0], newInterval[0])
            newInterval[1] = Math.max(input[i][1], newInterval[1])
            i++
        }

        result.add(newInterval)

        while (i < input.size) {
            result.add(input[i])
            i++
        }

        return result
    }

    fun intervalIntersection(
        array1: MutableList<MutableList<Int>>,
        array2: MutableList<MutableList<Int>>
    ): MutableList<MutableList<Int>> {

        var i = 0
        var j = 0
        var result : MutableList<MutableList<Int>> = mutableListOf()
        while (i < array1.size && j < array2.size) {

            if ((array1[i][0] >= array2[j][0] && array1[i][0] <= array2[j][1]) ||
                    (array2[j][0] >= array1[i][0] && array2[j][0] <= array1[i][0])) {
                result.add(mutableListOf(Math.max(array1[i][0], array2[j][0]), Math.min(array1[i][1], array2[j][1])))
                    }
            if (array1[i][1] < array2[j][1]) { //whichever one finishes first, you move on from
                i++
            } else {
                j++
            }
        }
    return result
    }

    fun conflictingAppts(input: MutableList<MutableList<Int>>) : Boolean {

        input.sortWith(compareBy({it.first()}, {it.last()}))
        for (i in 1 until input.size) {
            if (input[i][0] <= input[i-1][1]) {
                return true
            }
        }
        return false
    }
}