package lotto;

import lotto.exception.checkUserInputDivideByThousand;
import lotto.exception.CheckUserInputUnderThousand;

public class Ticket {
    private final int money;

    public Ticket(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int userInput) {
        checkUnderThousand(userInput);
        checkDivideByThousand(userInput);
    }

    private void checkUnderThousand(int userInput) {
        if (userInput == 0) {
            throw new CheckUserInputUnderThousand();
        }
    }

    private void checkDivideByThousand(int userInput){
        if (userInput % 1000 != 0) {
            throw new checkUserInputDivideByThousand();
        }
    }

    public int countTicket() {
        return money / 1000;
    }
}
