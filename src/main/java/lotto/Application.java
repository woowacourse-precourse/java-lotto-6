//package lotto;
//
//import lotto.control.LottoController;
//
//public class Application {
//    public static void main(String[] args) {
//        try {
//            LottoController lottoController = new LottoController();
//            lottoController.start();
//        } catch (IllegalArgumentException exception) {
//            System.out.println(exception.getMessage());
//        }
//    }
//}

package lotto;


import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.run();
    }
}