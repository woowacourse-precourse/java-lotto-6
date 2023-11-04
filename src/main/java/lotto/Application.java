package lotto;

import lotto.io.game.LottoGame;

public class Application {

    public static void main(String[] args) {
        try {
            LottoGame lottoGame = new LottoGame();
            lottoGame.run();
        } catch (Exception e) {
            System.out.println("예기치 않은 오류로 인해 어플리케이션을 종료합니다.");
            throw e;
        }
    }

}
