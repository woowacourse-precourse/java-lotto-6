package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Console;
public class InputView {
        public static List<Integer> inputLottoNumbers() {
                OutputView.mentionInputWinningNumber();
                String answerNumbers = Console.readLine();
                String [] splitNumbers = answerNumbers.split(",");
                return Stream.of(splitNumbers)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        }
        public static int inputMoney() {
                OutputView.mentionInputPrice();
                String inputMoney = Console.readLine();

               return conventToInt(inputMoney);
        }
        public static int inputBonusNumber() {
                OutputView.mentionInputBonusNumber();
                String inputBonusNumber = Console.readLine();
                return conventToInt(inputBonusNumber);
        }

        private static int conventToInt(String inputNumber) {
                try {
                        return Integer.parseInt(inputNumber);
                } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("숫자만 입력하세요");
                }
        }
}
