package lotto.service;

import lotto.domain.BonusNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import lotto.utils.constant.BuyPrice;
import lotto.utils.view.Input;
import lotto.utils.view.Messages;
import lotto.utils.view.Output;

public class LottoService {
    private final Input input = new Input();
    private final Output output = new Output();
    private Lottos lottos;
    private WinningNumbers winningNumbers;

    public void setupBuyLotto() {
        BuyPrice buyPrice = setupBuyPrice();
        lottos = setupLottos(buyPrice);
        showBoughtLottoNumbers(lottos);
    }

    private BuyPrice setupBuyPrice() {
        try {
            output.printMessage(Messages.SETUP_BUY_PRICE_MESSAGE.getMessage());
            return input.setupBuyPrice();
        } catch (IllegalArgumentException e) {
            output.printErrorMessage(e.getMessage());
            return setupBuyPrice();
        }
    }

    private Lottos setupLottos(BuyPrice buyPrice) {
        return new Lottos(buyPrice);
    }

    private void showBoughtLottoNumbers(Lottos lottos) {
        output.printMessage(lottos.getBuyMessage());
        output.printMessage(lottos.getLottoMessages());
    }



    public void setupWinningNumbers() {
        LottoNumbers lottoNumbers = setupLottoNumbers();
        BonusNumber bonusNumber = setupBonusNumber(lottoNumbers);
        winningNumbers = new WinningNumbers(lottoNumbers, bonusNumber);
    }

    private LottoNumbers setupLottoNumbers() {
        try {
            output.printMessage(Messages.SETUP_WINNING_NUMBERS_MESSAGE.getMessage());
            return input.setupLottoNumbers();
        } catch (IllegalArgumentException e) {
            output.printErrorMessage(e.getMessage());
            return setupLottoNumbers();
        }
    }

    private BonusNumber setupBonusNumber(LottoNumbers lottoNumbers) {
        try {
            output.printMessage(Messages.SETUP_BONUS_NUMBER_MESSAGE.getMessage());
            BonusNumber bonusNumber = input.setupBonusNumber();
            lottoNumbers.checkBonusNumber(bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            output.printErrorMessage(e.getMessage());
            return setupBonusNumber(lottoNumbers);
        }
    }
}
