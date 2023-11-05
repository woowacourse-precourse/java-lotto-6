package lotto.controller;



public class LottoController {
    public LottoController() {
    }

    public void run() {
        try {
            start();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

}


