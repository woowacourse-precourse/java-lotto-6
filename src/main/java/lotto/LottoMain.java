package lotto;

import lotto.Domain.*;
import lotto.Util.PrintUserLotto;

public class LottoMain {
    private final LottoPurchase lottoPurchase = new LottoPurchase();
    private final LottoWinningNumber lottoWinningNumber = new LottoWinningNumber();

    public void start(){
        try {
            LottoPurchase userLottoPurchase = lottoPurchase.userInputPurchase();
            LottoWinningNumber userWinningNumber = lottoWinningNumber.getWinningNumberResult();
            LottoResult lottoResult = new LottoResult(userWinningNumber);
            lottoResult.getLottoList(userLottoPurchase.getLottoNumber(), userLottoPurchase.getLottoPrice());

        }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
        }
    }
}
