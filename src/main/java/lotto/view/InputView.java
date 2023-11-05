package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Validator;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public int inputBuyCash() {
        System.out.println(ClientMessage.ASK_BUY_PRICE.getMessage());
        int inputCash = Integer.parseInt(Console.readLine());
        Validator.validateBuyCash(inputCash);
        return inputCash;
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println(ClientMessage.ASK_WINNING_NUMBERS.getMessage());
        return Arrays.stream(Console.readLine().split(",")).map(Integer::parseInt).toList();
    }

    public int inputBonusNumber() {
        System.out.println(ClientMessage.ASK_BONUS_NUMBERS.getMessage());
        return Integer.parseInt(Console.readLine());
    }
}
