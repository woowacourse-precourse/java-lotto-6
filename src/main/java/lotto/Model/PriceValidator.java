package lotto.Model;

public class PriceValidator {
    int inputPrice;

    public PriceValidator(String inputPrice) {
        this.inputPrice = toInt(inputPrice);
        validate(this.inputPrice);
    }

    public int getInputPrice() {
        return inputPrice;
    }

    private void validate(int inputPrice) throws IllegalArgumentException {
        isNotDivideWithOneThousands(inputPrice);
        isNotCorrectMoneyRange(inputPrice);
    }

    private void isNotDivideWithOneThousands(int inputPrice) throws IllegalArgumentException{
        if (inputPrice % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    private void isNotCorrectMoneyRange(int inputPrice) throws IllegalArgumentException{
        if (inputPrice <= 0 || inputPrice > 2000000000) {
            throw new IllegalArgumentException();
        }
    }

    private int toInt(String lottoPrice) throws IllegalArgumentException {
        return Integer.parseInt(lottoPrice);
    }
}
