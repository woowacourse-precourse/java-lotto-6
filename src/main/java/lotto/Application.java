package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int price = getPurchasePrice();
    }

    public static int getPurchasePrice() {
        String input = Console.readLine();
        int price = Integer.parseInt(input);
        isValidPrice(price);
        return price;
    }

    public static void isValidPrice(int price){
        if (isPriceDividedByThousand(price)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 나누어 떨어져야 합니다.");
        }
    }

    public static boolean isPriceDividedByThousand(int price) {
        return price % 1000 != 0;
    }
}
