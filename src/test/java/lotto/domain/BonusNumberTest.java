package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.exception.LottoExceptionMessage;
import lotto.util.OutputTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BonusNumberTest extends OutputTest {
    @DisplayName("보너스 번호가 1~45 사이 수가 아니면 에러 메시지가 출력된다.")
    @ParameterizedTest
    @CsvSource({"0", "-1", "46"})
    void getErrorMessageByNotBetweenStartAndEndInclusive(int bonusNumber) {
        WinningNumbers winningNumbers = WinningNumbers.from(List.of(1, 2, 3, 4, 5, 6));

        BonusNumber.of(bonusNumber, winningNumbers);
        assertThat(output()).contains(
                LottoExceptionMessage.BONUS_NUMBER_MUST_BETWEEN_START_AND_END_INCLUSIVE.getMessage()
        );
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 에러 메시지가 출력된다.")
    @ParameterizedTest
    @CsvSource({"1", "5", "6"})
    void getErrorMessageByDuplicateNumber(int bonusNumber) {
        WinningNumbers winningNumbers = WinningNumbers.from(List.of(1, 2, 3, 4, 5, 6));

        BonusNumber.of(bonusNumber, winningNumbers);
        assertThat(output()).contains(
                LottoExceptionMessage.BONUS_NUMBER_MUST_NOT_DUPLICATE.getMessage()
        );
    }
}
