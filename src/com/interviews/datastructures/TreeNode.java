package com.interviews.datastructures;

import java.util.*;

public class TreeNode
{
    public TreeNode left;
    public TreeNode right;
    private int val;
    public int tilt;

    /**
     * TreeNode constructor (single val point).
     * @param val
     */
    public TreeNode(int val)
    {
        this.val = val;
    }

    /**
     * TreeNode constructor (multiple val points).
     * @param data
     */
    public TreeNode(int[] data)
    {
        if (data.length > 0)
        {
            this.val = data[0];

            for (int i = 1; i < data.length; i++) {
                this.insert(new TreeNode(data[i]));
            }
        }
    }

    /**
     * Inserts val at first available space (non-sorted).
     * @param newNode
     */
    public void insert(TreeNode newNode)
    {
        TreeNode temp = this;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(temp);

        while (!q.isEmpty())
        {
            TreeNode node = q.poll();
            if (node.left == null)
            {
                node.left = newNode;
                break;
            } else {
                    q.add(node.left);
                }
            if (node.right == null)
            {
                node.right = newNode;
                break;
            } else {
                q.add(node.right);
            }
        }
    }

    /**
     * Prints the root along with all its children.
     */
    public void displayTree()
    {
        Stack<TreeNode> globalStack = new Stack();
        TreeNode root = this;
        globalStack.push(root);
        int emptyLeaf = 32;
        boolean isRowEmpty = false;
        System.out.println("****......................................................****");
        while(isRowEmpty==false)
        {

            Stack<TreeNode> localStack = new Stack();
            isRowEmpty = true;
            for(int j=0; j<emptyLeaf; j++)
                System.out.print(' ');
            while(globalStack.isEmpty()==false)
            {
                TreeNode temp = globalStack.pop();
                if(temp != null)
                {
                    if (temp.val == -1)
                    {
                        System.out.print("--");
                    } else {
                        System.out.print(temp.val);
                    }

                    localStack.push(temp.left);
                    localStack.push(temp.right);
                    if(temp.left != null ||temp.right != null)
                        isRowEmpty = false;
                }
                else
                {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for(int j=0; j<emptyLeaf*2-2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            emptyLeaf /= 2;
            while(localStack.isEmpty()==false)
                globalStack.push( localStack.pop() );
        }
        System.out.println("****......................................................****");
    }

    /**
     * Prints in post order.
     */
    public static void postOrder(TreeNode node)
    {
        if (node == null)
            return;

        //recur all left branches
        postOrder(node.left);

        //recur all right branches
        postOrder(node.right);

        System.out.print(node.val + " ");
    }

    /**
     * Returns the absolute difference of the left subtree and right subtree
     *
     * Given a binary tree, return the tilt of the whole tree.
     * The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values
     * and the sum of all right subtree node values. Null node has tilt 0.
     * The tilt of the whole tree is defined as the sum of all nodes' tilt.
     *
     */
    public int findTilt(TreeNode node) {
        if (node == null)
        {
            return 0;
        }

        tiltTraverse(node);

        return tilt;
    }

    private int tiltTraverse (TreeNode node)
    {
        if (node == null)
        {
            return 0;
        }

        int left = tiltTraverse(node.left);
        int right = tiltTraverse(node.right);

        tilt += Math.abs(left-right);

        return left + right + node.val;
    }

    public static int rangeSumBST(TreeNode root, int L, int R)
    {
        if (root == null)
            return 0;

        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty())
        {
            TreeNode node = stack.pop();
            if (node != null)
            {
                if (node.val >= L && node.val <= R)
                    sum += node.val;

                if (node.val > L)
                {
                    stack.push(node.left);
                }

                if (node.val < R)
                {
                    stack.push(node.right);
                }
            }
        }

        return sum;
    }

    public int height()
    {
        if (this == null)
            return 0;

        TreeNode root = this;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int height = 0;

        while (!q.isEmpty())
        {
            int size = q.size();
            for (int i = 0; i < size; i++)
            {
                TreeNode node = q.poll();
                if (node.left != null)
                {
                    q.add(node.left);
                }

                if (node.right != null)
                {
                    q.add(node.right);
                }
            }

            height++;
        }

        return height;
    }


}
