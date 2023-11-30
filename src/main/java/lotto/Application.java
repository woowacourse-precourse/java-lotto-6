package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoGame lottoGame;
        lottoGame = LottoGame.createLottoGame();

        lottoGame.startGame();
    }
}
