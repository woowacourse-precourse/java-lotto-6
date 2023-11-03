package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static void validateBuyingPrice(String input) {
        if (!LottoUtil.isInteger(input)) {
            throw new IllegalArgumentException("구매가격은 정수만 가능합니다");
        }
        if (Integer.parseInt(input) < 0) {
            throw new IllegalArgumentException("구매가격은 0보다 큰 값만 가능합니다.");
        }
        if (Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException("구매가격은 1000의 배수만 가능합니다.");
        }
    }
}
