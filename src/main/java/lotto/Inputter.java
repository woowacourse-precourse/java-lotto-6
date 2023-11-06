package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Inputter {
    private static Inputter inputter;

    private Inputter() {}

    public static Inputter getInputter() {
        if (inputter == null) {
            inputter = new Inputter();
        }
        return inputter;
    }

    public int purchase() {
        int won;

        System.out.println("구입금액을 입력해 주세요.");
        try {
            won = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바른 금액을 입력해주세요.");
        }
        return won;
    }
}
