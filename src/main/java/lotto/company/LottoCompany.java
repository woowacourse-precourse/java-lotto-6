package lotto.company;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.broadcaster.Broardcaster;

import java.util.*;

public class LottoCompany implements Company {
    private final Map<Integer, LotteryResult> lotteryResults;

    public LottoCompany() {
        this.lotteryResults = new HashMap<>();
    }

    @Override
    public List<Lotto> generateLottoList(int buyAmount) {
        List<Lotto> result = new ArrayList<>();
        for (int i = buyAmount; i > 0; i -= 1000) {
            Lotto lotto = new Lotto(new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
            Collections.sort(lotto.getNumbers());
            result.add(lotto);
        }
        return result;
    }

    @Override
    public void printLottoList(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        lottos.stream()
            .map(lotto -> lotto.getNumbers())
            .forEach(System.out::println);
        System.out.println();
    }

    @Override
    public LotteryResult getLotteryResult() {
        Broardcaster broardcaster = new Broardcaster();
        List<Integer> lotteryNumbers = broardcaster.pickLotteryNumbers();
        int bonusNumber = broardcaster.pickBonusNumber(lotteryNumbers);

        LotteryResult lotteryResult = LotteryResult.from(new Lotto(lotteryNumbers), bonusNumber);
        addLotteryResult(lotteryResult);
        return lotteryResult;
    }

    public void addLotteryResult(LotteryResult lotteryResult) {
        lotteryResults.put(lotteryResults.size() + 1, lotteryResult);
    }
}
