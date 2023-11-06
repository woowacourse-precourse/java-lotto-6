package lotto;

import lotto.controller.LottoController;

import javax.naming.ldap.Control;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController();
        lottoController.start();
    }
}
