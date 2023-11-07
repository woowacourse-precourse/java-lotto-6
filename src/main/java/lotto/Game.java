package lotto;

public class Game {
    private Amount amount;
    public void setAmount() {
        while(true) {
            try {
                this.amount = new Amount(Input.getPurchaseAmount());
            } catch (IllegalArgumentException e) {
                System.out.println(Output.ERROR_MESSAGE_PREFIX + Output.LOTTO_PURCHASE_AMOUNT_ERROR_MESSAGE);
            }
        }
    }
}
