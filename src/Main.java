import com.interviews.datastructures.TreeNode;

public class Main {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,-1,2,4,-1,-1};
        TreeNode root = new TreeNode(arr);



        root.displayTree();


        Codec codec = new Codec();

        System.out.println("serialize: " + codec.serialize(root));


    }
}
