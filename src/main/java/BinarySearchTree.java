public class BinarySearchTree {
    Node root;

    public BinarySearchTree(){
        root = null;
    }

    public void insert(int value){
        root = insertRec(root,value);
    }

    public Node insertRec(Node root, int value){
        if(root == null){
            root = new Node(value);
            return root;
        }

        if(value < root.value)
            root.left = insertRec(root.left, value);
        else if (value > root.value)
            root.right = insertRec(root.right,value);

        return root;
    }
    public boolean search(int value){
        return searchRec(root, value);
    }

    public boolean searchRec(Node root, int value){
        if(root == null){
            return false;
        }
        if(root.value == value){
            return true;
        }
        if(value < root.value)
            return searchRec(root.left, value);
        else
            return searchRec(root.right, value);
    }
    public void inorder(){
        inorderRec(root);
        System.out.println();
    }

    public void inorderRec(Node root){
        if(root!=null){
            inorderRec(root.left);
            System.out.print(root.value+" ");
            inorderRec(root.right);
        }
    }
}
