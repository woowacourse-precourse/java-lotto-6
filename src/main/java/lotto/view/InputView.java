package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.controller.InputController;
import lotto.model.Model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private final InputController inputController;
    private Lotto lotto;
    public InputView(Model model) {
        this.inputController = new InputController(model);
    }

    public void start() {
        int cash = inputLottoPayCount();
        printBuyLottoList(cash);
        inputLottoWinningNumber();
    }

    private void inputLottoWinningNumber() {
        List<Integer> list = inputWinningNumnberList();
        Integer bonusNumber = inputBonusNumber();
        lotto = new Lotto(list, bonusNumber);
    }

    private List<Integer> inputWinningNumnberList() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputLottoNumber = Console.readLine();
        List<Integer> list = inputController.createWinningLottoList(inputLottoNumber);
        inputController.checkRangeLottoNumber(list);
        return list;
    }

    private Integer inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return inputController.checkValidNumberFormat(Console.readLine());
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

    public Lotto returnLotto(){
        return lotto;
    }
}
