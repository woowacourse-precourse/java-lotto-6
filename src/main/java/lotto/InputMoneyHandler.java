package lotto;

public class InputMoneyHandler {
    static final int pricePerPiece = 1000;
    private final String moneyInput;
    private int verifiedMoney;

    InputMoneyHandler(String moneyInput) {
        this.moneyInput = moneyInput;
    }

    public void convertStringToInt(String moneyInput) {
        try {
            verifiedMoney = Integer.parseInt(moneyInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isDivisible() {
        return verifiedMoney % pricePerPiece == 0;
    }

    public boolean isValidInput() {
        return verifiedMoney > 0;
    }

    public void inputMoneyException() {
        convertStringToInt(moneyInput);
        if (!isDivisible() || !isValidInput()) throw new IllegalArgumentException();
    }

    public int exceptionHandledMoney(){
        inputMoneyException();
        return verifiedMoney;
    }

}
