package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;

class PlayerLottoTest {
    @Test
    @DisplayName("입력된 수만큼 로또가 발행되어야한다.")
    void publish() {
        int quantity = 3;
        PlayerLotto playerLotto = new PlayerLotto();
        playerLotto.publish(quantity);

        Assertions.assertThat(playerLotto.getQuantity() == quantity).isTrue();
    }

    @Test
    @DisplayName("구매한 로또의 결과 리스트는 입력된 발행 수와 같아야한다.")
    void calculate_result() {
        List<Integer> winning = new ArrayList<>(Arrays.asList(3, 5, 11, 16, 32, 38));
        WinningNumber winningNumber = new WinningNumber(winning);
        winningNumber.addBonusNumber(1);

        int quantity = 4;
        PlayerLotto playerLotto = new PlayerLotto();

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    playerLotto.publish(quantity);
                    Assertions.assertThat(playerLotto.calculateResult(winningNumber).size()).isEqualTo(quantity);
                },
                Arrays.asList(8, 21, 23, 41, 42, 43)
        );
    }

    @Test
    @DisplayName("구매한 로또의 보너스 결과 리스트는 입력된 발행 수와 같아야한다.")
    void calculate_bonus_result() {
        List<Integer> winning = new ArrayList<>(Arrays.asList(3, 5, 11, 16, 32, 38));
        WinningNumber winningNumber = new WinningNumber(winning);
        winningNumber.addBonusNumber(1);

        int quantity = 4;
        PlayerLotto playerLotto = new PlayerLotto();

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    playerLotto.publish(quantity);
                    Assertions.assertThat(playerLotto.bonusResult(winningNumber).size()).isEqualTo(quantity);
                },
                Arrays.asList(8, 21, 23, 41, 42, 43)
        );
    }
}
