package lotto;

public class Application {
    public static void main(String[] args) {
        LottoUserInput lottoInput = new LottoUserInput();
        Lotto lotto = new Lotto(lottoInput.printPurchaseLottoNumbers());
    }
}
