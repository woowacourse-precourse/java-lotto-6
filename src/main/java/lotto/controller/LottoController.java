package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.NumberGenerator;
import lotto.domain.Player;
import lotto.domain.Rank;
import lotto.view.ErrorView;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoController {
    private static final int CONDITION_HITS = 3;
    private final List<Lotto> lottos;
    private final Map<Rank, Integer> result;
    private final NumberGenerator numberGenerator;

    public LottoController() {
        numberGenerator = new NumberGenerator();
        lottos = new ArrayList<>();
        result = new HashMap<>();
    }

    public void run() {
        try {
            start();
        } catch (IllegalArgumentException e) {
            ErrorView.printErrorMessage(e.getMessage());
            run();
        }
    }

    public void start() {
        Player player = new Player(InputView.inputPurchaseAmount());
        pickLotto(player.getTicketCount());
        List<Integer> winningNumbers = numberGenerator.createWinningNumbers(InputView.inputWinningNumbers());
        int bonusNumber = numberGenerator.createBonusNumber(winningNumbers, InputView.inputBonusNumber());
        setResult();
        for (Lotto lotto : lottos) {
            compareNumbers(lotto, winningNumbers, bonusNumber);
            writeResult(lotto);
        }
        showResult(player.getAmountPurchase());
    }

    public void pickLotto(int ticketCount) {
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> numbers = numberGenerator.createLottoNumbers();
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        OutputView.printPurchasedLotto(lottos);
    }

    public void compareNumbers(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        for (Integer lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                lotto.updateHits();
            }
            if (lottoNumber.equals(bonusNumber)) {
                lotto.changeBonusStatus();
            }
        }
    }

    public void setResult() {
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    public void writeResult(Lotto lotto) {
        if (lotto.getHits() >= CONDITION_HITS) {
            Rank rank = Rank.getRank(lotto);
            result.put(rank, result.get(rank) + 1);
        }
    }

    public void showResult(int amount) {
        OutputView.printWinningStatistics();
        for (Rank rank : Rank.values()) {
            OutputView.printResult(rank, result);
        }
        double earningRate = getEarningRate(amount);
        OutputView.printEarningRate(earningRate);
    }

    public double getEarningRate(int amount) {
        double earnings = 0;
        for (Map.Entry<Rank, Integer> entrySet : result.entrySet()) {
            earnings += entrySet.getKey().getPrize() * entrySet.getValue();
        }
        return Double.parseDouble(String.format("%.1f", earnings / amount * 100));
    }
}