package lotto;

public class PlayerLottoAmount {
    //최소 금액
    private static final int MIN_AMOUNT = 1000;
    private static int amount;

    public PlayerLottoAmount(String amount) {
        int amountNumbers = amountNumber(amount);
        amountMessage(amountNumbers);
        this.amount = amountNumbers;
    }

    public static int divideAmount() {
        return amount / MIN_AMOUNT;
    }

    public static int amountNumber(String amount) throws IllegalArgumentException {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            ErrorMessage.setNumberOver();
            throw new IllegalArgumentException();
        }
    }

    public void amountMessage(int amount) {
        // type 에러
        amountType(amount);
        // 단위 에러
        amountNumberAbout(amount);
    }

    public void amountType(int amount) {

    }

    public void amountNumberAbout(int amount) {

    }


}
