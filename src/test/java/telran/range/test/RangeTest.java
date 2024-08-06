package telran.range.test;

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
    
}
