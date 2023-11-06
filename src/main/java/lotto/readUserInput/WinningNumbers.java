package lotto.readUserInput;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class WinningNumbers implements UserInput {
    public static List<Integer> numbers = new ArrayList<>();

    public void read() {
        String[] numbers = separateUserInput(userInput());
        addWinningNumbers(numbers);
    }

    public String userInput() {
        String readWinningNumbers = Console.readLine();
        try {
            isInputContainComma(readWinningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 로또 번호는 공백 없이 6개의 숫자 사이에 콤마를 넣어야 합니다.");
            readWinningNumbers = userInput();
        }
        return readWinningNumbers;
    }

    public String[] separateUserInput(String inputNumbers) {
        return inputNumbers.split(",");
    }

    public int singleTypeConversion(String readSingleNumber) {
        return Integer.parseInt(readSingleNumber);
    }

    public void addWinningNumbers(String[] readNumbers) {
        String[] readInputNumber = readNumbers;
        while(numbers.size() < 6) { // 상수로 표현 가능.
            int singleNumber = singleTypeConversion(readInputNumber[numbers.size()]);
            try {
                isNumberInRange(singleNumber);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                numbers.clear();
                readInputNumber = separateUserInput(userInput());
            }
            numbers.add(singleNumber);
        }
    }

    public void isInputContainComma(String userInput) {
        if (!Pattern.matches("^\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2}$", userInput)) {
            throw new IllegalArgumentException();
        }
    }

    public void isNumberInRange(int singleNumber) {
        if (!((singleNumber >= 1) && (singleNumber <= 45))) {
            throw new IllegalArgumentException();
        }
    }
}
