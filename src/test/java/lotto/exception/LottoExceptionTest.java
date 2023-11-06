package lotto.exception;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LottoExceptionTest {

    LottoException lottoException = new LottoException();

    @Test
    void 로또번호_양식_어긋난_경우() {
        String numbers = "1,2,3,4,5.6";
        assertThrows(IllegalArgumentException.class, () ->
                lottoException.validInputLottoNumbers(numbers), "[ERROR] 로또 번호 입력은 숫자와 콤마(,)로 구성되어야 합니다");
    }

    @Test
    void 로또번호_개수_초과한_입력() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
        assertThrows(IllegalArgumentException.class, () ->
                lottoException.validateLottoNumbersLength(numbers), "[ERROR] 로또 번호는 6개이어야 합니다");

    }
}
