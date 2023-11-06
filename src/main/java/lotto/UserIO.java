package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserIO {
    private final int lottoPrice = 1000;

    public int getAmount() {
        try {
            String input = iOAmount();
            isNumeric(input);
            int amount = Integer.parseInt(input);
            validAmount(amount);
            return amount / lottoPrice;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 구입 금액은 " + lottoPrice + "으로 나누어 떨어져야 하고 0보다 커야합니다.");
            return getAmount();
        }
    }

    public List<Integer> getNumbers() {
        try {
            String input = iONumbers();
            List<String> numbers = List.of(input.split(","));
            checkLength(numbers);
            for (String number : numbers) {
                isNumeric(number);
                isLottoNumber(Integer.parseInt(number));
            }
            return Arrays.stream(input.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자 6개 여야 합니다.");
            return getNumbers();
        }
    }

    public int getBonusNumber() {
        while (true) {
            try {
                String input = iOBonusNumbers();
                isNumeric(input);
                int bonusNumber = Integer.parseInt(input);
                isLottoNumber(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private String iOAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return input;
    }

    private String iOBonusNumbers() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return input;
    }

    private void isNumeric(String input) {
        if (!(input.matches("[0-9]+"))) {
            throw new IllegalArgumentException();
        }
    }

    private void validAmount(int amount) {
        if (amount % 1000 != 0 || amount == 0) {
            throw new IllegalArgumentException();
        }
    }

    private void isLottoNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException();
        }
    }

    private void checkLength(List<String> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private String iONumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return input;
    }

}
