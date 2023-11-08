package lotto;

import lotto.service.LottoService;
import lotto.model.Lotto;
import lotto.model.PurchaseAmount;
import lotto.model.Winning;
import lotto.validate.Check;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 구매 금액이 1000원 단위가 아닐 경우 예외가 발생한다.")
    @Test
    void createLottoBy1000() {
        assertThatThrownBy(() -> new PurchaseAmount(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1미만 일 경우 예외가 발생한다.")
    @Test
    void createLottoByUnderNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6, 45)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 45초과 일 경우 예외가 발생한다.")
    @Test
    void createLottoByOverNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 로또 번호와 중복시 예외가 발생한다.")
    @Test
    void createBonusByDuplicatedNumber() {

        List<Integer> winningNumber = Arrays.asList(1, 23, 29, 31, 38, 45);
        List<Integer> bonusNumber = List.of(1);

        assertThatThrownBy(() -> Check.numberDuplicate(winningNumber,bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45를 벗어나면 예외가 발생한다.")
    @Test
    void createBonusByRange() {

        List<Integer> bonusNumber = List.of(46);

        assertThatThrownBy(() -> Check.rightRange(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액 / 1000 == 로또 구입 수량이 아닐 경우 예외가 발생한다.")
    @Test
    void createPurchaseAmountByCount() {


        PurchaseAmount purchaseAmount = new PurchaseAmount(5000);
        int lottoCount = purchaseAmount.lottoCount();

        assertEquals(5,lottoCount);

    }

    @DisplayName("번호가 모두 일치 시 1등")
    @Test
    void when_All_Numbers_Match() {

        List<Integer> winningNumber = Arrays.asList(1, 23, 29, 31, 38, 45);
        List<Lotto> lotto = List.of(new Lotto(List.of(1, 23, 29, 31, 38, 45)));
        int bonusNumber = 22;

        Winning winning = LottoService.getWinning(lotto, winningNumber, bonusNumber);
        winning.lottoResult();
        long l = winning.calculateProfit();

        assertEquals(2000000000,l);
    }

    @DisplayName("5개 + 보너스 볼 일치 시 2등")
    @Test
    void when_5Numbers_BonusNumber_Match() {

        List<Integer> winningNumber = Arrays.asList(1, 23, 29, 31, 38, 45);
        List<Lotto> lotto = List.of(new Lotto(List.of(1, 23, 29, 31, 38, 22)));
        int bonusNumber = 22;

        Winning winning = LottoService.getWinning(lotto, winningNumber, bonusNumber);
        winning.lottoResult();
        long l = winning.calculateProfit();

        assertEquals(30000000,l);
    }

    @DisplayName("5개 일치 시 3등")
    @Test
    void when_5Numbers_Match() {

        List<Integer> winningNumber = Arrays.asList(1, 23, 29, 31, 38, 45);
        List<Lotto> lotto = List.of(new Lotto(List.of(1, 23, 29, 31, 38, 39)));
        int bonusNumber = 22;

        Winning winning = LottoService.getWinning(lotto, winningNumber, bonusNumber);
        winning.lottoResult();
        long l = winning.calculateProfit();

        assertEquals(1500000,l);
    }

    @DisplayName("4개 일치 시 4등")
    @Test
    void when_4Numbers_Match() {

        List<Integer> winningNumber = Arrays.asList(1, 23, 29, 31, 38, 45);
        List<Lotto> lotto = List.of(new Lotto(List.of(1, 23, 29, 31, 37, 39)));
        int bonusNumber = 22;

        Winning winning = LottoService.getWinning(lotto, winningNumber, bonusNumber);
        winning.lottoResult();
        long l = winning.calculateProfit();

        assertEquals(50000,l);
    }

    @DisplayName("3개 일치 시 5등")
    @Test
    void when_3Numbers_Match() {

        List<Integer> winningNumber = Arrays.asList(1, 23, 29, 31, 38, 45);
        List<Lotto> lotto = List.of(new Lotto(List.of(1, 23, 29, 32, 37, 39)));
        int bonusNumber = 22;

        Winning winning = LottoService.getWinning(lotto, winningNumber, bonusNumber);
        winning.lottoResult();
        long l = winning.calculateProfit();

        assertEquals(5000,l);
    }

    @DisplayName("2개 일치 시 0원")
    @Test
    void when_2Numbers_Match() {

        List<Integer> winningNumber = Arrays.asList(1, 23, 29, 31, 38, 45);
        List<Lotto> lotto = List.of(new Lotto(List.of(1, 24, 29, 32, 37, 39)));
        int bonusNumber = 22;

        Winning winning = LottoService.getWinning(lotto, winningNumber, bonusNumber);
        winning.lottoResult();
        long l = winning.calculateProfit();

        assertEquals(0,l);
    }
}