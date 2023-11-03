package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.util.Convertor.*;
import static lotto.util.Parser.*;
import static lotto.util.Validator.*;

import java.util.List;

public class InputView {
    public static String inputNumber() {
        return readLine();
    }

    public static List<Integer> inputAnswerLottoNumber() {
        String input = readLine();

        validateHasSpace(input);
        validateCommaStartEnd(input);

        List<String> parseInput = parseStringtoList(input);
        validateListIsInteger(parseInput);

        return convertListStringToInteger(parseInput);
    }
}
