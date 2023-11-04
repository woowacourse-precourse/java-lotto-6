package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Player;
import lotto.domain.PurchasePrice;
import lotto.service.LottoService;
import lotto.view.Input;
import lotto.view.Output;

/*
 *   사용자와 로또게임 사이의 흐름을 담당
 * */

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
        output.purchaseLotts(player);
        play(player);
    }

    private Player start() {
        output.requestPurchasePrice();
        PurchasePrice purchasePrice = createPurchasePrice();
        output.purchaseCount(purchasePrice);
        return lottoService.createPlayer(purchasePrice);
    }

    private PurchasePrice createPurchasePrice() {
        try {
            return PurchasePrice.from(input.purchasePrice());
        } catch (IllegalArgumentException e) {
            return createPurchasePrice();
        }
    }

    private void play(Player player) {
        output.requestWinningNumbers();
        Lotto lotteryResult = createLotteryResult();
        System.out.println(lotteryResult.getNumbers());
    }

    private Lotto createLotteryResult() {
        return createWinningNumbers();
//        createBonusNumber();
    }

    private Lotto createWinningNumbers() {
        try {
            return new Lotto(input.winningNumbers());
        } catch (IllegalArgumentException e) {
            return createWinningNumbers();
        }
    }
}
