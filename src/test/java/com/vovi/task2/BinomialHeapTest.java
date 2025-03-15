package com.vovi.task2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinomialHeapTest {

    private BinomialHeap heap;

    @BeforeEach
    void setUp() {
        // Initialize a BinomialHeap and insert common elements before each test
        heap = new BinomialHeap();
        heap.insert(10);
        heap.insert(5);
        heap.insert(20);
    }

    @Test
    @DisplayName("Test insertion and get_min")
    void testInsertionAndGetMin() {
        heap.insert(1); // Insert an additional element for this specific test
        assertEquals(1, heap.get_min(), "get_min should return 1");
    }

    @Test
    @DisplayName("Test extract_min")
    void testExtractMin() {
        heap.insert(1); // Insert an additional element for this specific test
        int min = heap.extract_min();
        assertEquals(1, min, "extract_min should return 1");
        assertEquals(5, heap.get_min(), "get_min should return 5 after extraction");
    }

    @Test
    @DisplayName("Test merge two heaps")
    void testMerge() {
        BinomialHeap heap2 = new BinomialHeap();
        heap2.insert(2);
        heap2.insert(15);

        heap.merge(heap2);

        assertEquals(2, heap.get_min(), "get_min should return 2 after merge");
    }

    @Test
    @DisplayName("Test decrease_key")
    void testDecreaseKey() {
        Node nodeToDecrease = heap.trees.get(0); // Get the first node in the heap
        heap.decrease_key(nodeToDecrease, 3);

        assertEquals(3, heap.get_min(), "get_min should return 3 after decrease_key");
    }

    @Test
    @DisplayName("Test size of the heap")
    void testSize() {
        assertEquals(3, heap.size(), "size should return 3");
    }

    @Test
    @DisplayName("Test if the heap is empty")
    void testIsEmpty() {
        BinomialHeap emptyHeap = new BinomialHeap();
        assertTrue(emptyHeap.is_empty(), "heap should be empty initially");

        emptyHeap.insert(10);
        assertFalse(emptyHeap.is_empty(), "heap should not be empty after insertion");
    }

    @Test
    @DisplayName("Test extract all elements and check if the heap is empty")
    void testExtractAllElements() {
        heap.extract_min();
        heap.extract_min();
        heap.extract_min();

        assertTrue(heap.is_empty(), "heap should be empty after extracting all elements");
    }
}