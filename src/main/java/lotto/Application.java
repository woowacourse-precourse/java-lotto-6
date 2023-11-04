package lotto;

import lotto.game.LottoGame;

public class Application {
    public static void main(String[] args) {
        try{
            LottoGame.play();
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }
}
