package lotto.model;

import lotto.constant.Constants;
import lotto.message.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {
    private static final int MIN_LOTTO_NUMBER = Constants.MIN_LOTTO_NUMBER.getValue();
    private static final int MAX_LOTTO_NUMBER = Constants.MAX_LOTTO_NUMBER.getValue();

    @DisplayName("올바른 값을 입력하면 성공한다.")
    @Test
    public void createBonusNumber() {
        String inputValue = "7";
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 45);
        BonusNumber bonusNumber = new BonusNumber(inputValue, winningLotto);
        assertThat(bonusNumber.getBonusNumber()).isEqualTo(7);
    }

    @DisplayName("빈 값을 입력하면 예외가 발생한다.")
    @Test
    public void createEmptyBonusNumber() {
        String inputValue = "";
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> new BonusNumber(inputValue, winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_NOT_NUMBER_MESSAGE.getMessage());
    }

    @DisplayName("공백으로 이루어진 값을 입력하면 예외가 발생한다.")
    @Test
    public void createBonusNumberWithBlank() {
        String inputValue = "    ";
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> new BonusNumber(inputValue, winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_NOT_NUMBER_MESSAGE.getMessage());
    }

    @DisplayName("숫자가 아닌 값을 입력하면 예외가 발생한다.")
    @Test
    public void createNot() {
        String inputValue = "7b";
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> new BonusNumber(inputValue, winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_NOT_NUMBER_MESSAGE.getMessage());
    }

    @DisplayName("1부터 45사이의 범위를 넘어가면 예외가 발생한다.")
    @Test
    public void createBonusNumberOutOfRange() {
        String inputValue = "0";
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> new BonusNumber(inputValue, winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.IS_NOT_IN_RANGE.getMessage(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER));
    }

    @DisplayName("1부터 45사이의 범위를 넘어가면 예외가 발생한다.")
    @Test
    public void createBonusNumberOutOfRange2() {
        String inputValue = "46";
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> new BonusNumber(inputValue, winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.IS_NOT_IN_RANGE.getMessage(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER));
    }

    @DisplayName("당첨 번호 안에 보너스 번호가 존재하면 예외가 발생한다.")
    @Test
    public void createBonusNumberInWinningLotto() {
        String inputValue = "6";
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> new BonusNumber(inputValue, winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_DUPLICATE_WITH_WINNING_LOTTO.getMessage());
    }
}
