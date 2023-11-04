package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoManager {

    private List<Lotto> lottoTickets = new ArrayList<Lotto>();

    // TODO: 로또 발행하기: Amount 만큼 로또 숫자 생성하기 실행 후 당첨번호 받기
    public LottoManager(int purchasingAmount) {
        for (int i = 0; i < purchasingAmount; i++) {
            Lotto lotto = new Lotto(generateLottoNumbers());
            lottoTickets.add(lotto);
        }
    }

    // TODO: 로또 숫자 생성하기: 중복되지 않는 숫자 6개
    private List<Integer> generateLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        System.out.println(numbers);
        return numbers;
    }

    // TODO: 로또 당첨 검증하기: 숫자가 맞는 만큼 Cnt index 저장하기
    public int[] countLotto(List<Integer> winningNumbers, Integer bonusNumber) {
        int[] resultCounts = new int[8];

        for (Lotto lotto : this.lottoTickets) {
            int result = lotto.calcuateNumber(winningNumbers, bonusNumber);
            resultCounts[result]++;
        }
        return resultCounts;
    }

    // TODO: 당첨 계산하기
    public int calcuateTotalLotto(int[] resultCounts) {

        System.out.println("당첨 통계\n---------");
        int totalPrize = 0;

        Prize[] prizes = Prize.values();
        for (Prize prize : prizes) {
            int matchingCount = prize.getMatchingCount();
            int prizeAmount = prize.getAmount();
            int count = resultCounts[matchingCount];
            int prizeTotal = count * prizeAmount;
            totalPrize += prizeTotal;

            System.out.printf("%s - %d개\n", prize.getDescription(), count);
        }
        return totalPrize;
    }

    public void printProfit(int totalPrize, int purchasingAmount) {
        double profitRatio = ((double) totalPrize / purchasingAmount); // 수익률 계산

        // 소수점 둘째 자리에서 반올림 출력
        System.out.printf("총 수익률은 %.1f%% 입니다.%n", profitRatio);
    }
}
