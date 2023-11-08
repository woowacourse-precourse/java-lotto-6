package lotto.inputAction;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;

public class InputWinningNumbers {
    public List<Integer> inputWinningNumbers() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            try {
                return parseWinningNumbers(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> parseWinningNumbers(String input) {
        String[] winningNumberStrings = input.split(",");
        if (winningNumberStrings.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        List<Integer> winningNumbers = Arrays.stream(winningNumberStrings)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        new Lotto(winningNumbers); // 유효성 검사를 위해 Lotto 객체 생성
        return winningNumbers;
    }
}
