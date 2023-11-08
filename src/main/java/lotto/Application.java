package lotto;

import lotto.controller.LottoController;

import static lotto.constant.ErrorMessages.INCORRECT_VALUE_INPUT;

public class Application {
    public static void main(String[] args) {
        try {
            LottoController controller = new LottoController();
            controller.start();
            controller.result();
        } catch (IllegalArgumentException e) {
            System.err.println(INCORRECT_VALUE_INPUT + e.getMessage());
        } catch (IllegalStateException e) {
            System.err.println(INCORRECT_VALUE_INPUT  + e.getMessage());
        } catch (Exception e) {
            System.err.println(INCORRECT_VALUE_INPUT  + e.getMessage());
            e.printStackTrace();
        } finally {
            Runtime.getRuntime().exit(0);
        }
    }
}