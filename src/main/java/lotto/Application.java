package lotto;

public class Application {
    public static void main(String[] args) {
        User user = new User();
        WinningInfo winningInfo = new WinningInfo();
        LottoGenerator lottoGenerator = new LottoGenerator();
        Game lottoGame = new Game(user, winningInfo, lottoGenerator);

        lottoGame.run();
    }
}
