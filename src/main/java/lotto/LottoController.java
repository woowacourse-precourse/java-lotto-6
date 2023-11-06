package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LottoController {
    private List<Integer> lotteryNumber = new ArrayList<>();
    private int bonusNumber;
    private final List<Lotto> lottos = new ArrayList<>();
    private final LottoViewer lottoViewer;
    private double profit;

    public LottoController(LottoViewer lottoViewer) {
        this.lottoViewer = lottoViewer;
    }

    public void startLottery(){
        int lottoCnt = lottoViewer.getMoney();
        generateLottos(lottoCnt);
        lottoViewer.printLottos(lottos);
        lotteryNumber = lottoViewer.getLotteryNumbers();
        bonusNumber = lottoViewer.getBonus();

        // TODO : 결과를 계산하는 로직 추가하기.

        lottoViewer.printLottoResult();
        lottoViewer.printProfitResult(profit);
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
