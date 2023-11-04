package lotto.domain;

import lotto.util.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoWinNumbersTest {
    @Test
    public void setWinLottoLoopTest() {
        Status status = Status.FAIL;
        int attempt = 0;

        while (status == Status.FAIL) {
            try {
                new LottoWinNumbers("fail");
                status = Status.SUCCESS;
            }catch (IllegalArgumentException ignored){ }
            finally {
                attempt++;
            }
            if(attempt==3){
                break;
            }
        }
        assertEquals(attempt, 3);
    }

    @Test
    public void validTest(){
        assertDoesNotThrow(() -> new LottoWinNumbers("1,2,3,4,5,6"));
    }

    @Test
    public void typeTest(){
        assertThrows(IllegalArgumentException.class, () -> new LottoWinNumbers("1,a,3,4,b,6"));
    }

    @Test
    public void rangeTest() {
        assertThrows(IllegalArgumentException.class, () -> new LottoWinNumbers("1,-1,3,4,50,6"));
    }

    @Test
    public void sizeTest() {
        assertThrows(IllegalArgumentException.class, () -> new LottoWinNumbers("1,2,3,4,5,6,7"));
    }

}