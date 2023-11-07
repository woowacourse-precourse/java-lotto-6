package lotto.advice;

import lotto.exception.LottoGameException;

public class GameAdvice {
    private final Runnable game;

    public GameAdvice(Runnable game) {
        this.game = game;
    }

    public void run(){
        while(true){
            try{
                game.run();
                break;
            }catch(LottoGameException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
