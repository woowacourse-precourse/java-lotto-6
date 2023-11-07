package lotto.domain;


import lotto.util.Constants;

import java.text.DecimalFormat;
import java.util.List;

public class LottoPrize {
    private List<Lotto> purchasedLotto;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoPrize(List<Lotto> purchasedLotto, List<Integer> winningNumbers, int bonusNumber) {
        this.purchasedLotto = purchasedLotto;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void calculatePrizes() {
        int[] prizeCounts = new int[7]; // 3개 ~ 6개 일치 및 보너스 번호까지 일치한 횟수를 저장하는 배열

        for (Lotto lotto : purchasedLotto) {
            int matchCount = countMatchingNumbers(lotto);
            if (matchCount == 5 && lotto.getNumbers().contains(bonusNumber)) {
                prizeCounts[6]++; // 보너스 번호까지 일치한 경우
            }
            prizeCounts[matchCount]++; // 맞춘 숫자 개수에 따라 횟수 증가
        }

        // 당첨 통계 출력
        System.out.println("당첨 통계");
        System.out.println("---");
        printPrize(6, prizeCounts[6]); // 6개 일치
        System.out.println(Constants.END_RESULT_MESSAGE_BONUS + prizeCounts[6] + "개"); // 보너스 번호까지 일치
        printPrize(5, prizeCounts[5]);
        printPrize(4, prizeCounts[4]);
        printPrize(3, prizeCounts[3]);

        // 총 수익률 계산
        double totalPrize = calculateTotalPrize(prizeCounts);
        double purchaseCost = purchasedLotto.size() * Constants.LOTTO_PRICE;
        double earningRate = (totalPrize / purchaseCost) * 100.0;

        DecimalFormat df = new DecimalFormat("0.0"); // 소수점 둘째 자리에서 반올림
        System.out.println("총 수익률은 " + df.format(earningRate) + "%입니다.");
    }


    private int countMatchingNumbers(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private void printPrize(int matchCount, int count) {
        if (matchCount == 6) {
            System.out.println(Constants.END_RESULT_MESSAGE_6 + count + "개");
        } else if (matchCount == 5) {
            System.out.println(Constants.END_RESULT_MESSAGE_5 + count + "개");
        } else if (matchCount == 4) {
            System.out.println(Constants.END_RESULT_MESSAGE_4 + count + "개");
        } else if (matchCount == 3) {
            System.out.println(Constants.END_RESULT_MESSAGE_3 + count + "개");
        }

    }

    private double calculateTotalPrize(int[] prizeCounts) {
        double totalPrize = 0;
        for (int i = 3; i <= 6; i++) {
            totalPrize += prizeCounts[i] * Constants.PRIZE_MONEY[i];
        }
        totalPrize += prizeCounts[2] * Constants.PRIZE_MONEY[2]; // 3개 일치 특별상
        totalPrize += prizeCounts[5] * Constants.PRIZE_MONEY[5]; // 5개 일치, 보너스 볼 일치
        return totalPrize;
    }
}
