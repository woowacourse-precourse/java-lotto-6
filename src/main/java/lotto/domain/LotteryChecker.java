package lotto.domain;

import lotto.constant.NumberConstants;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.NumberConstants.*;

public class LotteryChecker {

    public void prizeCheck(List<Lotto> lottoList, List<Integer> winningNumbers) {
        List<Integer> winningNum = winningNumbers.subList(0, WINNING_NUMBER_TOTAL.getValue());
        Integer bonusNum = winningNumbers.get(WINNING_NUMBER_TOTAL.getValue());
        System.out.println("보너스 번호 : " + bonusNum);

        countSameNumber(lottoList, winningNum, bonusNum);

        for (Lotto lotto : lottoList) {
            if (lotto.getMatchNumberCount() == SECOND_PRIZE_MATCH_COUNT.getValue() && lotto.isMatchBonusCount()) {
                lotto.setPrize(2);
            }
            if (lotto.getMatchNumberCount() == FIRST_PRIZE_MATCH_COUNT.getValue()) {
                lotto.setPrize(1);
            }
            if (lotto.getMatchNumberCount() == THIRD_PRIZE_MATCH_COUNT.getValue() && !lotto.isMatchBonusCount()) {
                lotto.setPrize(3);
            }
            if (lotto.getMatchNumberCount() == FOURTH_PRIZE_MATCH_COUNT.getValue()) {
                lotto.setPrize(4);
            }
            if (lotto.getMatchNumberCount() == FIFTH_PRIZE_MATCH_COUNT.getValue()) {
                lotto.setPrize(5);
            }
        }
    }

    private static void countSameNumber(List<Lotto> lottoList, List<Integer> winningNumbers, int bonusNum) {
        for (Lotto lotto : lottoList) {
            int count = (int) lotto.getNumbers().stream().filter(winningNumbers::contains).count();
            hasBonusNum(lotto, bonusNum);
            lotto.setMatchNumberCount(count);
            System.out.println("로또 번호 : " + lotto.getNumbers().toString());
            System.out.println("당첨 번호 : " + winningNumbers.toString());
            System.out.printf("당첨 번호와 일치하는 숫자 개수 = %d", count);
            System.out.println();
        }
    }

    private static void hasBonusNum(Lotto lotto, int bonusNum) {
        if (lotto.getNumbers().contains(bonusNum)) {
            lotto.setMatchBonusCount(true);
        }
    }

    public List<Integer> prizeCalculate(List<Lotto> lottoList) {
        List<Integer> tong = new ArrayList<>();
        int first = 0;
        int second = 0;
        int third = 0;
        int forth = 0;
        int fifth = 0;
        for (Lotto lotto : lottoList) {
            if (lotto.getPrize() == 1) {
                first++;
            }
            if (lotto.getPrize() == 2) {
                second++;
            }
            if (lotto.getPrize() == 3) {
                third++;
            }
            if (lotto.getPrize() == 4) {
                forth++;
            }
            if (lotto.getPrize() == 5) {
                fifth++;
            }
        }
        tong.add(first);
        tong.add(second);
        tong.add(third);
        tong.add(forth);
        tong.add(fifth);
        return tong;
    }
}
