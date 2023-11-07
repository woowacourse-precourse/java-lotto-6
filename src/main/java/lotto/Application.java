package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lo = new LottoController();
        lo.insertCoin();
        lo.buyLotto();
        lo.setWinner();
        lo.setBonus();
        lo.resultLotto();
    }
}
