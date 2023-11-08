package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.PlayerLotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningInformation;
import lotto.dto.PurchaseLottoDto;
import lotto.dto.WinningStatisticsDto;
import lotto.service.LottoGameService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGameService lottoGameService;

    public LottoGameController(InputView inputView, OutputView outputView, LottoGameService lottoGameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGameService = lottoGameService;
    }

    public void gameStart() {
        final int purchaseTotalCount = setPurchaseTotalCount();
        final PlayerLotto playerLotto = purchasePlayerLotto(purchaseTotalCount);
        final WinningInformation winningInformation = openWinningInformation();

        publishWinningStatistics(playerLotto, winningInformation);
    }

    private int setPurchaseTotalCount() {
        while (true) {
            try {
                PurchaseAmount purchaseAmount = new PurchaseAmount(inputView.readPurchaseAmount());

                return purchaseAmount.getPurchaseLottoCount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private PlayerLotto purchasePlayerLotto(final int purchaseTotalCount) {
        List<Lotto> purchaseLotto = lottoGameService.createPlayerLotto(purchaseTotalCount);
        outputView.printPurchaseLotto(new PurchaseLottoDto(purchaseLotto));
        return new PlayerLotto(purchaseLotto);
    }

    private WinningInformation openWinningInformation() {
        Lotto winningNumbers = setWinningNumbers();
        return setBonusNumber(winningNumbers);
    }

    private Lotto setWinningNumbers() {
        while (true) {
            try {
                List<Integer> winningNumbers = inputView.readWinningNumbers();

                return new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningInformation setBonusNumber(final Lotto winningNumbers) {
        while (true) {
            try {
                int bonusNumberInput = inputView.readBonusNumber();
                LottoNumber bonusNumber = new LottoNumber(bonusNumberInput);

                return new WinningInformation(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void publishWinningStatistics(PlayerLotto playerLotto, WinningInformation winningInformation) {
        WinningStatisticsDto winningStatisticsDto = lottoGameService.calculateWinningStatistics(playerLotto,
                winningInformation);
        outputView.printWinningStatistics(winningStatisticsDto);
    }
}