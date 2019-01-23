import com.interviews.datastructures.TreeNode;

public class Main {

    public static void main(String[] args) {

        int[] arr = {10,5,15,3,7,13,18,1,-1,6};
        TreeNode root = new TreeNode(arr);



        root.displayTree();


        System.out.println("range sum: " + TreeNode.rangeSumBST(root, 6, 10));

    }
}
