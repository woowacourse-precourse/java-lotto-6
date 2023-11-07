package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.constant.LottoRanking;
import lotto.dto.LottosInfo;
import lotto.dto.WinningStatistics;
import lotto.generator.CustomIntegerListGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoOwnerTest {

    @DisplayName("구입가격과 로또번호들, 로또결과를 이용하여 소유자를 생성한다.")
    @Test
    void lottoOwnerBuilderMethod() {
        // given
        long amount = 1000L;
        PurchasePrice purchasePrice = getPurchasePrice(amount);
        List<Lotto> lottos = Lotto.createRandomLottos(purchasePrice, new CustomIntegerListGenerator());
        LottoResult lottoResult = LottoResult.from(LottoRanking.convertValuesIntoCounters());

        // when
        LottoOwner result = LottoOwner.of(purchasePrice, lottos, lottoResult);

        // then
        assertThat(result).hasFieldOrPropertyWithValue("purchasePrice", purchasePrice);
        assertThat(result).hasFieldOrPropertyWithValue("lottos", lottos);
        assertThat(result).hasFieldOrPropertyWithValue("lottoResults", lottoResult);
    }

    @DisplayName("로또목록들을 문구형태로 반환한다.")
    @Test
    void getLottosInfo() {
        // given
        long amount = 2000L;
        CustomIntegerListGenerator generator = new CustomIntegerListGenerator();
        PurchasePrice purchasePrice = getPurchasePrice(amount);
        List<Lotto> lottos = Lotto.createRandomLottos(purchasePrice, generator);
        LottoOwner lottoOwner = getLottoOwner(purchasePrice, lottos);
        String expected = generator.generateIntegerList().toString();

        // when
        LottosInfo result = lottoOwner.getLottosInfo();

        // then
        assertThat(result.numbers()).hasSize(lottos.size());
        assertThat(result.numbers()).containsExactlyInAnyOrder(expected, expected);
    }

    @DisplayName("당첨 로또와 내 로또들과 순위를 매겨본다.")
    @Test
    void matchLottosWithWinningLotto() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 8, 9, 10);
        int bonusNumber = 17;
        WinningLotto given = WinningLotto.of(Lotto.from(winningNumbers), bonusNumber);
        LottoOwner lottoOwner = getLottoOwner();

        // when
        boolean result = lottoOwner.matchLottosWithWinningLotto(given);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("당첨통계를 반환한다.")
    @Test
    void getWinningStatistics() {
        // given
        LottoResult lottoResult = LottoResult.from(LottoRanking.convertValuesIntoCounters());
        LottoOwner lottoOwner = getLottoOwner(lottoResult);
        WinningStatistics expected = lottoResult.getWinnerStatistics();

        // when
        WinningStatistics result = lottoOwner.getWinningStatistics();

        // then
        assertThat(result).isEqualTo(expected);
    }

    private LottoOwner getLottoOwner() {
        PurchasePrice purchasePrice = getPurchasePrice(2000L);
        List<Lotto> lottos = Lotto.createRandomLottos(purchasePrice, new CustomIntegerListGenerator());
        return getLottoOwner(purchasePrice, lottos);
    }

    private LottoOwner getLottoOwner(LottoResult lottoResult) {
        PurchasePrice purchasePrice = getPurchasePrice(3000L);
        List<Lotto> lottos = Lotto.createRandomLottos(purchasePrice, new CustomIntegerListGenerator());
        return LottoOwner.of(purchasePrice, lottos, lottoResult);
    }

    private LottoOwner getLottoOwner(PurchasePrice purchasePrice, List<Lotto> lottos) {
        LottoResult lottoResult = LottoResult.from(LottoRanking.convertValuesIntoCounters());
        return LottoOwner.of(purchasePrice, lottos, lottoResult);
    }

    private PurchasePrice getPurchasePrice(long amount) {
        return PurchasePrice.from(amount);
    }
}
