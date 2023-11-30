package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusTest {

    private void runException(String string) {}

    @DisplayName("숫자 이외의 특수문자, 한글, 영어 등이 입력된 경우 예외가 발생한다.")
    @Test
    void createInvalidBonusNumber() {
        assertSimpleTest(() -> {
            runException("!@#,.");
        });

        assertSimpleTest(() -> {
            runException(" ");
        });
    }

    @DisplayName("보너스 볼 번호의 개수가 1개를 초과하는 경우 예외가 발생한다.")
    @Test
    void createBonusByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 볼 번호가 로또 번호와 중복되는 경우 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("보너스 볼 번호는 1 ~ 45 숫자 중에서만 선택하여 입력 가능하다.")
    @Test
    void createLottoInRange() {

        assertThatThrownBy(() -> new Lotto(List.of(46)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Lotto(List.of(0)))
                .isInstanceOf(IllegalArgumentException.class);
    }

}