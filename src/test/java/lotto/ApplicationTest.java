package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("로또 구입 금액에 숫자가 아닌 다른 문자열을 입력하면 예외가 발생한다.")
    @Test
    void InputLottoMoneyByNotNumber() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 구입 금액 단위가 1000으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @Test
    void InputWrongLottoMoneyUnit() {
        assertSimpleTest(() -> {
            runException("1100");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

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

    @DisplayName("로또 번호의 개수가 6개 미만이면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 숫자가 1 ~ 45 범위를 만족하지 않으면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 50)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 숫자와 구분자 쉼표(,)를 제외하고 다른 문자열을 입력하면 예외가 발생한다.")
    @Test
    void InputLottoByNotNumber() {
        assertSimpleTest(() -> {
            runException("1000", "#");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호에 숫자가 아닌 다른 문자열을 입력하면 예외가 발생한다.")
    @Test
    void InputBonusByNotNumber() {
        assertSimpleTest(() -> {
            runException("1000", "1, 2, 3, 4, 5, 6", "40,");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호의 숫자가 1 ~ 45 범위를 만족하지 않으면 예외가 발생한다.")
    @Test
    void InputBonusByOutOfRangeNumber() {
        assertSimpleTest(() -> {
            runException("1000", "1, 2, 3, 4, 5, 6", "50");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호가 로또 번호와 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void InputBonusByDuplicatedNumber() {
        assertSimpleTest(() -> {
            runException("1000", "1, 2, 3, 4, 5, 6", "6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
