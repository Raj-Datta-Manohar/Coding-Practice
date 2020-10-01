package DCP;

/**
 * Problem: Given a binary tree, implement Serialize(serializes the tree into string)
 * and deserialize(deserializes the string back into tree)
 */

public class Day3 {

    private static String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        int n = sb.length();
        sb.deleteCharAt(n-1);
        return sb.toString();
    }

    private static void serializeHelper(Node node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,");//# represents null
            return;
        }
        sb.append(""+node.val);
        sb.append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    private static Node deserialize(String s) {
        String[] nodes = s.split(",");
        int n = nodes.length;
        Node root = deserializeHelper(nodes, 0, n);
        return root;
    }

    private static Node deserializeHelper(String[] nodes, int currentIndex, int total) {
        if (i == n || nodes[i].equals("#"))
            return null;
        Node node = new Node(Integer.parseInt(nodes[i]));
        node.left = deserialize(nodes, currentIndex+1, n);
        node.right = deserialize(nodes, currentIndex+2, n);
        return node;
    } 
    
    public static void main(String[] args) {
        Node root = deserialize("");
        String s = serialize(root);
    }
}

class Node {

    int val;
    Node left, right;

    private Node() {}

    public Node(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}