package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.view.PrintMessage;

public class InputLotto {
    public static Lotto setInputLotto() {
        PrintMessage.printWinnigLotto();
        Lotto lotto = new Lotto(setLotto());
        return lotto;
    }

    public static List<Integer> setLotto() {
        String input = Console.readLine();
        return separateLottoNumber(input);
    }

    public static List<Integer> separateLottoNumber(String input) {
        List<Integer> separateNumbers = Stream.of(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return separateNumbers;
    }
}
