import java.io.File


fun main() {
    val treeBreadthFirstSearch = TreeBreadthFirstSearch()

    var root = TreeBreadthFirstSearch.TreeNode(12, null, null)
    root.left = TreeBreadthFirstSearch.TreeNode(7,null, null)
    root.right = TreeBreadthFirstSearch.TreeNode(1,null, null)
    root.left!!.left = TreeBreadthFirstSearch.TreeNode(9, null, null,)
    root.right!!.left = TreeBreadthFirstSearch.TreeNode(10, null,null)
    root.right!!.right = TreeBreadthFirstSearch.TreeNode(5,null,null)

    println( treeBreadthFirstSearch.reverseLevelOrderTraversal(root))


}
fun mainInPlaceLinkedList() {
    val inplaceLinkedList = InplaceReversalLinkedList()

    val head = ListNode(2)
    head.next = ListNode(4)
    head.next!!.next = ListNode(6)
    head.next!!.next!!.next = ListNode(8)
    head.next!!.next!!.next!!.next = ListNode(10)

    println(inplaceLinkedList.reverse(head))

}


fun mainCyclicSort() {
    val cyclicSort = CyclicSort()
    fun readInputForIntList(name: String) = File("src/main/kotlin/inputs", "$name.txt").readText().split(",").map { it.toInt() }.toMutableList()
    val input = readInputForIntList("CyclicSort2")
    println(cyclicSort.findAllMissingValues(input))
}
fun mainMergeIntervals() {
    val mergeIntervals = MergeIntervals()
    fun readInput(name: String) =
        File("src/main/kotlin/inputs", "$name.txt").readText()
            .split(",").map { println(it) }
    //need to figure out how to read this correctly
    val input = readInput("MergeIntervals1")
    println(input)
//    println(mergeIntervals.mergeIntervals(input))
}

fun mainFastAndSlowPointers() {
    val fastSlowPointers = FastSlowPointers()
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next!!.next = ListNode(3)
    head.next!!.next!!.next = ListNode(4)
    head.next!!.next!!.next!!.next = ListNode(5)
    head.next!!.next!!.next!!.next!!.next = ListNode(6)

//    println(fastSlowPointers.findingCycleInLinkedList(head))
//    head.next!!.next!!.next!!.next!!.next!!.next = head.next!!.next
//    println(fastSlowPointers.findingCycleInLinkedList(head))
//    head.next!!.next!!.next!!.next!!.next!!.next = head.next!!.next!!.next;
//    println(fastSlowPointers.findingCycleInLinkedList(head))
}

fun mainTwoPointers() {
//    val twoPointers = TwoPointers()
//    fun readInputForIntList(name: String) = File("src/main/kotlin/inputs", "$name.txt").readText().split(",").map { it.toInt() }
//    val input = readInputForIntList("TwoPointers8")
//    println(input)
//    println(twoPointers.pairWithTargetSum(input, 11))
//    println(twoPointers.removeDuplicates(input.toMutableList()))
//    println(twoPointers.squareASortedArray(input.toMutableList()))
//    println(twoPointers.tripletSum(input.toMutableList()))
//    println(twoPointers.tripletWithSmallerSum(input.toMutableList(),3))
//    println(twoPointers.subarrayWithProductLessThanTarget(input.toMutableList(),30))
//    println(twoPointers.dutchNationalFlag(input.toMutableList()))
}

fun mainIslands() {
//    val islands = Islands()
//
//    fun readMatrixInput(name: String) =
//        File("src/main/kotlin/inputs", "$name.txt").readText()
//            .split("\n")
//            .map { it -> it.split("").filter { !it.isNullOrEmpty() }.map { it.toInt() }.toMutableList()}
//            .toMutableList()
//    val input = readMatrixInput("Islands4")
//    println(input)
//    println(islands.numberOfIslandsDfs(input))
//    println(islands.biggestIsland(input))
//    println(islands.floodFill(input,Pair(1,3),2))
//    println(islands.numberOfClosedIslands(input))
}

fun mainSlidingWindows() {
//    val slidingWindows = SlidingWindows()
//

//    fun readInputForStringList(name: String) = File("src/main/kotlin", "$name.txt").readText()
//    val input = readInputForIntList("SlidingWindowsExample")
//    val input = readInputForStringList("SlidingWindowsExample2")

//    println(input)
//    println(slidingWindows.findAveragesOfSubarrays(input, 5))
//    println(slidingWindows.maxSumOfSubArray(input,3))
//    println(slidingWindows.smallestSubArrayWithAGreaterSum(input, 7))
//    println(slidingWindows.longestSubstringWithKDistinctCharacters(input, 2))
//    println(slidingWindows.fruitBasket(input))
//    println(slidingWindows.longestSubstringWithDistinctCharacters(input))
}