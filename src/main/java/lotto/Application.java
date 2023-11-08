package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoApp lottoApp = new LottoApp(new LottoPlayer(), new LottoAdmin());
        lottoApp.playGame();
    }
}
