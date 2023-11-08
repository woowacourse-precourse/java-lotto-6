package lotto;

public class Application {
    public static void main(String[] args) {
        LottoTimes lottoTimes = new LottoTimes();
        Purchace purchace = new Purchace(lottoTimes.times);
        WinLotto winLotto = new WinLotto();

        purchace.analysisStatistic(winLotto, lottoTimes.money);
    }
}
