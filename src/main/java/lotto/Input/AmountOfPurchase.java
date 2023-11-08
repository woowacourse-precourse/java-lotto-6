package lotto.Input;

public class AmountOfPurchase {
    private static int amount;

    public static int takeInput() {
        boolean validated;
        do {
            String input = camp.nextstep.edu.missionutils.Console.readLine();
            validated = calculateAmount(input);
        } while (!validated);
        return amount;
    }

    private static boolean calculateAmount(String input) {
        try {
            PriceCheck.validatePrice(input);
            amount = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 구입 금액은 1000으로 나누어 떨어지는 수여야 합니다.");
            return false;
        }
        return true;
    }
}
