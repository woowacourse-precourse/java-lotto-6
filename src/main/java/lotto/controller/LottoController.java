package lotto.controller;

import lotto.domain.Player;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class LottoController {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final LottoService lottoService = new LottoService();

    private static final String DELIMITER = ",";

    public void run() {
        Player player = inputPurchaseAmount();
        printLottoAmountAndLottoNumbers(player);
        WinningLotto winningLotto = inputWinningNumbersAndBonusNumber();
        printWinningStatistics(player, winningLotto);
    }

    private Player inputPurchaseAmount() {
        outputView.printInputPurchaseAmount();
        String stringPurchaseAmount = inputView.inputPurchaseAmount();
        //입력값 검증
        int purchaseAmount = Integer.parseInt(stringPurchaseAmount);
        return lottoService.createPlayer(purchaseAmount);
    }

    private void printLottoAmountAndLottoNumbers(Player player) {
        outputView.printLottoAmountAndLottoNumbers(player.getLottos());
    }

    private WinningLotto inputWinningNumbersAndBonusNumber() {
        outputView.printInputWinningNumbers();
        String stringWinningNumbers = inputView.inputWinningNumbers();
        //입력값 검증
        List<Integer> winningNumbers = convertStringToIntegerList(stringWinningNumbers);

        outputView.printInputBonusNumber();
        String stringBonusNumber = inputView.inputBonusNumbers();
        //입력값 검증
        int bonusNumber = Integer.parseInt(stringBonusNumber);

        return lottoService.createWinningLotto(winningNumbers, bonusNumber);
    }

    private void printWinningStatistics(Player player, WinningLotto winningLotto) {
        Map<Rank, Integer> winningStatistics = lottoService.makeWinningStatistics(player, winningLotto);
        outputView.printWinningStatistics(winningStatistics);
    }

    private List<Integer> convertStringToIntegerList(String stringWinningNumbers) {
        return Arrays.stream(stringWinningNumbers.split(DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }

}
