package lotto;

import lotto.controller.GameController;

//public class Application {
//    public static void main(String[] args) {
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

//        // TODO: 당첨 번호 입력 받기
//        while (true) {
//            try {
//                if (userNum.startsWith(",") || userNum.endsWith(",")) {
//                    throw new IllegalArgumentException("당첨 번호는 콤마(,)로 시작하거나 끝날 수 없습니다.");
//                }
//                if (userNumListInt.length != 6) {
//                    throw new IllegalArgumentException("당첨 번호는 6개의 숫자여야 합니다.");
//                }
//                for (int i = 0; i < userNumListInt.length; i++) {
//                    if (userNumListInt[i] < 1 || userNumListInt[i] > 45) {
//                        throw new IllegalArgumentException("당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
//                    }
//                }
//                break;
//            } catch (IllegalArgumentException e) {
//                System.out.println("[ERROR] " + e.getMessage());
//            }
//        }
//}

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.run();
    }
}