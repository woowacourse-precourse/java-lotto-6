package lotto.view;

import lotto.Lotto;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.constants.LottoNumberConstants.LOTTO_NUMBER_RANGE;
import static lotto.constants.NumberOfLottoPurchaseConstants.*;

public class NumberOfLottoPurchaseView {
    public String lottoPurchaseInterface() {
        System.out.println(PURCHASEVIEW);
        return readLine();
    }

    public void lottoPurchasedResult(List<Lotto> purchasedLotto){
        System.out.printf(PURCHASERESULTVIEW, purchasedLotto.size());
        lottoNumberView(purchasedLotto);
    }

    private void lottoNumberView(List<Lotto> purchasedLotto) {
        for (Lotto lotto : purchasedLotto)
            oneLottoNumberView(lotto);
    }

    private void oneLottoNumberView(Lotto oneLotto) {
        List<Integer> numbers = oneLotto.oneLottoNumberCopy();
        System.out.print(LEFT_BRACKET);
        for (int i = 0; i < LOTTO_NUMBER_RANGE; i++) {
            System.out.print(numbers.get(i));
            if (i < LOTTO_NUMBER_RANGE - 1) {
                System.out.print(COMMA + BLANK);
            }
        }
        System.out.println(RIGHT_BRACKET);
    }
}
