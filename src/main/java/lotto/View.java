package lotto;

import camp.nextstep.edu.missionutils.Console;

public class View {

    public static String askPrice(int unit) {
        System.out.println("구입금액을 입력해 주세요.");
        return getInputPrice(unit);
    }

    private static String getInputPrice(int unit) {
        String input;
        while (true) {
            try {
                input = Console.readLine();
                Validation.isNumber(input);
                Validation.isValidUnit(Integer.parseInt(input), unit);
                break;
            } catch (Exception e) {
                System.out.println("[ERROR]: " + unit + " 단위의 숫자를 입력해주세요.");
            }
        }
        return input;
    }
}