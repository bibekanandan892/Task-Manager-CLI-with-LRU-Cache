import kotlin.system.exitProcess




fun main() {

    try {
        println("Please enter the size of the cache : ")
        val size = readLine()!!



        val taskCache = TaskLRUCache(size.toInt())
        println("Welcome to Task Manager CLI")
        while (true) {
            println("\nAvailable Commands: add, get, update, remove, view, recent, clear, exit")
            print("Enter command: ")
            when (readLine()?.trim()) {
                "add" -> {
                    print("Enter task title: ")
                    val title = readLine()!!
                    print("Enter task description: ")
                    val description = readLine()!!
                    print("Enter task status (Todo, InProgress, Completed): ")
                    val status = TaskStatus.valueOf(readLine()!!.uppercase().trim())
                    taskCache.putTask(Task(title, description, status))
                    println("Task added.")
                }
                "get" -> {
                    print("Enter task title: ")
                    val title = readLine()!!
                    val task = taskCache.getTask(title)
                    if(task != null){
                        println("Task details : $task")
                        continue
                    }
                    println("No task is present with this title")

                }
                "update" -> {
                    print("Enter task title: ")
                    val title = readLine()!!
                    print("Enter new task description: ")
                    val description = readLine()!!
                    print("Enter new task status (Todo, InProgress, Completed): ")
                    val status = TaskStatus.valueOf(readLine()!!.uppercase().trim())
                    taskCache.putTask(Task(title, description, status))
                    println("Task updated.")
                }
                "remove" -> {
                    print("Enter task title to remove: ")
                    val title = readLine()!!
                    taskCache.removeTask(title)
                    println("Task removed.")
                }
                "view" -> {
                    println("Current tasks in cache:")
                    taskCache.printCache()
                }
                "recent" -> {
                    val recentTask = taskCache.getRecentTask()
                    if (recentTask != null) {
                        println("Most recent task: $recentTask")
                    } else {
                        println("No tasks in the cache.")
                    }
                }
                "clear" -> {
                    print("Are you sure you want to clear all tasks? (yes/no): ")
                    if (readLine()?.trim() == "yes") {
                        taskCache.clear()
                        println("All tasks cleared.")
                    } else {
                        println("Clear operation cancelled.")
                    }
                }
                "exit" -> {
                    println("Exiting Task Manager CLI. Goodbye!")
                    exitProcess(0)
                }
                else -> {
                        println("Invalid command. Please try again.")
                }
            }
        }
    }catch (e : Exception){
        e.printStackTrace()
        println("Invalid command. Please try again.")
        println("Application is reset.")
        main()
    }

}

fun inValidCommend(){
    println("Invalid command. Please try again.")
}
