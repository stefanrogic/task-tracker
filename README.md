# TaskTracker

A simple Java CLI application to manage and track your tasks.

## Features

- Add, edit, and delete tasks
- Mark tasks as complete/incomplete
- View all tasks

### Example

```
Current tasks:
[X] Implement task editing
[ ] Testing new features

Type 'help' for commands
task-cli help

Available commands:
list - List all tasks
add <task description> - Add a new task
delete <task index> - Delete a task by its index
complete <task index> - Mark a task as completed
todo <task index> - Mark a task as incomplete
update <task index> <new description> - Change a task's description
exit - Exit the application
task-cli complete 1

Current tasks:
[X] Implement task editing
[X] Testing new features
```

## Download

- Download the latest release from the [Releases](https://github.com/stefanrogic/task-tracker/releases) page.
- Or clone the repository:
  ```
  git clone <repository-url>
  cd TaskTracker
  ```

## Build in IntelliJ IDEA

1. Open IntelliJ IDEA.
2. Select **File > Open...** and choose the `TaskTracker` project directory.
3. If prompted, import the project as a Maven/Gradle project (if applicable).
4. Let IntelliJ finish indexing and building the project.

## Usage

If you downloaded the release, run:
```
java -jar TaskTracker.jar
```

https://roadmap.sh/projects/task-tracker
