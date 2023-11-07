package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.PlayerLotto;
import lotto.dto.PurchaseLottoDto;
import lotto.dto.WinningStatisticsDto;
import lotto.service.LottoGameService;
import lotto.utils.GameUtils;
import lotto.utils.validator.PurchaseAmountValidator;
import lotto.utils.validator.WinningInfoValidator;
import lotto.utils.validator.WinningNumberValidator;
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
        final Lotto winningNumbers = openWinningNumbers();
        final LottoNumber bonusNumber = openBonusNumber(winningNumbers);

        publishWinningStatistics(playerLotto, winningNumbers, bonusNumber);
    }

    private int setPurchaseTotalCount() {
        while (true) {
            try {
                String purchaseAmount = inputView.readPurchaseAmount();
                PurchaseAmountValidator.validate(purchaseAmount);
                return Integer.parseInt(purchaseAmount) / 1000;
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

    private Lotto openWinningNumbers() {
        while (true) {
            try {
                String winningNumbers = inputView.readWinningNumbers();
                WinningNumberValidator.validate(winningNumbers);

                return new Lotto(GameUtils.parse(winningNumbers));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private LottoNumber openBonusNumber(final Lotto winningNumbers) {
        while (true) {
            try {
                LottoNumber bonusNumber = new LottoNumber(Integer.parseInt(inputView.readBonusNumber()));
                WinningInfoValidator.validate(winningNumbers, bonusNumber);

                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void publishWinningStatistics(PlayerLotto playerLotto, Lotto winningNumbers, LottoNumber bonusNumber) {
        WinningStatisticsDto winningStatisticsDto = lottoGameService.calculateWinningStatistics(playerLotto,
                winningNumbers, bonusNumber);
        outputView.printWinningStatistics(winningStatisticsDto);
    }
}