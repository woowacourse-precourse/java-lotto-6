package lotto.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LottoExceptionTest {

    LottoException lottoException = new LottoException();

    // TEST lotto numbers
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
    @Test
    void 로또번호_범위_벗어난_입력() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 60);
        assertThrows(IllegalArgumentException.class, () ->
                lottoException.validateNumbersPermittedRange(numbers), "[ERROR] 로또 번호의 범위는 1~45 사이여야 합니다");
    }
    @Test
    void 로또_번호_중복_입력() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);
        assertThrows(IllegalArgumentException.class, () ->
                lottoException.validateDuplicatedNumbers(numbers), "[ERROR] 번호가 중복 되었습니다");
    }

    // TEST bonus number
    @Test
    void 보너스_번호_숫자_아닌_경우() {
        String number = "NotNumeric";
        assertThrows(IllegalArgumentException.class, () ->
                lottoException.validInputBonusNumber(number), "[ERROR] 보너스 번호는 숫자로 구성되어야 합니다");
    }
}
