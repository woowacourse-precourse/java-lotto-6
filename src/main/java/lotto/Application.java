package lotto;

import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        int purchaseAmount = Input.getPurchaseAmount();
        Utils lottoUtils = new Utils();
        List<Lotto> lottoList = lottoUtils.getLotto(purchaseAmount);

        for(Lotto lotto : lottoList) {
            lotto.showLottoNumbers();
        }

        String arrayList[] = Input.getLottoNumbers();
        int bonusNumber = Input.getBonusNumber();
        lottoUtils.setLottoWinnerNumber(arrayList, bonusNumber);
        lottoUtils.whoWining(lottoList);
        lottoUtils.showWiningStatics(purchaseAmount);
    }
}