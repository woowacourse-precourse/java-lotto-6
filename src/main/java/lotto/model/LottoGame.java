package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.LottoRules;
import lotto.view.OutputView;

import java.util.*;

public class LottoGame {
    int lottoCount;
    int purchaseAmount;
    public Map<Integer, Integer> winningResult;

    private int START_NUMBER = LottoRules.START_NUMBER.getValue();
    private int END_NUMBER = LottoRules.END_NUMBER.getValue();
    private int LOTTO_NUMBER_COUNT = LottoRules.LOTTO_NUMBER_COUNT.getValue();
    List<Lotto> BunchOfLotto = new ArrayList<>();


    public LottoGame() {}
    public List<Lotto> getBunchOfLotto(){
        return this.BunchOfLotto;
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
            BunchOfLotto.add(new Lotto(LottoNumber));
        }
    }

    private List<Integer> generateRandomNumbersInOrder() {
        List<Integer> RandomNumbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, LOTTO_NUMBER_COUNT);
//        RandomNumbers.sort(Comparator.comparingInt(null));
//        Collections.sort(RandomNumbers);
        return RandomNumbers;
    }

    public void showLottos(){
        for(Lotto lotto : BunchOfLotto){
            System.out.println(lotto.getNumbers());
        }
    }
}
