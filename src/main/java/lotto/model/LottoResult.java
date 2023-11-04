package lotto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoResult {
    private final List<Integer> winningNumber;
    private final int bonusNumber;
    private List<Integer> resultAmount;
    private List<Integer> winList;

    private LottoResult(List<Integer> winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        this.resultAmount = new ArrayList<>();
        this.winList = new ArrayList<>(List.of(0, 0, 0, 0, 0));
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
                winningNumber.set(index, winList.get(index)+1);
            }
        }
    }

    public String resultToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(LottoInfo.FIFTH_WINNER.getInfo()).append(" - ").append(winList.get(0)).append("개").append("\n");
        sb.append(LottoInfo.FOURTH_WINNER.getInfo()).append(" - ").append(winList.get(0)).append("개").append("\n");
        sb.append(LottoInfo.THIRD_WINNER.getInfo()).append(" - ").append(winList.get(0)).append("개").append("\n");
        sb.append(LottoInfo.SECOND_WINNER.getInfo()).append(" - ").append(winList.get(0)).append("개").append("\n");
        sb.append(LottoInfo.FIRST_WINNER.getInfo()).append(" - ").append(winList.get(0)).append("개").append("\n");
        return sb.toString();
    }

}
