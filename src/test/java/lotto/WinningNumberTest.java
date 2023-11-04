package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {
    @ParameterizedTest
    @ValueSource(strings = {"1 d 3 4 5 _", "10.1 3 2"})
    void 당첨번호_숫자가_아닌_입력_예외처리_테스트(String input) {
        List<String> inputs = Arrays.asList(input.split(" "));
        assertThatThrownBy(() -> new WinningNumber(inputs, "30")).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"10 50 100", "0 10"})
    void 당첨번호_범위에_벗어난_입력_예외처리_테스트(String input) {
        List<String> inputs = Arrays.asList(input.split(" "));
        assertThatThrownBy(() -> new WinningNumber(inputs, "30")).isInstanceOf(IllegalArgumentException.class);
    }
}
