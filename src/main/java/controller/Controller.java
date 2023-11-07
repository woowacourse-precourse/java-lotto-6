package controller;

import View.InputView;
import View.OutputView;
import java.util.List;
import java.util.Map;
import lotto.Buyer;
import lotto.Lotto;
import lotto.LottoMachine;
import lotto.PlayLotto;
import lotto.Rank;
import utils.Util;

public class Controller {
    private final LottoMachine lottoMachine;
    private final InputView inputView;
    private Buyer buyer;

    public Controller(LottoMachine lottoMachine, InputView inputView) {
        this.lottoMachine = lottoMachine;
        this.inputView = inputView;
    }

    public void run() {
        int purchaseAmount = askPurchaseAmount();
        buyer = new Buyer(purchaseAmount, lottoMachine);
        buyLotto(buyer);

        PlayLotto playLotto = startLotto();
        LottoResult(playLotto);
    }

    public PlayLotto startLotto() {
        Lotto prizeLotto = askPrizeNumbers();
        List<Integer> prizeNumbers = prizeLotto.getNumbers();
        int bonusNumber = askBonusNumber(prizeNumbers);

        return new PlayLotto(prizeNumbers, bonusNumber);
    }

    public void LottoResult(PlayLotto playLotto) {
        Map<Rank, Integer> lottoResult = calculatedLottoResults(playLotto);
        printLottoResults(lottoResult);
        long prizeSum = playLotto.prizeSum();
        printReturnOfRate(prizeSum);
    }

    private int askPurchaseAmount() {
        OutputView.promptPurchaseAmount();
        try {
            String puchasePrice = inputView.inputPuchasePrice();
            return Integer.parseInt(puchasePrice) / Lotto.LOTTO_PRICE;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return askPurchaseAmount();
        }
    }

    private void buyLotto(Buyer buyer) {
        buyer.buyLotteries();
        OutputView.printPurchaseAmount(buyer.getPurchaseAmount());
        OutputView.printLottos(buyer.getMyLotteries());
    }

    private Lotto askPrizeNumbers() {
        OutputView.promptPrizeNumbers();
        try {
            String inputPrizeNumbers = inputView.inputPrizeNumbers();
            return new Lotto(Util.stringToIntegerList(inputPrizeNumbers));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return askPrizeNumbers();
        }

    }

    private int askBonusNumber(List<Integer> prizeNumbers) {
        OutputView.promptBonusNumber();
        try {
            String inputBonusNumber = inputView.inputBonusNumber();
            int bonusNumber = Integer.parseInt(inputBonusNumber);
            validateBonusNumber(prizeNumbers, bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return askBonusNumber(prizeNumbers);
        }
    }

    private void validateBonusNumber(List<Integer> prizeNumbers, int bonusNumber) {
        Lotto.validateSingleNumberRange(bonusNumber);
        if (prizeNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨번호와 중복 값으로 설정할 수 없습니다.");
        }
    }

    private Map<Rank, Integer> calculatedLottoResults(PlayLotto playLotto) {
        playLotto.lottoResult(buyer.getMyLotteries());
        return playLotto.getLottoResult();
    }

    private void printLottoResults(Map<Rank, Integer> lottoResults) {
        OutputView.promptWinStatistics();
        for (Rank key : Rank.values()) {
            OutputView.printWinResult(key.getMessage(lottoResults.get(key)));
        }
    }

    private void printReturnOfRate(long prizeSum) {
        OutputView.printReturnOfRate(buyer.calculateReturnRate(prizeSum));
    }
}
