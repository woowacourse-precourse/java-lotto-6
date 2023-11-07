package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

class MatchTest extends NsTest {

    @Test
    void 로또_라운드별_결과값_구하기() {
        InputLottoNumber inputLottoNumber = new InputLottoNumber("1,3,5,7,9,11");
        InputBonusNumber inputBonusNumber = new InputBonusNumber("6");

        assertRandomUniqueNumbersInRangeTest(
            () -> {
                RandomNumber randomNumber = new RandomNumber();
                Lotto lotto = new Lotto(randomNumber.getRandomNumber());
                Match match = new Match(inputLottoNumber,
                    inputBonusNumber, lotto);
                match.calculate();

                System.out.println("randomNumber = " + randomNumber.getRandomNumber());
            },
            List.of(1, 3, 5, 7, 9, 10)
        );
    }

    @Override
    protected void runMain() {

    }
}