package lotto.controller;

import lotto.model.LottoPlayer;
import lotto.model.LottoNumbers;
import lotto.model.WinningCriteria;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;
import java.util.HashMap;
import java.util.List;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        LottoPlayer lottoPlayer = createLottoPlayer(getPurchase());
        createLottoList(lottoPlayer);
        WinningLotto winningLotto = getPlayerNumbers();
        displayResult(lottoPlayer, winningLotto);
    }

    private int getPurchase() {
        outputView.printLottoPurchaseInputMessage();
        int lottoPurchase = inputView.requestLottoPurchase();
        return lottoPurchase;
    }

    private LottoPlayer createLottoPlayer(int initialAmount) {
        LottoPlayer lottoPlayer = new LottoPlayer(initialAmount);
        return lottoPlayer;
    }

    private void createLottoList(LottoPlayer lottoPlayer) {
        int lottoCount = lottoPlayer.getLottoCount();
        outputView.printLottoPurchaseCountMessage(lottoCount);
        for (int i=0; i<lottoCount; i++) {
            createLotto(lottoPlayer);
        }
    }

    private void createLotto(LottoPlayer lottoPlayer) {
        List<Integer> lottoNumbers = LottoNumbers.setLottoNumbers();
        outputView.printLottoPurchasedNumber(lottoNumbers);
        lottoPlayer.lottoGeneration(lottoNumbers);
    }

    private WinningLotto getPlayerNumbers() {
        WinningLotto winningLotto = new WinningLotto(
                getWinningNumbers(),
                getBonusNumber()
        );
        return winningLotto;
    }

    private List<Integer> getWinningNumbers() {
        outputView.printWinningNumbersInputMessage();
        return inputView.requestWinningNumbers();
    }

    private int getBonusNumber() {
        outputView.printBonusNumberInputMessage();
        return inputView.requestBonusNumber();
    }

    private void displayResult(LottoPlayer player, WinningLotto winningLotto) {
        HashMap<WinningCriteria, Integer> result = computeLottosRank(player, winningLotto);
        double rateOfReturn = player.computeRateOfReturn(computeIncome(result));
        outputView.printLottoStatics(result, rateOfReturn);
    }

    private HashMap<WinningCriteria, Integer> computeLottosRank(LottoPlayer player, WinningLotto winningLotto) {
        HashMap<WinningCriteria, Integer> result = new HashMap<>();
        int lottoCount = player.getLottoCount();
        for (int i=0; i<lottoCount; i++) {
            WinningCriteria rank = computeLottoRank(winningLotto, player.getLottoNumberByIndex(i));
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return result;
    }

    private WinningCriteria computeLottoRank(WinningLotto winningLotto, List<Integer> lottoNumber) {
        return winningLotto.computeRank(lottoNumber);
    }

    private int computeIncome(HashMap<WinningCriteria, Integer> result) {
        int income = 0;
        for (WinningCriteria key : result.keySet()) {
            income += key.getPrizeAmount() * result.get(key);
        }
        return income;
    }
}
