package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import lotto.domain.generator.LottoGeneratorImpl;

public class LottoWinnerCounterTest {

    @Test
    void 로또_당첨_정보_반환할_수_있어야_함() {
        // given
        LottoGeneratorImpl givenGenerator = new TestGenerator();
        Lottos givenLottos = Lottos.fromCount(8, givenGenerator);
        Lotto givenWinnerNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber givenBonusNumber = BonusNumber.fromStringWitValidateWinningNumber("7",
                givenWinnerNumber.getNumbers());
        List<String> givenLottoResult = List.of("3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개");
        // when
        LottoWinnerCounter winnerCounter = LottoWinnerCounter.generateLottoWinnerCounter();
        winnerCounter.calculateLottoResult(givenLottos, givenWinnerNumber, givenBonusNumber);
        List<String> lottoResult = winnerCounter.getWinnerInformation();
        // then
        assertThat(lottoResult).isEqualTo(givenLottoResult);
    }

    @Test
    void 로또_수익율_정보를_반환할_수_있어야_함() {
        // given
        LottoBuyer lottoBuyer = LottoBuyer.fromString("8000");
        LottoGeneratorImpl givenGenerator = new TestGenerator();
        Lottos givenLottos = Lottos.fromCount(8, givenGenerator);
        Lotto givenWinnerNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber givenBonusNumber = BonusNumber.fromStringWitValidateWinningNumber("7",
                givenWinnerNumber.getNumbers());
        String givenTotalProfit = "62.5%";
        // when
        LottoWinnerCounter winnerCounter = LottoWinnerCounter.generateLottoWinnerCounter();
        winnerCounter.calculateLottoResult(givenLottos, givenWinnerNumber, givenBonusNumber);
        BigDecimal totalProfit = winnerCounter.totalProfit(lottoBuyer);
        String totalProfitString = String.format("%.1f%%", totalProfit);
        // then
        assertThat(givenTotalProfit).isEqualTo(totalProfitString);
    }

    class TestGenerator implements LottoGeneratorImpl {
        private final List<List<Integer>> lottoSequences = new ArrayList<>();
        private int currentIndex = 0;

        public TestGenerator() {
            lottoSequences.add(List.of(8, 21, 23, 41, 42, 43));
            lottoSequences.add(List.of(3, 5, 11, 16, 32, 38));
            lottoSequences.add(List.of(7, 11, 16, 35, 36, 44));
            lottoSequences.add(List.of(1, 8, 11, 31, 41, 42));
            lottoSequences.add(List.of(13, 14, 16, 38, 42, 45));
            lottoSequences.add(List.of(7, 11, 30, 40, 42, 43));
            lottoSequences.add(List.of(2, 13, 22, 32, 38, 45));
            lottoSequences.add(List.of(1, 3, 5, 14, 22, 45));
        }

        @Override
        public List<Integer> generate() {
            List<Integer> sequence = lottoSequences.get(currentIndex);
            currentIndex = (currentIndex + 1) % lottoSequences.size();
            return sequence;
        }
    }
}
