/**
 * testSinglyLinkedList
 */
public class testDoublyLinkedList {

    public static void main(String[] args) {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addFirst(4);
        linkedList.addFirst(5);
        linkedList.addLast(10);
        linkedList.addAfter(3, 21);
        // linkedList.deleteFirst();
        // linkedList.deleteLast();
        linkedList.deleteAfter(3);
        linkedList.print();
    }
}