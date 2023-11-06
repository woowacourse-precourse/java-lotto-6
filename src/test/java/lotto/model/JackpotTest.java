package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class JackpotTest {

    @DisplayName("당첨 번호와 보너스 번호를 통해 Jackpot 객체를 생성한다.")
    @Test
    void createJackpot() {
        // given
        String inputWinningNumbers = "1,2,3,4,5,6";
        String inputBonusNumber = "45";

        // when
        Jackpot jackpot = new Jackpot(inputWinningNumbers, inputBonusNumber);

        // then
        assertThat(jackpot)
                .extracting("winningNumbers", "bonusNumber")
                .contains(Arrays.asList(1, 2, 3, 4, 5, 6), 45);
    }
}