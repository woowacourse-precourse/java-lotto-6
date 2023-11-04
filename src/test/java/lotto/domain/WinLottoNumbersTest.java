package lotto.domain;

import lotto.util.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinLottoNumbersTest {

    @Test
    public void validTest(){
        assertDoesNotThrow(() -> new WinLottoNumbers("1,2,3,4,5,6"));
    }

    @Test
    public void typeTest(){
        assertThrows(IllegalArgumentException.class, () -> new WinLottoNumbers("1,a,3,4,b,6"));
    }

    @Test
    public void rangeTest() {
        assertThrows(IllegalArgumentException.class, () -> new WinLottoNumbers("1,-1,3,4,50,6"));
    }

    @Test
    public void sizeTest() {
        assertThrows(IllegalArgumentException.class, () -> new WinLottoNumbers("1,2,3,4,5,6,7"));
    }

}