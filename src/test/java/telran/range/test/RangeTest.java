package telran.range.test;

import java.util.Iterator;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import org.junit.jupiter.api.Test;

import telran.range.OutOfRangeMaxValueException;
import telran.range.OutOfRangeMinValueException;
import telran.range.Range;

public class RangeTest {
    private static final int MIN = 50;
    private static final int MAX = 100;
    Range range = Range.getRange(MIN, MAX);

    @Test
    void worngRangeCreatingTest(){
        assertThrowsExactly(IllegalArgumentException.class, () -> Range.getRange(MAX, MIN));
    }

    @Test
    void rightNumber() throws OutOfRangeMaxValueException, OutOfRangeMinValueException{
        range.checkNumber(55);
    }

    @Test
    void wrongNumberTest() throws Exception{
         assertThrowsExactly(OutOfRangeMaxValueException.class, () -> Range.checkNumber(MAX+1));
         assertThrowsExactly(OutOfRangeMinValueException.class, () -> Range.checkNumber(MIN-1));
    }

    @Test
    void iteratorTest(){
        Predicate<Integer> isPrime = n -> {
            boolean flag = true;
            int i=2;
            if (n<2) flag = false;
            while (i <= Math.sqrt(n) && flag == true) {
                if (n % i == 0){
                    flag = false;
                }
                i++;
            }
            return flag;
        };

        Range rangIt = Range.getRange(1, 50);
        rangIt.setPredicate(isPrime);
        Iterator<Integer> it = rangIt.iterator();

        Integer[] expected = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};
        Integer[] actual = new Integer[expected.length];
        int index = 0;
        while (it.hasNext() && index < actual.length) {
            actual[index++] = it.next();
        }

        assertArrayEquals(expected, actual);
    }
    
}
