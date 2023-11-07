package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String ONLY_NUMBER = "[^0-9]";

    public Integer inputPrice() {
        String strPrice = Console.readLine()
                .trim()
                .replaceAll(ONLY_NUMBER, "");
        return Integer.parseInt(strPrice);
    }

    public String inputLotto() {
        return Console.readLine();
    }

    public String inputBonus() {
        return Console.readLine();
    }
}
