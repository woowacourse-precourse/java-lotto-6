package lotto.controller;

import java.util.List;
import lotto.domain.LotteryNumbers;
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

    private final Output output;
    private final Input input;
    private final LottoService lottoService;

    public LottoController(Output output, Input input, LottoService lottoService) {
        this.output = output;
        this.input = input;
        this.lottoService = lottoService;
    }

    public void run() {
        Player player = settingPlayer();
        output.purchasedLotts(player);
        playGame(player);
        output.winningResult(player.getLotteryResults());
        output.rateOfRevenue(player.findRateOfRevenue());
    }

    private Player settingPlayer() {
        output.requestPurchasePrice();
        PurchasePrice purchasePrice = createPurchasePrice();
        output.purchaseCount(purchasePrice);
        List<Lotto> lottos = lottoService.purchaseLottos(purchasePrice);
        return Player.of(purchasePrice, lottos);
    }

    private PurchasePrice createPurchasePrice() {
        try {
            return PurchasePrice.from(input.purchasePrice());
        } catch (IllegalArgumentException e) {
            return createPurchasePrice();
        }
    }

    private void playGame(Player player) {
        LotteryNumbers lotteryNumbers = createLotteryNumbers();
        lottoService.checkLotteryNumbers(player, lotteryNumbers);
    }

    private LotteryNumbers createLotteryNumbers() {
        output.requestWinningNumbers();
        Lotto winningLotto = createWinningLotto();
        output.requestBonusNumber();
        int bonusNumber = createBonusNumber(winningLotto);
        return LotteryNumbers.of(winningLotto, bonusNumber);
    }

    private int createBonusNumber(Lotto winningLotto) {
        int bonusNumber = inputBonusNumber();
        try {
            LotteryNumbers.of(winningLotto, bonusNumber);
        } catch (IllegalArgumentException e) {
            return createBonusNumber(winningLotto);
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

    private int inputBonusNumber() {
        try {
            return Integer.parseInt(input.bonusNumber());
        } catch (IllegalArgumentException e) {
            return inputBonusNumber();
        }
    }
}