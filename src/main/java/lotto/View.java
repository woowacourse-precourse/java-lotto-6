package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Iterator;
import java.util.List;

public class View {

    public static void showBundle(List<Lotto> bundle) {
        System.out.println(bundle.size() + "개를 구매했습니다.");
        for (Lotto lotto : bundle) {
            System.out.println(lotto.toString());
        }
    }

    public static String askBonusNumber(Lotto lotto) {
        System.out.println("보너스 번호를 입력해 주세요.");
        return getInputBonusNumber(lotto);
    }

    private static String getInputBonusNumber(Lotto lotto) {
        String input;
        while (true) {
            try {
                input = Console.readLine();
                Validation.bonusNumber(input, lotto);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return input;
    }

    public static String askWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return getInputWinningNumber();
    }

    private static String getInputWinningNumber() {
        String input;
        while (true) {
            try {
                input = Console.readLine();
                Validation.winningNumber(input);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return input;
    }

    public static String askPrice(int unit) {
        System.out.println("구입금액을 입력해 주세요.");
        return getInputPrice(unit);
    }

    private static String getInputPrice(int unit) {
        String input;
        while (true) {
            try {
                input = Console.readLine();
                Validation.price(input);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return input;
    }
}