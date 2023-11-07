package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public int inputLottoPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        String amount = Console.readLine();

        inputValidator.validateInputType(amount);
        inputValidator.validateInputAmountUnit(toInt(amount));

        return toInt(amount);
    }

    public List<Integer> inputLottoWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();

        inputValidator.validateInputType(winningNumbers.replace(",", ""));
        toIntList(winningNumbers).stream()
                .forEach(inputValidator::validateInputNumberRange);

        return toIntList(winningNumbers);
    }

    public int inputLottoBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();

        inputValidator.validateInputType(bonusNumber);
        inputValidator.validateInputNumberRange(toInt(bonusNumber));

        return toInt(bonusNumber);
    }

    private List<Integer> toIntList(String str){
        return Arrays
                .stream(str.replace(" ", "").split(","))
                .mapToInt(this::toInt)
                .boxed()
                .toList();
    }
    private int toInt(String str){
        return Integer.parseInt(str);
    }
}
