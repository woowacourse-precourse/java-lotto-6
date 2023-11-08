package lotto.domain;

import java.util.List;
import lotto.util.LottoUtil;

public class Customer {
private List<Lotto> lottos;
private int money;

public Customer(int money) {
    this.money = money;
}
public void buyLotto() {
    lottos = LottoUtil.generateMultiple(money / 1000);
}

public int[] getPlaceCount(Lotto answer, int bonus) {
    int[] placeCount = new int[7]; // index는 당첨 등수를 의미, 1~6까지만 사용
    for (Lotto lotto: lottos) {
        placeCount[lotto.getRank(answer, bonus)]++;
    }
    return placeCount;
}

public double getROI(Lotto answer, int bonus) {
    long prize = 0;
    for (Lotto lotto: lottos) {
        prize += lotto.getPrize(answer, bonus);
    }
    double ROI = prize * 100 / (double) money;
    return (double) Math.round(ROI*100) / 100;
}

public List<Lotto> getLottos() {
    return lottos;
}

}
