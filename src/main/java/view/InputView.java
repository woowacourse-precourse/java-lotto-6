package view;

import camp.nextstep.edu.missionutils.Console;
import domain.Lotto;
import domain.LottoService;
import domain.NumberValidate;
import java.util.List;

public class InputView {

    private final NumberValidate amountInput = new NumberValidate();
    private final LottoService lottoService = new LottoService();

    public void printRequestAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public Integer InputAmount() {
        String amount = Console.readLine();

        try {
            amountInput.validateAmount(amount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return InputAmount();
        }
        return Integer.parseInt(amount);
    }

    public List<Integer> inputWinningNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String userInputNum = Console.readLine();
        List<Integer> winningNum = lottoService.convertToIntegerList(userInputNum);
        List<Integer> finalWinningNum;

        try {
            Lotto lotto = new Lotto(winningNum);
            finalWinningNum = lotto.getNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNumber();
        }
        return finalWinningNum;
    }

    public int inputBonusNumber() {
        int bonusNumber;
        System.out.println("보너스 번호를 입력해 주세요");
        String userInputNum = Console.readLine();

        try {
            bonusNumber = lottoService.receiveBonusNumber(userInputNum);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber();
        }
        return bonusNumber;
    }
}
