import java.util.Objects;

public class DoublyLinkedList implements LinkedList{
    private Node2P head,tail;
    int size=0;

    public DoublyLinkedList(){
        head = tail = null;
    }

    public boolean isEmpty(){
        return(size==0);
    }

    public int size(){
        return size;
    }

    public void addFirst(Object inputData){
        Node2P baru = new Node2P(inputData);
        if (isEmpty()){
            head = baru;
            tail = baru;
            size++;
        }
        else{
            baru.next = head;
            head.prev = baru;
            head = baru;
            size++;
        }
    }
    public void addLast(Object inputData){
        Node2P baru = new Node2P(inputData);
        if (isEmpty()){
            head = baru;
            tail = baru;
            size++;
        }
        else{
            tail.next = baru;
            baru.prev = tail;
            tail = baru;
            size++;
        }
    }

    public void addAfter(int index,Object inputData){
        Node2P baru = new Node2P(inputData);
        if (isEmpty()){
            head = baru;
            tail = baru;
            size++;
        }
        else{
            Node2P temp = head;
            for(int i=0;i<index;i++){
                temp = temp.next;
            }
            baru.prev = temp;
            baru.next = temp.next;
            temp.next = baru;
            baru.next.prev = baru;
            size++;
        }
    }
    
    public void deleteFirst(){
        Node2P temp = head;
        if (!isEmpty()){ 
            if (head == tail)
                head = tail = null;
            else
            {
                head.next.prev = null;
                head = temp.next;
            } size--;
        }
        else
            System.out.println("List kosong!");
    }

    public void deleteLast(){
        Node2P temp = tail;
        if (!isEmpty()){
            if (tail == head){
                head = tail = null;
            }
            else {
                tail.prev.next = null;
                tail=temp.prev;
            } size--;
        }
        else System.out.println("List kosong!");

    }
    public void deleteAfter(int index){
        Node2P temp = head;
        if(index < size-2){
            for(int i=0;i<index;i++){
                temp = temp.next;
            }
            temp.next.next.prev = temp;
            temp.next = temp.next.next;
            size--;
        }
        else if(index==size-2){//menghapus tail
            this.deleteLast();
        }
        else{
            System.out.println("Index lebih besar atau sama dari ukuran list");
        }

    }


    public void print(){
        Node2P currentNode = head;
        for(int i =0;i<size;i++){
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node2P current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    
    @Override
    public int indexOf(Object targetData) {
        // Haidar
        int count = 0;
        Node2P n = head;

        while(n != null){
            if(Objects.equals(n.data, targetData)){
                return count;
            }

            n = n.next;
            count++;
        }

        return -1;
    }

    @Override
    public void printReverse() {
        // Haidar
        if(tail == null){
            return;
        }
        
        Node2P n = tail;
        while(n != null){
            System.out.print(n.data + " ");
            n = n.prev;
        }

        System.out.println();
    }

    @Override
    public boolean remove(Object targetData) {
        // Haidar
        if(head == null){
            return false;
        }
        
        if(Objects.equals(head.data, targetData)){
            deleteFirst();
            return true;
        }
        
        if(Objects.equals(tail.data, targetData)){
            deleteLast();
            return true;
        }
        
        Node2P current = head.next;
        while(current.next != null) {
            if(Objects.equals(current.data, targetData)) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                size--;
                return true;
            }

            current = current.next;
        }

        return false;
    }
    
    @Override
    public Object[] toArray() {
        // TODO digunakan untuk mendapatkan keseluruhan data pada node-node di linked list dalam bentuk array. Data-data pada array disusun secara urut mulai dari head sampai dengan tail.
        if(isEmpty()) {
            return new Object[0];
        }
        Object[] result = new Object[size];
        Node2P current = head;
        for (int i = 0; i < size; i++) {
            result[i] = current.data;
            current = current.next;
        }
        return result;
    }
}
