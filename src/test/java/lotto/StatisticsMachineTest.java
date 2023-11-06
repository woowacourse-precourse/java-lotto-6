package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

class StatisticsMachineTest extends NsTest {

    @Test
    void 통계_구하기() {
        InputLottoNumber inputLottoNumber = new InputLottoNumber("1,3,5,7,9,11");
        InputBonusNumber inputBonusNumber = new InputBonusNumber("6");

        assertRandomUniqueNumbersInRangeTest(
            () -> {
                RandomNumber randomNumber = new RandomNumber();
                Lotto lotto = new Lotto(randomNumber.getRandomNumber());
                StatisticsMachine statisticsMachine = new StatisticsMachine(inputLottoNumber,
                    inputBonusNumber, lotto);
                statisticsMachine.calculate();

                System.out.println("randomNumber = " + randomNumber.getRandomNumber());
            },
            List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @Override
    protected void runMain() {

    }
}