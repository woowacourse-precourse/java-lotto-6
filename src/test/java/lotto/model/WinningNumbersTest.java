package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.common.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    private final LottoTickets lottoTickets = LottoTickets.generateTickets(5);

    @DisplayName("보너스 번호가 1개가 아닌 경우 예외 발생 테스트")
    @Test
    void isNotOntBonusNumber() {

        assertThatThrownBy(() -> WinningNumbers.createBonusNumber(lottoTickets, "10,2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ERROR_LOTTO_IS_NOT_ONE_BONUS_NUMBER.get());
    }

    @DisplayName("보너스 번호 입력 널값인 경우 예외 발생 테스트")
    @Test
    void validateBonusNumber() {
        assertThatThrownBy(() -> WinningNumbers.createBonusNumber(lottoTickets, ""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ERROR_LOTTO_BONUS_NUMBER_NULL.get());
    }

    @DisplayName("보너스 번호에 공백 포함된 경우 예외 발생 테스트")
    @Test
    void validateBonusNumber2() {
        assertThatThrownBy(() -> WinningNumbers.createBonusNumber(lottoTickets, " 10"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ERROR_LOTTO_BONUS_NUMBER_CONTAINS_BLANK.get());
    }

    @DisplayName("보너스 번호에 공백만 포함된 경우 예외 발생 테스트")
    @Test
    void validateBonusNumber3() {
        assertThatThrownBy(() -> WinningNumbers.createBonusNumber(lottoTickets, "    "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ERROR_LOTTO_BONUS_NUMBER_CONTAINS_BLANK.get());
    }


}