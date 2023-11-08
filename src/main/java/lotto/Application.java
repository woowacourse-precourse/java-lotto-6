package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoGame;

public class Application {
    private static final LottoGame lottoGame = new LottoGame();
    public static void main(String[] args) {
        try{
            LottoController lottoController = new LottoController(lottoGame);
            lottoController.run();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }


    }
}
