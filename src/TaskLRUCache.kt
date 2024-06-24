
import kotlin.collections.HashMap

// LRU Cache implementation for storing Tasks with a maximum size limit
class TaskLRUCache(private var maxSize: Int = 16) {
    private val hashMap: HashMap<String, Pair<Node<String>, Task>> = HashMap()
    private var head: Node<String>? = null
    private var tail: Node<String>? = null
    private var currentSize = 0

    // Retrieves a task by title and moves it to the front of the cache
    fun getTask(title: String): Task? {
        val pair = hashMap[title] ?: return null
        removeFromLinkedList(pair.first)
        pushFront(pair.first)
        return pair.second
    }

    // Retrieves the most recently accessed task
    fun getRecentTask(): Task? {
        return head?.let { hashMap[it.value]?.second }
    }

    // Adds a new task to the cache or updates it if it already exists
    fun putTask(task: Task) {
        if (hashMap.containsKey(task.title)) {
            updateTask(task)
        } else {
            val newNode = Node(task.title)
            pushFront(newNode)
            hashMap[task.title] = Pair(newNode, task)
            currentSize++
            if (currentSize > maxSize) {
                popBack()
            }
        }
    }

    // Updates an existing task in the cache and moves it to the front
    fun updateTask(task: Task) {
        val node = hashMap[task.title]?.first ?: return
        removeFromLinkedList(node)
        pushFront(node)
        hashMap[task.title] = Pair(node, task)
    }

    // Removes a task from the cache by title
    fun removeTask(title: String) {
        val node = hashMap[title]?.first ?: return
        removeFromLinkedList(node)
        hashMap.remove(title)
        currentSize--
    }

    // Adds a node to the front of the linked list
    private fun pushFront(node: Node<String>) {
        if (head == null) {
            head = node
            tail = node
        } else {
            node.next = head
            head?.prev = node
            head = node
        }
    }

    // Removes the node at the back of the linked list (least recently used)
    private fun popBack() {
        tail?.let {
            hashMap.remove(it.value)
            removeFromLinkedList(it)
            currentSize--
        }
    }

    // Removes a node from the linked list
    private fun removeFromLinkedList(node: Node<String>) {
        node.prev?.next = node.next
        node.next?.prev = node.prev

        if (node == head) {
            head = node.next
        }
        if (node == tail) {
            tail = node.prev
        }

        node.prev = null
        node.next = null
    }

    // Prints the current tasks in the cache from most to least recently used
    fun printCache() {
        if (head == null) {
            println("To Do list is Empty")
            return
        }
        var tempHead = head
        var index = 0
        while (tempHead != null) {
            val task = hashMap[tempHead.value]?.second
            println("Task : $index -> Title : ${task?.title} || Description : ${task?.description} || Status : ${task?.status}" )
            tempHead = tempHead.next
            index++
        }
    }

    // Clears all tasks from the cache
    fun clear() {
        hashMap.clear()
        head = null
        tail = null
        currentSize = 0
    }
}


// Node class representing each element in the doubly linked list
data class Node<V>(val value: V? = null, var next: Node<V>? = null, var prev: Node<V>? = null)

