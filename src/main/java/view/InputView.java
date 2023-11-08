package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {}

    public static int inputMoney() {
        System.out.println("구입할 금액을 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자로 입력해주세요.");
        } finally {
            System.out.println();
        }
    }
}
