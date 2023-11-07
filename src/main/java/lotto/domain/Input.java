package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private static List<Integer> numbers;
    private static int bonusNumber;
    private static int money;

    public static List<Integer> getNumbers() {
        return numbers;
    }

    public static void inputLottoMessage() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        while (true) {
            numbers = inputLottoNumber();
            try {
                Lotto lotto = new Lotto(numbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> inputLottoNumber() {
        String input = Console.readLine();
        String[] input_list = input.split(",");
        List<Integer> number_list = new ArrayList<>();

        try {
            for (String s : input_list) {
                int number = Integer.parseInt(s.trim());
                number_list.add(number);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 당첨 번호는 숫자로 입력해 주세요.");
        }
        return number_list;
    }

    public static int getBonusNumber(){
        return bonusNumber;
    }

    public static void inputBonusNumberMessage() {
        while (true){
            System.out.println("\n보너스 번호를 입력해 주세요.");
            try {
                int bonusnumber = inputBonusNumber();
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int inputBonusNumber() {
        bonusNumber = 0;
        String input = Console.readLine().trim();
        try {
            bonusNumber = Integer.parseInt(input);
            BonusNumber bonus = new BonusNumber(bonusNumber, numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 한 개의 숫자로 입력해 주세요");
        } catch (IllegalArgumentException e) {
            throw e;
        }
        return bonusNumber;
    }

    public static int getMoney() {
        return money;
    }

    public static void inputMoneyMessage() {
        System.out.println("구입금액을 입력해 주세요.");
        inputMoney();
    }

    private static void inputMoney() {
        money = 0;
        boolean validInput = false;

        while (!validInput) {
            String input = Console.readLine().trim();
            try {
                money = Integer.parseInt(input);
                checkMoneyDivided(money);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 구입 금액은 숫자로 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void checkMoneyDivided(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
        }
    }
}
