package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int input = buyLotto();
    }

    private static int buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String str = Console.readLine();

        if (!isDigit(str)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(str);
    }

    private static boolean isDigit(String str) {
        boolean isNumeric = true;

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                isNumeric = false;
                break;
            }
        }

        return isNumeric;
    }
}
