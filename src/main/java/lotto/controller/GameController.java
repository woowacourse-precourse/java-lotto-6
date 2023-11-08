package lotto.controller;

import lotto.domain.Calculator;
import lotto.domain.LottoResult;
import lotto.domain.PurchasedLotto;
import lotto.domain.User;
import lotto.domain.WinningBonusNumber;
import lotto.domain.WinningNumbers;
import lotto.dto.InputBonus;
import lotto.dto.InputMoney;
import lotto.dto.InputWinningNumbers;
import lotto.dto.LottoResultDTO;
import lotto.dto.PurchasedLottoDTO;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    public static void runGame() {
        InputMoney inputMoney = moneyInput();
        User user = new User(inputMoney.getMoney());
        PurchasedLotto purchasedLotto = buyLotto(inputMoney);
        LottoResultDTO lottoResultDTO = lottoProgress(purchasedLotto);
        double totalPrizeMoney = lottoProfit(user, lottoResultDTO);
        OutputView.printProfit(totalPrizeMoney);
    }

    private static PurchasedLotto buyLotto(InputMoney inputMoney) {
        PurchasedLotto purchasedLotto = LottoService.inputMoneyAndIssueLotto(inputMoney);
        PurchasedLottoDTO purchasedLottoDTO = LottoService.purchasedLottoToDTO(purchasedLotto);
        OutputView.printPurchasedLotto(purchasedLottoDTO);
        return purchasedLotto;
    }

    private static LottoResultDTO lottoProgress(PurchasedLotto purchasedLotto) {
        WinningNumbers winningNumbers = inputWinningNumbers();
        WinningBonusNumber winningBonusNumber = inputBonusNumber(winningNumbers);
        LottoResultDTO lottoResultDTO = matchingLotto(winningNumbers, winningBonusNumber, purchasedLotto);
        return lottoResultDTO;
    }

    private static LottoResultDTO matchingLotto(WinningNumbers winningNumbers, WinningBonusNumber winningBonusNumber,
                                             PurchasedLotto purchasedLotto) {
        LottoResult lottoResult = LottoService.compareLotto(winningNumbers, winningBonusNumber,
                purchasedLotto);
        LottoResultDTO lottoResultDTO = new LottoResultDTO(lottoResult.getLottoResult());
        OutputView.printLottoResult(lottoResultDTO);
        return lottoResultDTO;
    }

    private static double lottoProfit(User user, LottoResultDTO lottoResultDTO) {
        return Calculator.profitCalculator(user, lottoResultDTO);
    }

    private static InputMoney moneyInput() {
        try {
            return InputView.inputMoney();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return moneyInput();
        }
    }

    private static WinningNumbers inputWinningNumbers() {
        try {
            InputWinningNumbers inputWinningNumbers = InputView.inputWinningNumbers();
            return LottoService.inputWinningLotto(inputWinningNumbers);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return inputWinningNumbers();
        }
    }

    private static WinningBonusNumber inputBonusNumber(WinningNumbers winningNumbers) {
        try {
            InputBonus inputBonus = InputView.inputBonusNumber();
            return LottoService.inputBonusLotto(winningNumbers, inputBonus);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return inputBonusNumber(winningNumbers);
        }
    }
}
