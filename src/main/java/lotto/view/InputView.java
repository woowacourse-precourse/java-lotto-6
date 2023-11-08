package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.UserLotto;

public class InputView {
    public static Integer moneyInput() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return validmoney(input);
    }

    public static UserLotto lottosInput(int money) {
        System.out.printf("\n%d개를 구매했습니다.%n", money);
        return new UserLotto(money);
    }

    public static Lotto winNumInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return tryParseWinNumInput();
    }

    private static Lotto tryParseWinNumInput() {
        String input = Console.readLine();
        try {
            List<Integer> winNumbers = parseWinNumbers(input);
            return new Lotto(winNumbers);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자만 입력 가능합니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return winNumInput(); // 재귀 호출
    }

    private static List<Integer> parseWinNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }


    private static Integer validmoney(String stmoney) {
        try {

            int money = Integer.parseInt(stmoney);

            if (money < 1000) {
                throw new IllegalArgumentException("[ERROR] 금액은 1000원 이상이어야 합니다.");
            }

            if (money % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위여야 합니다.");
            }
            return money;

        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 금액은 숫자여야 합니다.");
        }
        return moneyInput();

    }

    public static int bunusInput(Lotto winLotto) {
        try {
            System.out.println();
            System.out.print("보너스 번호를 입력해 주세요: ");
            int bonusNumber = Integer.parseInt(Console.readLine());
            if (!winLotto.isContain(bonusNumber)) {
                return bonusNumber;
            } else {
                System.out.println("[ERROR] 당첨 번호와 중복되는 숫자입니다. 다른 숫자를 입력해 주세요.");
                return bunusInput(winLotto); // 중복된 경우 재귀 호출
            }
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해야 합니다.");
            return bunusInput(winLotto); // 입력 형식 오류 시 재귀 호출
        }
    }
}
