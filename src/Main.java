import com.interviews.datastructures.TreeNode;

public class Main {

    public static void main(String[] args) {

        int[] arr = {3};
        TreeNode root = new TreeNode(arr);

        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(4);
        root.left.right.left.right = new TreeNode(5);

        root.displayTree();

    }
}
