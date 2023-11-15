public class Bst1 <Key extends Comparable>{
    private Node root;


    private class Node{
        private Key key;
        Node left, right;
        int N;

        public Node(Key key1, int N){
            key = key1;
            left = null;
            right = null;
        }
    }

    public int size(){return size(root);}
    public int size(Node x){
        if(x == null) return 0;
        else          return x.N;
    }

    private Node put(Node x, Key key){
        if(x == null) return new Node(key, 1);

        int cmp = key.compareTo(x.key);
        if (cmp<0) x.left = put(x.left, key);
        else if (cmp>0) x.right = put(x.right, key);
        else x.key = key;

        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void put(Key key){
        root = put(root, key);
    }

    private void printInOrder(Node x){
        if (x == null) return;
        printInOrder(x.left);        
        System.out.println(x.key);
        printInOrder(x.right);
    }

    public void printInOrder(){
        printInOrder(root);
    }

    public Key min(){
        return min(root).key;
    }

    private Node min(Node x){
        if(x.left==null) return x;
        return min(x.left);
    }

    public Key max(){
        return max(root).key;
    }

    private Node max(Node x){
        if(x.right==null) return x;
        return max(x.right);
    }


    public void deleteMin(){
        root = deleteMin(root);
    }
    private Node deleteMin(Node x){
        if(x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key){
        root = delete(root, key);
    }

    private Node delete(Node x, Key key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else{
            if(x.right == null) return x.left;
            if(x.left == null) return x.right;
            Node t = x;
            x=min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }

        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }


    //traversels
    //preOrder

    public void preOrder(Node x){
        if(x != null){
            System.out.println(root.key + " ");
            preOrder(x.left);
            preOrder(x.right);
        }
    }
    //50 30 20 40 70 60 80


    //post-order
    public void postOrder(Node x){
        if(x != null){
            preOrder(x.left);
            preOrder(x.right);
            System.out.println(root.key + " ");
        }
    }
    // 20 40 30 60 80 70 50. 50 is the root


    public Node search(Node x, Key key){
        if(x == null || x.key == key){
            return x;
        }
        int cmp = key.compareTo(x.key);
        if(cmp<0)
            return search(x.left, key);
        else   
            return search(x.right, key);
    }
    private Node search(Key key){
        return search(root, key);
    }

}
