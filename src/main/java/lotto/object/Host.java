package lotto.object;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Enums.WinningRanks;

import java.util.*;

public class Host {
    public static final Integer PURCHASEUNIT = 1000;

    private final List<Lotto> lottos = new ArrayList<>();
    private double totalReturn;

    public void lottoIssuance(User user) {
        System.out.println(user.getLottoPurchaseNumber() + "개를 구매했습니다.");
        for (int i = 0; i < user.getLottoPurchaseNumber(); i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lottoAscendingOrder(lotto));
            String lottos = String.join(",", lotto.getNumbers().toString());
            System.out.println(lottos);
        }
    }

    private static Lotto lottoAscendingOrder(Lotto lotto) {
        List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    public void winningStatistics(User user) {
        lottoNumberMatch(user);
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + WinningRanks.FIFTHPROFIT.getCount() + "개");
        System.out.println("4개 일치 (50,000원) - " + WinningRanks.FOURTHPROFIT.getCount() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + WinningRanks.THIRDPROFIT.getCount() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + WinningRanks.SECONDPROFIT.getCount() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + WinningRanks.FIRSTPROFIT.getCount() + "개");
        rateReturn(user);
    }

    private void rateReturn(User user) {
        String returnFormat = null;
        for (WinningRanks winningRanks : WinningRanks.values()) {
            totalReturn += winningRanks.getCount() * winningRanks.getAmount();
        }
        totalReturn /= (double) user.getPurchaseAmount();
        if (totalReturn < 1.0) {
            returnFormat = String.format("%.1f", totalReturn * 100);
        }
        if (totalReturn >= 1.0) {
            returnFormat = String.format("%,.1f", totalReturn);
        }
        System.out.println("총 수익률은 " + returnFormat + "%입니다.");
    }

    private void lottoNumberMatch(User user) {
        lottos.forEach(lotto -> {
            long count = lotto.getNumbers().stream().filter(user.getLottoWinningNumbers()::contains).count();
            long bonusCount = lotto.getNumbers().stream().filter(item -> item.equals(user.getBonusNumber())).count();
            if (count == 3)
                WinningRanks.FIFTHPROFIT.setCount(WinningRanks.FIFTHPROFIT.getCount() + 1);
            if (count == 4)
                WinningRanks.FOURTHPROFIT.setCount(WinningRanks.FOURTHPROFIT.getCount() + 1);
            if (count == 5 && bonusCount == 0)
                WinningRanks.THIRDPROFIT.setCount(WinningRanks.THIRDPROFIT.getCount() + 1);
            if (count == 5 && bonusCount == 1)
                WinningRanks.SECONDPROFIT.setCount(WinningRanks.SECONDPROFIT.getCount() + 1);
            if (count == 6)
                WinningRanks.FIRSTPROFIT.setCount(WinningRanks.FIRSTPROFIT.getCount() + 1);
        });
    }

    public double getTotalReturn() {
        return totalReturn;
    }
}
