package ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Stream;
import ui.validator.BonusNumberValidator;
import ui.validator.CommonNumberValidator;
import ui.validator.MoneyValidator;

class InputView {
    private InputView() {
    }

    /**
     * @return 1000 단위로 끊어진 로또 구매 금액.
     */
    public static int getMoney() {
        while (true) {
            try {
                String input = Console.readLine();
                int money = Integer.parseInt(input);
                MoneyValidator.verify(money);
                return money;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> getCommonNumbers() {
        while (true) {
            try {
                String input = Console.readLine();
                String[] inputNumbers = input.split(",");

                List<Integer> integers = Stream.of(inputNumbers).map(Integer::parseInt).toList();

                CommonNumberValidator.verify(integers);

                return integers;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getBonusNumber(List<Integer> commonNumbers) {
        while (true) {
            try {
                String input = Console.readLine();
                int number = Integer.parseInt(input);
                BonusNumberValidator.verify(commonNumbers, number);
                return number;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
