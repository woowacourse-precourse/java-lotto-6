package lotto;

import lotto.model.LotteryMachine;
import lotto.utils.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LotteryMachineTest {

    @DisplayName("생성된 로또 번호는 1과 45사이의 숫자이다.")
    @Test
    void generateLottosInRange() {
        LotteryMachine lotteryMachine = LotteryMachine.getInstance();
        lotteryMachine
                .draw()
                .forEach(num -> {
                    assertTrue(num > Constants.MINIMUM && num < Constants.MAXIMUM);
                });
    }

    @DisplayName("생성되는 로또 번호는 6개이다.")
    @Test
    void generateNumbers(){
        LotteryMachine lotteryMachine = LotteryMachine.getInstance();
        assertThat(lotteryMachine.draw().size()).isEqualTo(Constants.DRAW_COUNT);
    }

}
