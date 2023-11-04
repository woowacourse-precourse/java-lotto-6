package lotto.Model;

import static lotto.Utils.toInt;

public class Price {
    int purchasePrice;

    public Price(String input) {
        validate(input);
        this.purchasePrice = toInt(input);
    }

    public int divideWithOneThousands(Price price) {
        return price.purchasePrice / 1000;
    }

    private void validate(String input) {
        int validInput = isNumber(input);
        isDivideWithOneThousands(validInput);
        isCorrectRange(validInput);
    }

    private int isNumber(String input) {
        try {
            int priceInput = toInt(input);
            if (priceInput > 2000000000) {
                throw new IllegalArgumentException("[ERROR] 로또구입금액은 최대 20억입니다.");
            }
            return priceInput;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만을 입력하세요.(최대 구입금액은 20억입니다)");
        }
    }

    private void isDivideWithOneThousands(int validInput) throws IllegalArgumentException {
        if (validInput % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력하세요.");
        }
    }

    private void isCorrectRange(int validInput) {
        if (validInput <= 0) {
            throw new IllegalArgumentException("[ERROR] 로또구입금액은 최소 1000원입니다.");
        }
    }
}
