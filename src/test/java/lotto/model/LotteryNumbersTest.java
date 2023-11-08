package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;



class LotteryNumbersTest {

    @DisplayName("보너스 번호가 당첨 번호 숫자와 중복되면 예외가 발생한다")
    @Test
    void createLotteryNumbersWithDuplicatedNumber() {
        //given
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(4);

        //when, then
        assertThatThrownBy(() -> new LotteryNumbers(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

}