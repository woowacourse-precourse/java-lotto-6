package lotto;

import lotto.controller.LottoController;
import lotto.model.Lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController();
        int price = lottoController.processInputPurchaseAmount();
        System.out.println(price);

        // TODO: 로또 번호 생성 및 결과 처리 로직 추가
    }
}
