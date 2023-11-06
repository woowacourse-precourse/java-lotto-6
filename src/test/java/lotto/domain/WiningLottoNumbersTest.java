package lotto.domain;

import static lotto.ErrorMessage.BONUS_DUPLICATION_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WiningLottoNumbersTest {

    @Test
    @DisplayName("보너스 번호와 로또번호에 중복이 있다.")
    void createWiningLottoNumbersByBonusDuplicationInLotto() {
        Lotto lotto = new Lotto(List.of(5, 10, 15, 20, 25, 30));
        Bonus bonus = new Bonus(15);

        assertThatThrownBy(() -> new WiningLottoNumbers(lotto, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_DUPLICATION_ERROR_MESSAGE.get());
    }
}
