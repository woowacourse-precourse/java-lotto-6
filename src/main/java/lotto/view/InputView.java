package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.validate.AmountValidator;

public class InputView {
    private final AmountValidator amountValidator = new AmountValidator();

    public int inputBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String amount = Console.readLine();
        amountValidator.validate(amount);
        return Integer.parseInt(amount);
    }

    public List<Integer> inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] number = Console.readLine().split(",");
        return Arrays.stream(number)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int inputBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
