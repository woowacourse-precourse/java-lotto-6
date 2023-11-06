package lotto;

public class Application {
    public static void main(String[] args) {
        LottoWinningProcess lottoWinningProcess = new LottoWinningProcess();
        LottoResult lottoResult = lottoWinningProcess.run();
    }
}