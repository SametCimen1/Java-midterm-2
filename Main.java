public class Main{
    public static void main(String[] args)
    {
        Bst1 bst1 = new Bst1<Integer>();
        bst1.put(1);
        bst1.put(5);
        bst1.put(3);
        bst1.put(4);

        bst1.printInOrder();

    }
}