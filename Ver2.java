package com.mycompany.ver;

import java.util.*;

// BST NODE
class Node {
    double data;
    Node left, right;

    Node(double v) {
        data = v;
        left = right = null;
    }
}

public class Ver {

    static Node root = null;

    // INSERT
    public static Node insert(Node root, double value) {

        if (root == null)
            return new Node(value);

        if (value < root.data)
            root.left = insert(root.left, value);

        else if (value > root.data)
            root.right = insert(root.right, value);

        return root;
    }

    // FIND MIN
    public static Node findMin(Node root) {
        while (root.left != null)
            root = root.left;
        return root;
    }

    // DELETE
    public static Node delete(Node root, double value) {

        if (root == null) return root;

        if (value < root.data)
            root.left = delete(root.left, value);

        else if (value > root.data)
            root.right = delete(root.right, value);

        else {

            if (root.left == null)
                return root.right;

            else if (root.right == null)
                return root.left;

            Node temp = findMin(root.right);
            root.data = temp.data;
            root.right = delete(root.right, temp.data);
        }

        return root;
    }

    // PRINT VALUE (removes .0 if whole number)
    public static void printValue(double value){
        if(value == (int)value)
            System.out.print((int)value + " ");
        else
            System.out.print(value + " ");
    }

    // INORDER
    public static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            printValue(root.data);
            inorder(root.right);
        }
    }

    // PREORDER
    public static void preorder(Node root) {
        if (root != null) {
            printValue(root.data);
            preorder(root.left);
            preorder(root.right);
        }
    }

    // POSTORDER
    public static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            printValue(root.data);
        }
    }

    public static void main(String[] args) {

        Scanner a = new Scanner(System.in);

        while (true) {

            System.out.println("\n=== Binary Search Tree Traversal ===");
            System.out.println("[A] Insert value(s)");
            System.out.println("[B] Remove value");
            System.out.println("[C] Print Traversals");
            System.out.println("[D] Exit");

            String choice = a.nextLine().toLowerCase();

            switch (choice) {

                case "a":

                    System.out.print("Enter values (example: 20, 1.5, 10, 50.75): ");
                    String input = a.nextLine();

                    String[] numbers = input.split(",");

                    for (String num : numbers) {
                        double value = Double.parseDouble(num.trim());
                        root = insert(root, value);
                    }

                    System.out.println("Values inserted.");
                    break;

                case "b":

                    System.out.print("Enter value to remove: ");
                    double remove = Double.parseDouble(a.nextLine());
                    root = delete(root, remove);
                    break;

                case "c":

                    System.out.print("Inorder: ");
                    inorder(root);

                    System.out.print("\nPreorder: ");
                    preorder(root);

                    System.out.print("\nPostorder: ");
                    postorder(root);

                    System.out.println();
                    a.close();
                    return;

                case "d":

                    System.out.println("Exit program.");
                    a.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}