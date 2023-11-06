package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public String inputPrice() {
        return Console.readLine();
    }

    public List<Integer> inputWinningNumbers() {
        try {
            return Arrays.stream(Console.readLine().split(","))
                    .map(number -> parseInputNumber(number.trim()))
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] (,)를 기준으로 입력해주세요.");
        }
    }

    public int inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return parseInputNumber(Console.readLine());
    }

    private int parseInputNumber(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 입력 번호는 숫자로 이루어져야 합니다.");
        }
    }

}
