package com.vovi.task2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinomialHeapTest {

    @Test
    @DisplayName("Test insertion and get_min")
    void testInsertionAndGetMin() {
        BinomialHeap heap = new BinomialHeap();
        heap.insert(10);
        heap.insert(5);
        heap.insert(20);
        heap.insert(1);

        assertEquals(1, heap.get_min(), "get_min should return 1");
    }

    @Test
    @DisplayName("Test extract_min")
    void testExtractMin() {
        BinomialHeap heap = new BinomialHeap();
        heap.insert(10);
        heap.insert(5);
        heap.insert(20);
        heap.insert(1);

        int min = heap.extract_min();
        assertEquals(1, min, "extract_min should return 1");
        assertEquals(5, heap.get_min(), "get_min should return 5 after extraction");
    }

    @Test
    @DisplayName("Test merge two heaps")
    void testMerge() {
        BinomialHeap heap1 = new BinomialHeap();
        heap1.insert(10);
        heap1.insert(5);

        BinomialHeap heap2 = new BinomialHeap();
        heap2.insert(2);
        heap2.insert(15);

        heap1.merge(heap2);

        assertEquals(2, heap1.get_min(), "get_min should return 2 after merge");
    }

    @Test
    @DisplayName("Test decrease_key")
    void testDecreaseKey() {
        BinomialHeap heap = new BinomialHeap();
        heap.insert(10);
        heap.insert(5);
        heap.insert(20);

        Node nodeToDecrease = heap.trees.get(0);
        heap.decrease_key(nodeToDecrease, 3);

        assertEquals(3, heap.get_min(), "get_min should return 3 after decrease_key");
    }

    @Test
    @DisplayName("Test size of the heap")
    void testSize() {
        BinomialHeap heap = new BinomialHeap();
        heap.insert(10);
        heap.insert(5);
        heap.insert(20);

        assertEquals(3, heap.size(), "size should return 3");
    }

    @Test
    @DisplayName("Test if the heap is empty")
    void testIsEmpty() {
        BinomialHeap heap = new BinomialHeap();
        assertTrue(heap.is_empty(), "heap should be empty initially");

        heap.insert(10);
        assertFalse(heap.is_empty(), "heap should not be empty after insertion");
    }

    @Test
    @DisplayName("Test extract all elements and check if the heap is empty")
    void testExtractAllElements() {
        BinomialHeap heap = new BinomialHeap();
        heap.insert(10);
        heap.insert(5);
        heap.insert(20);

        heap.extract_min();
        heap.extract_min();
        heap.extract_min();

        assertTrue(heap.is_empty(), "heap should be empty after extracting all elements");
    }
}