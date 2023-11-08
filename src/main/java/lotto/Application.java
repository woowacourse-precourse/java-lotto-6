package lotto;

import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        try {
            LottoController controller = new LottoController();
            controller.start();
            controller.result();
        } catch (IllegalArgumentException e) {
            System.err.println("입력값이 잘못되었습니다: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.err.println("프로그램 상태가 올바르지 않습니다: " + e.getMessage());
        } finally {
            Runtime.getRuntime().exit(0);
        }
    }
}