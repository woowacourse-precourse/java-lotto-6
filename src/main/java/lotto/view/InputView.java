package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InputView {
    public static int inputMoney() {
        System.out.println("구입금액을 입력해주세요.");
        String input = Console.readLine();
        validateEmptyInput(input);
        validateInt(input);
        return Util.stringToInt(input);
    }

    public static List<Integer> inputLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        validateEmptyInput(input);
        List<String> splitInput = Util.stringToStringList(input);
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String stringNumber : splitInput) {
            validateInt(stringNumber);
            int number = Util.stringToInt(stringNumber);
            lottoNumbers.add(number);
        }
        return lottoNumbers;
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요");
        String input = Console.readLine();
        validateEmptyInput(input);
        validateInt(input);
        return Util.stringToInt(input);
    }

    private static void validateInt(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }

    private static void validateEmptyInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 빈 칸을 입력하셨습니다.");
        }
    }

}
