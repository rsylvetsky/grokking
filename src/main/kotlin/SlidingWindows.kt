import javax.print.DocFlavor.STRING
import kotlin.math.max

class SlidingWindows {
    fun findAveragesOfSubarrays(input: List<Int>, k: Int): MutableList<Double> {
      var start = 0
      var end = 0
      var sum = 0
      var result = mutableListOf<Double>()

        for (i in 0 until input.size) {
          sum += input[i]
//if i is past the first k values in the array, you need to slide the window it to move forward
          if (i >= k-1) {
              result.add(sum.toDouble()/k)
              sum -= input[start]
              start ++
          }
      }
        return result
    }

    fun maxSumOfSubArray(input: List<Int>, k: Int): Int {
        var sum = 0
        var start = 0
        var maxSum: Int = 0

        for (i in input.indices) {
            sum += input[i]
            if (i >= k-1) {
                if (sum > maxSum) {
                    maxSum = sum
                }
                sum -= input[start]
                start ++
            }
        }
        return maxSum
    }
    fun findMinSubArray(S: Int, arr: IntArray): Int {
        var windowSum = 0
        var minLength = Int.MAX_VALUE
        var windowStart = 0
        for (windowEnd in arr.indices) {
            windowSum += arr[windowEnd] // add the next element
            // shrink the window as small as possible until the 'windowSum' is smaller than 'S'
            while (windowSum >= S) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1)
                windowSum -= arr[windowStart] // subtract the element going out
                windowStart++ // slide the window ahead
            }
        }
        return if (minLength == Int.MAX_VALUE) 0 else minLength
    }


    fun smallestSubArrayWithAGreaterSum(input: List<Int>, s: Int): Int {
     var sum = 0
     var start = 0
     var end = 0
     var minSize = Int.MAX_VALUE

        for (end in input.indices) {
            sum += input[end]
            while (sum >= s) {
                minSize = Math.min(minSize, end - start + 1)
                sum -= input[start]
                start++
            }
        }
        return if (minSize == Int.MAX_VALUE) 0 else minSize
    }

    fun longestSubstringWithKDistinctCharacters(input: String, s: Int): Int {
        var start = 0
        var end: Int = 0
        var maxLength = 0
        var distinctCharCount = mutableMapOf<Char, Int>()

        for (end in input.indices) {

            if (distinctCharCount.keys.contains(input[end])) {
                distinctCharCount[input[end]] = distinctCharCount[input[end]]!! + 1
            } else {
                distinctCharCount[input[end]] = 1
            }

            while (distinctCharCount.keys.size > s) {
                distinctCharCount[input[start]] = distinctCharCount[input[start]]!! - 1
                if (distinctCharCount[input[start]] == 0) {
                    distinctCharCount.remove(input[start])
                }
                maxLength = Math.max(distinctCharCount.values.sum(), maxLength)
                start++
            }
        }

        return maxLength
    }

    fun fruitBasket(input:String): Int {
        var start = 0
        var end = 0
        var maxFruit = 0
        var fruitCount = mutableMapOf<Char, Int>()

        for (end in input.indices) {
            println("start: $start, end: $end, table: $fruitCount, maxFruit = $maxFruit")
            if ( fruitCount.contains(input[end])) {
                fruitCount[input[end]] = fruitCount[input[end]]!! + 1
            } else {
                fruitCount[input[end]] = 1
            }
            while (fruitCount.keys.size > 2) {
                fruitCount[input[start]] =  fruitCount[input[start]]!! - 1
                if (fruitCount[input[start]] == 0) {
                    fruitCount.remove(input[start])
                }
                start ++
            }
            maxFruit = Math.max(maxFruit, fruitCount.values.sum())
        }
        return maxFruit
    }

    fun longestSubstringWithDistinctCharacters(input: String) : Int {
        var start =0
        var end = 0
        var maxLength = 0
        var charCount = mutableMapOf<Char, Int>()

        for (end in input.indices) {
            if (charCount.contains(input[end])) {
                charCount[input[end]] = charCount[input[end]]!! + 1
            } else {
                charCount[input[end]] = 1
            }

            while (charCount.values.any { it > 1 })  {
                charCount[input[start]] =  charCount[input[start]]!! - 1
                if (charCount[input[start]] == 0) {
                    charCount.remove(input[start])
                }
                start++
            }
            maxLength = Math.max(maxLength, charCount.keys.size)
        }
        return maxLength
    }

}