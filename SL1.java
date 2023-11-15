public class SL1<Item>{
    private Node first;
    private Node last;
    private int N;

    private class Node{
        Node next;
        Item item;
    }

    public void add(Item item){
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(first == null) first = last;
        else oldLast.next = last;
        N++;
    }   

    public void addFirst(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }   


    public void printAll(){
        Node head = first;
        while(head != null){
            System.out.println(head.item);
            head = head.next; 
        }
    }

    public Item delete(){
        Item item = first.item;
        first = first.next;
        if(first == null) last = null;
        return item;
    }
}
