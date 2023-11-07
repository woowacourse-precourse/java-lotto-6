package lotto.view;

import static lotto.message.LotteryMessages.ENTER_BONUS_NUMBER;
import static lotto.message.LotteryMessages.ENTER_BUY_AMOUNT;
import static lotto.message.LotteryMessages.ENTER_WINNING_NUMBERS;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import lotto.service.InputValidator;
import lotto.service.LottoValidator;

public class InputView {
    InputValidator inputValidator = new InputValidator();
    LottoValidator lottoValidator = new LottoValidator();
    boolean isFirst = true;
    public int getBuyAmount() {
        if(isFirst) {
            System.out.println(ENTER_BUY_AMOUNT.getMessage());
            isFirst = false;
        }
        String buyAmount = Console.readLine();

        while (!inputValidator.isValidInputNumber(buyAmount)) {
            buyAmount = Console.readLine();
        }
        System.out.println();
        return Integer.parseInt(buyAmount);
    }
    public int[] getWinningNumbers() {
        System.out.println(ENTER_WINNING_NUMBERS.getMessage());
        String winningNumber = Console.readLine();

        while (!inputValidator.isValidNumberList(winningNumber)) {
            winningNumber = Console.readLine();
        }
        System.out.println();
        return Arrays.stream(winningNumber.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
    public int getBonusNumber() {
        System.out.println(ENTER_BONUS_NUMBER.getMessage());
        String bonusNumber = Console.readLine();
        while (!inputValidator.isValidInputNumber(bonusNumber)) {
            bonusNumber = Console.readLine();
        }
        System.out.println();
        return Integer.parseInt(bonusNumber);
    }
}
