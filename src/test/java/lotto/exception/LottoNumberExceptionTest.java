package lotto.exception;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumberExceptionTest {
    @Test
    public void testLottoNumberException_ValidInput() {

        String input = "1,2,3,4,5,6";


        List<Integer> lottoNumbers = LottoNumberException.LottoNumberException(input);


        assertEquals(6, lottoNumbers.size());
        assertEquals(1, (int) lottoNumbers.get(0));
        assertEquals(2, (int) lottoNumbers.get(1));
        assertEquals(3, (int) lottoNumbers.get(2));
        assertEquals(4, (int) lottoNumbers.get(3));
        assertEquals(5, (int) lottoNumbers.get(4));
        assertEquals(6, (int) lottoNumbers.get(5));
    }

    @Test
    public void testLottoNumberException_InvalidInput() {
        String input = "1,2,3,4,5,";


        LottoNumberException.LottoNumberException(input);
    }

    @Test
    public void testLottoNumberException_WrongSizeInput() {

        String input = "1,2,3,4,5";


        LottoNumberException.LottoNumberException(input);
    }
}
