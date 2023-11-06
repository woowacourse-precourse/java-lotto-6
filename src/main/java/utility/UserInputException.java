package utility;

public class UserInputException {

    public void lottoPriceInputValidate(int lottoPrice) {

        if (lottoPrice % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
