package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {

    public static List<Integer> inputLottoMessage() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return inputLottoNumber();
    }

    private static List<Integer> inputLottoNumber() {
        String input = Console.readLine();
        String[] input_list = input.split(",");
        List<Integer> numbers = new ArrayList<>();

        try {
            for (int i = 0; i < 6; i++) {
                int number = Integer.parseInt(input_list[i].trim());
                numbers.add(number);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 당첨 번호는 숫자로 입력해주세요.");
        }
        return numbers;
    }

    public static int inputBonusNumberMessage() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return inputBonusNumber();
    }

    private static int inputBonusNumber() {
        int bonusNumber = 0;
        String input = Console.readLine().trim();
        try {
            bonusNumber = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 보너스 번호는 숫자로 입력해주세요");
        }
        return bonusNumber;
    }

    public static int inputMoneyMessage() {
        System.out.println("구입금액을 입력해 주세요.");
        return inputMoney();
    }

    private static int inputMoney() {
        int money = 0;
        String input = Console.readLine().trim();
        try {
            money = Integer.parseInt(input);
            checkMoneyDivided(money);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 구입 금액은 숫자로 입력해야합니다.");
        }
        return money;
    }

    private static void checkMoneyDivided(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야합니다.");
        }
    }
}
