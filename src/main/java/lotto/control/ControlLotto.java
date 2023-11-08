package lotto.control;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ControlLotto {
    private final ArrayList<Lotto> lottos = new ArrayList<>();
    private final HashMap<LottoRank, Integer> results = new HashMap<>();
    private long totalReward;

    public ControlLotto() {
        for (LottoRank x: LottoRank.values()) {
            this.results.put(x, 0);
        }
    }


    public void createLottos(long n) {
        for (int i = 0; i < n; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
    }

    public ArrayList<Lotto> getlottos() {
        return this.lottos;
    }

    public void checkResult(ArrayList<Integer> winningNumbers, int bonusNumber) {
        int len = this.lottos.size();
        for (int i = 0; i < len; i++) {
            checkWinningNumbers(i, winningNumbers, bonusNumber);
        }
    }

    private void addresult(LottoRank lottoRank) {
        if (results.containsKey(lottoRank)) {
            results.put(lottoRank, results.get(lottoRank) + 1);
        }
    }

    private void checkWinningNumbers(int i, ArrayList<Integer> winningNumbers, int bonusNumber) {
        List<Integer> lotto = this.lottos.get(i).getnumbers();
        int count = 0;
        for (Integer n: winningNumbers) {
            if (lotto.contains(n)) {
                count++;
            }
        }
        if (count == 5 && checkBonusNumber(i, bonusNumber)) {
                addresult(LottoRank.RANK2);
        }
        if (count > 2) {
            addresult(LottoRank.values()[count-2]);
        }
    }

    private boolean checkBonusNumber(int i, int bonusNumber) {
        return this.lottos.get(i).getnumbers().contains(bonusNumber);
    }

    public void printResult(long money) {
        printFifth();
        printFourth();
        printThird();
        printSecond();
        printFirst();
        printRateOfReturn(money);
    }

    private void printFifth() {
        System.out.print("3개 일치 (5,000원) - ");
        System.out.println(results.get(LottoRank.RANK5) + "개");
        this.totalReward += results.get(LottoRank.RANK5) * 5000;
    }

    private void printFourth() {
        System.out.print("4개 일치 (50,000원) - ");
        System.out.println(results.get(LottoRank.RANK4) + "개");
        this.totalReward += results.get(LottoRank.RANK4) * 50000;
    }

    private void printThird() {
        System.out.print("5개 일치 (1,500,000원) - ");
        System.out.println(results.get(LottoRank.RANK3) + "개");
        this.totalReward += results.get(LottoRank.RANK3) * 1500000;
    }

    private void printSecond() {
        System.out.print("5개 일치, 보너스 볼 일치 (30,000,000원) - ");
        System.out.println(results.get(LottoRank.RANK2) + "개");
        this.totalReward += results.get(LottoRank.RANK2) * 30000000;
    }

    private void printFirst() {
        System.out.print("6개 일치 (2,000,000,000원) - ");
        System.out.println(results.get(LottoRank.RANK2) + "개");
        this.totalReward += results.get(LottoRank.RANK2) * 2000000000;
    }

    private void printRateOfReturn(long purchaseMoney) {
        System.out.println("총 수익률은 " + String.format("%.1f", (100 * this.totalReward / (double) purchaseMoney)) + "%입니다.");
    }
}
