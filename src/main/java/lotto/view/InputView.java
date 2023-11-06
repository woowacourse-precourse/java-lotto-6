package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.InputController;
import lotto.model.Model;

import java.util.List;

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
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> list;
        do{
            String inputLottoNumber = Console.readLine();
            list = inputController.createWinningLottoList(inputLottoNumber);
            inputController.checkRangeLottoNumber(list);
            inputController.storeLotto(list);
        }while (inputController.getLotto().againInputList());
    }

    private Integer inputBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = inputController.checkValidNumberFormat(Console.readLine());
        inputController.checkRangeLottoNumber(bonusNumber);
        return bonusNumber;
    }

    private void printBuyLottoList(int cash) {
        int lottoCount = inputController.cashToLottoCount(cash);
        System.out.println(lottoCount + "개를 구매했습니다.");
        inputController.storeLottoTicket(lottoCount);
        inputController.showLottoTicket();
    }

    private int inputLottoPayCount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int number = inputController.checkValidNumberFormat(input);
        return inputController.checkNotThousandAndNegative(number);
    }
}
