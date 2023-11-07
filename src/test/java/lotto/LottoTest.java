package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static lotto.common.Validation.*;
import static org.assertj.core.api.Assertions.*;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1 이하의 숫자가 있다면 예외가 발생한다.")
    @Test
    void createLottoByUnder1() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, -5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 45 이상의 숫자가 있다면 예외가 발생한다.")
    @Test
    void createLottoByOver45() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 49)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매금액이 1000원 이하이면 예외가 발생한다.")
    @Test
    void validateInputPurchaseMoneyUnder1000() {
        String input = "500";

        assertThatThrownBy(() -> validatePurchaseMoney(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매금액이 1000원 으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void validateInputPurchaseMoneyNotDivide1000() {
        String input = "1500";

        assertThatThrownBy(() -> validatePurchaseMoney(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void validateInputPurchaseMoneyNotNumber() {
        String input = "d";

        assertThatThrownBy(() -> validatePurchaseMoney(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매금액이 int 범위를 벗어나면 예외가 발생한다.")
    @Test
    void validateInputPurchaseMoneyOverRange() {
        String input = "10000000000000000";

        assertThatThrownBy(() -> validatePurchaseMoney(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매한 로또 수량은 (입력한 금액 / 1000)개 이다.")
    @Test
    void checkBuyCount() {
        LottoService lottoService = new LottoService();
        String input = "300000";


        assertThat(lottoService.getBuyCount(Integer.parseInt(input))).isEqualTo(Integer.parseInt(input) / 1000);
    }

    @DisplayName("당첨 번호가 중복이면 예외가 발생한다.")
    @Test
    void createWinningNumsByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 5), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinningNumsByOverSize() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 7, 8), 9))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("당첨 번호에 1 이하의 숫자가 있다면 예외가 발생한다.")
    @Test
    void createWinningNumsByUnder1() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, -5), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 45 이상의 숫자가 있다면 예외가 발생한다.")
    @Test
    void createWinningNumsByOver45() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 49), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호에 이미 포함되어 있다면 예외가 발생한다.")
    @Test
    void createBonusNumDuplicatedByWinningNums() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력이 숫자가 아니라면 예외가 발생한다.")
    @Test
    void validateWinningNumsNotNumber() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, Integer.parseInt("no")), 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력이 숫자가 아니라면 예외가 발생한다.")
    @Test
    void validateBonusNumNotNumber() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), Integer.parseInt("no")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입한 로또 번호와 당첨 번호 몇 개 맞는지 계산")
    @Test
    void calculateMatchCountBetweenMyLottosAndWinningNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 7), 14);

        int matchCount = lotto.getMatchCount(winningNumbers);
        assertThat(matchCount).isEqualTo(5);
    }

    @DisplayName("구입한 로또 번호에 보너스 번호가 포함되어있는지 계산")
    @Test
    void isContainBonusNumInMyLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 7), 6);

        boolean bonusMatch = lotto.isBonusMatch(winningNumbers);
        assertThat(bonusMatch).isEqualTo(true);
    }

    @DisplayName("맞은 개수와 보너스 번호 일치 계산 후 랭크 확인")
    @Test
    void checkRankWithMyWINLottos() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 7), 6);

        int matchCount = lotto.getMatchCount(winningNumbers);
        boolean bonusMatch = lotto.isBonusMatch(winningNumbers);
        Rank rank = Rank.valueOf(matchCount, bonusMatch);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @DisplayName("맞은 개수와 보너스 번호 일치 계산 후 랭크 확인2")
    @Test
    void checkRankFirstWithMyWINLottos2() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 14);

        int matchCount = lotto.getMatchCount(winningNumbers);
        boolean bonusMatch = lotto.isBonusMatch(winningNumbers);
        Rank rank = Rank.valueOf(matchCount, bonusMatch);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @DisplayName("맞은 개수와 보너스 번호 일치 계산 후 랭크 확인3")
    @Test
    void checkRankMissWithMyWINLottos() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(21,22,23,24,25,26), 45);

        int matchCount = lotto.getMatchCount(winningNumbers);
        boolean bonusMatch = lotto.isBonusMatch(winningNumbers);
        Rank rank = Rank.valueOf(matchCount, bonusMatch);
        assertThat(rank).isEqualTo(Rank.MISS);
    }

    @DisplayName("결과를 보관할 맵에 랭크 : 랭크의 개수 형태로 잘 담기는지 확인")
    @Test
    void checkResultMapWhetherPutRankMiss() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(21,22,23,24,25,26), 45);

        int matchCount = lotto.getMatchCount(winningNumbers);
        boolean bonusMatch = lotto.isBonusMatch(winningNumbers);

        Rank rank = Rank.valueOf(matchCount, bonusMatch);

        LottoResult lottoResult = new LottoResult();
        lottoResult.addRank(rank);

        Map<Rank, Integer> result = lottoResult.getResult();
        assertThat(result.get(Rank.MISS)).isEqualTo(1);
    }

    @DisplayName("결과를 보관할 맵에 랭크 : 랭크의 개수 형태로 잘 담기는지 확인2")
    @Test
    void checkResultMapWhetherPutRankFirst() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1,2,3,4,5,6), 45);

        int matchCount = lotto.getMatchCount(winningNumbers);
        boolean bonusMatch = lotto.isBonusMatch(winningNumbers);

        Rank rank = Rank.valueOf(matchCount, bonusMatch);

        LottoResult lottoResult = new LottoResult();
        lottoResult.addRank(rank);

        Map<Rank, Integer> result = lottoResult.getResult();
        assertThat(result.get(Rank.FIRST)).isEqualTo(1);
    }

    @DisplayName("결과를 보관할 맵에 랭크 : 랭크의 개수 형태로 잘 담기는지 확인3")
    @Test
    void checkResultMapWhetherPutRankFourth() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 41, 42));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1,2,3,4,5,6), 7);

        int matchCount = lotto.getMatchCount(winningNumbers);
        boolean bonusMatch = lotto.isBonusMatch(winningNumbers);

        Rank rank = Rank.valueOf(matchCount, bonusMatch);

        LottoResult lottoResult = new LottoResult();
        lottoResult.addRank(rank);

        Map<Rank, Integer> result = lottoResult.getResult();
        assertThat(result.get(Rank.FOURTH)).isEqualTo(1);
    }

    @DisplayName("로또 최종 상금 계산")
    @Test
    void calculateTotalPrizeMoneyZero() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(11, 12, 13, 14, 15, 16)));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(21, 22, 23, 24, 25, 26), 27);

        LottoService lottoService = new LottoService();
        LottoResult lottoResult = lottoService.calculateResult(lottos, winningNumbers);

        long totalPrizeMoney = lottoResult.getTotalPrizeMoney();

        assertThat(totalPrizeMoney).isEqualTo(0L);
    }

    @DisplayName("로또 최종 상금 계산2")
    @Test
    void calculateTotalPrizeMoneyFirst() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(11, 12, 13, 14, 15, 16)));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 27);

        LottoService lottoService = new LottoService();
        LottoResult lottoResult = lottoService.calculateResult(lottos, winningNumbers);

        long totalPrizeMoney = lottoResult.getTotalPrizeMoney();

        assertThat(totalPrizeMoney).isEqualTo(2000000000L);
    }

    @DisplayName("로또 최종 상금 계산3")
    @Test
    void calculateTotalPrizeMoneyThirdAndFourthAndSecond() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 45)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 45 ,44)));
        lottos.add(new Lotto(List.of(1, 2, 3, 45, 44 ,43)));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        LottoService lottoService = new LottoService();
        LottoResult lottoResult = lottoService.calculateResult(lottos, winningNumbers);

        long totalPrizeMoney = lottoResult.getTotalPrizeMoney();

        assertThat(totalPrizeMoney).isEqualTo(1555000L);
    }

    @DisplayName("로또 최종 수익률 계산")
    @Test
    void calculateFinalProfitRate() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 45)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 45 ,44)));
        lottos.add(new Lotto(List.of(1, 2, 3, 45, 44 ,43)));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        LottoService lottoService = new LottoService();
        LottoResult lottoResult = lottoService.calculateResult(lottos, winningNumbers);

        Double profitRate = lottoResult.calculateProfitRate(3000);

        assertThat(profitRate).isEqualTo(518.3333333333334);
    }

    @DisplayName("로또 최종 수익률 계산2")
    @Test
    void calculateFinalProfitRateFirstWinner() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(41, 42, 43, 34, 45 ,44)));
        lottos.add(new Lotto(List.of(21, 22, 23, 45, 44 ,43)));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        LottoService lottoService = new LottoService();
        LottoResult lottoResult = lottoService.calculateResult(lottos, winningNumbers);

        Double profitRate = lottoResult.calculateProfitRate(1000);

        assertThat(profitRate).isEqualTo(2000000);
    }

    @DisplayName("로또 최종 수익률 계산3")
    @Test
    void calculateFinalProfitRateMiss() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(31, 32, 33, 34, 35, 36)));
        lottos.add(new Lotto(List.of(41, 42, 43, 34, 45 ,44)));
        lottos.add(new Lotto(List.of(21, 22, 23, 45, 44 ,43)));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        LottoService lottoService = new LottoService();
        LottoResult lottoResult = lottoService.calculateResult(lottos, winningNumbers);

        Double profitRate = lottoResult.calculateProfitRate(1000);

        assertThat(profitRate).isEqualTo(0);
    }



}