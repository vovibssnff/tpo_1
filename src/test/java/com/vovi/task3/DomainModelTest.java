package com.vovi.task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HeadTest {

    @Test
    @DisplayName("Test Head constructor and getState")
    void testHeadConstructorAndGetState() {
        Head head = new Head(HeadState.SMILING);
        assertEquals(HeadState.SMILING, head.getState(), "Head state should be SMILING");
    }

    @Test
    @DisplayName("Test Head setState")
    void testHeadSetState() {
        Head head = new Head(HeadState.IDLE);
        head.setState(HeadState.PICKING_TEETH);
        assertEquals(HeadState.PICKING_TEETH, head.getState(), "Head state should be updated to PICKING_TEETH");
    }

    @Test
    @DisplayName("Test Head toString")
    void testHeadToString() {
        Head head = new Head(HeadState.SMILING);
        assertEquals("Head{state=SMILING}", head.toString(), "toString should return the correct representation");
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

    @Test
    @DisplayName("Test Person constructor and getName")
    void testPersonConstructorAndGetName() {
        Person person = new Person("Alice");
        assertEquals("Alice", person.getName(), "Person name should be Alice");
    }

    @Test
    @DisplayName("Test Person setName")
    void testPersonSetName() {
        Person person = new Person("Alice");
        person.setName("Bob");
        assertEquals("Bob", person.getName(), "Person name should be updated to Bob");
    }

    @Test
    @DisplayName("Test Person toString")
    void testPersonToString() {
        Person person = new Person("Alice");
        assertEquals("Person{name='Alice'}", person.toString(), "toString should return the correct representation");
    }
}

class TwoHeadedPersonTest {

    @Test
    @DisplayName("Test TwoHeadedPerson constructor and getters")
    void testTwoHeadedPersonConstructorAndGetters() {
        Head leftHead = new Head(HeadState.SMILING);
        Head rightHead = new Head(HeadState.IDLE);
        TwoHeadedPerson person = new TwoHeadedPerson("Alice", leftHead, rightHead);

        assertEquals("Alice", person.getName(), "Person name should be Alice");
        assertEquals(leftHead, person.getLeftHead(), "Left head should match the input");
        assertEquals(rightHead, person.getRightHead(), "Right head should match the input");
    }

    @Test
    @DisplayName("Test TwoHeadedPerson setters")
    void testTwoHeadedPersonSetters() {
        Head leftHead = new Head(HeadState.SMILING);
        Head rightHead = new Head(HeadState.IDLE);
        TwoHeadedPerson person = new TwoHeadedPerson("Alice", leftHead, rightHead);

        Head newLeftHead = new Head(HeadState.PICKING_TEETH);
        Head newRightHead = new Head(HeadState.SMILING);
        person.setLeftHead(newLeftHead);
        person.setRightHead(newRightHead);

        assertEquals(newLeftHead, person.getLeftHead(), "Left head should be updated");
        assertEquals(newRightHead, person.getRightHead(), "Right head should be updated");
    }

    @Test
    @DisplayName("Test TwoHeadedPerson toString")
    void testTwoHeadedPersonToString() {
        Head leftHead = new Head(HeadState.SMILING);
        Head rightHead = new Head(HeadState.IDLE);
        TwoHeadedPerson person = new TwoHeadedPerson("Alice", leftHead, rightHead);

        String expected = "TwoHeadedPerson{name='Alice', leftHead=Head{state=SMILING}, rightHead=Head{state=IDLE}}";
        assertEquals(expected, person.toString(), "toString should return the correct representation");
    }
}
