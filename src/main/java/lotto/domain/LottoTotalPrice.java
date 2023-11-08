package lotto.domain;


public class LottoTotalPrice {
    private static final String NOT_NUMBER_MESSAGE = "[ERROR]:금액에 숫자를 입력해주세요.";
    private static final String RANGE_ERROR_MESSAGE = "[ERROR]:금액이 0 이상이어야 합니다.";
    private static final String NOT_THOUSAND_UNITS = "[ERROR]:금액은 1000원 단위여야 합니다.";
    private final int price;
    private final int numberOfPurchasedLotto;
    private final int UNIT = 1000;

    public LottoTotalPrice(String price) {
        validate(price);
        this.price = convertStringToInt(price);
        this.numberOfPurchasedLotto = calculateNumberOfPurchasedLotto(this.price);
    }

    public int getNumberOfPurchasedLotto() {
        return numberOfPurchasedLotto;
    }

    public int getPrice() {
        return price;
    }

    private Boolean isExceedZero(String inputPrice) {
        return convertStringToInt(inputPrice) > 0;
    }

    private int calculateNumberOfPurchasedLotto(int price) {
        validateUnit(price);
        int number = price / UNIT;
        return number;
    }

    private int convertStringToInt(String inputPrice) {
        int price = Integer.parseInt(inputPrice);
        return price;
    }

    private void validate(String inputPrice) {
        validateInteger(inputPrice);
        validateRange(inputPrice);
    }

    private void validateRange(String price) {
        if (!isExceedZero(price)) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }

    private void validateUnit(int inputPrice) {
        if (inputPrice % UNIT != 0) {
            throw new IllegalArgumentException(NOT_THOUSAND_UNITS);
        }
    }

    private void validateInteger(String inputPrice) {
        if (isStringEmpty(inputPrice) || !isStringDigit(inputPrice)) {
            throw new IllegalArgumentException(NOT_NUMBER_MESSAGE);
        }
    }

    private boolean isStringEmpty(String price) {
        return price == null || price.isBlank();
    }

    private boolean isStringDigit(String price) {
        return price.chars().allMatch(Character::isDigit);
    }
}
