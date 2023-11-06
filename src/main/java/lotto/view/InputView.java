package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import lotto.exception.InvalidInput;

public class InputView {
    private static final String INPUT_BUYING_COST_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final String COMMA = ",";

    public int inputBuyingCost() {
        InvalidInput invalidInput = new InvalidInput();
        String cost;

        do {
            System.out.println(INPUT_BUYING_COST_MESSAGE);
            cost = readLine();
        } while (!invalidInput.notIntegerValueException(cost));

        return Integer.parseInt(cost);
    }

    public List<String> inputWinningNumbers(){
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        String[] inputNumbers = readLine().split(COMMA);

        return Arrays.stream(inputNumbers).toList();
    }

    public int inputBonusNumber() {
        InvalidInput invalidInput = new InvalidInput();
        String bonus;

        do {
            System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
            bonus = readLine();
        } while (!invalidInput.notIntegerValueException(bonus));

        return Integer.parseInt(bonus);
    }
}
