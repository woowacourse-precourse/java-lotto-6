package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static lotto.constant.LottoConstant.*;

public class Compare {
    private int match; // 일치한 숫자 개수
    private List<Integer> winningRank = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
    private int revenue = 0;

    public void matchLotto(List<Lotto> lottos, Lotto lotto, BonusNumber bonus) {
        List<Integer> luckyNumbers = lotto.getNumbers();

        for (Lotto purchaseLotto : lottos) {
            List<Integer> purchaseNumbers = purchaseLotto.getNumbers();
            List<Integer> matchNumbers = purchaseNumbers.stream().filter(o -> luckyNumbers.stream()
                    .anyMatch(Predicate.isEqual(o))).collect(Collectors.toList());

            match = matchNumbers.size();
            saveMatch(match, purchaseLotto, bonus);
        }
    }

    public void saveMatch(int match, Lotto lotto, BonusNumber bonus) {
        if (match == WINNING_5) saveWinning_5();
        if (match == WINNING_4) saveWinning_4();
        if (match == WINNING_2OR3) {
            boolean isExistBounus = lotto.getNumbers().contains(bonus.getNumber());
            if (isExistBounus) saveWinning_2();
            if (!isExistBounus) saveWinning_3();
        }
        if (match == WINNING_1) saveWinning_1();
    }

    public void saveWinning_5() {
        winningRank.set(4, winningRank.get(4) + 1);
        revenue += WINNING_5_REVENUE;
    }

    public void saveWinning_4() {
        winningRank.set(3, winningRank.get(3) + 1);
        revenue += WINNING_4_REVENUE;
    }

    public void saveWinning_3() {
        winningRank.set(2, winningRank.get(2) + 1);
        revenue += WINNING_3_REVENUE;
    }

    public void saveWinning_2() {
        winningRank.set(1, winningRank.get(1) + 1);
        revenue += WINNING_2_REVENUE;
    }

    public void saveWinning_1() {
        winningRank.set(0, winningRank.get(0) + 1);
        revenue += WINNING_1_REVENUE;
    }

    public List<Integer> getWinningRank() {
        return winningRank;
    }

    public String caculateProfits(int money) {
        return String.format("%,.1f", 1.0 * revenue / money * 100.0);
    }

}