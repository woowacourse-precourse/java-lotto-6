package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.exception.ExceptionMessage.DUPLICATE_WINNING_NUMBERS_AND_BONUS_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LuckyNumbersTest {
    @DisplayName("로또 번호에 보너스 숫자와 같은 숫자가 있으면 예외가 발생한다.")
    @Test
    void DuplicatedWinningNumberAndBonusNumber() {
        //given
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(3);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> {
            new LuckyNumbers(winningNumber,bonusNumber);
        });

        //then
        assertThat(exception.getMessage()).isEqualTo(DUPLICATE_WINNING_NUMBERS_AND_BONUS_NUMBER.get(6));

    }
}