package lotto.controller;

import static lotto.util.ListUtils.stringToInt;
import static lotto.util.ListUtils.stringToIntegerSortedList;
import static lotto.view.OutputMessage.REQUEST_BONUS_NUMBER;
import static lotto.view.OutputMessage.REQUEST_PURCHASE_AMOUNT;
import static lotto.view.OutputMessage.REQUEST_WINNING_NUMBER;

import java.util.List;
import lotto.domain.Cashier;
import lotto.domain.Customer;
import lotto.service.LottoService;
import lotto.service.ResultDto;
import lotto.util.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Validator validator = new Validator();
    Cashier cashier = new Cashier();
    LottoService lottoService = new LottoService();

    public LottoController() {

    }

    public void run() {
        Customer customer = new Customer(getPurchaseAmount());
        int lottoQuantity = cashier.calculateLotto(customer.getMoney());
        outputView.printPurchaseResult(lottoQuantity);

        lottoService.issueLotto(customer, lottoQuantity);
        outputView.printIssuedLottos(customer.getIssuedLottos());

        List<Integer> winningNumber = getWinningNumber();
        int bonusNumber = getBonusNumber(winningNumber);

        lottoService.saveWinningLotto(winningNumber, bonusNumber);

        outputView.printWinningStatistics();
        ResultDto resultDto = lottoService.getResult();
        outputView.printResult(resultDto.getResult());
        outputView.printTotalReturn(resultDto.getReturnRate());
    }

    public final int getPurchaseAmount() {
        try {
            outputView.printMessage(REQUEST_PURCHASE_AMOUNT.getMessage());
            String money = inputView.inputMessage();
            validator.validateMoney(money);
            return stringToInt(money);
        } catch (IllegalArgumentException exception) {
            outputView.printMessage(exception.getMessage());
            return getPurchaseAmount();
        }
    }

    public final List<Integer> getWinningNumber() {
        try {
            outputView.printMessage(REQUEST_WINNING_NUMBER.getMessage());
            String winningNumber = inputView.inputMessage();
            validator.validateWinningNumber(winningNumber);
            return stringToIntegerSortedList(winningNumber);
        } catch (IllegalArgumentException exception) {
            outputView.printMessage(exception.getMessage());
            return getWinningNumber();
        }
    }

    public final int getBonusNumber(List<Integer> winningNumber) {
        try {
            outputView.printMessage(REQUEST_BONUS_NUMBER.getMessage());
            String bonusNumber = inputView.inputMessage();
            validator.validateBonusNumber(winningNumber, bonusNumber);
            return stringToInt(bonusNumber);
        } catch (IllegalArgumentException exception) {
            outputView.printMessage(exception.getMessage());
            return getBonusNumber(winningNumber);
        }
    }
}
