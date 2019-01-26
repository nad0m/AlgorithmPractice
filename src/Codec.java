/**
 * Created by Huy Nguyen on 1/25/19.
 */

import com.interviews.datastructures.TreeNode;
import java.util.*;

public class Codec
{
    // Encodes a tree to a single string.
    public String compactSerial(TreeNode root)
    {
        if (root == null)
            return null;
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        q.add(root);
        sb.append(root.val);

        while (!q.isEmpty())
        {
            TreeNode node = q.poll();

            if (node.left != null)
            {
                q.add(node.left);
                sb.append("," + node.left.val);
            }

            if (node.right != null) {
                q.add(node.right);
                sb.append("," + node.right.val);
            }

        }

        return sb.toString();
    }

    public String serialize(TreeNode root)
    {
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder serial = new StringBuilder();
        q.add(root);
        serial.append(root.val);

        while (!q.isEmpty())
        {
            TreeNode node = q.poll();

            if (node.left != null)
            {
                q.add(node.left);
                serial.append("," + node.left.val);
            } else {
                serial.append(",#");
            }

            if (node.right != null)
            {
                q.add(node.right);
                serial.append("," + node.right.val);
            } else {
                serial.append(",#");
            }
        }

        return serial.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data)
    {
        if (data == null)
            return null;

        String[] strings = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(strings[0]));

        for (int i = 1; i < strings.length; i++)
        {
            TreeNode newNode = new TreeNode(Integer.parseInt(strings[i]));
            root = BSTinsert(root, newNode);
        }

        return root;
    }

    public TreeNode BSTinsert(TreeNode root, TreeNode newNode)
    {
        TreeNode temp = root;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(temp);

        while (!q.isEmpty())
        {
            TreeNode node = q.poll();

            if (newNode.val < node.val)
            {
                if (node.left == null)
                {
                    node.left = newNode;
                    break;
                } else {
                    q.add(node.left);
                }
            } else {
                if (node.right == null) {
                    node.right = newNode;
                    break;
                } else {
                    q.add(node.right);
                }
            }
        }

        return root;
    }
}
