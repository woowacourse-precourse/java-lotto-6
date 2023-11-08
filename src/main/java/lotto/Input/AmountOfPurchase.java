package lotto.Input;

public class AmountOfPurchase {
    static final int PRICE = 1000;

    private static int amount;

    public static int takeInput() {
        do {
            System.out.println("구입금액을 입력해 주세요.");
            String input = camp.nextstep.edu.missionutils.Console.readLine();
            if (calculateAmount(input)) {
                break;
            }
        } while (true);
        System.out.println();
        return amount;
    }

    private static boolean calculateAmount(String input) {
        try {
            PriceCheck.validatePrice(input);
            amount = Integer.parseInt(input) / PRICE;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 구입 금액은 1000으로 나누어 떨어지는 수여야 합니다.");
            return false;
        }
        return true;
    }
}
