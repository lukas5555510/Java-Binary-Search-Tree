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

    public void deleteNode(int value){
        root = deleteNodeRec(root, value);
    }

    public Node deleteNodeRec(Node root, int value){
        if(root == null){
            return root;
        }

        if(value > root.value){
            root.right = deleteNodeRec(root.right,value);
        } else if (value < root.value) {
            root.left = deleteNodeRec(root.left, value);
        }else {
            //node with only one child or no child
            if(root.left == null){
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            //node with 2 children

            root.value = minValue(root.right);
            root.right = deleteNodeRec(root.right,root.value);
        }
            return root;
    }

    int minValue(Node root){
        int minv = root.value;
        while(root.left!=null){
            minv = root.left.value;
            root = root.left;
        }
        return minv;
    }

    public int countNodes(){
        return countNodesRec(root);
    }
    int countNodesRec(Node root){
        if(root == null){
            return 0;
        }else{
            return 1 + countNodesRec(root.left) + countNodesRec(root.right);
        }
    }

    public int sumValues(){
        return sumValuesRec(root);
    }

    int sumValuesRec(Node root){
        if (root == null){
            return 0;
        }else {
            return root.value + sumValuesRec(root.right)+ sumValuesRec(root.left);
        }
    }

    public int height(){
        return heightRec(root);
    }

    int heightRec(Node root){
        if(root == null){
            return 0;
        }else{
            return 1+Math.max(heightRec(root.left),heightRec(root.right));
        }
    }

    public int min(){
        return minRec(root).value;
    }
    public int max(){
        return maxRec(root).value;
    }

    Node maxRec(Node root){
        if(root == null) {
            return null;
        }
        else if(root.right == null){
            return root;
        }else
            return maxRec(root.right);
    }

    Node minRec(Node root){
        if(root == null)
            return null;
        else if(root.left == null)
            return root;
        else
            return minRec(root.left);
    }

    public int countLeaves(){
        return countLeavesRec(root);
    }
    int countLeavesRec(Node root){
        if(root == null)
            return 0;
        else if(root.left == null && root.right == null)
            return 1;
        else return countLeavesRec(root.left)+countNodesRec(root.right);
    }
}
