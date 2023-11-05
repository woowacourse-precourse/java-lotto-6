package lotto;

import lotto.utils.InputUtils;

public class Application {
    public static void main(String[] args) {
        int amount = InputUtils.getAmount();
        System.out.println("### amount = " + amount);
    }
}
