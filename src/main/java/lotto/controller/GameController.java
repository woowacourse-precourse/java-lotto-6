package lotto.controller;

import lotto.domain.LottoWinningBonusNumber;
import lotto.domain.LottoWinningNumbers;
import lotto.domain.PurchasedLottoNumbers;
import lotto.domain.dto.InputBonusNumber;
import lotto.domain.dto.InputMoney;
import lotto.domain.dto.InputWinningNumbers;
import lotto.domain.dto.LottoResultDTO;
import lotto.domain.dto.PurchasedLottoDTO;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    public static void runGame() {
        PurchasedLottoNumbers purchasedLottoNumbers = buyLotto();
        lottoProgress(purchasedLottoNumbers);
    }

    private static PurchasedLottoNumbers buyLotto() {
        PurchasedLottoNumbers purchasedLottoNumbers = moneyInputAndLottoIssue();
        PurchasedLottoDTO purchasedLottoDTO = LottoService.purchasedLottoToDTO(purchasedLottoNumbers);
        OutputView.printPurchasedLotto(purchasedLottoDTO);
        return purchasedLottoNumbers;
    }

    private static void lottoProgress(PurchasedLottoNumbers purchasedLottoNumbers) {
        LottoWinningNumbers lottoWinningNumbers = inputWinningNumbers();
        LottoWinningBonusNumber lottoWinningBonusNumber = inputBonusNumber(lottoWinningNumbers);
        LottoResultDTO lottoResultDTO = LottoService.compareLotto(lottoWinningNumbers, lottoWinningBonusNumber,
                purchasedLottoNumbers);
        OutputView.printLottoResult(lottoResultDTO);
    }

    private static PurchasedLottoNumbers moneyInputAndLottoIssue() {
        try {
            InputMoney money = InputView.inputMoney();
            return LottoService.inputMoneyAndIssueLotto(money);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return moneyInputAndLottoIssue();
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
