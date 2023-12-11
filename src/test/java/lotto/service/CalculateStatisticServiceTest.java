package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.BuyLottoDto;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoNumbers;
import lotto.model.PurchasePrice;
import lotto.model.Statistics;
import lotto.model.WinnerNumber;
import lotto.view.output.OutputView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculateStatisticServiceTest {
    private final CalculateStatisticService calculateStatisticService;

    CalculateStatisticServiceTest() {
        calculateStatisticService = new CalculateStatisticService(new OutputView());
    }

    @DisplayName("총 수익금 계산")
    @Test
    void calculate_Total_Money_Test() {
        //given
        PurchasePrice purchasePrice = PurchasePrice.createPurchasePrice(8000);
        List<Lotto> lottos = createLotto();

        LottoNumbers lottoNumbers = LottoNumbers.createLottoNumbers(lottos);
        WinnerNumber winnerNumber = WinnerNumber.createWinnerNumber(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.createBonusNumber(winnerNumber.getWinnerNumbers(), 7);
        BuyLottoDto buyLottoDto = BuyLottoDto.createBuyLottoDto(purchasePrice, lottoNumbers, winnerNumber, bonusNumber);
        Statistics statistics = buyLottoDto.calculateMatching();

        //when
        long totalMoney = calculateStatisticService.calculatePrizeMoney(statistics.getResult());

        //then
        Assertions.assertEquals(5000, totalMoney);
    }

    private static List<Lotto> createLotto() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 7, 8, 9)));
        lottos.add(new Lotto(List.of(11, 12, 13, 17, 18, 19)));
        lottos.add(new Lotto(List.of(21, 22, 23, 27, 28, 29)));
        lottos.add(new Lotto(List.of(31, 32, 33, 37, 38, 39)));
        lottos.add(new Lotto(List.of(41, 42, 43, 45, 34, 40)));
        lottos.add(new Lotto(List.of(12, 22, 33, 37, 28, 19)));
        lottos.add(new Lotto(List.of(13, 22, 39, 17, 28, 12)));
        lottos.add(new Lotto(List.of(14, 32, 31, 17, 18, 19)));
        return lottos;
    }

}