package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.constant.Exception;

public class View {
    public void output(String message) {
        System.out.println(message);
    }

    public int inputCost() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Exception.COST_FORMAT);
        }
    }
}
