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
        } catch (Exception e) {
            System.err.println("알 수 없는 오류가 발생했습니다: " + e.getMessage());
            e.printStackTrace();
        } finally {
            Runtime.getRuntime().exit(0);
        }
    }
}ㅎ