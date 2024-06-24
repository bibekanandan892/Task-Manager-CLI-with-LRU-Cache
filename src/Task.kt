data class Task(val title : String,val description : String,val status : TaskStatus)

enum class TaskStatus{
        TODO,
    INPROGRESS,
    COMPLETED
}
