package lotto.validate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import java.util.List;
import lotto.domain.Lotto;
import lotto.utils.InputProcessor;
import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidateWinningLottoNumberTest {
    private final InputProcessor inputProcessor = new InputProcessor(new InputView());

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "4,33,34,37,11,3", "6,7,8,9,10,11", "15,16,17,13,12,11"})
    @DisplayName("당첨_번호_입력_검증_통과")
    void 당첨_번호_입력_검증_통과(String input) {
        List<Integer> winningNumbers = inputProcessor.getUserInputWinningNumbers(input);
        assertThatCode(() -> new Lotto(winningNumbers))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7", "4,33,34,37,11,3,2", "6,7,8,9,10,11,12", "15,16,17,13,12,11,10"})
    @DisplayName("당첨_번호_입력_검증_실패_7개_이상")
    void 당첨_번호_입력_검증_실패_7개_이상(String input) {
        List<Integer> winningNumbers = inputProcessor.getUserInputWinningNumbers(input);
        assertThatCode(() -> new Lotto(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "4,33,34,37,11", "6,7,8,9,10", "15,16,17,13,12"})
    @DisplayName("당첨_번호_입력_검증_실패_5개_이하")
    void 당첨_번호_입력_검증_실패_5개_이하(String input) {
        List<Integer> winningNumbers = inputProcessor.getUserInputWinningNumbers(input);
        assertThatCode(() -> new Lotto(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,47", "4,33,34,48,11,3", "6,50,8,9,10,11", "-1,16,17,13,12,11"})
    @DisplayName("당첨_번호_입력_검증_실패_범위_초과")
    void 당첨_번호_입력_검증_실패_범위_초과(String input) {
        List<Integer> winningNumbers = inputProcessor.getUserInputWinningNumbers(input);
        assertThatCode(() -> new Lotto(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,5", "4,33,34,11,11,3", "6,8,8,9,10,11", "16,16,17,13,12,11"})
    @DisplayName("당첨_번호_입력_검증_실패_중복_숫자")
    void 당첨_번호_입력_검증_실패_중복_숫자(String input) {
        List<Integer> winningNumbers = inputProcessor.getUserInputWinningNumbers(input);
        assertThatCode(() -> new Lotto(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,a", "4,33,34,37,1b,3", "6,7,8,9,cc,11", "15,dd,17,13,12,11"})
    @DisplayName("당첨_번호_입력_검증_실패_숫자_아닌_문자")
    void 당첨_번호_입력_검증_실패_숫자_아닌_문자(String input) {
        assertThatCode(() -> inputProcessor.getUserInputWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,", ",,", ",,,,,,,", "15,,17,13,12,"})
    @DisplayName("당첨_번호_입력_검증_실패_공백_입력")
    void 당첨_번호_입력_검증_실패_공백_입력(String input) {
        assertThatCode(() -> {
            inputProcessor.getUserInputWinningNumbers(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
