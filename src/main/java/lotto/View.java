package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;

public class View {

    public static void showResult(Map<String, Integer> result, float rate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + result.getOrDefault("3", 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + result.getOrDefault("4", 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.getOrDefault("5", 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.getOrDefault("5+", 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.getOrDefault("6", 0) + "개");
        System.out.printf("총 수익률은 %.1f%% 입니다.", rate);
    }

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