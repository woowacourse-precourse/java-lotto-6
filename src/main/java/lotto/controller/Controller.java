package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.PrizeTable;
import lotto.domain.WinningNumbers;
import lotto.service.Service;
import lotto.util.Utils;
import lotto.validation.Validation;
import lotto.view.InputMessage;
import lotto.view.OutputMessage;

import java.util.HashMap;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.util.LottoConstants.MIN_UNIT;

public class Controller {

    private Buyer buyer;
    private WinningNumbers winningNumbers;
    private final Service service = new Service();

    public void run() {
        settingBuyLotto();
        settingWinningNumber();
        lottoGameResult();
    }

    private void lottoGameResult() {
        HashMap<PrizeTable, Integer> result = service.checkMyLotto(buyer, winningNumbers);
        OutputMessage.winningStatistics();
        OutputMessage.showRankResult(result);
        OutputMessage.showYieldResult(buyer.getYield(result));
    }

    private void settingBuyLotto() {
        buyer = new Buyer(getInputAmount());
        service.buyLotto(buyer);
        showBuyingResult();
    }

    private int getInputAmount() {
        while (true) {
            InputMessage.moneyInputMessage();
            String userInput = readLine();
            try {
                Validation.validateInput(userInput);
                return Utils.stringToInteger(userInput);
            } catch (IllegalArgumentException e) {
            }
        }
    }


    private void showBuyingResult() {
        int count = buyer.getPurchaseAmount() / MIN_UNIT;
        OutputMessage.totalLottoMessage(count);
        for (Lotto lotto : buyer.getPurchasedLotteries()) {
            OutputMessage.viewLottoNumbers(lotto.getLottoNumbers());
        }
    }

    private void settingWinningNumber() {
        boolean isValidInput = false;
        while (!isValidInput) {
            try {
                this.winningNumbers = new WinningNumbers(getInputWinningNumbers(), getInputBonusNumber());
                isValidInput = true;
            } catch (IllegalArgumentException e) {
            }
        }
    }


    private List<Integer> getInputWinningNumbers() {
        InputMessage.winningInputMessage();
        return Utils.stringToIntegerList(readLine().split(","));
    }

    private int getInputBonusNumber() {
        InputMessage.inputBonusNumber();
        return Utils.stringToInteger(readLine().trim());
    }


}
