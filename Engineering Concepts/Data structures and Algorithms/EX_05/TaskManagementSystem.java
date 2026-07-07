package EX_05;
class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }
}

class SinglyLinkedList {
    private Task head;

    public void addTask(int id, String name, String status) {
        Task newTask = new Task(id, name, status);

        if (head == null) {
            head = newTask;
            return;
        }

        Task temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newTask;
    }

    public Task searchTask(int id) {
        Task temp = head;

        while (temp != null) {
            if (temp.taskId == id) {
                return temp;
            }
            temp = temp.next;
        }

        return null;
    }

    public void traverseTasks() {
        if (head == null) {
            System.out.println("Task List is Empty");
            return;
        }

        Task temp = head;

        while (temp != null) {
            System.out.println(
                    "Task ID: " + temp.taskId +
                    ", Task Name: " + temp.taskName +
                    ", Status: " + temp.status);
            temp = temp.next;
        }
    }

    public void deleteTask(int id) {
        if (head == null) {
            System.out.println("Task List is Empty");
            return;
        }

        if (head.taskId == id) {
            head = head.next;
            System.out.println("Task Deleted");
            return;
        }

        Task temp = head;

        while (temp.next != null && temp.next.taskId != id) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Task Not Found");
        } else {
            temp.next = temp.next.next;
            System.out.println("Task Deleted");
        }
    }
}

public class TaskManagementSystem {
    public static void main(String[] args) {

        SinglyLinkedList taskList = new SinglyLinkedList();

        taskList.addTask(101, "Design Database", "Pending");
        taskList.addTask(102, "Develop Backend", "In Progress");
        taskList.addTask(103, "Test Application", "Pending");

        System.out.println("All Tasks:");
        taskList.traverseTasks();

        System.out.println();

        Task task = taskList.searchTask(102);

        if (task != null) {
            System.out.println("Task Found:");
            System.out.println(task.taskId + " " + task.taskName + " " + task.status);
        } else {
            System.out.println("Task Not Found");
        }

        System.out.println();

        taskList.deleteTask(102);

        System.out.println();

        System.out.println("Tasks After Deletion:");
        taskList.traverseTasks();
    }
}