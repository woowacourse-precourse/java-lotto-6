package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.constant.LottoConstant;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.error.ErrorMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int purchaseAmount = getPurchaseAmount();
        int lottoCount = purchaseAmount / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LottoConstant.LOTTO_MIN_NUMBER,
                    LottoConstant.LOTTO_MAX_NUMBER,
                    LottoConstant.LOTTO_LENGTH);
            Collections.sort(numbers);
            outputView.printLottoNumber(numbers);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }

        WinningNumber winningNumber = getWinningNumber();
        BonusNumber bonusNumber = getBonusNumber(winningNumber);
    }

    private int getPurchaseAmount() {
        while (true) {
            try {
                outputView.printPurchaseInputMessage();
                int purchaseAmount = inputView.getNumber();
                if (purchaseAmount != 0 && purchaseAmount % 1000 != 0) {
                    throw new IllegalArgumentException();
                }
                return purchaseAmount;
            } catch(IllegalArgumentException e) {
                outputView.printErrorMessage(ErrorMessage.INVALID_LOTTO_PURCHASE_AMOUNT);
            }
        }
    }

    private WinningNumber getWinningNumber() {
        while (true) {
            try {
                outputView.printWinningNumberInputMessage();
                List<Integer> numbers = inputView.getNumbers();
                WinningNumber winningNumber = new WinningNumber(numbers);
                return winningNumber;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(ErrorMessage.INVALID_WINNING_NUMBERS);
            }
        }
    }

    private BonusNumber getBonusNumber(WinningNumber winningNumber) {
        while (true) {
            try {
                outputView.printBonusNumberInputMessage();
                int number = inputView.getNumber();
                BonusNumber bonusNumber = new BonusNumber(number, winningNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(ErrorMessage.INVALID_BONUS_NUMBER);
            }
        }
    }
}
