package user;

import service.Inputter;

public class Money {

    private int money;


    public void requestMoney(Inputter inputter) {
        boolean isValidInput = false;
        while (!isValidInput) {
            try {
                String input = inputter.inputPurchaseAmount();
                this.money = transformStringtoInt(input);
                isValidInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getMoney() {
        return money;
    }

    private int transformStringtoInt(String money) {
        try {
            int purchaseAmount = Integer.parseInt(money);
            validate(purchaseAmount);
            return purchaseAmount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[Error] 금액은 숫자로 입력해야합니다.");
        }
    }

    private void validate(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[Error] 금액은 1000원 단위로 입력해야합니다.");
        }
    }
}
