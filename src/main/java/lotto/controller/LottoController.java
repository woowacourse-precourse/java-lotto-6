package lotto.controller;

import lotto.domain.LotteryNumbers;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
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
        output.purchasedLotts(player);
        play(player);
    }

    private Player start() {
        output.requestPurchasePrice();
        PurchasePrice purchasePrice = createPurchasePrice();
        output.purchaseCount(purchasePrice);
        Lottos lottos = lottoService.purchaseLottos(purchasePrice);
        return Player.of(purchasePrice, lottos);
    }

    private PurchasePrice createPurchasePrice() {
        try {
            return PurchasePrice.from(input.purchasePrice());
        } catch (IllegalArgumentException e) {
            return createPurchasePrice();
        }
    }

    private void play(Player player) {
        LotteryNumbers lotteryNumbers = createLotteryResult();
        lottoService.compareLotteryResult(player, lotteryNumbers);
    }

    /*
     *   이 부분으로 밑에까지 다시 한번 확인해보기
     * */
    private LotteryNumbers createLotteryResult() {
        output.requestWinningNumbers();
        Lotto winningLotto = createWinningLotto();
        output.requestBonusNumber();
        int bonusNumber = tryCreateBonusNumber(winningLotto);
        return LotteryNumbers.of(winningLotto, bonusNumber);
    }

    private int tryCreateBonusNumber(Lotto winningLotto) {
        int bonusNumber = createBonusNumber();
        System.out.println(bonusNumber);
        try {
            LotteryNumbers.of(winningLotto, bonusNumber);
        } catch (IllegalArgumentException e) {
            return tryCreateBonusNumber(winningLotto);
        }
        return bonusNumber;
    }

    private Lotto createWinningLotto() {
        try {
            return new Lotto(input.winningNumbers());
        } catch (IllegalArgumentException e) {
            return createWinningLotto();
        }
    }

    private int createBonusNumber() {
        try {
            return Integer.parseInt(input.bonusNumber());
        } catch (IllegalArgumentException e) {
            return createBonusNumber();
        }
    }


}