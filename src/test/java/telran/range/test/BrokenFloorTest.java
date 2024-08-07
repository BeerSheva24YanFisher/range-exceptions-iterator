package telran.range.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import telran.range.BallBrokenFloor;

public class BrokenFloorTest {

    private int getMinimalBrokenFloor(BallBrokenFloor bbf){
        int low = 1;
        int high = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high-low) / 2;
            try {
                bbf.checkFloor(mid);
                low = mid + 1;
            } catch (Exception e) {
                high = mid - 1;
            }
        }
        return low;
    }

    @Test
    void minimalBrokenFloorTest() throws Exception {
        int [] floors = {200, 17, 1001, 2000};
        for(int floor:floors) {
            BallBrokenFloor bbf = new BallBrokenFloor(floor);
            assertEquals(bbf.getMinBrokenFloor(), getMinimalBrokenFloor(bbf));
        }
    }
}

