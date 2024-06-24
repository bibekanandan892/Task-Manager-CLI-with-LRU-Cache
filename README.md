# Task Manager CLI with LRU Cache

## Project Description

This Kotlin project is a Command-Line Interface (CLI) Task Manager, designed to manage a list of tasks efficiently using an LRU (Least Recently Used) Cache mechanism. The project allows users to add, update, retrieve, remove, view, and clear tasks, ensuring that the most recently accessed tasks are prioritized in memory.

## Features

- **Add Task**: Users can add tasks with a title, description, and status.
- **Get Task**: Retrieve task details by title, moving the task to the front of the cache if found.
- **Update Task**: Update the description and status of an existing task.
- **Remove Task**: Remove a task by title.
- **View Tasks**: Display all current tasks in the cache from most to least recently used.
- **Recent Task**: Retrieve the most recently accessed task.
- **Clear Tasks**: Clear all tasks from the cache.
- **Exit**: Exit the CLI application.

## LRU Cache

The project uses a custom LRU Cache implementation to manage the tasks efficiently. The cache maintains a doubly linked list to keep track of the order of access, and a hash map for fast lookups. The cache size is user-defined and helps in managing memory effectively by discarding the least recently used tasks when the cache exceeds its maximum size.

## Code Overview

### Main Application

The main application handles user input and command execution. It provides a user-friendly interface for interacting with the task manager.

### TaskLRUCache

The `TaskLRUCache` class implements the LRU caching mechanism. It includes methods for adding, updating, retrieving, and removing tasks, as well as for managing the internal linked list structure.

### Task

The `Task` data class represents a task with a title, description, and status.

### TaskStatus

The `TaskStatus` enum defines the possible statuses for a task: `TODO`, `INPROGRESS`, and `COMPLETED`.

## Getting Started

1. **Clone the Repository**: 
   ```sh
   git clone https://github.com/yourusername/task-manager-cli.git
   cd task-manager-cli
   ```

2. **Run the Application**:
   ```sh
   kotlinc TaskManager.kt -include-runtime -d TaskManager.jar
   java -jar TaskManager.jar
   ```

3. **Follow On-Screen Instructions**: Enter the size of the cache and follow the available commands to manage your tasks.

## Example Usage

```plaintext
Please enter the size of the cache : 3
Welcome to Task Manager CLI

Available Commands: add, get, update, remove, view, recent, clear, exit
Enter command: add
Enter task title: Task1
Enter task description: Description1
Enter task status (Todo, InProgress, Completed): TODO
Task added.

Available Commands: add, get, update, remove, view, recent, clear, exit
Enter command: view
Current tasks in cache:
Task : 0 -> Title : Task1 || Description : Description1 || Status : TODO

Available Commands: add, get, update, remove, view, recent, clear, exit
Enter command: exit
Exiting Task Manager CLI. Goodbye!
```


Feel free to contribute to this project by submitting issues or pull requests. For major changes, please open an issue first to discuss what you would like to change. 

Happy task managing!
