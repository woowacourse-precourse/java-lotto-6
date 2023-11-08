package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoGameTest {

    @DisplayName("로또 게임을 생성한다.")
    @Test
    void createTest() {
        assertThatCode(() -> new LottoGame(new ManualLottoGenerator()))
                .doesNotThrowAnyException();
    }

    @DisplayName("1,000원 단위의 구매 금액을 입력하면 구매금액이 초기화된다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 20000, 300000, 4000000})
    void initializePurchaseAmountSuccessTest(int purchaseAmount) {
        LottoGame lottoGame = new LottoGame(new ManualLottoGenerator());
        assertThatCode(() -> lottoGame.initializePurchaseAmount(purchaseAmount))
                .doesNotThrowAnyException();
        assertThat(lottoGame.getPurchaseAmount()).isEqualTo(purchaseAmount);
    }

    @DisplayName("1,000원 단위가 아니거나 1,000원 이하의 구매 금액을 입력하면 구매금액이 초기화되지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 999, -1, 1001, 1234})
    void initializePurchaseAmountFailTest(int purchaseAmount) {
        LottoGame lottoGame = new LottoGame(new ManualLottoGenerator());
        assertThatCode(() -> lottoGame.initializePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자의 금액만큼 로또를 구매한다.")
    @ParameterizedTest
    @CsvSource({"1000, 1", "10000, 10"})
    void purchaseUserLottos(int purchaseAmount, int expectedSize) {
        LottoGame lottoGame = new LottoGame(new RandomLottoGenerator());
        lottoGame.initializePurchaseAmount(purchaseAmount);
        assertThatCode(lottoGame::purchaseLottos)
                .doesNotThrowAnyException();
        Lottos purchasedLottos = lottoGame.getPurchasedLottos();
        List<Lotto> lottos = purchasedLottos.getLottos();
        assertThat(lottos.size()).isEqualTo(expectedSize);
    }

    @DisplayName("입력받은 당첨번호를 저장한다.")
    @Test
    void determineWinningLotto() {
        List<Integer> inputNumbers = List.of(1, 2, 3, 4, 5, 6);
        LottoGame lottoGame = new LottoGame(new ManualLottoGenerator());
        assertThatCode(() -> lottoGame.determineWinningNumbers(inputNumbers))
                .doesNotThrowAnyException();
    }

    @DisplayName("입력받은 보너스 번호를 저장한다.")
    @Test
    void determineBonusNumberSuccessTest() {
        LottoGame lottoGame = new LottoGame(new ManualLottoGenerator());
        lottoGame.determineWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        assertThatCode(() -> lottoGame.determineBonusNumber(7))
                .doesNotThrowAnyException();
    }

    @DisplayName("입력받은 보너스 번호가 입력받은 당첨 번호에 이미 속해있다면 에러를 반환한다.")
    @Test
    void determineBonusNumberFailTest() {
        LottoGame lottoGame = new LottoGame(new ManualLottoGenerator());
        lottoGame.determineWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        assertThatCode(() -> lottoGame.determineBonusNumber(1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매한 로또의 등수를 계산한다.")
    @Test
    void calculateRankTest() {
        LottoGame lottoGame = new LottoGame(new ManualLottoGenerator());
        lottoGame.initializePurchaseAmount(1000);
        lottoGame.purchaseLottos();
        lottoGame.determineWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        lottoGame.determineBonusNumber(7);
        RankResult rankResult = lottoGame.calculateRank();

        Map<RankPrize, Integer> rank = rankResult.getRankResult();

        assertThat(rank.get(RankPrize.FIRST_PLACE)).isEqualTo(1);
        assertThat(rank.get(RankPrize.SECOND_PLACE)).isEqualTo(0);
        assertThat(rank.get(RankPrize.THIRD_PLACE)).isEqualTo(0);
        assertThat(rank.get(RankPrize.FOURTH_PLACE)).isEqualTo(0);
        assertThat(rank.get(RankPrize.FIFTH_PLACE)).isEqualTo(0);
    }
}
