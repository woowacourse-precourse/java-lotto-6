package lotto.exceptionTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.exception.LottoNumberException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LottoNumberExceptionTest extends NsTest {

    @Test
    @DisplayName("입력 값이 올바른 로또 번호 형식인 경우, 아닌경우")
    void 로또_형식_검증() {
        // given
        String lotto1 = "1,2,3,4,5,6";
        String lotto2 = "1,2,3,4,5";
        String lotto3 = "1,2,3,4,5,a";
        String lotto4 = "1,2,3,4,5,6,7";
        String lotto5 = "1/2/3/4/5/6";
        String lotto6 = "1 2 3 4 5 6";
        String lotto7 = "1, 2, 3, 4, 5, 6";

        // when & then
        Assertions.assertDoesNotThrow(() -> LottoNumberException.validateFormat(lotto1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> LottoNumberException.validateFormat(lotto2));
        Assertions.assertThrows(IllegalArgumentException.class, () -> LottoNumberException.validateFormat(lotto3));
        Assertions.assertThrows(IllegalArgumentException.class, () -> LottoNumberException.validateFormat(lotto4));
        Assertions.assertThrows(IllegalArgumentException.class, () -> LottoNumberException.validateFormat(lotto5));
        Assertions.assertThrows(IllegalArgumentException.class, () -> LottoNumberException.validateFormat(lotto6));
        Assertions.assertThrows(IllegalArgumentException.class, () -> LottoNumberException.validateFormat(lotto7));
    }

    @Test
    @DisplayName("입력 값이 Integer 범위를 넘어가는지 확인")
    void Integer_최대범위_내_로또번호_검증() {
        // given
        String lotto1 = "1,2,3,4,5,6"; // 올바른 형식
        String lotto2 = "1,2,3,4,5,2147483648"; // Integer 범위를 넘어감

        // when & then
        Assertions.assertDoesNotThrow(() -> LottoNumberException.validateNumbersInRangeMaxInt(lotto1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> LottoNumberException.validateNumbersInRangeMaxInt(lotto2));
    }

    @Test
    @DisplayName("입력 값이 설정된 범위 내에 있는지 확인")
    void 설정된_범위_내_로또번호_검증() {
        // given
        List<Integer> lotto1 = Arrays.asList(1, 2, 3, 4, 5, 6); // 범위 내
        List<Integer> lotto2 = Arrays.asList(1, 2, 3, 4, 5, 0); // 범위 밖 (하한을 벗어남)
        List<Integer> lotto3 = Arrays.asList(1, 2, 3, 4, 5, 46); // 범위 밖 (상한을 벗어남)

        // when & then
        Assertions.assertDoesNotThrow(() -> LottoNumberException.validateNumbersInRange(lotto1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> LottoNumberException.validateNumbersInRange(lotto2));
        Assertions.assertThrows(IllegalArgumentException.class, () -> LottoNumberException.validateNumbersInRange(lotto3));
    }

    @Test
    @DisplayName("입력 값이 중복되지 않는지 확인")
    void 로또번호_중복_검증() {
        // given
        List<Integer> lotto1 = Arrays.asList(1, 2, 3, 4, 5, 6); // 중복 없음
        List<Integer> lotto2 = Arrays.asList(1, 2, 3, 4, 5, 1); // 중복 있음

        // when & then
        Assertions.assertDoesNotThrow(() -> LottoNumberException.validateNoDuplicates(lotto1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> LottoNumberException.validateNoDuplicates(lotto2));
    }

    @Test
    @DisplayName("입력 값이 올바른 보너스 번호 형식인지 확인")
    void 보너스번호_형식_검증() {
        // given
        String bonusNumber1 = "7"; // 올바른 형식
        String bonusNumber2 = "a"; // 숫자가 아님
        String bonusNumber3 = "7.5"; // 소수점이 포함됨

        // when & then
        Assertions.assertDoesNotThrow(() -> LottoNumberException.validateBonusNumberFormat(bonusNumber1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> LottoNumberException.validateBonusNumberFormat(bonusNumber2));
        Assertions.assertThrows(IllegalArgumentException.class, () -> LottoNumberException.validateBonusNumberFormat(bonusNumber3));
    }

    @Test
    @DisplayName("입력 값이 Integer 범위를 넘어가는지 확인")
    void Integer_최대범위_내_보너스번호_검증() {
        // given
        String bonusNumber1 = "7"; // 올바른 형식
        String bonusNumber2 = "2147483648"; // Integer 범위를 넘어감

        // when & then
        Assertions.assertDoesNotThrow(() -> LottoNumberException.validateBonusNumbersInRangeMaxInt(bonusNumber1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> LottoNumberException.validateBonusNumbersInRangeMaxInt(bonusNumber2));
    }

    @Test
    @DisplayName("입력 값이 설정된 범위 내에 있는지 확인")
    void 설정된_범위_내_보너스번호_검증() {
        // given
        int bonusNumber1 = 7; // 범위 내
        int bonusNumber2 = 0; // 범위 밖 (하한을 벗어남)
        int bonusNumber3 = 46; // 범위 밖 (상한을 벗어남)

        // when & then
        Assertions.assertDoesNotThrow(() -> LottoNumberException.validateNumbersInRange(bonusNumber1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> LottoNumberException.validateNumbersInRange(bonusNumber2));
        Assertions.assertThrows(IllegalArgumentException.class, () -> LottoNumberException.validateNumbersInRange(bonusNumber3));
    }

    @Test
    @DisplayName("보너스 번호가 로또 번호와 중복되지 않는지 확인")
    void 로또번호와_보너스번호_중복_검증() {
        // given
        int bonusNumber1 = 7; // 중복 없음
        int bonusNumber2 = 1; // 중복 있음
        List<Integer> lotto = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when & then
        Assertions.assertDoesNotThrow(() -> LottoNumberException.validateBonusNumberWithLotto(bonusNumber1, lotto));
        Assertions.assertThrows(IllegalArgumentException.class, () -> LottoNumberException.validateBonusNumberWithLotto(bonusNumber2, lotto));
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
