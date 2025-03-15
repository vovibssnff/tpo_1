package com.vovi.task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class HeadTest {

    private Head head;
    private static final HeadState DEFAULT_HEAD_STATE = HeadState.SMILING;

    @BeforeEach
    void setUp() {
        // Initialize a Head object with a default state before each test
        head = new Head(DEFAULT_HEAD_STATE);
    }

    @Test
    @DisplayName("Test Head constructor, getState, and toString")
    void testHeadConstructorGetStateAndToString() {
        assertAll(
                () -> assertEquals(DEFAULT_HEAD_STATE, head.getState(), "Head state should be SMILING"),
                () -> assertEquals("Head{state=SMILING}", head.toString(), "toString should return the correct representation")
        );
    }

    @Test
    @DisplayName("Test Head constructor, getState, and toString using reflection")
    void testHeadConstructorGetStateAndToStringUsingReflection() throws Exception {
        Method getStateMethod = Head.class.getMethod("getState");
        HeadState state = (HeadState) getStateMethod.invoke(head);
        assertEquals(DEFAULT_HEAD_STATE, state, "Head state should be SMILING");

        Method toStringMethod = Head.class.getMethod("toString");
        String toStringResult = (String) toStringMethod.invoke(head);
        assertEquals("Head{state=SMILING}", toStringResult, "toString should return the correct representation");
    }

    @Test
    @DisplayName("Test Head setState")
    void testHeadSetState() {
        head.setState(HeadState.PICKING_TEETH);
        assertEquals(HeadState.PICKING_TEETH, head.getState(), "Head state should be updated to PICKING_TEETH");
    }
}

class HeadStateTest {

    @Test
    @DisplayName("Test HeadState values")
    void testHeadStateValues() {
        assertEquals(3, HeadState.values().length, "HeadState should have 3 values");
        assertEquals(HeadState.SMILING, HeadState.valueOf("SMILING"), "HeadState should include SMILING");
        assertEquals(HeadState.PICKING_TEETH, HeadState.valueOf("PICKING_TEETH"), "HeadState should include PICKING_TEETH");
        assertEquals(HeadState.IDLE, HeadState.valueOf("IDLE"), "HeadState should include IDLE");
    }
}

class PersonTest {

    private Person person;
    private static final String DEFAULT_NAME = "Alice";

    @BeforeEach
    void setUp() {
        // Initialize a Person object with a default name before each test
        person = new Person(DEFAULT_NAME);
    }

    @Test
    @DisplayName("Test Person constructor and getName")
    void testPersonConstructorAndGetName() {
        assertEquals(DEFAULT_NAME, person.getName(), "Person name should be Alice");
    }

    @Test
    @DisplayName("Test Person setName")
    void testPersonSetName() {
        person.setName("Bob");
        assertEquals("Bob", person.getName(), "Person name should be updated to Bob");
    }

    @Test
    @DisplayName("Test Person toString")
    void testPersonToString() {
        assertEquals("Person{name='Alice'}", person.toString(), "toString should return the correct representation");
    }
}

class TwoHeadedPersonTest {

    private TwoHeadedPerson twoHeadedPerson;
    private Head leftHead;
    private Head rightHead;
    private static final String DEFAULT_NAME = "Alice";
    private static final HeadState DEFAULT_LEFT_HEAD_STATE = HeadState.SMILING;
    private static final HeadState DEFAULT_RIGHT_HEAD_STATE = HeadState.IDLE;

    @BeforeEach
    void setUp() {
        // Initialize a TwoHeadedPerson object with default heads and name before each test
        leftHead = new Head(DEFAULT_LEFT_HEAD_STATE);
        rightHead = new Head(DEFAULT_RIGHT_HEAD_STATE);
        twoHeadedPerson = new TwoHeadedPerson(DEFAULT_NAME, leftHead, rightHead);
    }

    @Test
    @DisplayName("Test TwoHeadedPerson constructor and getters")
    void testTwoHeadedPersonConstructorAndGetters() {
        assertEquals(DEFAULT_NAME, twoHeadedPerson.getName(), "Person name should be Alice");
        assertEquals(leftHead, twoHeadedPerson.getLeftHead(), "Left head should match the input");
        assertEquals(rightHead, twoHeadedPerson.getRightHead(), "Right head should match the input");
    }

    @Test
    @DisplayName("Test TwoHeadedPerson setters")
    void testTwoHeadedPersonSetters() {
        Head newLeftHead = new Head(HeadState.PICKING_TEETH);
        Head newRightHead = new Head(HeadState.SMILING);
        twoHeadedPerson.setLeftHead(newLeftHead);
        twoHeadedPerson.setRightHead(newRightHead);

        assertEquals(newLeftHead, twoHeadedPerson.getLeftHead(), "Left head should be updated");
        assertEquals(newRightHead, twoHeadedPerson.getRightHead(), "Right head should be updated");
    }

    @Test
    @DisplayName("Test TwoHeadedPerson toString")
    void testTwoHeadedPersonToString() {
        String expected = "TwoHeadedPerson{name='Alice', leftHead=Head{state=SMILING}, rightHead=Head{state=IDLE}}";
        assertEquals(expected, twoHeadedPerson.toString(), "toString should return the correct representation");
    }
}