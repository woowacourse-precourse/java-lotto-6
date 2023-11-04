package lotto.model.lotto;

import lotto.model.PaperBag;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoHandler {
    private final List<Integer> winningNumber;
    private final int bonusNumber;
    private List<Integer> resultAmount;
    private List<Integer> winList;

    private LottoHandler(List<Integer> winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        this.resultAmount = new ArrayList<>();
        this.winList = new ArrayList<>(List.of(0, 0, 0, 0, 0));
    }

    public static LottoHandler of(List<Integer> winningNumber, int bonusNumber) {
        return new LottoHandler(winningNumber, bonusNumber);
    }

    public void calculateResult(PaperBag paperBag) {
        calculateMatchNumber(paperBag);
        calculateWinningResult();
    }

    public int getTotalWinAmount() {
        int sum =0;
        for (int amount : resultAmount) {
            sum = sum + amount;
        }
        return sum;
    }

    private void calculateMatchNumber(PaperBag paperBag) {
        List<Lotto> lottoes = paperBag.getLottoes();
        for (Lotto lotto : lottoes) {
            Set<Integer> lottoSet = new HashSet<>(lotto.getNumbers());
            Set<Integer> winningNumberSet = new HashSet<>(winningNumber);
            lottoSet.retainAll(winningNumberSet);
            calculateResult(lottoSet.size(),lotto);
        }
    }

    private void calculateResult(int size, Lotto lotto) {
        for (LottoInfo info : LottoInfo.values()) {
            if (info.getNumberMatch() == size && size!=5) {
                resultAmount.add(info.getWinningAmount());
            }
            if (info.getNumberMatch() == size && size == 5) {
                resultAmount.add(ifMatchNumberFive(lotto));
            }
        }
    }

    private int ifMatchNumberFive(Lotto lotto) {
        List<Integer> lottoNumber = lotto.getNumbers();
        if (lottoNumber.contains(bonusNumber)) {
            return LottoInfo.SECOND_WINNER.getWinningAmount();
        }
        return LottoInfo.THIRD_WINNER.getWinningAmount();
    }

    private void calculateWinningResult() {
        for (int amount : resultAmount) {
            calWinList(amount);
        }
    }

    private void calWinList(int amount) {
        for (LottoInfo lottoInfo : LottoInfo.values()) {
            if (amount == lottoInfo.getWinningAmount()) {
                int index = lottoInfo.getIndex();
                winningNumber.set(index, winList.get(index) + 1);
            }
        }
    }

    public String resultToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(LottoInfo.FIFTH_WINNER.getInfo()).append(" - ").append(winList.get(0)).append("개").append("\n");
        sb.append(LottoInfo.FOURTH_WINNER.getInfo()).append(" - ").append(winList.get(1)).append("개").append("\n");
        sb.append(LottoInfo.THIRD_WINNER.getInfo()).append(" - ").append(winList.get(2)).append("개").append("\n");
        sb.append(LottoInfo.SECOND_WINNER.getInfo()).append(" - ").append(winList.get(3)).append("개").append("\n");
        sb.append(LottoInfo.FIRST_WINNER.getInfo()).append(" - ").append(winList.get(4)).append("개").append("\n");
        return sb.toString();
    }

}
