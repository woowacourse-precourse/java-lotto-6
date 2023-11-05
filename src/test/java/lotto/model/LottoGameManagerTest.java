package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameManagerTest {

    @DisplayName("로또 구입 개수 계산 테스트")
    @Test
    void calculateLottoCount() {
        Amount amount = Amount.create("8000");
        int lottoCount = LottoGameManager.calculateLottoCount(amount);
        assertThat(lottoCount).isEqualTo(8);
    }

    @DisplayName("로또 구입 테스트")
    @Test
    void buyLotto() {
        int lottoCount = 8;
        List<Lotto> lottoList = LottoGameManager.buyLotto(lottoCount);
        assertThat(lottoList).hasSize(8);
    }

    @DisplayName("수익률 계산 테스트")
    @Test
    void calculateYield() {
        Amount amount = Amount.create("8000");
        List<LottoMatch> lottoResultCount = List.of(
                LottoMatch.collect(3, false),
                LottoMatch.collect(0, false),
                LottoMatch.collect(1, false),
                LottoMatch.collect(2, false),
                LottoMatch.collect(0, true),
                LottoMatch.collect(1, true),
                LottoMatch.collect(2, true),
                LottoMatch.collect(1, true)
        );
        Double yield = LottoGameManager.calculateYield(lottoResultCount, amount);
        assertThat(yield).isEqualTo(62.5);

        Amount amount2 = Amount.create("1000");
        List<LottoMatch> lottoResultCount2 = List.of(
                LottoMatch.collect(5, true)
        );
        Double yield2 = LottoGameManager.calculateYield(lottoResultCount2, amount2);
        assertThat(yield2).isEqualTo(3000000.0);
    }
}
