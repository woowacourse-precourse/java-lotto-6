package lotto;

import lotto.LottoCheck;

import java.util.List;
import java.util.ArrayList;

import lotto.LottoGroup;
import lotto.Input;

public class Output {

    public void showLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void showLottoGroupNum(LottoGroup lottoGroup) {
        List<Lotto> lottoList = lottoGroup.getGroupLotto();
        for (int i = 0; i < lottoList.size(); i++) {
            List<Integer> lottoNum = lottoList.get(i).getNumbers();
            System.out.println(lottoNum);
        }

    }



    public void showLottoCheckPrice(LottoCheck lottoCheck, int userPrice) {
        LottoCheckResult lottoCheckResult = lottoCheck.getLottoCheckResult();
        double totalPrice = 5000 * lottoCheckResult.getThreeCount() + 50000 * lottoCheckResult.getFourCount() +
                1500000 * lottoCheckResult.getFiveCount() + 30000000 * lottoCheckResult.getFiveWithBonusCount()
                + 2000000000 * lottoCheckResult.getSixCount();
        double price = (1-((double) userPrice-totalPrice) / (double) (userPrice)) * 100;
        String priceRate = String.format("%.1f", price);
        System.out.println("총 수익률은 " + priceRate + "%입니다.");
    }
}
