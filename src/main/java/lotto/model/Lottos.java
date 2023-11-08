package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.LottoRules;
import lotto.view.OutputView;

import java.util.*;

public class Lottos {
    int lottoCount;
    int purchaseAmount;
    public Map<Integer, Integer> winningResult;

    int lottoNumberCount = LottoRules.LOTTO_NUMBER_COUNT.getValue();
    int startNumber = LottoRules.START_NUMBER.getValue();
    int endNumber = LottoRules.END_NUMBER.getValue();
    List<Lotto> lottos = new ArrayList<>();


    public Lottos() {}
    public List<Lotto> getLottos(){
        return this.lottos;
    }

    public Map<Integer, Integer>  getWinningResult(){
        return this.winningResult;
    }

    public void setWinningResult(Map<Integer, Integer> lottoResultCount){
        this.winningResult = lottoResultCount;
    }

    public int getPurchaseAmount(){
        return this.purchaseAmount;
    }

    public void payForLottoGame(){
        PurchaseAmount purchaseAmount = new PurchaseAmount();
        purchaseAmount.generateLottoCount();
        this.lottoCount = purchaseAmount.purchaseCount;
        this.purchaseAmount = purchaseAmount.purchaseAmount;
    }

    public void issueLottos() {
        OutputView.printBuyLottoCount(lottoCount);
        generateLottos(lottoCount);
    }

    private void generateLottos(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> LottoNumber = generateRandomNumbersInOrder();
            lottos.add(new Lotto(LottoNumber));
        }
    }

    private List<Integer> generateRandomNumbersInOrder() {
        List<Integer> RandomNumbers = new ArrayList<>();

        for (int i = 0; i < lottoNumberCount; i++) {
            RandomNumbers.add(pickUniqueNumber(RandomNumbers));
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

    public void showLottos(){
        for(Lotto lotto : lottos){
            System.out.println(lotto.getNumbers());
        }
    }
}
