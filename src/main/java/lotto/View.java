package lotto;

import camp.nextstep.edu.missionutils.Console;

public class View {

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
                System.out.println("[ERROR]: 당첨 번호와 중복되지 않는 1 ~ 45 범위의 번호를 입력해주세요.");
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
                System.out.println("[ERROR]: 6자리 당첨 번호를 입력해주세요.");
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
                System.out.println("[ERROR]: " + unit + " 단위의 숫자를 입력해주세요.");
            }
        }
        return input;
    }
}