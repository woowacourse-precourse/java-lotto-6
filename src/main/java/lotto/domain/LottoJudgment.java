package lotto.domain;

import java.util.LinkedList;
import java.util.List;

import static lotto.domain.NumberGenerator.createLottoNumber;
import static lotto.util.LottoConstant.LOTTO_PRICE;
import static lotto.view.OutputView.PURCHASE_AMOUNT;

public class LottoJudgment {

    private List<Lotto> lottoList;

    public LottoJudgment(int price) {
        lottoList = new LinkedList<>();
        int lottoCount = price / LOTTO_PRICE.getValue();

        System.out.printf(PURCHASE_AMOUNT.getMessage() , lottoCount);
        addLottoList(lottoCount);
        printLottoNumber();
    }

    private void addLottoList(int amount) {
        for(int i = 0; i < amount; i++) {
            Lotto lotto = createLottoNumber();

            lottoList.add(lotto);
        }
    }

    private void printLottoNumber() {
        for(Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }

}
