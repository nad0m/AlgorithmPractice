import com.interviews.datastructures.TreeNode;

public class Main {

    public static void main(String[] args) {

        int[] arr = {3, 3, 5, 5, 7, 8, 9};
        TreeNode root = new TreeNode(arr);



        root.displayTree();

        TreeNode.postOrder(root);

        System.out.println("\n" + root.findTilt(root));

    }
}
