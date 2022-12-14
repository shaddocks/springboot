package tree;

import java.util.*;

public class TreeTest {
    //144.前序遍历
    public void preorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();

        if (root == null) return result;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            stack.push(node.right);
            stack.push(node.left);
        }
        return result;
    }

    //145.后序遍历
    public void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorder(root.left, result);
        inorder(root.right, result);
        result.add(root.val);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();

        if (root == null) return result;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            stack.push(node.left);
            stack.push(node.right);
        }
        Collections.reverse(result);
        return result;
    }

    //94.中序遍历
    public void postorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postorder(root.left, result);
        result.add(root.val);
        postorder(root.right, result);
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
        }
        return result;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {

        }
        return result;
    }

    //102.层序遍历(107, 199, 637, 429, 515, 116, 117, 104, 111)
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> layer = new ArrayList<>();

            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                assert node != null;
                layer.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(layer);
        }
        return result;
    }

    //226.翻转二叉树
    public void invertTree1(TreeNode root) {
        if (root == null) return;
        invertTree1(root.left);
        invertTree1(root.right);
        swapChildren(root);
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                TreeNode node = deque.poll();
                assert node != null;
                swapChildren(node);
                if (node.left != null) {deque.offer(node.left);}
                if (node.right != null) {deque.offer(node.right);}
            }
        }
        return root;
    }

    private void swapChildren(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    //101.对称二叉树
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        else return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode leftChild, TreeNode rightChild) {
        if (leftChild == null && rightChild == null) return true;
        if (leftChild == null || rightChild == null) return false;
        return leftChild.val == rightChild.val && isSymmetric(leftChild.left, rightChild.right) && isSymmetric(leftChild.right, rightChild.left);
    }

    //104.二叉树的最大深度
    //层序遍历
    //后序遍历
    public int depth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }

    int result;
    public void depth2(TreeNode root, int depth) {
        result = Math.max(depth, result);
        if (root.left == null && root.right == null) return ;
        if (root.left != null) {
            depth2(root.left, depth + 1);
        }
        if (root.right != null) {
            depth2(root.right, depth + 1);
        }
    }

    //559.n叉树的最大深度
    public int maxDepth(Node root) { // 简单的层序遍历
        int result = 0;
        ArrayDeque<Node> queue = new ArrayDeque<>();

        if (root == null) return result;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                assert node != null;
                if (node.children != null) {
                    queue.addAll(node.children);
                }
            }
            ++result;
        }
        return result;
    }

    public int maxDepth2(Node root) { //后序求高度
        if (root == null) return 0;
        int depth = 0;
        for (Node child : root.children) {
            depth = Math.max(depth, maxDepth2(child));
        }
        return depth + 1;
    }

    //111.二叉树的最小深度
    public int minDepth(TreeNode root) {//后序遍历
        if (root == null) return 0;
        if (root.left == null) { //注意的是深度是指从根结点到最近叶子结点的结点数量
            return 1 + minDepth(root.right);
        }
        if (root.right == null) {
            return 1+ minDepth(root.left);
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    public void minDepth(TreeNode root, int depth) {//前序遍历
        if (root.left == null && root.right == null) {
            result = Math.min(depth, result);
        }
        if (root.left != null) {
            minDepth(root.left, depth + 1);
        }
        if (root.right != null) {
            minDepth(root.right, depth + 1);
        }
    }

    //222.完全二叉树的节点个数
    public int countNodes(TreeNode root) { //迭代法
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    //层序遍历 略

    public int countNodes2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 0;
        int rightDepth = 0;
        while (left != null) {
            left = left.left;
            ++leftDepth;
        }
        while (right != null) {
            right  = right.right;
            ++rightDepth;
        }
        if (leftDepth == rightDepth) {// 左子树是满二叉树
            return (2 << leftDepth) - 1;
        }
        return countNodes2(root.left) + countNodes2(root.right) + 1;
    }

    //110.平衡二叉树
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(getNodeDepth(root.left) - getNodeDepth(root.right)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int getNodeDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getNodeDepth(root.left), getNodeDepth(root.right));
    }

    private int getHeight(TreeNode root) {//以-1返回值标记未平衡二叉树
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        // 左右子树高度差大于1，return -1表示已经不是平衡树了
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    //257.二叉树的所有路径
    public List<String> binaryTreePaths(TreeNode root) {
        return null;
    }
}
