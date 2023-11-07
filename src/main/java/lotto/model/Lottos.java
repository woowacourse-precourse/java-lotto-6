package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.LottoRules;
import lotto.view.OutputView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class Lottos {
    int lottoCount;

    int lottoNumberCount = LottoRules.LOTTO_NUMBER_COUNT.getValue();
    int startNumber = LottoRules.START_NUMBER.getValue();
    int endNumber = LottoRules.END_NUMBER.getValue();
    List<Lotto> lottos = new ArrayList<>();


    public Lottos() {}

    public void payForLottoGame(){
        PurchaseAmount purchaseAmount = new PurchaseAmount();
        purchaseAmount.generateLottoCount();
        this.lottoCount = purchaseAmount.purchaseCount;
    }

    public void howManyLottos() {
        OutputView.printBuyLottoCount(lottoCount);
        issueLottos(lottoCount);
    }

    private void issueLottos(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> LottoNumber = generateRandomNumbersInOrder();
            System.out.println(LottoNumber);
            lottos.add(new Lotto(generateRandomNumbersInOrder()));
        }
    }

    private List<Integer> generateRandomNumbersInOrder() {
        List<Integer> RandomNumbers = new ArrayList<>();

        for (int i = 0; i < lottoNumberCount; i++) {
            int uniqueNumber = pickUniqueNumber(RandomNumbers);
            RandomNumbers.add(uniqueNumber);
        }
        Collections.sort(RandomNumbers);
        return RandomNumbers;
    }

    private int pickUniqueNumber(List<Integer> RandomNumbers) {
        int number = Randoms.pickNumberInRange(startNumber, endNumber);
        while (!isUnique(number, RandomNumbers)) {
            number = Randoms.pickNumberInRange(startNumber, endNumber);
        }
        return number;
    }

    public boolean isUnique(int number, List<Integer> RandomNumbers) {
        for (int randomNumber : RandomNumbers) {
            if (randomNumber == number) {
                return false;
            }
        }
        return true;
    }

}
