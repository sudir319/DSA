package datastructures.tree.bt;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
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
        TreeNode newNode = new TreeNode(value);
        if(rootNode == null)
        {
            rootNode = newNode;
        }
        else
        {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(rootNode);
            TreeNode currentNode = null;
            while(!queue.isEmpty()) {
                currentNode = queue.remove();
                if(currentNode.getLeftNode() == null) {
                    currentNode.setLeftNode(newNode);
                    break;
                }
                else if(currentNode.getRightNode() == null) {
                    currentNode.setRightNode(newNode);
                    break;
                }
                else {
                    queue.add(currentNode.getLeftNode());
                    queue.add(currentNode.getRightNode());
                }
            }
        }
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
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(rootNode);
        TreeNode node = null;
        while(!queue.isEmpty()) {
            node = queue.remove();
            if(node.getValue() == value) {
                node.setValue(getDeepestNode().getValue());
                removeDeepestNode();
                break;
            }
            if(node.getLeftNode() != null) {
                queue.add(node.getLeftNode());
            }
            if(node.getRightNode() != null) {
                queue.add(node.getRightNode());
            }
        }
    }

    private TreeNode getDeepestNode()
    {
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
        }
        return node;
    }

    private void removeDeepestNode()
    {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(rootNode);
        TreeNode previousNode, presentNode = null;
        while(!queue.isEmpty()) {
            previousNode = presentNode;
            presentNode = queue.remove();

            if (presentNode.getLeftNode() == null) {
                previousNode.setRightNode(null);
                return;
            }else if ((presentNode.getRightNode() == null)) {
                presentNode.setLeftNode(null);
                return;
            }

            if(presentNode.getLeftNode() != null) {
                queue.add(presentNode.getLeftNode());
            }
            if(presentNode.getRightNode() != null) {
                queue.add(presentNode.getRightNode());
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        for(int i = 1; i <= 15; i++) {
            binaryTree.insert(i * 10);
        }

        binaryTree.preOrderTraversal();
        binaryTree.inOrderTraversal();
        binaryTree.postOrderTraversal();
        binaryTree.levelOrderTraversal();

        binaryTree.removeNodeWithValue(20);

        binaryTree.preOrderTraversal();
        binaryTree.inOrderTraversal();
        binaryTree.postOrderTraversal();
        binaryTree.levelOrderTraversal();
    }
}

//                                        10
//                        20                              30
//                40              50              60              70
//            80      90     100      110     120     130     140     150


//                      10
//           20                    30
//       40      50            60      70
//   80