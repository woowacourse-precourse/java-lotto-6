package lotto.domain;

import lotto.config.Prize;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.PlayerLotto;
import lotto.domain.lottoManage.LottoGenerator;
import lotto.domain.lottoManage.LottoManager;
import lotto.domain.lottoManage.PurchaseAmount;
import lotto.dto.response.PrizeResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.config.GameConfig.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoManagerTest {

    List<Integer> numbers;
    Lotto lotto;
    LottoNumber bonusNumber;
    PurchaseAmount purchaseAmount;
    PlayerLotto player;
    List<Lotto> winningLottos;
    LottoManager lottoManager;

    @BeforeEach
    void setUp() {
        // given
        numbers = List.of(1, 2, 3, 4, 5, 6);
        lotto = Lotto.create(numbers);
        bonusNumber = LottoNumber.create(7);
        purchaseAmount = PurchaseAmount.create(8000);
        player = PlayerLotto.create(lotto, bonusNumber);
        winningLottos = LottoGenerator.generateWinningLottos(purchaseAmount);

        lottoManager = LottoManager.create(winningLottos, purchaseAmount, player);
    }

    @Test
    @DisplayName("범위 내의 랜덤한 6자리 숫자를 생성한다.")
    void generateWinningLottos() {
        // given
        Lotto winningLotto = LottoGenerator.generateWinningLottos(PurchaseAmount.create(1000)).get(0);

        // when
        List<Integer> numbers = winningLotto.getLottoNumbers()
                .stream()
                .map(LottoNumber::getPrimitiveLottoNumber)
                .toList();

        // then
        assertThat(numbers.size()).isEqualTo(LOTTO_NUMBERS_LENGTH.getNumber());
        numbers.forEach(number -> assertThat(number).isBetween(
                MINIMUM_LOTTO_NUMBER.getNumber(),
                MAXIMUM_LOTTO_NUMBER.getNumber()));
    }

    @Test
    @DisplayName("주어진 당첨 상금과 당첨 횟수에 따라 당첨 결과를 반환한다.")
    void getWinningResult() {
        // given
        List<Prize> winningPrizes = new ArrayList<>();
        winningPrizes.add(Prize.FOUR_NUMBER_MATCH);

        Map<Prize, Integer> winningCounts = new HashMap<>();
        winningCounts.put(Prize.FOUR_NUMBER_MATCH, 1);

        // when
        List<PrizeResponse> prizeResponses = winningCounts.entrySet().stream()
                .map(winningCount -> PrizeResponse.of(winningCount.getKey(), winningCount.getValue()))
                .toList();

        // then
        assertThat(prizeResponses.get(0).getPrize()).isEqualTo(Prize.FOUR_NUMBER_MATCH);
        assertThat(prizeResponses.get(0).getMatchingNumberCount()).isEqualTo(4);
        assertThat(prizeResponses.get(0).getPrizeMoney()).isEqualTo(50000);
        assertThat(prizeResponses.get(0).getWinningCount()).isEqualTo(1);

    }

    @Test
    @DisplayName("주어진 당첨 결과를 바탕으로 수익률을 계산한다.")
    void calculateProfitRate() {
        // given
        List<Prize> winningPrizes = new ArrayList<>();
        winningPrizes.add(Prize.NONE);
        winningPrizes.add(Prize.NONE);
        winningPrizes.add(Prize.FOUR_NUMBER_MATCH);

        Map<Prize, Integer> winningCounts = new HashMap<>();
        winningCounts.put(Prize.NONE, 2);
        winningCounts.put(Prize.FOUR_NUMBER_MATCH, 1);

        List<PrizeResponse> prizeResponses = winningCounts.entrySet().stream()
                .map(winningCount -> PrizeResponse.of(winningCount.getKey(), winningCount.getValue()))
                .toList();

        // when
        double profitRate = lottoManager.calculateProfitRate(prizeResponses);

        // then
        assertThat(profitRate).isEqualTo(625.0);
    }
}