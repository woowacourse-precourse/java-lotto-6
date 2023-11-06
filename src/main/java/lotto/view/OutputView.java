package lotto.view;

import java.util.Arrays;
import lotto.Lotto;
import lotto.domain.dto.PurchasedLottoDTO;

public class OutputView {
    public static void printPurchasedLotto(PurchasedLottoDTO purchasedLottoDTO){
        System.out.println(purchasedLottoDTO.getPurchasedLotto().size() + "개를 구매했습니다.");
        for(Lotto lotto : purchasedLottoDTO.getPurchasedLotto()){
            System.out.println(Arrays.toString(lotto.getNumbers().toArray()));
        }
    }
}
