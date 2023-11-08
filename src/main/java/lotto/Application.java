package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game lottoGame = new Game();

        lottoGame.publish();
        lottoGame.printLotto();

        lottoGame.setPrizeWinNum();

        lottoGame.initStat();
        lottoGame.stareStat();

        lottoGame.calc();

        lottoGame.printPrizeWinStat();
    }
}
