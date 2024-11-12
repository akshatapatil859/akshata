class Node {
    int data;
    Node prev;
    Node next;

    // Constructor to create a new node
    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

// Doubly Linked List class
class DoublyLinkedList {
    Node head; // Points to the first node
    Node tail; // Points to the last node

    // Method to add a node at the end of the list
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) { // If the list is empty
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Method to add a node at the beginning of the list
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) { // If the list is empty
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Method to delete a node from the beginning of the list
    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head == tail) { // Only one element in the list
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    // Method to delete a node from the end of the list
    public void deleteLast() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }
        if (head == tail) { // Only one element in the list
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    // Method to display the list in forward direction
    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to display the list in reverse direction
    public void displayBackward() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    // Method to insert a node at a specific position (1-based index)
    public void insertAtPosition(int data, int position) {
        if (position <= 0) {
            System.out.println("Invalid position");
            return;
        }
        Node newNode = new Node(data);
        if (position == 1) {
            addFirst(data);
            return;
        }

        Node current = head;
        int count = 1;

        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Position out of bounds");
        } else {
            newNode.next = current.next;
            if (current.next != null) {
                current.next.prev = newNode;
            }
            current.next = newNode;
            newNode.prev = current;

            if (newNode.next == null) {
                tail = newNode; // Update tail if inserted at the end
            }
        }
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        // Adding elements to the list
        dll.addLast(10);
        dll.addLast(20);
        dll.addLast(30);
        dll.addFirst(5);

        System.out.println("List (forward):");
        dll.displayForward(); // Output: 5 10 20 30

        System.out.println("List (backward):");
        dll.displayBackward(); // Output: 30 20 10 5

        // Inserting at a specific position
        dll.insertAtPosition(15, 3);
        System.out.println("After inserting 15 at position 3:");
        dll.displayForward(); // Output: 5 10 15 20 30

        // Deleting elements from the list
        dll.deleteFirst();
        System.out.println("After deleting first element:");
        dll.displayForward(); // Output: 10 15 20 30

        dll.deleteLast();
        System.out.println("After deleting last element:");
        dll.displayForward(); // Output: 10 15 20
    }
}
