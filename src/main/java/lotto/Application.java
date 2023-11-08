package lotto;

import lotto.controller.LottoManager;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoManager lottoController=new LottoManager();
        lottoController.buyLotto();
    }
}
