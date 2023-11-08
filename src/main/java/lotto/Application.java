package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.*;

public class Application {
    private static final String ERROR_MESSAGE = "[ERROR]";

    private static Lotto setLottoWinningNumbers() {
        try {
            System.out.println("당첨 번호를 입력해 주세요.");
            String[] userInputNumbers = inputWinningNumbers();
            return generateWinningNumbers(userInputNumbers);
        } catch (IllegalArgumentException e) {
            return setLottoWinningNumbers();
        }
    }

    private static String[] inputWinningNumbers() {
        String userInputNumbers = Console.readLine();
        checkSeparator(userInputNumbers);

        return userInputNumbers.split(",");
    }

    private static void checkSeparator(String numbers) {
        String regularExpressionNumbers = numbers.replaceAll("[0-9,]", "");
        System.out.println(regularExpressionNumbers);
        if (!regularExpressionNumbers.equals("")) {
            System.out.println(ERROR_MESSAGE + " 당첨 번호는 숫자만 입력해야 하며 구분자는 쉼표(,)로 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private static Lotto generateWinningNumbers(String[] numbers) {
        List<Integer> winningNumbers = Arrays.stream(numbers).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        Lotto winningLotto = new Lotto(winningNumbers);

        return winningLotto;
    }

    public static void main(String[] args) {
        LottoMoney lottoMoney = new LottoMoney();
        System.out.println(lottoMoney.money);

        Lotto winningNumbers = setLottoWinningNumbers();
        System.out.println(winningNumbers.numbers);
    }
}
