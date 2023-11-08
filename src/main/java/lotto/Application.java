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

    private static int askPurchaseNumber() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            double purchaseAmount = Double.parseDouble(camp.nextstep.edu.missionutils.Console.readLine());
            return (int) isDivisibleByOneThousand(purchaseAmount); // 구매 금액이 1,000으로 나누어지는지 확인 후 정수로 바꾸어 리턴
        } catch (NullPointerException e) {
            System.out.println("[ERROR] 구매금액을 입력하셔야 합니다.");
            throw e;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 구매금액은 숫자형식이어야 합니다.");
            throw e;
        }
    }
}
