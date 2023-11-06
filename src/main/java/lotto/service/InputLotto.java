package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.view.ErrorMessage;
import lotto.view.PrintMessage;

public class InputLotto {
    public static Lotto setInputLotto() {
        try {
            PrintMessage.printWinnigLotto();
            Lotto lotto = new Lotto(setLotto());
            return lotto;
        } catch (IllegalArgumentException e) {
            ErrorMessage.printErrorMessage(e);
            return setInputLotto();
        }

    }

    public static List<Integer> setLotto() {
        try {
            String input = Console.readLine();
            isNumeric(input);
            return separateLottoNumber(input);
        } catch (IllegalArgumentException e) {
            ErrorMessage.printErrorMessage(e);
            PrintMessage.printWinnigLotto();
            return setLotto();
        }
    }


    public static List<Integer> separateLottoNumber(String input) {
        List<Integer> separateNumbers = Stream.of(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return separateNumbers;
    }

    public static void isNumeric(String input) {
        if (!input.matches("^\\d+(,\\d+)*$")) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUM_ERROR);
        }

    }
}
