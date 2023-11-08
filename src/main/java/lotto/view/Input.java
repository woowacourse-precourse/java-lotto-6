package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.InputMessage;
import lotto.validator.AmountValidator;
import lotto.validator.BounsNumberValidator;
import lotto.validator.LottoPrizeNumberValidator;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private LottoPrizeNumberValidator prizeNumValidator;
    private AmountValidator amountValidator;
    private BounsNumberValidator bounsNumValidator;

    public Input() {
        prizeNumValidator = new LottoPrizeNumberValidator();
        amountValidator = new AmountValidator();
        bounsNumValidator = new BounsNumberValidator();
    }

    public int requestLottoBuyAmount() {
        String buyAmount;

        System.out.print(InputMessage.REQUEST_AMOUNT.getInputMessage());

        do {
            System.out.println(amountValidator.getErrorMessage());
            buyAmount = Console.readLine();
        } while (!amountValidator.validate(buyAmount));

        System.out.println();
        return amountValidator.getResultAmount();
    }

    public ArrayList<Integer> requestLottoPrizeNums() {
        String prizeNums;

        System.out.print(InputMessage.REQUEST_PRIZE_NUM.getInputMessage());

        do {
            System.out.println(prizeNumValidator.getErrorMessage());
            prizeNums = Console.readLine();
        } while (!prizeNumValidator.validate(prizeNums));

        System.out.println();
        return prizeNumValidator.getLottoNums();
    }

    public int requestBonusNums(List<Integer> prizeNums) {
        String bonusNum;
        System.out.print(InputMessage.REQUEST_BONUS_NUM.getInputMessage());

        do {
            System.out.println(bounsNumValidator.getErrorMessage());
            bonusNum = Console.readLine();

        } while (!bounsNumValidator.validate(bonusNum, prizeNums));

        System.out.println();
        return bounsNumValidator.getBonusNum();
    }
}
