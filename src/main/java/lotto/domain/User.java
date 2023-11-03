package lotto.domain;

import lotto.ui.Computer;

public class User {
    private Integer money;

    private boolean isPurchasing = true;

    public void purchaseLotto() {
        while (isPurchasing) {
            try {

                Computer computer = new Computer();
                String userInput = computer.getInput();

                computer.checkNumber(userInput);
                computer.checkZero(userInput);

                money = Integer.parseInt(userInput);
                computer.checkRemainder(money);

                isPurchasing = false;

            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
