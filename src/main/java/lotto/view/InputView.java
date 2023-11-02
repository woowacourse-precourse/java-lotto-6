package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Validator;

import java.util.List;

public class InputView {
    public static int inputCash(){
        int input = Integer.parseInt(Console.readLine());
        Validator.validateCash(input);
        return input;
    }

    public static List<Integer> inputLotto(){
        return null;
    }
}
