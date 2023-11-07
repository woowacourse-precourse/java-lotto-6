package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.Lotto;
import lotto.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {

    private Lotto lotto;

    @BeforeEach
    void createLotto() {
        lotto = new Lotto("1,2,3,4,5,6");
    }

    @DisplayName("보너스 번호가 입력한 당첨 번호에 포함되면 예외가 발생한다.")
    @Test
    void createBonusNumberExistInLotto() {
        assertThatThrownBy(() -> new User(lotto, "5")).isInstanceOf(IllegalArgumentException.class);
    }

}
