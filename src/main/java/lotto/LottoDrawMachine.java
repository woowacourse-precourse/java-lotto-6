package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoDrawMachine {

    private List<Integer> winningNumbers;
    private int bonusNumber;

    LottoDrawMachine() {
//        this.winningNumbers = new ArrayList<>();
    }

    public void drawNumberManual() {
        // winningNumber 입력 받기
        this.winningNumbers = getWinningNumbersFromInput();
        System.out.println(this.winningNumbers);
        // bonusNumber 입력받기
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    private List<Integer> getWinningNumbersFromInput() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                String[] inputWinningNumbers = input.split(",");
                validateNumericInputNumbers(inputWinningNumbers);
                validateDigitCountInputNumbers(inputWinningNumbers);
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

    private void validateDigitCountInputNumbers(String[] inputNumbers) {
        if (inputNumbers.length != 6) { // TODO: 하드코딩
            throw new IllegalArgumentException("[ERROR]");
        }
    }
}
