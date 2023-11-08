package lotto.util;

import lotto.model.Lotto;
import lotto.view.OutputView;

public class Parser {

    public static int stringToInt(String input) {
        try {
            StringUtil.checkNull(input);
            StringUtil.checkEmpty(input);
            return StringUtil.checkNumber(input);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return -1;
        }
    }

    public static Lotto stringToLotto(String input) {
        try {
            StringUtil.checkNull(input);
            StringUtil.checkEmpty(input);
            StringUtil.checkDelimiter(input);
            return new Lotto(StringUtil.splitAndToList(input));
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return null;
        }
    }
}
