package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public int getPurchase() {
        while (true) {
            String input = readInput("구입금액을 입력해주세요");
            int purchase = parseInt(input);

            if (purchase % 1000 != 0) {
                System.out.println("[ERROR] 1000단위로 입력해주세요");
                return getPurchase();
            }
            return purchase;
        }
    }

    public List<Integer> getWinNumbers() {
        while (true) {
            String input = readInput("당첨 번호를 입력해 주세요");
            List<Integer> winNumbers = parseNumbers(input);

            if (isValidWinNumbers(winNumbers)) {
                return winNumbers;
            }
        }
    }

    public int getBonusNumbers() {
        while (true) {
            String input = readInput("보너스 번호를 입력해 주세요");
            int bonusNumber = parseInt(input);

            if (isValidBonusNumber(bonusNumber)) {
                return bonusNumber;
            }
        }
    }

    private String readInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자로 입력해주세요");
            return parseInt(readInput("다시 입력해주세요"));
        }
    }

    private List<Integer> parseNumbers(String input) {
        String[] tokens = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            int number = parseInt(token);
            if (number >= 1 && number <= 45) {
                numbers.add(number);
            } else {
                System.out.println("[ERROR] 1부터 45 사이의 유효한 숫자를 입력하세요.");
                return parseNumbers(readInput("다시 입력해주세요"));
            }
        }
        if (numbers.size() == 6) {
            return numbers;
        } else {
            System.out.println("[ERROR] 6개의 숫자를 입력하세요.");
            return parseNumbers(readInput("다시 입력해주세요"));
        }
    }

    private boolean isValidWinNumbers(List<Integer> winNumbers) {
        return winNumbers.size() == 6 && winNumbers.stream().allMatch(n -> n >= 1 && n <= 45) && winNumbers.size() == winNumbers.stream().distinct().count();
    }

    private boolean isValidBonusNumber(int bonusNumber) {
        return bonusNumber >= 1 && bonusNumber <= 45;
    }
}
