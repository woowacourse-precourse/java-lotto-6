package InputManager;

import ErrorMessages.CustomErrorMessages;
import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class InputManager {
    public static Integer inputCost() {
        while (true) {
            try {
                Integer cost = inputOneCost();
                return cost;
            }catch(IllegalArgumentException err) {
                System.out.println(err.getMessage());
            }
        }
    }

    private static Integer inputOneCost() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputText = Console.readLine();

        if (!Pattern.matches(InputRegex.COST_NUMBER_REGEX.getRegex(), inputText))
            throw new IllegalArgumentException(CustomErrorMessages.UNMATCHED_WITH_INPUT_FORM.getMsg());

        Integer ret = Integer.parseInt(inputText);
        if (ret % 1000 != 0) {
            throw new IllegalArgumentException(CustomErrorMessages.CANNOT_DIVIDED_WITH_1000.getMsg());
        }

        return Integer.parseInt(inputText);
    }
}
