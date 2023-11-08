package lotto;

public class Game {
    int purchaseAmount;
    
    void play() {
        calculateNumberOfPurchase();
        showPurchasedLottos();
    }
    
    void calculateNumberOfPurchase() {
        OutputView.outputPurchaseAmount();
        String inputPurchaseAmount = InputView.inputPurchaseAmount();
        int number = checkInteger(inputPurchaseAmount);
        checkNaturalNumber(number);
        purchaseAmount = checkMultiple(number);
        System.out.println();
    }
    
    int checkInteger(String string) {
        try {
            int number = Integer.parseInt(string);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[Error] 정수가 아닌 입력입니다.");
        }
    }
    
    void checkNaturalNumber(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("[Error] 자연수가 아닌 입력입니다.");
        }
    }
    
    int checkMultiple(int number) {
        if(number % 1000 != 0) {
            throw new IllegalArgumentException("[Error] 1000의 배수가 아닌 입력입니다.");
        }
        return number / 1000;
    }
    
    void showPurchasedLottos() {
        System.out.println(purchaseAmount + "개를 구매했습니다.");
        Lottos lottos = new Lottos(purchaseAmount);
        lottos.printLottos();
        System.out.println();
    }
}
