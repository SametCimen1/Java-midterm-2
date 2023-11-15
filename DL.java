public class DL<Item> {
    private Node first;
    private int N;

    private class Node{
        Node prev;
        Node next;
        Item item;
    }


    public void add(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        if(oldFirst == null){}
        else oldFirst.prev = first;
        N++;
    }

    public void printMiddle(Item item){
        Node current = first;

        while(current != null){
            if(current.item == item){
                System.out.println("BEFORE: " +  current.prev.item);
                System.out.println("NEXT: " +  current.next.item);
            }

            current = current.next;
        }


    }


    public void delete(Item item){
        Node current = first;

        while(current != null){
            if(current.item == item){
                current.prev.next = current.next;
                current.next.prev = current.prev;
                return;
            }

            current = current.next;
        }

    }


    public void printAll(){

        Node currentNode = first;
        while(currentNode != null){
            System.out.println(currentNode.item);
            currentNode = currentNode.next;
        }
    }


}
