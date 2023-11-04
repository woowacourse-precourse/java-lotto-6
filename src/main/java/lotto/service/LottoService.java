package lotto.service;

import lotto.common.Money;
import lotto.common.Range;
import lotto.controller.LottoController;
import lotto.entity.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private final LottoController lottoController;
    private final LottoGenerator lottoGenerator;
    private List<Lotto> lottery;
    private Lotto prize;
    private int bonusNumber;
    private int cash;

    public LottoService() {
        lottoController = new LottoController();
        lottoGenerator = new LottoGenerator();
        lottery = new ArrayList<>();
    }

    public void start() {
        settingSequence();
        finalSequence();
    }

    private void settingSequence() {
        cash = lottoController.getPurchaseAmount();
        addLottery(cash);
        lottoController.printPurchaseResult(lottery);
        prize = new Lotto(lottoController.getLottoNumber());
        bonusNumber = lottoController.getBonusNumber(prize);
    }

    private void finalSequence() {
        List<Integer> status = createStatus();
        for (Lotto lotto : lottery) {
            int rank = lotto.checkWin(prize, bonusNumber);
            status.set(rank, status.get(rank) + 1);
        }
        calculateResult(status);
    }

    private void addLottery(int amount) {
        amount /= Range.MINIMUM.getValue();
        for (int i = 0; i < amount; i++) {
            lottery.add(new Lotto(lottoGenerator.getRandomNumbers()));
        }
    }

    private List<Integer> createStatus() {
        List<Integer> status = new ArrayList<>();
        for (int i = 0; i <= Range.SIZE.getValue(); i++) {
            status.add(0);
        }
        return status;
    }

    private void calculateResult(List<Integer> status) {
        int totalEarn = 0;
        for (int i = 1; i <= Range.RANK.getValue(); i++) {
            totalEarn += (status.get(i) * Money.values()[i - 1].getCash());
        }
        String earnRate = String.format("%.1f", ((double) totalEarn / (double) cash) * 100.0);
        lottoController.printResult(status, earnRate);
    }
}
