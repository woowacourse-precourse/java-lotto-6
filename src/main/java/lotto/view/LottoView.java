package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.LottoFinalConsts;

public class LottoView implements LottoFinalConsts {

    public String inputLottoPurchase(){
        System.out.println(INPUT_LOTTO_PURCHASE);
        return Console.readLine();
    }

    public void printLottoPurchase(int lottoPurchase){
        System.out.printf("%d%s", lottoPurchase, PRINT_LOTTO_PURCHASE_COUNT);
    }
}
