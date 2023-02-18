public class BinaryTreeMine {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null; 
            this.right = null;
        }
    }
    static class BinaryTree {
        static int index = -1;
        public static Node buildTree(int nodes[]){
            index++;
            if(nodes[index] == -1){
                return null;
            }
            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }
    static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
}
