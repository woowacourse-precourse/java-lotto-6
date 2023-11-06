package lotto.view;

import java.util.List;
import lotto.constants.LottoMsg;

public class OutView {

    public void randomLottoOutView(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public void lottoPriceView(int divisionLottoPrice) {
        System.out.println(String.format(LottoMsg.LOTTO_PRICE_COUNT.getMsg(), divisionLottoPrice));
    }
}
