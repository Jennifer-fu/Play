package tree;

public class BinarySearchTree {

    private Node root;


    public Node insert(int key) {
        Node node = new Node(key);
        if (root == null) {
            root = node;
        } else {
            Node current = root;
            while (true) {
                if (current.getValue() > key) {
                    if (current.hasRight()) current = current.getRight();
                    else {
                        current.setRight(node);
                        return root;
                    }
                } else if (current.getValue() < key) {
                    if (current.hasLeft()) current = current.getLeft();
                    else {
                        current.setLeft(node);
                        return root;
                    }
                } else {
                    return root;
                }
            }
        }
        return root;
    }

    public int LCA(Node root, Node n1, Node n2) {
        int value1 = n1.getValue();
        int value2 = n2.getValue();
        int left = value1 > value2 ? value2 : value1;
        int right = value1 > value2 ? value1 : value2;

        Node current = root;
        Node parent = null;
        while (true) {
            int currentValue = current.getValue();
            if (currentValue < left) {
                parent = current;
                current = current.getRight();
            } else if (currentValue > right) {
                parent = current;
                current = current.getLeft();
            } else if (currentValue == left || currentValue == right) {
                return parent.getValue();
            } else {
                return currentValue;
            }
        }
    }
}
