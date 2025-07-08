# TaskTracker

A simple Java CLI application to manage and track your tasks.

## Features

- Add, edit, and delete tasks
- Mark tasks as complete/incomplete
- Persistent data storage (tasks are saved between sessions)

## Example

```console
user@userpc:~$ java -jar TaskTracker.jar

Current tasks:
[X] Implement task editing
[X] Testing new features

Type 'help' for commands
task-cli help

Available commands:
list - List all tasks
list <completed|todo> - List completed tasks or incomplete tasks
add <task description> - Add a new task
delete <task index> - Delete a task by its index
complete <task index> - Mark a task as completed
todo <task index> - Mark a task as incomplete
update <task index> <new description> - Change a task's description
exit - Exit the application

task-cli add New task

Current tasks:
[X] Implement task editing
[X] Testing new features
[ ] New task

task-cli update 2 Submit this project

Current tasks:
[X] Implement task editing
[X] Testing new features
[ ] Submit this project

task-cli complete 2

Current tasks:
[X] Implement task editing
[X] Testing new features
[X] Submit this project
```

## Download and Usage

- Download the latest release from the [Releases](https://github.com/stefanrogic/task-tracker/releases) page.

  ```
  java -jar TaskTracker.jar
  ```
