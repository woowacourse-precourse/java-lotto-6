package lotto.controller;

import lotto.domain.Player;
import lotto.domain.PurchasePrice;
import lotto.service.LottoService;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {

    //주입 방법을 다시 생각해보기
    //생성자 주입, 필드로 지정해주기
    private final Output output;
    private final Input input;
    private final LottoService lottoService;


    //정적 팩토리 메서드를 사용해야하나
    public LottoController(Output output, Input input, LottoService lottoService) {
        this.output = output;
        this.input = input;
        this.lottoService = lottoService;
    }

    public void run() {
        Player player = start();    //가독성이 나쁘지는 않을까? start를 통해서 player가 생성된다는 의미가 전달되나?
    }

    private Player start() {
        output.requestPurchasePrice();
        String input = this.input.purchasePrice();
        PurchasePrice purchasePrice = lottoService.createPurchasePrice(input);
        output.purchaseCount(purchasePrice);
        return lottoService.createPlayer(purchasePrice);
    }

    private void play() {

    }

    private void showGameResult() {

    }
}
