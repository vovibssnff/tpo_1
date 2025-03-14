package com.vovi.task2;

import java.util.*;

class Node {
    public int value;
    public Node parent;
    public List<Node> children;
    public int degree;
    public boolean marked;

    public Node(int val) {
        value = val;
        parent = null;
        children = new ArrayList<>();
        degree = 0;
        marked = false;
    }
}

class BinomialHeap {
    public List<Node> trees;
    public Node min_node;
    public int count;

    public BinomialHeap() {
        min_node = null;
        count = 0;
        trees = new ArrayList<>();
    }

    public boolean is_empty() {
        return min_node == null;
    }

    public void insert(int value) {
        Node node = new Node(value);
        BinomialHeap heap = new BinomialHeap();
        heap.trees.add(node);
        heap.count = 1;
        merge(heap);
    }

    public int get_min() {
        if (is_empty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        return min_node.value;
    }

    public int extract_min() {
        if (is_empty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        Node minNode = min_node;
        trees.remove(minNode);
        BinomialHeap heap = new BinomialHeap();
        heap.trees = minNode.children;
        for (Node child : heap.trees) {
            child.parent = null; // Reset parent pointers
        }
        merge(heap); // Merge the children into the heap
        _consolidate(); // Consolidate the heap after merging
        _find_min(); // Update the min_node
        count -= 1;
        return minNode.value;
    }

    public void merge(BinomialHeap other_heap) {
        trees.addAll(other_heap.trees);
        count += other_heap.count;
        _consolidate(); // Consolidate the heap after merging
        _find_min(); // Update the min_node
    }

    public void _find_min() {
        min_node = null;
        for (Node tree : trees) {
            if (min_node == null || tree.value < min_node.value) {
                min_node = tree;
            }
        }
    }

    public void decrease_key(Node node, int new_value) {
        if (new_value > node.value) {
            throw new IllegalArgumentException("New value is greater than the current value");
        }
        node.value = new_value;
        _bubble_up(node);
        _find_min(); // Update the min_node
    }

    public void delete_node(Node node) {
        decrease_key(node, Integer.MIN_VALUE);
        extract_min();
    }

    public void _bubble_up(Node node) {
        Node parent = node.parent;
        while (parent != null && node.value < parent.value) {
            int temp = node.value;
            node.value = parent.value;
            parent.value = temp;
            node = parent;
            parent = node.parent;
        }
    }

    public void _link(Node tree1, Node tree2) {
        if (tree1.value > tree2.value) {
            Node temp = tree1;
            tree1 = tree2;
            tree2 = temp;
        }
        tree2.parent = tree1;
        tree1.children.add(tree2);
        tree1.degree += 1;
    }

    public void _consolidate() {
        int max_degree = (int) Math.floor(Math.log(count) / Math.log(2)) + 1;
        Node[] degree_to_tree = new Node[max_degree + 1];

        while (!trees.isEmpty()) {
            Node current = trees.get(0);
            trees.remove(0);
            int degree = current.degree;
            while (degree_to_tree[degree] != null) {
                Node other = degree_to_tree[degree];
                degree_to_tree[degree] = null;
                if (current.value < other.value) {
                    _link(current, other);
                } else {
                    _link(other, current);
                    current = other;
                }
                degree++;
            }
            degree_to_tree[degree] = current;
        }

        min_node = null;
        trees.clear();
        for (Node tree : degree_to_tree) {
            if (tree != null) {
                trees.add(tree);
                if (min_node == null || tree.value < min_node.value) {
                    min_node = tree;
                }
            }
        }
    }

    public int size() {
        return count;
    }
}
