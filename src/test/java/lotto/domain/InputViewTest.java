package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputCSVNumbersValidator;
import lotto.view.InputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    void inputNumbers() {
        // given
        System.setIn(createUserInput("1,2,3,4,5,6"));
        // when, then
        assertThat(InputView.inputWinningNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("하나라도 음수가 포함되면 예외가 발생한다.")
    @Test
    void inputNumbers_음수_입력() {
        // given
        System.setIn(createUserInput("-1,2,3,4,5,6"));
        // when, then
        assertThatIllegalArgumentException().isThrownBy(InputView::inputWinningNumbers)
                .withMessageContaining("음수가 입력되었습니다.");
    }

    @DisplayName("하나라도 숫자가 아닌값이 포함되면 예외가 발생한다.")
    @Test
    void inputNumbers_숫자가_아닌값() {
        // given
        System.setIn(createUserInput("hi,2,3,4,5,6"));
        // when, then
        assertThatIllegalArgumentException().isThrownBy(InputView::inputWinningNumbers)
                .withMessageContaining("숫자가 아닌 값이 입력되었습니다.");
    }

    @Test
    void inputBonusNumber() {
        // given
        System.setIn(createUserInput("1"));
        // when, then
        assertThat(InputView.inputBonusNumber()).isEqualTo(1);
    }

    @DisplayName("음수가 입력되면 예외가 발생한다.")
    @Test
    void inputBonusNumber_음수_입력() {
        // given
        System.setIn(createUserInput("-1"));
        // when, then
        assertThatIllegalArgumentException().isThrownBy(InputView::inputBonusNumber)
                .withMessageContaining("음수가 입력되었습니다.");
    }

    @DisplayName("숫자가 아닌값이 입력되면 예외가 발생한다.")
    @Test
    void inputBonusNumber_숫자가_아닌값() {
        // given
        System.setIn(createUserInput("hi"));
        // when, then
        assertThatIllegalArgumentException().isThrownBy(InputView::inputBonusNumber)
                .withMessageContaining("숫자가 아닌 값이 입력되었습니다.");
    }

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}