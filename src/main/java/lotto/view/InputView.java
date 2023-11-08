package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Console;
public class InputView {
        public static List<Integer> inputLottoNumbers() {
                String answerNumbers = Console.readLine();
                String [] splitNumbers = answerNumbers.split(",");
                return Stream.of(splitNumbers)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        }
        public static int inputMoney() {
               return Integer.parseInt(Console.readLine());
        }
        public static int inputBonusNumber() {
                return Integer.parseInt(Console.readLine());
        }
}
