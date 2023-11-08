package lotto.model;

import static java.util.Map.entry;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.model.enums.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultCalculatorTest {
    WinLotto winNumbers;
    Lottos lottos;
    List<Lotto> testLottos;
    ResultCalculator resultCalculator;

    @BeforeEach
    void setUp() {
        winNumbers = createWinLotto();
        lottos = new Lottos(new ArrayList<>());
        testLottos = lottos.lottosInfo();
        resultCalculator = new ResultCalculator(winNumbers, lottos);
    }

    @Test
    @DisplayName("1등 1개, 2등 1개, 3등 1개")
    void lottosResultTest() {

        testLottos.add(createFirstTicket());
        testLottos.add(createSecondTicket());
        testLottos.add((createThirdTicket()));

        Map<Rank, Integer> result = resultCalculator.calculateResult();

        Assertions.assertThat(result)
                .contains(entry(Rank.FIRST, 1), entry(Rank.SECOND, 1), entry(Rank.THIRD, 1));
    }

    @Test
    @DisplayName("8개 중 5등 한개 당첨 시 수익률 62.5%")
    void lottosRateOfReturnTest() {
        for (int i = 0; i < 7; i++) {
            testLottos.add(createOtherTicket());
        }
        testLottos.add(createFifthTicket());

        double rateOfReturn = resultCalculator.calculateRateOfReturn();

        assertThat(rateOfReturn).isEqualTo(62.5);
    }

    private WinLotto createWinLotto() {
        Lotto winTicket = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusnumber = new BonusNumber(7);
        return new WinLotto(winTicket, bonusnumber);
    }

    private Lotto createFirstTicket() {
        return new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    private Lotto createSecondTicket() {
        return new Lotto(List.of(1, 2, 3, 4, 5, 7));
    }

    private Lotto createThirdTicket() {
        return new Lotto(List.of(1, 2, 3, 4, 5, 45));
    }

    private Lotto createFourthTicket() {
        return new Lotto(List.of(1, 2, 3, 4, 44, 45));
    }

    private Lotto createFifthTicket() {
        return new Lotto(List.of(1, 2, 3, 43, 44, 45));
    }

    private Lotto createOtherTicket() {
        return new Lotto(List.of(40, 41, 42, 43, 44, 45));
    }
}