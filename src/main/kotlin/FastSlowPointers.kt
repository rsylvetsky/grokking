class FastSlowPointers {


    class ListNode(var data: Int) {
             var next: ListNode? = null
         }

    fun findingCycleInLinkedList(head: ListNode?) : Boolean {

        var fast = head?.next
        var slow = head

        while (fast?.next != null) {
            if (fast == slow) {
                return true
            }
            fast = fast.next?.next
            slow = slow?.next
        }
        return false
    }

    fun findIntersection(head:ListNode) : ListNode {
        var fast = head
        var slow = head

        while (fast.next != null && fast.next!!.next !=null) {
            fast = fast!!.next!!.next!!
            slow = slow!!.next!!
        }
        if (fast == slow) {
            return fast
        }
        return fast //this is wrong
    }

    fun findStartOfCycle(head:ListNode) : ListNode {
        var start = head
        var intersection = findIntersection(head)

        while (start.next !=null && intersection.next != null) {
            start = start.next!!
            intersection = intersection.next!!
        }

        if (start == intersection) {
            return start
        }
        return ListNode(0) //this is wrong
    }

    fun happyNumbers(input: Int): Boolean {

        fun findSquare(num: Int): Int {
            var num = num
            var sum = 0
            var digit = 0
            while (num > 0) {
                digit = num % 10
                sum = +digit * digit
                num /= 10
            }
            return sum
        }

        var slow = input
        var fast = input

        do {
            slow = findSquare(slow)
            fast = findSquare(findSquare(fast))
        } while (slow != fast)

        return slow == 1
    }

    fun middleOfLinkedList(head: ListNode) : ListNode {
        var slow = head
        var fast = head

        while (fast.next != null && fast.next!!.next != null) {
            slow = slow.next!!
            fast = fast.next!!.next!!
        }
        return slow
    }


}