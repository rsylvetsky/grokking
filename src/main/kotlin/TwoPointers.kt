import java.util.*
import kotlin.math.abs


class TwoPointers {

    fun pairWithTargetSum(input: List<Int>, target: Int) : MutableList<Int> {
        var start = 0
        var end = input.size-1

        while (start < end) {
            if (input[start] + input[end] == target) {
                return mutableListOf(start, end)
            } else if (input[start] + input[end] > target) {
                end--
            } else if (input[start] + input[end] < target) {
                start++
            }
        }
        return mutableListOf(start, end)
    }

    fun removeDuplicates(input: MutableList<Int>) : Int {
        var left = 1
        var right = 1

        while (right < input.size) {
            if (input[right] == input[right - 1]) {
                right++
            } else if (input[right] != input[right - 1]) {
                input[left] = input[right]
                left++
                right++
            }
        }
        println("final array: $input")
        return left
    }

    fun squareASortedArray(input:MutableList<Int>) : MutableList<Int> {
        var start = 0
        var end = input.size-1
        var result = LinkedList<Int>()

        while (start <= end) {
            if (Math.abs(input[start]) > Math.abs(input[end])) {
                result.push(input[start] * input[start])
                start ++
            } else {
                result.push(input[end] * input[end])
                end --
            }
        }
        return result
    }

    fun tripletSum(input: MutableList<Int>) : MutableList<MutableList<Int>> {
        input.sort()
        var result = mutableListOf<MutableList<Int>>()
        for (i in 0 until input.size-2) {
            if (i > 0 && input[i] == input[i-1]) {
                continue
            }
            var start = i +1
            var end = input.size-1
            while (start < end) {
                if (input[start] + input[end] == -input[i]) {
                    result.add(mutableListOf(input[start],input[end],input[i]))
                    start ++
                    end --
                    while (start < end && input[start] == input[start - 1]) {
                        start ++
                    }
                    while (start < end && input[end] == input[end+1]) {
                        end --
                    }
                } else if (input[start] + input[end] + input[i] > 0) {
                    end --
                } else if (input[start] + input[end] + input[i] < 0) {
                    start ++
                }
            }
        }
        return result
    }

    fun closestTriple(input: MutableList<Int>, targetSum: Int) : Int {
        // incomplete solution
        var start = 1
        var end = input.size-1
        var minDifference = Int.MAX_VALUE
        var result = 0

         fun sum(a:Int, b:Int, c:Int) : Int {
            return a + b + c
        }

        for (i in 0 until input.size - 2) {
            var targetDiff = targetSum - input[i] - input[start] - input[end]
            if (targetSum - targetDiff == 0) {
                return targetSum
            }

            if (abs(targetSum - targetDiff) < minDifference) {
                minDifference = abs(targetSum - targetDiff)
            }
        }
        return result
    }

    fun tripletWithSmallerSum(input: MutableList<Int>, target: Int):Int {
        var count = 0
        input.sort()

        for (i in 0 until input.size-2) {
            var start = i+1
            var end = input.size-1
            while (start < end) {
                if (input[i] + input[start] + input[end] >= target) {
                    end--
                } else {
                    count += (end - start)
                    start++
                }
            }
        }
        println("sortedInput: $input, count: $count")
        return count
    }

    fun subarrayWithProductLessThanTarget(input: MutableList<Int>, target: Int): MutableList<LinkedList<Int>> {

        var start = 0
        var product = 1.0
        var result = mutableListOf<LinkedList<Int>>()

        for (end in input.indices) {
            product *= input[end]
            while (product >= target) {
                product /= input[start].toDouble()
                start++
            }
            val tempList = LinkedList<Int>()
            for (i in end downTo start) {
                tempList.add(0, input[i])
                println("result: $result")
                result.add(tempList)
            }
        }
        return result
    }

    fun grokkingFindSubarrays(arr:  MutableList<Int>, target: Int): List<List<Int>>? {
        val result: MutableList<List<Int>> = ArrayList()
        var product = 1.0
        var left = 0
        for (right in arr.indices) {
            product *= arr[right].toDouble()
            while (product >= target && left < arr.size) product /= arr[left++].toDouble()
            // since the product of all numbers from left to right is less than the target
            // therefore, all subarrays from left to right will have a product less than the
            // target too; to avoid duplicates, we will start with a subarray containing only
            // arr[right] and then extend it
            val tempList = LinkedList<Int>()
            for (i in right downTo left) {
                tempList.add(0, arr[i])
                result.add(ArrayList(tempList))
            }
        }
        return result
    }

    fun dutchNationalFlag(input: MutableList<Int>) : MutableList<Int> {
        var low = 0
        var high = input.size -1
        var i = 0

        fun swapVals(input: MutableList<Int>, i:Int, j:Int) {
            val temp = input[i]
            input[i] = input[j]
            input[j] = temp
        }

        while (i <= high) {
            if (input[i] == 0) {
                swapVals(input, i, low)
                low++
                i++
            } else if (input[i] == 1) {
                i++
            } else {
                swapVals(input, i, high)
                high--
            }
        }
       return input
    }
}