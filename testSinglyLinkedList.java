/**
 * testSinglyLinkedList
 */
public class testSinglyLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addFirst(4);
        linkedList.addFirst(5);
        // linkedList.deleteFirst();
        // linkedList.deleteFirst();
        // linkedList.deleteLast();
        linkedList.deleteAfter(1);
        linkedList.print();
    }
}