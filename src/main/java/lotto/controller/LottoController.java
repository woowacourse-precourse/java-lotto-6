package lotto.controller;

import lotto.constants.ViewConsts;
import lotto.domain.game.LottoGame;
import lotto.domain.game.Money;
import lotto.domain.game.Prizes;
import lotto.domain.generator.LottoNumberGenerator;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoNumbers;
import lotto.domain.lotto.WinningNumber;
import lotto.utils.InputParser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoController(InputView inputView, OutputView outputView, LottoNumberGenerator lottoNumberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public void run() {
        final Money purchasingMoney = receiveAndValidatePurchasingMoney();
        final LottoGame lottoGame = createLottoGame(purchasingMoney);

        displayPurchasedLottos(lottoGame);

        final WinningNumber winningNumber = receiveAndCreateWinningNumber();
        updateWinningNumber(lottoGame, winningNumber);

        final Prizes prizes = calculateAndDisplayPrizes(lottoGame);
        displayStatistics(lottoGame, prizes);
    }

    private Money receiveAndValidatePurchasingMoney() {
        return inputPurchasingMoney();
    }

    private LottoGame createLottoGame(Money purchasingMoney) {
        return LottoGame.of(purchasingMoney, lottoNumberGenerator);
    }

    private void displayPurchasedLottos(LottoGame lottoGame) {
        outputView.printPurchasedLottos(lottoGame.getPurchasedLottosInfo());
    }

    private WinningNumber receiveAndCreateWinningNumber() {
        final LottoNumbers winningLottoNumbers = inputWinningLottoNumbers();
        return inputBonusLottoNumber(winningLottoNumbers);
    }

    private void updateWinningNumber(LottoGame lottoGame, WinningNumber winningNumber) {
        lottoGame.updateWinningNumber(winningNumber);
    }

    private Prizes calculateAndDisplayPrizes(LottoGame lottoGame) {
        return lottoGame.calculatePrizes();
    }

    private void displayStatistics(LottoGame lottoGame, Prizes prizes) {
        outputView.printPrizesStatistics(lottoGame.getPrizesStatisticsInfo(prizes));
    }

    private Money inputPurchasingMoney() {
        while (true) {
            try {
                final String purchasingMoney = inputView.inputPurchasingMoney();
                return new Money(InputParser.parseToInt(purchasingMoney));
            } catch (final IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private LottoNumbers inputWinningLottoNumbers() {
        while (true) {
            try {
                final String winningLottoNumbers = inputView.inputWinningLottoNumbers();
                return LottoNumbers.from(InputParser.parseToIntegerListByDelimiter(winningLottoNumbers, ViewConsts.INPUT_WINNING_LOTTO_NUMBERS_DELIMITER.getMessage()));
            } catch (final IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private WinningNumber inputBonusLottoNumber(final LottoNumbers winningLottoNumbers) {
        while (true) {
            try {
                final String bonusNumber = inputView.inputBonusNumber();
                final LottoNumber bonusLottoNumber = new LottoNumber(InputParser.parseToInt(bonusNumber));
                return new WinningNumber(winningLottoNumbers, bonusLottoNumber);
            } catch (final IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }


}
