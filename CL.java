public class CL<Item> {
    private Node last;

    private class Node{
        Item item;
        Node next;
    }


    public void push(Item item){
        Node newFirst = new Node();
        newFirst.item = item;
        if(last == null){
            newFirst.next = newFirst;
            last = newFirst;    
        }
        else{
            newFirst.next = last.next;
            last.next = newFirst;  
        }            
    }


    public void traverse(){
        if(last == null) return;
        Node head = last.next;
        Node temp = last.next;

        if (temp != null) 
        {
            do
            {
                System.out.print(temp.item + " ");
                temp = temp.next;
            } while (temp != head);
        }
    }


    public void delete(Item item){
        Node head = last.next;
        Node temp = last.next;
        Node prev = last.next;

        if(temp != null){
            do{
                if(temp.item == item){
                    prev.next = temp.next;
                }
                prev = temp;
                temp = temp.next;
            }while(temp != head);
        }

    }

    public void pop(){
        if(last == null) return;
        if(last.next == last){
            last = null;
        }else{
            last.next = last.next.next;
        }

    }



}
