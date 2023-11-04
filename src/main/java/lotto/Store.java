package lotto;

public class Store {
    private void validateDividedByPrice(Integer money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000으로 가격이 나누어 떨어져야 합니다.");
        }
    }
}
