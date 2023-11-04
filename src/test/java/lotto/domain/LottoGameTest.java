package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGameTest {

    @DisplayName("로또 게임을 생성한다.")
    @Test
    void createTest() {
        assertThatCode(() -> new LottoGame(new ManualLottoGenerator()))
                .doesNotThrowAnyException();
    }

    @DisplayName("사용자의 금액만큼 로또를 구매한다.")
    @Test
    void purchaseUserLottos() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(1000);
        LottoGame lottoGame = new LottoGame(new ManualLottoGenerator());
        assertThatCode(() -> lottoGame.purchaseLottoNumbersOf(purchaseAmount.getAvailablePurchaseCounts()))
                .doesNotThrowAnyException();
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
        lottoGame.purchaseLottoNumbersOf(1);
        lottoGame.determineWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        lottoGame.determineBonusNumber(7);

        RankResult rankResult = lottoGame.calculateRank();

        assertThat(rankResult.getWinCounts(RankPrize.FIRST_PLACE)).isEqualTo(1);
        assertThat(rankResult.getWinCounts(RankPrize.SECOND_PLACE)).isEqualTo(0);
        assertThat(rankResult.getWinCounts(RankPrize.THIRD_PLACE)).isEqualTo(0);
        assertThat(rankResult.getWinCounts(RankPrize.FOURTH_PLACE)).isEqualTo(0);
        assertThat(rankResult.getWinCounts(RankPrize.FIFTH_PLACE)).isEqualTo(0);
    }
}
