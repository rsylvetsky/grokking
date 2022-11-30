class InplaceReversalLinkedList {



    fun reverse(head: ListNode) : ListNode? {
        var current: ListNode? = head
        var previous:ListNode? = null
        var next : ListNode? = null

        while (current != null) {
            next = current.next
            current.next = previous
            previous = current
            current = next
        }
        return previous
    }
}

class ListNode(var data: Int) {
    var next: ListNode? = null
}