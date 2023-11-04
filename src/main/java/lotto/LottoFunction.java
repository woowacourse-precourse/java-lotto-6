package lotto;

public class LottoFunction {

    Validator validator = new Validator();

    int divideThousand(String input) {
        int quotient;
        validator.isInteger(input);
        quotient = Integer.parseInt(input) / 1000;
        validator.isMultipleOfThousand(quotient);
        return quotient;
    }

}
