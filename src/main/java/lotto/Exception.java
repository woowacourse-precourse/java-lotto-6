package lotto;

public class Exception {
    public static void printException(String message) {
        System.out.println("[ERROR] " + message);
        System.out.println();
    }

    public static void priceValidate(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("로또 1장의 가격은 1,000원입니다.");
        }
    }
}
