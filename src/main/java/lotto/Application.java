package lotto;

import lotto.domain.LottoGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("작동시작한다?!");
        LottoGame lottoGame = new LottoGame();
        lottoGame.start();
    }
}
