public class SL<Item> {
    private Node first;
    private int N;


    private class Node{
        Item item;    
        Node next;
    }

    public void push(Item item){
        //insert at head
        Node old = first;
        first = new Node();
        first.item = item;
        first.next = old;
        N++;
    }

    public Item pop(){
        Item x = first.item;
        first = first.next;
        return x;
    }

    public void insertAfter(Item pos, Item item){
        if(N == 0){
            return;
        }
        for(Node x = first; x!= null; x=x.next){
            if(x.item == pos){
                Node newNode = new Node();
                newNode.item = item;
                newNode.next = x.next;
                x.next = newNode;
            }
        }
    }

    public void delete(Item item){
        Node temp = first;
        Node prev = null;
        //head itself holds the key to be deleted
        if(temp != null && temp.item == item){
            first = temp.next;
            return;
        }
        while(temp != null && temp.item != item){
            prev = temp;
            temp = temp.next;
        }
        if(temp == null){
            return;
        }
        prev.next = temp.next;

    }

    public void deleteAtIndex(int i){
        Node temp = first;
        Node prev = null;
        int pos = 0;

        //head itself holds the key to be deleted
        if(temp != null && pos == i){
            first = temp.next;
            return;
        }
        while(temp != null && pos != i){
            prev = temp;
            temp = temp.next;
            pos++;
        }
        if(temp == null){
            return;
        }
        prev.next = temp.next;

    }


    public void printAll(){
        for(Node x = first; x!= null; x=x.next){
            System.out.println(x.item);
        }
    }


}
