package view;

import static enums.StringEnums.BONUS_INPUT;
import static enums.StringEnums.PURCHASE_AMOUNT;
import static enums.StringEnums.WIN_LOTTO_INPUT;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import view.validator.InputValidator;

public class InputView {

    private static final String AMOUNT_INPUT_STRING = PURCHASE_AMOUNT.toString();
    private static final String WIN_INPUT_STRING = WIN_LOTTO_INPUT.toString();
    private static final String BONUS_INPUT_STRING = BONUS_INPUT.toString();

    public Integer amountInput() {
        String s;
        int i;

        System.out.println(AMOUNT_INPUT_STRING);

        s = Console.readLine();
        InputValidator.verifyNumber(s);
        InputValidator.verifyThousand(s);

        i = Integer.parseInt(s);
        
        return i;
    }

    public List<Integer> winLottoInput() {
        System.out.println(WIN_INPUT_STRING);
        String s = Console.readLine();
        return InputValidator.verifyWinLotto(s);
    }

    public Integer bonusInput() {
        System.out.println(BONUS_INPUT_STRING);
        String s = Console.readLine();
        InputValidator.verifyNumber(s);

        return Integer.parseInt(s);
    }
}
