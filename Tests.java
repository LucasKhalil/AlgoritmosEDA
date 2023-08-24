import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import Algoritmos.Array;
import Algoritmos.Stack;
import org.junit.Before;
import org.junit.Test;

public class Tests {

    private Stack emptyStackLen10;
    private Stack emptyStackLen1;
    private Stack emptyStackLen0;
    private Stack repeatedElementsStack;
    private Stack differentElementsStack;

    @Before
    public void setUp() {
        this.emptyStackLen10 = new Stack(10);
        this.emptyStackLen1 = new Stack(1);
        this.emptyStackLen0 = new Stack(0);
        this.repeatedElementsStack = new Stack(new int[] { 2, 2, 2, 2, 2, 2 });
        this.differentElementsStack = new Stack(new int[] { 1, 2, 3, 4, 7, 10, 5 });
    }

    private void genericTestEmpty(Stack stack) {
        assertTrue(stack.isEmpty());
        try {
            stack.pop();
        } catch (Exception e) {
        }
        System.out.println(stack.toString());
        stack.push(10);
        System.out.println(stack.toString());
        assertEquals(stack.peek(), 10);
        assertEquals(stack.size(), 1);
        assertEquals(stack.capacity(), stack.getContent().length);
        assertEquals(stack.pop(), 10);
        System.out.println(stack.toString());
        assertEquals(stack.size(), 0);
        assertEquals(stack.capacity(), stack.getContent().length);
        for (int i = 0; i < stack.capacity(); i++) {
            stack.push(i);
            System.out.println(stack.toString());
        }
        assertTrue(stack.isFull());
        try {
            stack.push(0);
        } catch (Exception e) {
        }
        assertTrue(stack.isFull());
        assertTrue(!stack.isEmpty());
        assertTrue(stack.contains(stack.capacity() - 1));
        assertTrue(stack.contains((stack.capacity() - 1) / 2));
        assertTrue(stack.contains(0));
        assertEquals(stack.indexOf(stack.capacity() - 1), stack.capacity() - 1);
        assertEquals(stack.indexOf((stack.capacity() - 1) / 2), (stack.capacity() - 1) / 2);
        assertEquals(stack.indexOf(0), 0);

    }

    @Test
    public void testStackLen10() {
        Stack stack = this.emptyStackLen10;
        genericTestEmpty(stack);
    }

}