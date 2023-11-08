package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Exception.Exception;

import java.util.ArrayList;
import java.util.List;

import static lotto.Lotto.validate;

public class Input {

    static int bonus;
    public static int money;
    final static int LOTTO_WINNING_NUMBER_COUNT = 6;

    public static int money() {
        while (true) {
            try {
                money = Integer.parseInt(Console.readLine());
                if (!Exception.isValidMoney(money)) {
                    System.out.println("[ERROR] 구입금액은 1000단위 정수만 입력할 수 있습니다.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 구입금액은 1000단위 정수만 입력할 수 있습니다.");
            }
        }
        return money;
    }

    public static List<Integer> winningNumbers() {
        List<Integer> winningNumbersList = new ArrayList<>();
        String winningNumbers;
        while (true) {
            try {
                Output.winningNumberGuide();
                winningNumbers = Console.readLine();

                String[] splitNumbers = winningNumbers.split(",");

                if (!Exception.isValidWinningNumberSingle(splitNumbers)) {
                    throw new IllegalArgumentException("[ERROR] 당첨 숫자는 1~45 사이 정수여야 합니다.");
                }

                for (int i = 0; i < Input.LOTTO_WINNING_NUMBER_COUNT; i++) {
                    winningNumbersList.add(Integer.parseInt(splitNumbers[i]));
                }
                if (!Exception.isNoneEqualNumbers(winningNumbersList)) {
                    throw new IllegalArgumentException("[ERROR] 당첨 숫자는 중복될 수 없습니다.");
                }
                if (!Exception.isValidWinningNumbers(winningNumbersList)) {
                    throw new IllegalArgumentException("[ERROR] 당첨 숫자는 정수 6개로 이루어져야 합니다.");
                }
                validate(winningNumbersList);
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 당첨 숫자는 정수로 이루어져야 합니다. 다시 입력하세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("[ERROR] 입력형식에 맞지 않습니다. 다시 입력하세요.");
            }
        }

        return winningNumbersList;
    }

    public static int bonusNumber() {
        while (true) {
            try {
                Output.bonusNumberGuide();
                bonus = Integer.parseInt(Console.readLine());
                if (bonus < 1 || bonus > 45) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 보너스 번호는 1~45 사이 정수 하나만 입력할 수 있습니다. 다시 입력하세요.");
            }
        }
        return bonus;
    }
}
