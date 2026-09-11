/**
 * LinkedList
 */
interface LinkedList {
    boolean isEmpty();
    int size();
    void addFirst(Object data);
    void addLast(Object data);
    void addAfter(int index,Object inputData);
    void deleteFirst();
    void deleteLast();
    void deleteAfter(int index);
    void print();
}