package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import lotto.util.Validator;

public class InputView {


    public String readMoney() {
        String money = Console.readLine();
        Validator.validateInputRange(money);
        return money;
    }

    public String readWinningNumbers() {
        String numbers = Console.readLine();
        numbers = numbers.replace(" ", "");
        Arrays.stream(numbers.split(",")).forEach(num -> Validator.validateInputRange(num));
        return numbers;
    }

    public String readBonusNumber() {
        String number = Console.readLine();
        Validator.validateInputRange(number);
        return number;
    }
}
