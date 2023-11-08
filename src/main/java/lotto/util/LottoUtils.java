package lotto.util;

import lotto.Lotto;


public class LottoUtils {

    // 총 상금과 구매 금액을 받아 수익률 계산
    public static double calculateProfitRate(int purchaseAmount, int totalPrize) {
        return ((double) totalPrize / purchaseAmount) * 100;
    }

    // 사용자 로또 번호와 당첨 번호 중 일치하는 번호의 개수를 세는 메서드
    public static int countMatchedNumbers(Lotto userLotto, Lotto winningLotto) {
        int count = 0;
        // 사용자 로또 번호 중 당첨 번호와 일치하는 번호의 개수를 세는 반복문
        for (int number : userLotto.getNumbers()) {
            if (winningLotto.containsNumber(number)) {
                count++;
            }
        }
        return count;
    }
}
