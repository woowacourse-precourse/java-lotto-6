package lotto.controller;

import lotto.domain.Calculator;
import lotto.domain.LottoResult;
import lotto.domain.LottoWinningBonusNumber;
import lotto.domain.LottoWinningNumbers;
import lotto.domain.PurchasedLottoNumbers;
import lotto.domain.User;
import lotto.domain.dto.InputBonusNumber;
import lotto.domain.dto.InputMoney;
import lotto.domain.dto.InputWinningNumbers;
import lotto.domain.dto.LottoResultDTO;
import lotto.domain.dto.PurchasedLottoDTO;
import lotto.service.LottoService;
import lotto.service.ResultService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    public static void runGame() {
        InputMoney inputMoney = moneyInput();
        User user = new User(inputMoney.getMoney());
        PurchasedLottoNumbers purchasedLottoNumbers = buyLotto(inputMoney);
        LottoResultDTO lottoResultDTO = lottoProgress(purchasedLottoNumbers);
        double totalPrizeMoney = lottoProfit(user, lottoResultDTO);
        OutputView.printProfit(totalPrizeMoney);
    }

    private static PurchasedLottoNumbers buyLotto(InputMoney inputMoney) {
        PurchasedLottoNumbers purchasedLottoNumbers = LottoService.inputMoneyAndIssueLotto(inputMoney);
        PurchasedLottoDTO purchasedLottoDTO = LottoService.purchasedLottoToDTO(purchasedLottoNumbers);
        OutputView.printPurchasedLotto(purchasedLottoDTO);
        return purchasedLottoNumbers;
    }

    private static LottoResultDTO lottoProgress(PurchasedLottoNumbers purchasedLottoNumbers) {
        LottoWinningNumbers lottoWinningNumbers = inputWinningNumbers();
        LottoWinningBonusNumber lottoWinningBonusNumber = inputBonusNumber(lottoWinningNumbers);
        LottoResult lottoResult = LottoService.compareLotto(lottoWinningNumbers, lottoWinningBonusNumber,
                purchasedLottoNumbers);
        LottoResultDTO lottoResultDTO = new LottoResultDTO(lottoResult.getLottoResult());
        OutputView.printLottoResult(lottoResultDTO);
        return lottoResultDTO;
    }

    private static double lottoProfit(User user, LottoResultDTO lottoResultDTO){
        return Calculator.profitCalculator(user,lottoResultDTO);
    }

    private static InputMoney moneyInput() {
        try {
            return InputView.inputMoney();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return moneyInput();
        }
    }

    private static LottoWinningNumbers inputWinningNumbers() {
        try {
            InputWinningNumbers inputWinningNumbers = InputView.inputWinningNumbers();
            return LottoService.inputWinningLotto(inputWinningNumbers);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return inputWinningNumbers();
        }
    }

    private static LottoWinningBonusNumber inputBonusNumber(LottoWinningNumbers lottoWinningNumbers) {
        try {
            InputBonusNumber inputBonusNumber = InputView.inputBonusNumber();
            return LottoService.inputBonusLotto(lottoWinningNumbers, inputBonusNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return inputBonusNumber(lottoWinningNumbers);
        }
    }
}
