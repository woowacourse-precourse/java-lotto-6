package lotto.controller;

import lotto.domain.Player;
import lotto.domain.WinningLotto;


public class LottoController {


    public void run() {
        Player player = inputPurchaseAmount();
        printLottoAmountAndLottoNumbers(player);
        WinningLotto winningLotto = inputWinningNumbersAndBonusNumber();
        printWinningStatistics(player, winningLotto);
    }

    private Player inputPurchaseAmount() {
        // LottoService.createPlayer(int purchaseAmount);
        return null;
    }

    private void printLottoAmountAndLottoNumbers(Player player) {

    }

    private WinningLotto inputWinningNumbersAndBonusNumber() {
        // LottoService.createWinningLotto(List<Integer> winningNumbers, int bonusNumber);
        return null;
    }

    private void printWinningStatistics(Player player, WinningLotto winningLotto) {
        // LottoService.makeWinningStatistics(Player player, WinningLotto winningLotto);
    }



}
