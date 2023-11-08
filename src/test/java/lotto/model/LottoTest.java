package lotto.model;

import lotto.constant.IntConstants;
import lotto.message.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private static final int LOTTO_SIZE = IntConstants.LOTTO_SIZE.getValue();
    private static final int MIN_LOTTO_NUMBER = IntConstants.MIN_LOTTO_NUMBER.getValue();
    private static final int MAX_LOTTO_NUMBER = IntConstants.MAX_LOTTO_NUMBER.getValue();

    @DisplayName("올바른 로또를 생성하면 성공한다.")
    @Test
    void createRightLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 5, 45, 23, 24));
        assertThat(lotto.getNumbers()).size().isEqualTo(6);
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NOT_SAME_WITH_LOTTO_SIZE.getMessage(LOTTO_SIZE));
    }

    @DisplayName("1부터 45사이의 범위를 넘어간 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoOutOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.IS_NOT_IN_RANGE.getMessage(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER));
    }

    @DisplayName("1부터 45사이의 범위를 넘어간 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoOutOfRange2() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.IS_NOT_IN_RANGE.getMessage(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER));
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.CONSIST_OF_DUPLICATE_NUMBER.getMessage());
    }

    @DisplayName("올바른 당첨 로또를 입력하면 성공한다.")
    @Test
    void inputRightLotto() {
        String inputNumbers = "1, 2, 3, 4, 5, 6";
        Lotto winningLotto = new Lotto(inputNumbers);
        assertThat(winningLotto.getNumbers()).size().isEqualTo(6);
    }

    @DisplayName("입력받은 당첨 로또가 비어있다면 예외가 발생한다.")
    @Test
    void inputEmptyLotto() {
        String inputNumbers = "";
        assertThatThrownBy(() -> new Lotto(inputNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_NOT_NUMBER_MESSAGE.getMessage());
    }

    @DisplayName("입력받은 당첨 로또가 공백으로 이루어져 있다면 예외가 발생한다.")
    @Test
    void inputBlankLotto() {
        String inputNumbers = "    ";
        assertThatThrownBy(() -> new Lotto(inputNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_NOT_NUMBER_MESSAGE.getMessage());
    }

    @DisplayName("입력받은 당첨 로또가 숫자가 아닌 값으로 이루어져 있다면 예외가 발생한다.")
    @Test
    void inputNotNumberLotto() {
        String inputNumbers = "1, 2, 3, 4, HI, 5";
        assertThatThrownBy(() -> new Lotto(inputNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_NOT_NUMBER_MESSAGE.getMessage());
    }

    @DisplayName("입력받은 당첨 로또 숫자가 6개를 넘어간다면 예외가 발생한다.")
    @Test
    void inputLottoByOverSize() {
        String inputNumbers = "1, 2, 3, 4, 5, 6, 7";
        assertThatThrownBy(() -> new Lotto(inputNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NOT_SAME_WITH_LOTTO_SIZE.getMessage(LOTTO_SIZE));
    }

    @DisplayName("입력받은 당첨 로또 숫자가 6개보다 작다면 예외가 발생한다.")
    @Test
    void inputLottoByUnderSize() {
        String inputNumbers = "1, 2, 3, 4, 5";
        assertThatThrownBy(() -> new Lotto(inputNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NOT_SAME_WITH_LOTTO_SIZE.getMessage(LOTTO_SIZE));
    }

    @DisplayName("입력받은 당첨 로또 숫자가 45보다 크다면 예외가 발생한다.")
    @Test
    void inputLottoOutOfRange() {
        String inputNumbers = "1, 2, 3, 4, 5, 46";
        assertThatThrownBy(() -> new Lotto(inputNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.IS_NOT_IN_RANGE.getMessage(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER));
    }

    @DisplayName("입력받은 당첨 로또 숫자가 1보다 작다면 예외가 발생한다.")
    @Test
    void inputLottoOutOfRange2() {
        String inputNumbers = "1, 2, 3, 4, 5, 0";
        assertThatThrownBy(() -> new Lotto(inputNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.IS_NOT_IN_RANGE.getMessage(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER));
    }

    @DisplayName("입력받은 당첨 로또 숫자가 모두 다르지 않다면 예외가 발생한다.")
    @Test
    void inputLottoByDuplicateNumber() {
        String inputNumbers = "1, 2, 3, 4, 5, 5";
        assertThatThrownBy(() -> new Lotto(inputNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.CONSIST_OF_DUPLICATE_NUMBER.getMessage());
    }

}