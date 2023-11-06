package lotto;

import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        boolean continuePlaying = true;
//        while (continuePlaying) {
//            try {
//                lottoController.play();
//                continuePlaying = false;
//            }
//            catch (IllegalArgumentException e) {
//                System.out.println(e);
//            }
//        }
        lottoController.play();
    }
}
