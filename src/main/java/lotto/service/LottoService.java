package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.LottoRank.*;
import static lotto.util.ErrorProperties.*;
import static lotto.util.LottoProperties.*;

public class LottoService {

    private final List<Lotto> lottoList = new ArrayList<>();
    private int purchaseMoney;
    private int count;

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    /**
     * 1000원 단위가 아닌 경우 예외 발생
     * @param money
     */
    public void validateMoneyUnit(int money) {
        if (money % 1000 != 0)
            throw new IllegalArgumentException(getErrorMessageMoneyUnit());
    }

    /**
     * 로또 번호 세팅
     * 해당 가격에 맞는 개수만큼 총 6개의 숫자를 뽑는 로또 발행
     * @param money
     */
    public void initLottoNumbers(int money) {
        validateMoneyUnit(money);
        purchaseMoney = money;
        count = money / 1000;

        List<Integer> lottoNumbers;
        for (int i = 0; i < count; i++) {
            lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(lottoNumbers);
            lottoList.add(lotto);
        }
    }

    /**
     * 발행된 로또 번호 출력
     */
    public void printLottoInfo() {
        System.out.println(getBuyCount(purchaseMoney));
        for (Lotto lotto : lottoList) {
            System.out.println(getLottoNumbers(lotto.getNumbers()));
        }
    }

    /**
     * 로또 결과 추출
     * 6개 / 5개+보너스 / 5개 / 4개 / 3개 번호 일치
     * @param winningNumber
     * @param bonusNumber
     */
    public List<Integer> extractWinning(List<Integer> winningNumber, Integer bonusNumber) {
        int sum_match3 = 0, sum_match4 = 0, sum_match5 = 0, sum_match5_bonus = 0, sum_match6 = 0;
        for (Lotto lotto : lottoList) {
            List<Integer> numberList = lotto.getNumbers();
            if (matches_3(winningNumber, numberList)) sum_match3++;
            else if (matches_4(winningNumber, numberList)) sum_match4++;
            else if (matches_5(winningNumber, numberList)) sum_match5++;
            else if (matches_5_bonus(winningNumber, bonusNumber, numberList)) sum_match5_bonus++;
            else if (matches_6(winningNumber, numberList)) sum_match6++;
        }
        System.out.println(getWinningStatistics(purchaseMoney, sum_match3, sum_match4, sum_match5, sum_match5_bonus, sum_match6));
        return List.of(sum_match3, sum_match4, sum_match5, sum_match5_bonus, sum_match6);
    }

    /**
     * 5등: 3개 번호 일치
     * @param winningNumber
     * @param numberList
     * @return
     */
    private boolean matches_3(List<Integer> winningNumber, List<Integer> numberList) {
        int matchSum = 0;
        if (!matches_6(winningNumber, numberList) && !matches_5(winningNumber, numberList) && !matches_4(winningNumber, numberList)) {
            matchSum = getMatchSum(winningNumber, numberList, matchSum);
        }
        return (matchSum == 3);
    }

    /**
     * 4등 : 4개 번호 일치
     * @param winningNumber
     * @param numberList
     * @return
     */
    private boolean matches_4(List<Integer> winningNumber, List<Integer> numberList) {
        int matchSum = 0;
        if (!matches_6(winningNumber, numberList) && !matches_5(winningNumber, numberList)) {
            matchSum = getMatchSum(winningNumber, numberList, matchSum);
        }
        return (matchSum == 4);
    }

    /**
     * 3등 : 5개 번호 일치
     * @param winningNumber
     * @param numberList
     * @return
     */
    private boolean matches_5(List<Integer> winningNumber, List<Integer> numberList) {
        int matchSum = 0;
        if (!matches_6(winningNumber, numberList)) {
            matchSum = getMatchSum(winningNumber, numberList, matchSum);
        }
        return (matchSum == 5);
    }

    /**
     * 일치하는 번호 개수 찾는 메서드
     * @param winningNumber
     * @param numberList
     * @param matchSum
     * @return
     */
    private static int getMatchSum(List<Integer> winningNumber, List<Integer> numberList, int matchSum) {
        for (Integer n : numberList) {
            if (winningNumber.contains(n)) matchSum++;
        }
        return matchSum;
    }

    /**
     * 2등 : 5개 번호 + 보너스 번호 일치
     * @param winningNumber
     * @param bonusNumber
     * @param numberList
     * @return
     */
    private boolean matches_5_bonus(List<Integer> winningNumber, Integer bonusNumber, List<Integer> numberList) {
        return matches_5(winningNumber, numberList) && numberList.contains(bonusNumber);
    }

    /**
     * 1등 : 6개 번호 일치
     * @param winningNumber
     * @param numberList
     * @return
     */
    private boolean matches_6(List<Integer> winningNumber, List<Integer> numberList) {
        return winningNumber.equals(numberList);
    }

    /**
     * 발행된 로또 번호 출력
     * @param lottoNumbers
     * @return
     */
    public static String getLottoNumbers(List<Integer> lottoNumbers) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < lottoNumbers.size(); i++) {
            Integer lottoNum = lottoNumbers.get(i);
            if (i == lottoNumbers.size() - 1) {
                sb.append(lottoNum);
                break;
            }
            sb.append(lottoNum).append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * 당첨 통계 출력
     * @param purchaseMoney
     * @return
     */
    public static String getWinningStatistics(int purchaseMoney, int ... matches) {

        double returnRate = getReturnRate(purchaseMoney, matches);

        return "당첨 통계\n" +
                "---\n" +
                MATCH_3.getMatchingCount() + "개 일치 (" + MATCH_3.getReword() + "원) - " + matches[0] + "개\n" +
                MATCH_4.getMatchingCount() + "개 일치 (" + MATCH_4.getReword() + "원) - " + matches[1] + "개\n" +
                MATCH_5.getMatchingCount() + "개 일치 (" + MATCH_5.getReword() + "원) - " + matches[2] + "개\n" +
                MATCH_5_BONUS.getMatchingCount() + "개 일치, 보너스 볼 일치 (" + MATCH_5_BONUS.getReword() + "원) - " + matches[3] + "개\n" +
                MATCH_6.getMatchingCount() + "개 일치 (" + MATCH_6.getReword() + "원) - " + matches[4] + "개\n" +
                "총 수익률은 " + String.format("%.1f", returnRate) + "%입니다.";
    }

    /**
     * 수익률 계산
     * @param purchaseMoney
     * @return
     */
    private static double getReturnRate(int purchaseMoney, int ... matches) {
        return (double) ((MATCH_3.getRewordByInt() * matches[0]) +
                (MATCH_4.getRewordByInt() * matches[1]) +
                (MATCH_5.getRewordByInt() * matches[2]) +
                (MATCH_5_BONUS.getRewordByInt() * matches[3]) +
                (MATCH_6.getRewordByInt() * matches[4])) / purchaseMoney * 100;
    }
}
