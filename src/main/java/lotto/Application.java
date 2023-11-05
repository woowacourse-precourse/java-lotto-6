package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int purchaseAmount;
        int purchaseCount = 0;

        System.out.println("구입금액을 입력해 주세요.");

        UserInput userInput = new UserInput();

        while(UserInput.repeatPurchase) {
            purchaseAmount = userInput.getPurchaseAmount();
            purchaseCount = userInput.validatePurchaseAmount(purchaseAmount);
        }

        System.out.println();
        System.out.printf("%d개를 구매했습니다.%n", purchaseCount); //


    }
}
