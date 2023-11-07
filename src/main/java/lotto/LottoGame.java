package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {
    Input input = new Input();
    Print print = new Print();
    Lottos lottos;
    int purchasePrice = 0;
    int lottoCount = 0;

    public void playLottoGame() {
        purchasePrice = input.inputPurchasePrice();
        getLottoCountByPurchasePrice(purchasePrice);
        lottos = getLottoNumbers(lottoCount);
    }

    private void getLottoCountByPurchasePrice(int price) {
        lottoCount = price / 1000;
        print.printLottoCount(lottoCount);
    }

    private Lottos getLottoNumbers(int count) {
        List<Lotto> lottos = new ArrayList<>();
        while (count-- > 0) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            print.printLottoNumbers(lotto);
            lottos.add(lotto);
        }
        return new Lottos(lottos);
    }
}
