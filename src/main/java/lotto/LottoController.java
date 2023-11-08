package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.variables.LottoVariables;

import java.util.*;

public class LottoController {
    private List<Integer> lotteryNumber = new ArrayList<>();
    private int bonusNumber;
    private final List<Lotto> lottos = new ArrayList<>();
    private final LottoViewer lottoViewer;

    private Map<Integer, Integer> lotteryResult = new HashMap<>();
    private double profit;

    public LottoController(LottoViewer lottoViewer) {
        this.lottoViewer = lottoViewer;
    }

    public void startLottery(){
        int lottoMoney = lottoViewer.getMoney();
        generateLottos(lottoMoney / 1000);
        lottoViewer.printLottos(lottos);
        lotteryNumber = lottoViewer.getLotteryNumbers();
        bonusNumber = lottoViewer.getBonus();

        initLotteryResult();
        countLottery();
        calcProfit(lottoMoney);

        lottoViewer.printLottoResult(lotteryResult);
        lottoViewer.printProfitResult(profit);
    }

    private void calcProfit(int lottoMoney) {
        int sum = 0;
        for(LottoVariables lottoVariables: LottoVariables.values()) sum += calcProfit(lottoVariables);

        profit = sum / lottoMoney;
    }

    private int calcProfit(LottoVariables lottoVariables) {
        return lotteryResult.get(lottoVariables.getPrice()) * lottoVariables.getPrice();
    }

    private void initLotteryResult() {
        for(LottoVariables lottoVariables: LottoVariables.values()) lotteryResult.put(lottoVariables.getPrice(), 0);
    }

    private void countLottery(){
        for (Lotto lotto: lottos) checkLottery(lotto);
    }

    private void checkLottery(Lotto lotto) {
        if (lotto.countLottery(lotteryNumber) == 6) lotteryResult.put(LottoVariables.LOTTO_FIRST.getPrice(), lotteryResult.get(LottoVariables.LOTTO_FIRST.getPrice()) + 1);

        if (lotto.countLottery(lotteryNumber) == 5 && lotto.hasBonusNumber(bonusNumber)) lotteryResult.put(LottoVariables.LOTTO_SECOND.getPrice(), lotteryResult.get(LottoVariables.LOTTO_SECOND.getPrice()) + 1);

        if (lotto.countLottery(lotteryNumber) == 5 && !lotto.hasBonusNumber(bonusNumber)) lotteryResult.put(LottoVariables.LOTTO_THIRD.getPrice(), lotteryResult.get(LottoVariables.LOTTO_THIRD.getPrice()) + 1);

        if (lotto.countLottery(lotteryNumber) == 4) lotteryResult.put(LottoVariables.LOTTO_FOURTH.getPrice(), lotteryResult.get(LottoVariables.LOTTO_FOURTH.getPrice()) + 1);

        if (lotto.countLottery(lotteryNumber) == 3) lotteryResult.put(LottoVariables.LOTTO_FIFTH.getPrice(), lotteryResult.get(LottoVariables.LOTTO_FIFTH.getPrice()) + 1);
    }

    private void generateLottos(int lottoCnt) {
        for(int i = 0; i < lottoCnt; i++) generateLottos();
    }

    private void generateLottos() {
        List<Integer> tmp = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(tmp);
        lottos.add(new Lotto(tmp));
    }
}
