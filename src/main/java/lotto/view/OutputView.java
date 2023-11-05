package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoSet;

public class OutputView {
    private static final String LOTTO_NUM_MESSAGE = "\n%d개를 구매했습니다.\n";

    public static void outputLottoNum(int lottoNum){
        System.out.printf(LOTTO_NUM_MESSAGE, lottoNum);
    }

    public static void outputLottoSet(LottoSet lottoSet){
        for(Lotto lotto : lottoSet.getLottoSet()){
            System.out.println(lotto.getNumbers().toString());
        }
    }
}
