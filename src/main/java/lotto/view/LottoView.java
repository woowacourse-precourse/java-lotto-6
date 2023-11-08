package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.LottoFinalConsts;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;

import java.util.HashMap;
import java.util.Iterator;
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

    public void printTotalResults(HashMap<LottoRank, Integer> lottoRanks, String lottoReturnRate){
        List<LottoRank> lottoRankEnums = List.of(LottoRank.values());
        for (LottoRank lottoRank:lottoRankEnums){
            printLottoResult(lottoRanks, lottoRank);
        }
        System.out.printf(LOTTO_RETURN_RATE_PRINT, lottoReturnRate);
    }

    public void printLottoResult(HashMap<LottoRank, Integer> lottoRanks, LottoRank lottoRank){
        if (!lottoRanks.keySet().contains(lottoRank)){
            System.out.printf(lottoRank.getLottoResultPrint(), 0);
        } else if (lottoRanks.keySet().contains(lottoRank)){
            System.out.printf(lottoRank.getLottoResultPrint(), lottoRanks.get(lottoRank));
        }
    }
}
