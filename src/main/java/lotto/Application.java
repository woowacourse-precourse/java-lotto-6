package lotto;

import lotto.controller.GameController;

//        // TODO: 로또 구입 금액 입력 받기
//        while (true) {
//            try {
//                int lottoBought1000 = lottoBought % 1000;
//                if (lottoBought1000 != 0) {
//                    throw new IllegalArgumentException("1,000원 단위로 입력해 주세요.");
//                }
//                break;
//            } catch (IllegalArgumentException e) {
//                System.out.println("[ERROR] " + e.getMessage());
//            }
//        }
public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.run();
    }
}