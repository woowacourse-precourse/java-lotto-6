package input;

import static constant.ErrorMessage.buildErrorMessage;

import constant.ErrorMessage;
import constant.ServiceMessage;
import java.util.Scanner;

public class Purchase {
    private String money;
    private final int PRICE_PER_TICKET = 1000;
    private boolean isValidInput = false;

    public Purchase() {
        while(!isValidInput) {
            getPurchaseCount();
        }
    }

    private void getPurchaseCount(){
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print(ServiceMessage.getMessageByCode(101));
            this.money = scanner.nextLine();
            isValidInput = isValidate(money);
        } catch (IllegalArgumentException e) {
            System.out.print(e);
        }
    }
    private boolean isValidate(final String money) {
        validNumber(money);
        int amount = Integer.parseInt(money);
        validAmount(amount);

        return true;
    }

    private void validNumber(final String number) {
        if(!number.matches("\\d+")) {
            throw new IllegalArgumentException(buildErrorMessage(901));
        }
    }
    private boolean isValidAmount(final int amount) {
        return (amount >= PRICE_PER_TICKET) && (amount % PRICE_PER_TICKET == 0);
    }
    private void validAmount(final int amount) {
        if(!isValidAmount(amount)) {
            throw new IllegalArgumentException(buildErrorMessage(902));
        }
    }

    public int getMoney(){
        return Integer.parseInt(money);
    }
}
