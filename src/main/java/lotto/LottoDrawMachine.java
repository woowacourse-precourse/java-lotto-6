package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoDrawMachine {

    private List<Integer> winningNumbers;

    LottoDrawMachine() {
//        this.winningNumbers = new ArrayList<>();
    }

    public void drawNumberManual() {
        // winningNumber 입력 받기
        this.winningNumbers = getWinningNumbersFromInput();
        // bonusNumber 입력받기
    }
    private List<Integer> getWinningNumbersFromInput() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                String[] inputWinningNumbers = input.split(",");
                validateNumericInputNumbers(inputWinningNumbers);
                return Arrays.stream(inputWinningNumbers)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]");
            }
        }
    }

    private void validateNumericInputNumbers(String[] inputNumbers) {
        try {
            for (String string : inputNumbers) {
                Integer.parseInt(string);
            }
        } catch (Exception exception) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }
}
