package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.exception.LottoExceptionMessage;
import lotto.util.OutputTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest extends OutputTest {
    @DisplayName("당첨 번호가 중복되면 에러 메시지가 출력된다.")
    @Test
    void getErrorMessageByNonNumbers() {
        WinningNumbers.from(List.of(1, 1, 2, 3, 4, 5));
        assertThat(output()).contains(
                LottoExceptionMessage.WINNING_NUMBERS_MUST_BE_SIX_DIGITS.getMessage()
        );
    }

    @DisplayName("당첨 번호가 6자리가 아니면 에러 메시지가 출력된다.")
    @Test
    void getErrorMessageByFIVEDIGIT() {
        WinningNumbers.from(List.of(1, 2, 3, 4, 5));
        assertThat(output()).contains(
                LottoExceptionMessage.WINNING_NUMBERS_MUST_BE_SIX_DIGITS.getMessage()
        );
    }

    @DisplayName("당첨 번호가 1~45 사이 숫자가 아니면 에러 메시지가 출력된다.")
    @Test
    void getErrorMessageByNotBetweenStartAndEndInclusive() {
        WinningNumbers.from(List.of(1, 2, 3, 4, 5, 46));
        assertThat(output()).contains(
                LottoExceptionMessage.WINNING_NUMBERS_MUST_BETWEEN_START_AND_END_INCLUSIVE.getMessage()
        );
    }
}
