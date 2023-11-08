package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @DisplayName("로또 번호 유효성 검사 테스트 - 6자리가 아닌 데이터 - 오류")
    @Test
    void validateNumbersAmountTest() {
        List<Integer> testNumbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> new Lotto(testNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구매를 위한 6개의 당첨번호를 입력해주세요.");
    }

    @DisplayName("로또 번호 유효성 검사 테스트 - 1~45를 벗어난 데이터 - 오류")
    @Test
    void validateNumbersRangeTest() {
        List<Integer> testNumbers = Arrays.asList(1, 2, 3, 4, 5, 46);
        assertThatThrownBy(() -> new Lotto(testNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 번호는 1~45의 숫자를 입력해주세요.");
    }

    @DisplayName("로또 번호 유효성 검사 테스트 - 중복된 데이터 - 오류")
    @Test
    void validateNumbersDuplicatedTest() {
        List<Integer> testNumbers = Arrays.asList(1, 2, 3, 4, 5, 5);
        assertThatThrownBy(() -> new Lotto(testNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복되지 않은 숫자를 입력해주세요.");
    }

    @DisplayName("로또 번호 유효성 검사 테스트 - 정상 데이터 - 성공")
    @Test
    void validateNumbersCorrectTest() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 45));
        List<Integer> expectedResult = Arrays.asList(1, 2, 3, 4, 5, 45);
        assertThat(lotto.getNumbers()).isEqualTo(expectedResult);
    }

    @DisplayName("로또 번호 불변성 테스트 - 번호 삭제 시도 - 오류")
    @Test
    void validateImmutableNumbersTest() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 45));
        List<Integer> expectedResult = Arrays.asList(1, 2, 3, 4, 5, 45);
        assertThatThrownBy(() -> lotto.getNumbers().remove(45))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("같은 번호 개수 반환 테스트 - 정상 데이터 - 성공")
    @Test
    void calculateSameNumbersTest() {
        Lotto testLotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 45));
        Lotto testLotto2 = new Lotto(Arrays.asList(5, 6, 7, 8, 9, 45));
        int expectedResult = 2;
        assertThat(testLotto1.calculateSameNumbers(testLotto2)).isEqualTo(expectedResult);
    }
}
