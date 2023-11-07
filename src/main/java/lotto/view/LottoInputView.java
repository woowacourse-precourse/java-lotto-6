package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.util.Validator;

public class LottoInputView {

    public static final String PROMPT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String PROMPT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String PROMPT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public int promptForPurchaseAmount() {
        System.out.println(PROMPT_PURCHASE_AMOUNT);
        String input = Console.readLine();
        Validator.validatePurchaseAmount(input);
        int money = Integer.parseInt(input);
        System.out.println();
        return money;
    }

    public List<Integer> promptWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        System.out.println(PROMPT_WINNING_NUMBERS);
        String[] strList = Console.readLine().split(",");
        for (String str : strList) {
            winningNumbers.add(Integer.parseInt(str));
        }
        System.out.println();
        return winningNumbers;
    }

    public int promptBonusNumber() {
        System.out.println(PROMPT_BONUS_NUMBER);
        int bonus = Integer.parseInt(Console.readLine());
        System.out.println();
        return bonus;
    }

}
