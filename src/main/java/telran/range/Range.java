package telran.range;

public class Range {
    private static final String ERROR_MESSAGE = "max less or equal min";
    private static int min;
    private static int max;

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
    


    
}
