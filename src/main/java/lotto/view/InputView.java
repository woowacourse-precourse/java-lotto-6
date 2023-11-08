package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.InputController;
import lotto.model.db.Model;

import static lotto.util.Constant.InputClass.*;

public class InputView {
    private final InputController inputController;
    public InputView(Model model) {
        this.inputController = new InputController(model);
    }

    public void start() {
        int cash = inputLottoPayCount();
        printBuyLottoList(cash);
        inputLottoWinningNumber();
    }

    private void inputLottoWinningNumber() {
        inputWinningNumberList();
        inputController.storeBonusNumber(inputBonusNumber());
    }

    private void inputWinningNumberList() {
        System.out.println();
        System.out.println(ASK_MESSAGE_WINNING_NUMBER_LIST);
        String inputLottoNumber = Console.readLine();
        inputController.checkStoreLotto(inputLottoNumber);

    }

    private Integer inputBonusNumber() {
        System.out.println();
        System.out.println(ASK_MESSAGE_WINNING_BONUS_NUMBER_LIST);
        int bonusNumber = inputController.checkValidNumberFormat(Console.readLine());
        inputController.checkRangeLottoNumber(bonusNumber);
        return bonusNumber;
    }

    private void printBuyLottoList(int cash) {
        int lottoCount = inputController.cashToLottoCount(cash);
        System.out.println(lottoCount + PRINT_BUYING_LOTTO_LIST);
        inputController.storeLottoTicket(lottoCount);
        inputController.showLottoTicket();
    }

    private int inputLottoPayCount() {
        System.out.println(ASK_MESSAGE_LOTTO_CASH);
        String input = Console.readLine();
        int number = inputController.checkValidNumberFormat(input);
        return inputController.checkNotThousandAndNegative(number);
    }
}
