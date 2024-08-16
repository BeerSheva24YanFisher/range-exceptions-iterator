package telran.range;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class Range implements Iterable<Integer>{
    private static final String ERROR_MESSAGE = "max less or equal min";
    private static int min;
    private static int max;
    private Predicate<Integer> predicate;

    public void setPredicate(Predicate<Integer> predicate){
        this.predicate = predicate;
    }

    private Range(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public static Range getRange(int min, int max) {
        if (max <= min) {
            throw new IllegalArgumentException(ERROR_MESSAGE);            
        }
        return new Range(min, max);       
    }

    public static void checkNumber(int number) throws OutOfRangeMaxValueException, OutOfRangeMinValueException {
        if (number>max) {
            throw new OutOfRangeMaxValueException(max, number);            
        }
        if (number<min) {
            throw new OutOfRangeMinValueException(min, number);            
        }

        

    }   

    @Override
    public Iterator<Integer> iterator() {
       return new RangeIterator();
    }


    private class RangeIterator implements Iterator<Integer> {
        int current = min;

        @Override
        public boolean hasNext() {
            // Не изменяем этот метод
            return current <= max;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            setCurrent(current);
            int result = current;
            setCurrent(current + 1);
            return result;
        }

        private void setCurrent(int start) {
            while (start <= max && !predicate.test(start)) {
                start++;
            }
            current = start;
        }
    }
    


    
}
