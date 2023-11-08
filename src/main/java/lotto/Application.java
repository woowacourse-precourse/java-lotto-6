/*
 * 로또 구현 프로그램
 * 2023.11.02 ~ 2023.11.08
 */

package lotto;

import lotto.controller.MainController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        MainController mainController = new MainController(new InputView(), new OutputView());
        try {
            mainController.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
