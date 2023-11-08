package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import lotto.model.InputBonusNumber;
import lotto.model.InputLottoNumber;
import lotto.model.Lotto;
import lotto.model.Match;
import lotto.model.MatchResult;
import lotto.model.RandomNumber;
import lotto.model.Statistics;
import org.junit.jupiter.api.Test;

class MatchTest extends NsTest {

    @Test
    void 로또_총수익률_구하기() {
        InputLottoNumber inputLottoNumber = new InputLottoNumber("1,2,3,4,5,6");
        InputBonusNumber inputBonusNumber = new InputBonusNumber("7");
        List<MatchResult> matchResults = new ArrayList<MatchResult>();

        assertRandomUniqueNumbersInRangeTest(
            () -> {
                for (int i = 0; i < 8; i++) {
                    RandomNumber randomNumber = new RandomNumber();
                    Lotto lotto = new Lotto(randomNumber.getRandomNumber());
                    Match match = new Match(inputLottoNumber,
                        inputBonusNumber, lotto);
                    MatchResult matchResult = match.calculate();
                    matchResults.add(matchResult);
                }
            },
            List.of(8, 21, 23, 41, 42, 43),
            List.of(3, 5, 11, 16, 32, 38),
            List.of(7, 11, 16, 35, 36, 44),
            List.of(1, 8, 11, 31, 41, 42),
            List.of(13, 14, 16, 38, 42, 45),
            List.of(7, 11, 30, 40, 42, 43),
            List.of(2, 13, 22, 32, 38, 45),
            List.of(1, 3, 5, 14, 22, 45)
        );

        Statistics statistics = new Statistics(8000, matchResults);
        statistics.evaluateTotalProfit();
    }

    @Override
    protected void runMain() {

    }
}