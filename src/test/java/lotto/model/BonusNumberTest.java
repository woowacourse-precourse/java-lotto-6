package lotto.model;

import lotto.constant.IntConstants;
import lotto.message.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {
    private static final int MIN_LOTTO_NUMBER = IntConstants.MIN_LOTTO_NUMBER.getValue();
    private static final int MAX_LOTTO_NUMBER = IntConstants.MAX_LOTTO_NUMBER.getValue();
    private static final List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);

    @DisplayName("올바른 값을 입력하면 성공한다.")
    @Test
    public void createBonusNumber() {
        String inputValue = "7";
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 45);
        BonusNumber bonusNumber = new BonusNumber(inputValue, winningLotto);
        assertThat(bonusNumber.getBonusNumber()).isEqualTo(7);
    }

    @DisplayName("숫자가 아닌 값을 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "    ", "7b"})
    public void createBonusNumberInNotNumber(String bonusNumber) {
        assertThatThrownBy(() -> new BonusNumber(bonusNumber, winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_NOT_NUMBER_MESSAGE.getMessage());
    }

    @DisplayName("1부터 45사이의 범위를 넘어가면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    public void createBonusNumberOutOfRange(String bonusNumber) {
        assertThatThrownBy(() -> new BonusNumber(bonusNumber, winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.IS_NOT_IN_RANGE.getMessage(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER));
    }

    @DisplayName("당첨 번호 안에 보너스 번호가 존재하면 예외가 발생한다.")
    @Test
    public void createBonusNumberInWinningLotto() {
        String bonusNumber = "6";
        assertThatThrownBy(() -> new BonusNumber(bonusNumber, winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_DUPLICATE_WITH_WINNING_LOTTO.getMessage());
    }
}
