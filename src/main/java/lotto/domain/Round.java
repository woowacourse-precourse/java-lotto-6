package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.global.enums.Constants.LOTTO_MAX_NUM;
import static lotto.global.enums.Constants.LOTTO_MIN_NUM;
import static lotto.global.enums.Constants.LOTTO_NUM_CNT;
import static lotto.global.util.InputManager.inputPayment;
import static lotto.global.util.OutputManager.printHistory;
import static lotto.global.util.OutputManager.printRateOfProfit;
import static lotto.global.util.OutputManager.printWinResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Round {

    private int payment;    // 지불 금액
    private List<Integer> winCnts;   // 당첨 개수
    private final List<Lotto> lottos;
    private List<Boolean> containsBonus;  // 보너스 볼 포함 여부
    private final Map<Integer, Long> winningAmount;  // 당첨 금액

    public Round() {
        lottos = new ArrayList<Lotto>();
        winningAmount = new HashMap<Integer, Long>();
    }

    /**
     * 지불한 금액의 장 수만큼 로또 번호를 추출하는 메서드
     * @param totalCnt
     */
    public void extractor(int totalCnt) {
        for (int i=0; i<totalCnt; i++) {
            List<Integer> randomNums = new ArrayList<>(pickUniqueNumbersInRange(LOTTO_MIN_NUM, LOTTO_MAX_NUM, LOTTO_NUM_CNT));
            Collections.sort(randomNums);   // 오름차순 정렬
            Lotto lotto = new Lotto(randomNums);
            lottos.add(lotto);
        }
        printHistory(totalCnt, lottos);
    }

    /**
     * 지불한 금액을 구매 장 수로 변환하는 메서드
     * - 1000원 단위로 나누어 계산한다
     * @return
     */
    public int getTotalCnt() {
        payment = inputPayment();
        return payment / 1000;
    }

    /**
     * 당첨 여부 확인을 위해 로또 번호를 비교하는 메서드
     * @param winNum
     * @param bonusNum
     */
    public void judge(Lotto winNum, int bonusNum) {

        containsBonus = lottos.stream()
                .map(lotto -> lotto.getNumbers().contains(bonusNum))
                .toList();

        winCnts = lottos.stream()
                .map(lotto -> {
                    return countWinNum(winNum, bonusNum, lotto);
                })
                .toList();
    }

    /**
     * 각각의 로또에서 당첨 번호와 일치하는 숫자 개수를 카운트하는 메서드
     * @param winNum
     * @param bonusNum
     * @param lotto
     * @return
     */
    private static int countWinNum(Lotto winNum, int bonusNum, Lotto lotto) {
        int winCnt = (int) winNum.getNumbers().stream()
                .filter(num -> lotto.getNumbers().contains(num))
                .count();

        if (lotto.getNumbers().contains(bonusNum))
            winCnt++;

        return winCnt;
    }

    /**
     * 당첨 결과를 보여주는 메서드
     */
    public void showResult() {
        printWinResult(saveResult());
        printRateOfProfit(calculateProfit(winningAmount));
    }

    /**
     * 각 당첨금에 해당하는 개수로 당첨 결과를 저장하는 메서드
     * @return
     */
    private Map<Integer, Long> saveResult() {
        long containBonusCnt = (int) (IntStream.range(0, winCnts.size())
                .filter(i -> containsBonus.get(i) && winCnts.get(i) == 5)
                .count());
        long notContainBonusCnt = winCnts.stream().filter(num -> num == 5).count() - containBonusCnt;

        winningAmount.put(5_000, winCnts.stream().filter(num -> num == 3).count());
        winningAmount.put(50_000, winCnts.stream().filter(num -> num == 4).count());
        winningAmount.put(1_500_000, notContainBonusCnt);
        winningAmount.put(30_000_000, containBonusCnt);
        winningAmount.put(2_000_000_000, winCnts.stream().filter(num -> num == 6).count());

        return winningAmount;
    }

    /**
     * 수익률을 계산하는 메서드
     * @param winningAmount
     * @return
     */
    private double calculateProfit(Map<Integer, Long> winningAmount) {

        double profit = winningAmount.entrySet().stream()
                .mapToLong(win -> win.getKey() * win.getValue())
                .sum();
        profit = ((double) (profit - payment) / payment) * 100;
        profit = Math.round(profit * 10) / 10.0;  // 소수점 둘째 자리 반올림

        return 100 + profit;
    }

    public List<Integer> getWinCnts() {
        return winCnts;
    }
}
