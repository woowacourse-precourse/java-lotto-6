package lotto;

import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("당첨 번호 테스트")
class WinningLottoTest {
    @DisplayName("실패: 앞에서 입력한 `6`개의 숫자와 중복되면 안된다.")
    @Test
    void test1() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        Integer duplicatedNumber = 1;
        assertThatCode(() -> new WinningLotto(lotto, duplicatedNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CustomErrorMessage.DUPLICATED_BONUS_NUMBER);
    }

    @DisplayName("성공: 앞에서 입력한 `6`개의 숫자와 중복되면 안된다.")
    @Test
    void test2() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        Integer duplicatedNumber = 7;
        assertThatCode(() -> new WinningLotto(lotto, duplicatedNumber))
                .doesNotThrowAnyException();
    }
}