package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount=InputView.getPurchaseAmount();
        int numberOfLotto=purchaseAmount/1000;
        OutputView.printNumberOfLotto(numberOfLotto);


    }
}
