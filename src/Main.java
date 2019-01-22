import com.interviews.datastructures.TreeNode;

public class Main {

    public static void main(String[] args) {

        int[] arr = {3, 4, 5, 6, 7, 8, 9};
        TreeNode root = new TreeNode(arr);



        root.displayTree();

        System.out.print(root.findTilt(root));

    }
}
