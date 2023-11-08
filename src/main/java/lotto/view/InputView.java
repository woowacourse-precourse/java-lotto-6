package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.NumberGenerator;
import lotto.enums.Instructions;

public class InputView {
    public Integer readPurchaseAmount() {
        System.out.println(Instructions.PURCHASE_AMOUNT.getInstruction());
        String input = Console.readLine();
        return NumberGenerator.formatNumber(input);
    }

    public List<Integer> readWinnerNumbers() {
        System.out.println(Instructions.WINNING_NUMBER.getInstruction());
        String input = Console.readLine();
        return NumberGenerator.formatNumbers(input);
    }

    public Integer readBonusNumber() {
        System.out.println(Instructions.BONUS_NUMBER.getInstruction());
        String input = Console.readLine();
        return NumberGenerator.formatNumber(input);
    }
}
