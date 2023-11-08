package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개보다 적으면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 결과를 비교하여 요구 사항에 맞는 결과를 반환한다.")
    @ParameterizedTest
    @CsvSource({
            "1,2,3,4,5,6,7,SIX",
            "1,2,3,4,5,13,6,FIVE_BONUS",
            "1,2,3,4,5,13,7,FIVE",
            "1,2,3,4,9,13,6,FOUR",
            "1,2,3,8,9,13,6,THREE",
            "1,2,7,8,9,13,6,LOSE",
            "1,40,7,8,9,13,6,LOSE",
            "41,40,7,8,9,13,6,LOSE"
    })
    void compareLottoNumWithResultNum(int num1, int num2, int num3, int num4, int num5, int num6, int bonusNum, Result expected) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Result result = lotto.match(List.of(num1, num2, num3, num4, num5, num6), bonusNum);
        assertThat(result).isEqualTo(expected);
    }
}