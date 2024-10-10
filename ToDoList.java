import java.util.Scanner;

public class ToDoList {
	Node head;
	
	static class Node {
		Node next;
		String task;
		boolean status;
		
		Node(String task, boolean status) {
			this.task = task;
			this.status = status;
			this.next = null;
		}
	}
	
	// to add the task and its status to the to-do list
	public void addTask(String task, boolean status) {
		Node newTask = new Node(task, status);
		
		if (head == null) {
			head = newTask;
			System.out.println("-> Task added!");
			return;
		}
		
		Node currTask = head;
		while (currTask.next != null) {
			if (currTask.task.equals(task)) {
				System.out.println("-> Task already exists !!!");
				return;
			}
			currTask = currTask.next;
		}
		
		currTask.next = newTask;
		System.out.println("-> Task added!");
	}
	
	// deleting a task from the to-do list
	public void deleteTask(String task) {
		Node prevTask = null;
		Node currTask = head;
		
		if (currTask != null && currTask.task.equals(task)) {
			head = currTask.next;
			System.out.println("-> Task deleted!");
			return;
		}
		
		while (currTask != null) {
			if (currTask.task.equals(task)) {
				prevTask.next = currTask.next;
				System.out.println("-> Task deleted!");
				return;
			}
			prevTask = currTask;
			currTask = currTask.next;
		}
		
		System.out.println("-> No such task found !!!");
	}
	
	// update status of a task
	public void changeStatus(String task) {
		Node currTask = head;
		
		while (currTask != null) {
			if (currTask.task.equals(task)) {
				if (currTask.status) {
					currTask.status = false;
				} else {
					currTask.status = true;
				}
				System.out.println("-> Status changed!");
				return;
			}
			currTask = currTask.next;
		}
		
		System.out.println("-> No such task found !!!");
	}
	
	// displaying the to-do list
	public void printList() {
		Node currTask = head;
		if (head == null) {
			System.out.println("-> There is no task in the list");
			return;
		}
		
		while (currTask != null) {
			System.out.println(currTask.task + " -> " + currTask.status);
			currTask = currTask.next;
		}
	}
	
	// main
	public static void main(String[] args) {
		ToDoList list = new ToDoList();
		
		String task;
		boolean status;
		Scanner sc1, sc2;
		int choice;
		
		System.out.println("--- Welcome to To-Do List ---");
		System.out.println("-> This is a simple program to handle your tasks.\nHere you can add or delete a task\nor just change the status of a task.\n");
		System.out.println("Here are the choices you can choose from:-\n1. Add a task\n2. Delete a task\n3. Update status of a task\n4. Display your list\n5. Exit the program\n");
		System.out.println("[NOTE: When you exit the program your list will be automatically deleted.]\n");
		
		do {
			sc1 = new Scanner(System.in);
			System.out.print("Enter your choice: ");
			choice = sc1.nextInt();
			
			System.out.println("---------------------------------------");
			
			if (choice == 1) {
				sc2 = new Scanner(System.in);
				
				System.out.println("-- Add a task --\n");
				System.out.print("Enter the task to add: ");
				task = sc2.nextLine();
				System.out.print("Enter its status (true/false): ");
				status = sc2.nextBoolean();
				
				list.addTask(task, status);
			} else if (choice == 2) {
				sc2 = new Scanner(System.in);
				
				System.out.println("-- Delete a task --\n");
				System.out.print("Enter the task to delete: ");
				task = sc2.nextLine();
				
				list.deleteTask(task);
			} else if (choice == 3) {
				sc2 = new Scanner(System.in);
				
				System.out.println("-- Update status --\n");
				System.out.print("Enter the task whose status is to be changed: ");
				task = sc2.nextLine();
				
				list.changeStatus(task);
			} else if (choice == 4) {
				System.out.println("-- Display the To-Do List --\n");
				list.printList();
			} else if (choice == 5) {
				System.out.println("-- Exiting --");
				break;
			} else {
				System.out.println("-> Invalid choice !!!");
				continue;
			}
			
			System.out.println("---------------------------------------");
			
		} while (choice != 5);
		
	}
}
