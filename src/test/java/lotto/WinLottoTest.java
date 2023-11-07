package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinLottoTest {
    @DisplayName("당첨 번호 양식을 다르게 입력했을 때 예외가 발생한다.")
    @Test
    void inputFormValidate() {
        String input = "1/2/3/4/5";

        assertThatThrownBy(() -> new Lotto(Arrays.stream(input.split(","))
                                                   .map(e -> Integer.parseInt(e))
                                                   .toList()))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("당첨 번호 입력 시 숫자 범위를 초과하면 예외가 발생한다.")
    @Test
    void inputRangeValidate() {
        String input = "1,2,3,4,46,5";

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 46, 5)).lottoByRange())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
