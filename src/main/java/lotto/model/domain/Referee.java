package lotto.model.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Referee {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final List<Integer> lottoRank;
    private Double lottoBenefit;

    public Referee(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = new ArrayList<>(winningNumbers);
        Collections.sort(this.winningNumbers);
        this.bonusNumber = bonusNumber;
        this.lottoRank = new ArrayList<>(initLottoRank());
    }

    public List<Integer> initLottoRank() {
        List<Integer> lottoRank = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            lottoRank.add(0);
        }

        return lottoRank;
    }

    public void increaseCountForRank(int rank) {
        int count = this.lottoRank.get(rank);
        this.lottoRank.set(rank, count + 1);
    }

    public void calculateLottoBenefit(int lottoAmount) {
        int first = lottoRank.get(1) * 2_000_000_000;
        int second = lottoRank.get(2) * 30_000_000;
        int third = lottoRank.get(3) * 1_500_000;
        int fourth = lottoRank.get(4) * 50_000;
        int fifth = lottoRank.get(5) * 5_000;

        long sum = first + second + third + fourth + fifth;

        this.lottoBenefit = (sum * 100 / (double) lottoAmount);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getLottoRank() {
        return lottoRank;
    }

    public Double getLottoBenefit() {
        return lottoBenefit;
    }
}
