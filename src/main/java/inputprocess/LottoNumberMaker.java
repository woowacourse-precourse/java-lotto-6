package inputprocess;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberMaker {
    public LottoNumberMaker() {lottoInput();}

    public List<List<Integer>> getPurchaseLotto() {
        return purchaseLotto;
    }

    int getLottoNumber = MoneyInput.money / 1000;
    List<List<Integer>> purchaseLotto = new ArrayList<>();

    private void lottoInput() {
        makeRandomNumebr();
    }

    private void makeRandomNumebr() {
        for (int i = 0 ; i < getLottoNumber; i++){
            List<Integer> randomNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(randomNumber);
            purchaseLotto.add(randomNumber);
        }
        printNumber();
    }

    private void printNumber() {
        for(List<Integer> oneLotte : purchaseLotto) {
            System.out.println(oneLotte);
        }
    }
}
