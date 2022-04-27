package datastructures.tree.bt;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    static class TreeNode {
        private int value;
        private TreeNode leftNode;
        private TreeNode rightNode;

        public TreeNode(int root) {
            this.value = root;
        }

        public TreeNode getLeftNode() {
            return leftNode;
        }
        public void setLeftNode(TreeNode leftNode) {
            this.leftNode = leftNode;
        }
        public TreeNode getRightNode() {
            return rightNode;
        }
        public void setRightNode(TreeNode rightNode) {
            this.rightNode = rightNode;
        }
        public int getValue() {
            return value;
        }
        public void setValue(int value) {
            this.value = value;
        }
    }

    private TreeNode rootNode;

    private void insert(int value) {
        rootNode = insert(rootNode, value);
    }

    private TreeNode insert(TreeNode currentNode, int value) {
        if(currentNode == null) {
            currentNode = new TreeNode(value);
        }
        else {
            if(value < currentNode.value) {
                currentNode.leftNode = insert(currentNode.getLeftNode(), value);
            }
            else {
                currentNode.rightNode = insert(currentNode.getRightNode(), value);
            }
        }
        return currentNode;
    }

    private void preOrderTraversal() {
        preOrderTraversal(rootNode);
        System.out.println();
    }

    private void preOrderTraversal(TreeNode node) {
        System.out.print(node.value + " ");
        if(node.getLeftNode() != null) {
            preOrderTraversal(node.leftNode);
        }
        if(node.getRightNode() != null) {
            preOrderTraversal(node.rightNode);
        }
    }

    private void inOrderTraversal() {
        inOrderTraversal(rootNode);
        System.out.println();
    }

    private void inOrderTraversal(TreeNode node) {
        if(node.getLeftNode() != null) {
            inOrderTraversal(node.leftNode);
        }
        System.out.print(node.value + " ");
        if(node.getRightNode() != null) {
            inOrderTraversal(node.rightNode);
        }
    }

    private void postOrderTraversal() {
        postOrderTraversal(rootNode);
        System.out.println();
    }

    private void postOrderTraversal(TreeNode node) {
        if(node.getLeftNode() != null) {
            postOrderTraversal(node.leftNode);
        }
        if(node.getRightNode() != null) {
            postOrderTraversal(node.rightNode);
        }
        System.out.print(node.value + " ");
    }

    private void levelOrderTraversal() {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(rootNode);
        TreeNode node = null;
        while(!queue.isEmpty()) {
            node = queue.remove();
            if(node.getLeftNode() != null) {
                queue.add(node.getLeftNode());
            }
            if(node.getRightNode() != null) {
                queue.add(node.getRightNode());
            }
            System.out.print(node.getValue() + " ");
        }

        System.out.println();
    }

    private void removeNodeWithValue(int value) {
        removeNodeWithValue(rootNode, value);
    }

    private TreeNode removeNodeWithValue(TreeNode rootNode, int value) {
        if(rootNode == null) return null;
        if(value < rootNode.value) {
            rootNode.leftNode = removeNodeWithValue(rootNode.getLeftNode(), value);
        }
        else if (value > rootNode.value) {
            rootNode.rightNode = removeNodeWithValue(rootNode.getRightNode(), value);
        }
        else {
            if(rootNode.getLeftNode() != null && rootNode.getRightNode() != null) {
                TreeNode minNode = getMinimumNodeFromTree(rootNode.getRightNode());
                removeNodeFromTree(minNode);
                minNode.leftNode = rootNode.leftNode;
                minNode.rightNode = rootNode.rightNode;
                rootNode = minNode;
            }
            else if(rootNode.getLeftNode() != null) {
                rootNode = rootNode.getLeftNode();
            }
            else if(rootNode.getRightNode() != null) {
                rootNode = rootNode.getRightNode();
            }
            else {
                rootNode = null;
            }
        }
        return rootNode;
    }

    private void removeNodeFromTree(TreeNode minNode) {
        removeNodeFromTree(rootNode, minNode);
    }

    private TreeNode removeNodeFromTree(TreeNode rootNode, TreeNode minNode) {
        if(rootNode.value < minNode.value) {
            rootNode.rightNode = removeNodeFromTree(rootNode.rightNode, minNode);
        }
        else if(rootNode.value > minNode.value) {
            rootNode.leftNode = removeNodeFromTree(rootNode.leftNode, minNode);
        }
        else {
            rootNode = null;
        }
        return rootNode;
    }

    private TreeNode getMinimumNodeFromTree(TreeNode rootNode) {
        if(rootNode.getLeftNode() != null) {
            return getMinimumNodeFromTree(rootNode.getLeftNode());
        }
        return rootNode;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        int[] values = new int[] {100, 80, 200, 70, 90, 150, 300, 50, 250, 400, 40, 60};
        for(int value : values) {
            bst.insert(value);
        }

        bst.preOrderTraversal();
        bst.inOrderTraversal();
        bst.postOrderTraversal();
        bst.levelOrderTraversal();

        bst.removeNodeWithValue(150);

        bst.preOrderTraversal();
        bst.inOrderTraversal();
        bst.postOrderTraversal();
        bst.levelOrderTraversal();
    }
}

//                                        100
//                        80                              200
//                70              90               150            300
//            50                                              250     400
//        40      60
