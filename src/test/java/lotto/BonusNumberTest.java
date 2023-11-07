package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.Lotto;
import lotto.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberTest {

    private Lotto lotto;

    @BeforeEach
    void createLotto() {
        lotto = new Lotto("1,2,3,4,5,6");
    }

    @DisplayName("보너스 번호가 입력한 당첨 번호에 포함되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "5"})
    void createBonusNumberExistInLotto(String bonus) {
        assertThatThrownBy(() -> new User(lotto, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "가", "."})
    void createBonusNumberByString(String bonus) {
        assertThatThrownBy(() -> new User(lotto, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호의 범위가 1 ~ 45가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "46", "-1"})
    void createBonusNumberByInvalidRange(String bonus) {
        assertThatThrownBy(() ->  new User(lotto, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 공백이면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void createBonusNumberByBlank(String bonus) {
        assertThatThrownBy(() -> new User(lotto, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
