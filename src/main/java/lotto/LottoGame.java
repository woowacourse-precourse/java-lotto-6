package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGame {
    Input input = new Input();
    Print print = new Print();
    int purchasePrice = 0;
    int lottoCount = 0;

    public void playLottoGame() {
        purchasePrice = input.inputPurchasePrice();
        getLottoCountByPurchasePrice(purchasePrice);
        getLottoNumbers(lottoCount);
    }

    private void getLottoCountByPurchasePrice(int price) {
        lottoCount = price / 1000;
        print.printLottoCount(lottoCount);
    }

    private void getLottoNumbers(int count) {
        while (count-- > 0) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            print.printLottoNumbers(lotto);
        }
    }
}
