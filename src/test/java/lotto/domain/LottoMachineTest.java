package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.constant.LottoNumber;
import lotto.constant.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoMachineTest {
    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
    }

    @ParameterizedTest
    @CsvSource(value = {"1000,1", "10000,10"})
    void 금액에_해당하는_만큼_로또_발행(int amount, int expected) {
        List<Lotto> lotteries = lottoMachine.issue(amount / LottoNumber.PRICE.getValue());

        assertThat(lotteries.size()).isEqualTo(expected);
    }

    @Test
    void 총_당첨금이_얼마인지_계산() {
        List<Rank> result = Arrays.asList(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH);
        double winnings = lottoMachine.combineWinnings(result);
        double expected = 2031555000;

        assertThat(winnings).isEqualTo(expected);
    }
}