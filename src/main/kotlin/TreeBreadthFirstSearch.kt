import com.sun.source.tree.Tree
import java.util.LinkedList

class TreeBreadthFirstSearch {

    class TreeNode(val data: Int, var left: TreeNode?, var right: TreeNode?)

    fun levelOrderTraversal(root: TreeNode) : MutableList<MutableList<Int>> {

        val result: MutableList<MutableList<Int>> = mutableListOf()
        val queue = LinkedList<TreeNode>()
        queue.add(root)
        while (!queue.isEmpty()) {
            var levelSize = queue.size
            var currentLevel = mutableListOf<Int>()
            for (i in 0 until levelSize) {
                var currentNode = queue.pop()
                currentLevel.add(currentNode.data)
                if (currentNode.left != null) {
                    queue.add(currentNode.left!!)
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right!!)
                }
            }
            result.add(currentLevel)
        }
        return result
    }

    fun reverseLevelOrderTraversal(root: TreeNode) : MutableList<MutableList<Int>> {
        var queue = LinkedList<TreeNode>()
        queue.add(root)
        var result = mutableListOf<MutableList<Int>>()
        while (!queue.isEmpty()) {
            var levelSize = queue.size
            var currentLevel = mutableListOf<Int>()
            for (i in 0 until levelSize) {
                var currentNode = queue.poll()
                currentLevel.add(currentNode.data)
                if (currentNode.left !=null) {
                    queue.add(currentNode.left!!)
                }
                if (currentNode.right !=null) {
                    queue.add(currentNode.right!!)
                }
            }
            result.add(0, currentLevel)
        }
    return result
    }

    fun zigZag(root: TreeNode) : MutableList<MutableList<Int>> {
        var queue = LinkedList<TreeNode>()
        queue.add(root)
        var result = mutableListOf<MutableList<Int>>()
        while (!queue.isEmpty()) {
            var levelSize = queue.size
            var currentLevel = mutableListOf<Int>()
            var leftToRight = true
            for (i in 0 until levelSize) {
                var currentNode = queue.poll()
                if (leftToRight) {
                    currentLevel.add(currentNode.data)
                } else {
                    currentLevel.add(0, currentNode.data)
                }
                if (currentNode.left != null) {
                    queue.add(currentNode.left!!)
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right!!)
                }
            }
            result.add(currentLevel)
            leftToRight = !leftToRight
        }
        return result
    }

    fun levelAverageInBinaryTree(root: TreeNode) : MutableList<Double> {
        var queue = LinkedList<TreeNode>()
        queue.add(root)
        var result = mutableListOf<Double>()
        while (!queue.isEmpty()) {
            var levelSize = queue.size
            var tempLevel = mutableListOf<Int>()
            for (i in 0 until levelSize) {
                var currentNode = queue.poll()
                tempLevel.add(currentNode.data)
                if (currentNode.left !=null) {
                    queue.add(currentNode.left!!)
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right!!)
                }
            }
            result.add(tempLevel.average())
        }
        return result
    }
}