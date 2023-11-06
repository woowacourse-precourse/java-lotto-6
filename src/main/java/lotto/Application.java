package lotto;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PurchaseAmount purchaseAmount = new PurchaseAmount();
        int lottoNumber = purchaseAmount.input();

        LottoFactory factory = new LottoFactory(lottoNumber);
        factory.createLottos();

        WinningNumbersSetter setter = new WinningNumbersSetter();
        WinningNumbers winningNumbers = new WinningNumbers(setter.setWinning());
    }
}
