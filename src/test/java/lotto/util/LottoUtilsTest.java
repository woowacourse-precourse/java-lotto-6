package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
public class LottoUtilsTest {
    @Test
    @DisplayName("입력받은 숫자 문자열을 로또 번호 리스트로 변환한다")
    void convertStringToLottoNumberList() {
        String input = "1, 2, 3, 4, 5, 6";
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> result = LottoUtils.convertStringToLottoNumberList(input);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("로또 번호의 유효성을 검사한다")
    void validateLottoNumbers() {
        List<Integer> validNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(LottoUtils.validateLottoNumbers(validNumbers)).isTrue();

        List<Integer> invalidNumbers = Arrays.asList(0, 2, 3, 4, 5, 51);
        assertThrows(IllegalArgumentException.class, () -> LottoUtils.validateLottoNumbers(invalidNumbers));
    }
}
