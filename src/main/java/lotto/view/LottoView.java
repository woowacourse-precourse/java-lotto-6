package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.LottoFinalConsts;
import lotto.domain.Lotto;

import java.util.List;

public class LottoView implements LottoFinalConsts {

    public String inputLottoPurchase(){
        System.out.println(INPUT_LOTTO_PURCHASE);
        return Console.readLine();
    }

    public void printLottoPurchase(int lottoPurchase){
        System.out.printf("%d%s", lottoPurchase, PRINT_LOTTO_PURCHASE_COUNT);
    }

    public void printPublishedLotto(List<Lotto> lottos){
        for (Lotto lotto:lottos) {
            System.out.println(lotto.toString());
        }
    }

    public String inputLottoWinningNumber(){
        System.out.println(INPUT_WIN_LOTTO);
        return Console.readLine();
    }

    public String inputLottoBonusNumber(){
        System.out.println(INPUT_BONUS_LOTTO);
        return Console.readLine();
    }
}
