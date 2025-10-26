

public class Main {
    public static void main(String[] args){
        System.out.println("Hello world");

        BinarySearchTree bts = new BinarySearchTree();

        bts.insert(3);
        bts.insert(7);
        bts.insert(5);
        bts.insert(10);
        bts.insert(20);
        bts.insert(14);
        bts.insert(57);
        bts.insert(49);

        bts.inorder();
        System.out.println(bts.countNodes());
        System.out.println(bts.sumValues());
        System.out.println("height: " + bts.height());
        System.out.println("max: "+bts.max());
        System.out.println("min: "+bts.min());

        System.out.println("leaves: "+bts.countLeaves());

        bts.deleteNode(20);



        bts.inorder();

        System.out.println(bts.search(4));
        System.out.println(bts.search(5));
        System.out.println(bts.search(6));
        System.out.println(bts.search(7));
    }
}
