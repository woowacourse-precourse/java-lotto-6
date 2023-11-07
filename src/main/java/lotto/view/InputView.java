package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public int getPurchase() {
        System.out.println("구입금액을 입력해주세요");
        String input = Console.readLine();

        try {
            int purchase = Integer.parseInt(input);

            if (purchase % 1000 != 0) {
                throw new IllegalArgumentException("구입 금액은 1,000원 단위로 입력해주세요");
            }

            return purchase;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR]");
            return getPurchase();
        }
    }


    public List<Integer> getWinNumbers() {
        System.out.println("당첨 번호를 입력해 주세요");
        String input = Console.readLine();
        List<Integer> winNumbers = parseNumbers(input);

        if (winNumbers.size() != 6 || !areValidNumbers(winNumbers)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개의 1부터 45 사이의 유효한 숫자여야 합니다.");
        }

        return winNumbers;
    }

    public int getBonusNumbers() {
        System.out.println("보너스 번호를 입력해 주세요");

        try {
            String input = Console.readLine();
            int bonusNumber = Integer.parseInt(input);

            if (bonusNumber < 1 || bonusNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            }

            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자로 입력해주세요");
        }
    }


    private List<Integer> parseNumbers(String winNumbers) {
        String [] tokens=winNumbers.split(",");
        List<Integer> numbers=new ArrayList<>();
        for (String token : tokens) {
            try {
                numbers.add(Integer.parseInt(token));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 올바른 숫자를 입력하세요.");
            }
        }
        return numbers;
    }

    private boolean areValidNumbers(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                return false;
            }
        }
        return true;
    }
}