package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.util.Convertor.*;
import static lotto.util.Parser.*;
import static lotto.util.Validator.*;

import java.util.List;
import lotto.util.Convertor;
import lotto.util.Parser;
import lotto.util.Validator;

public class InputView {
    public static String inputTicketQuantity() {
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
