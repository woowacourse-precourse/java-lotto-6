package lotto.validation;

public class LottoValidation {

    public void validatePurchasePrice(String input) {
        validateIsDigit(input);
        int price = Integer.parseInt(input);
        if((price % 1000) != 0) {
            throw new IllegalArgumentException("[ERROR] 천원 단위로 입력해 주세요.");
        }
    }

    private void validateIsDigit(String price) {
        for(int i = 0; i< price.length(); i++) {
            findDigit(price, i);
        }
    }

    private void findDigit(String price, int i) {
        if(!Character.isDigit(price.charAt(i))) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        }
    }
}
