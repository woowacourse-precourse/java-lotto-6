package lotto.domain;

import lotto.constant.NumberConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.domain.LottoRank.NO_RANK;

public class LotteryChecker {



    private static void countSameNumber(List<Lotto> lottoList, List<Integer> winningNumbers, int bonusNum) {
        for (Lotto lotto : lottoList) {
            int count = (int) lotto.getNumbers().stream().filter(winningNumbers::contains).count();
            hasBonusNum(lotto, bonusNum);
            lotto.setMatchNumberCount(count);
//            System.out.println("로또 번호 : " + lotto.getNumbers().toString());
//            System.out.println("당첨 번호 : " + winningNumbers.toString());
//            System.out.printf("당첨 번호와 일치하는 숫자 개수 = %d", count);
//            System.out.println();
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
