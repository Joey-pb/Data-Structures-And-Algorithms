package datastructures.doublylinkedlist;

public class Main {

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList(1);
        list.append(2);
        list.append(3);

        System.out.println(list.remove(1).value);
        System.out.println(list.remove(0).value);



    }
}
