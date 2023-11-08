package lotto.controller;

import lotto.model.Lotto;
import lotto.model.PrizeRank;
import lotto.model.WinningLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class LottoControllerTest {
    @Mock
    private LottoService lottoService;

    @Mock
    private InputView inputView;

    @Mock
    private ResultView resultView;

    @InjectMocks
    private LottoController lottoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("구입 금액에 맞게 로또를 구매하고 결과를 출력해야 한다")
    void validatePurchaseAmountAndDisplayResult() {
        int purchaseAmount = 5000;
        List<Lotto> purchasedLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
        );
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), bonusNumber);
        List<PrizeRank> prizeRanks = Arrays.asList(PrizeRank.FIRST, PrizeRank.SECOND);
        double totalPrize = PrizeRank.FIRST.getPrizeMoney() + PrizeRank.SECOND.getPrizeMoney();
        double rateOfReturn = (totalPrize / purchaseAmount) * 100;

        when(inputView.promptForPurchaseAmount()).thenReturn(purchaseAmount);
        when(lottoService.purchaseLottos(purchaseAmount)).thenReturn(purchasedLottos);
        when(inputView.promptForWinningNumbers()).thenReturn(winningNumbers);
        when(inputView.promptForBonusNumber(winningNumbers)).thenReturn(bonusNumber);
        when(lottoService.generateWinningLotto(winningNumbers, bonusNumber)).thenReturn(winningLotto);
        when(lottoService.determinePrizeRank(purchasedLottos, winningLotto)).thenReturn(prizeRanks);
        when(lottoService.calculateTotalPrize(prizeRanks)).thenReturn(totalPrize);
        when(lottoService.calculateRateOfReturn(purchaseAmount, totalPrize)).thenReturn(rateOfReturn);

        lottoController.run();

        verify(inputView).promptForPurchaseAmount();
        verify(lottoService).purchaseLottos(purchaseAmount);
        verify(resultView).displayPurchasedLottos(purchasedLottos);
        verify(inputView).promptForWinningNumbers();
        verify(inputView).promptForBonusNumber(winningNumbers);
        verify(lottoService).generateWinningLotto(winningNumbers, bonusNumber);
        verify(lottoService).determinePrizeRank(purchasedLottos, winningLotto);
        verify(resultView).displayWinningStatistics(prizeRanks);
        verify(lottoService).calculateTotalPrize(prizeRanks);
        verify(lottoService).calculateRateOfReturn(purchaseAmount, totalPrize);
        verify(resultView).displayRateOfReturn(rateOfReturn);
    }
}
