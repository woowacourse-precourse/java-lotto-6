package lotto.domain;

import static lotto.constants.ErrorMessage.DUPLICATE_BONUS;
import static lotto.constants.ErrorMessage.NUMBER_OUT_OF_RANGE;
import static lotto.constants.LottoOption.END_LOTTO_NUMBER;
import static lotto.constants.LottoOption.START_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusTest {
    private Lotto winningLotto;

    @BeforeEach
    void setUp() {
        winningLotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("유효한 범위 내의 번호로 Bonus 객체가 생성된다.")
    @Test
    void createBonusWithValidNumber() {
        Bonus bonus = Bonus.createWithValidate(7, winningLotto);
        assertThat(bonus.getNumber()).isEqualTo(7);
    }

    @DisplayName("당첨 번호와 중복되는 보너스 번호로 Bonus 객체를 생성하면 예외가 발생한다.")
    @Test
    void createBonusWithDuplicateNumber() {
        assertThatThrownBy(() -> Bonus.createWithValidate(6, winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_BONUS.getMessage());
    }

    @DisplayName("Bonus 객체는 올바른 번호를 반환한다.")
    @Test
    void getBonusNumber() {
        Bonus bonus = Bonus.createWithValidate(7, winningLotto);
        assertThat(bonus.getNumber()).isEqualTo(7);
    }

    @DisplayName("유효한 범위 밖의 번호로 Bonus 객체를 생성하면 예외가 발생한다.")
    @Test
    void createBonusWithOutOfRangeNumber() {
        int invalidNumber = START_LOTTO_NUMBER.getValue() - 1; // 유효 범위 밖의 번호

        assertThatThrownBy(() -> Bonus.createWithValidate(invalidNumber, winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(NUMBER_OUT_OF_RANGE.getMessage(), START_LOTTO_NUMBER.getValue(),
                        END_LOTTO_NUMBER.getValue()));
    }
}