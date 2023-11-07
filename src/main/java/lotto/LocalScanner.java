package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LocalScanner {

    public Integer getPurchasePrice() {
        while (true) {
            try {
                return getPrice();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getPrice() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            String input = Console.readLine();
            System.out.println();
            int price = Integer.parseInt(input);
            validatePrice(price);
            return price;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 가격은 1000원으로 나누어 떨어지는 숫자여야 합니다.");
        }
    }

    private void validatePrice(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 가격은 1000원으로 나누어 떨어지는 숫자여야 합니다.");
        }
    }

    public Integer getBonusNumber() {
        while (true) {
            try {
                return readBonusNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int readBonusNumber() {
        try {
            System.out.println("보너스 번호를 입력해 주세요.");
            String input = Console.readLine();
            System.out.println();
            int number = Integer.parseInt(input);
            validateNumber(number);
            return number;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public List<Integer> getWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                System.out.println();
                return convertInputNumbers(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> convertInputNumbers(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(Integer::parseInt)
                    .peek(this::validateNumber)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 하고 \",\"로 구분되어야 합니다.");
        }
    }

    private void validateNumber(int number) {
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException();
        }
    }
}
