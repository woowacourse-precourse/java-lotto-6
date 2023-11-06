package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusTest {

    private Lotto lotto;

    @BeforeEach
    void setup() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        lotto = new Lotto(numbers);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되는 경우 예외가 발생한다.")
    @Test
    void 보너스_번호_입력_당첨_번호와_중복_실패_테스트() {
        int bonusNumber = 3;
        String expectedErrorMessage = ErrorMessage.BONUS_DUPLICATE_WITH_LOTTO.get();

        assertThatThrownBy(() -> new Bonus(bonusNumber, lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedErrorMessage);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되지 않을 경우 테스트가 성공한다.")
    @Test
    void 보너스_번호_입력_당첨_번호와_중복_성공_테스트() {
        int bonusNumber = 7;

        Bonus bonus = new Bonus(bonusNumber, lotto);

        assertThat(bonus.number()).isEqualTo(bonusNumber);
    }

    @DisplayName("보너스 번호가 1과 45 사이에 존재하지 않을 경우 예외가 발생한다.")
    @Test
    void 보너스_번호_입력_범위_실패_테스트() {
        int bonusNumber = 46;
        String expectedErrorMessage = ErrorMessage.LOTTO_NUMBER_RANGE.get();

        assertThatThrownBy(() -> new Bonus(bonusNumber, lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedErrorMessage);
    }

    @DisplayName("보너스 번호가 1과 45 사이에 존재할 경우 Bonus 객체가 정상적으로 생성된다.")
    @Test
    void 보너스_번호_입력_범위_성공_테스트() {
        int bonusNumber = 45;

        Bonus bonus = new Bonus(bonusNumber, lotto);

        assertThat(bonus.number()).isEqualTo(bonusNumber);
    }
}