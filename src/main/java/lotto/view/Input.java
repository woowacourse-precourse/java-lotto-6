package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.InputMessage;
import lotto.validator.InputValidator;

import java.util.ArrayList;

public class Input {
    private InputValidator inputValidator;

    public Input() {
        inputValidator = new InputValidator();
    }

    public int requestLottoBuyAmount() {
        String buyAmount;

        System.out.print(InputMessage.REQUEST_AMOUNT.getInputMessage());

        do {
            System.out.println(inputValidator.getErrorMessage());
            buyAmount = Console.readLine();
        } while (!inputValidator.validLottoBuyAmount(buyAmount));
        System.out.println();

        return inputValidator.getResultAmount();
    }

    public ArrayList<Integer> requestLottoPrizeNums() {
        String prizeNums;

        System.out.print(InputMessage.REQUEST_PRIZE_NUM.getInputMessage());

        do {
            System.out.println(inputValidator.getErrorMessage());
            prizeNums = Console.readLine();
        } while (!inputValidator.validLottoPrizeNums(prizeNums));

        return inputValidator.getLottoNums();
    }
}
