package lotto;


public class Application {
    public static final double ONE_LOTTO_PRICE = 1000;

    public static void main(String[] args) {


    }

    // 입력 값이 1,000 단위로 나누어 떨어지는지 체크하는 메서드
    public static double isDivisibleByOneThousand(double number) {
        if (number < ONE_LOTTO_PRICE)
            throw new IllegalArgumentException("[ERROR] 구매금액은 1,000원 이상으로 입력하셔야 합니다."); // 예외처리: 1,000원보다 작은 경우
        if (number % ONE_LOTTO_PRICE != 0)
            throw new IllegalArgumentException("[ERROR] 구매금액은 1,000원 단위로 입력하셔야 합니다."); // 예외처리: 1,000으로 나누어떨어지지 않는 경우
        return number / ONE_LOTTO_PRICE;
    }
}
