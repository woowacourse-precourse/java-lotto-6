package lotto.domain.lotto;

import lotto.global.enums.LottoPrize;

public class LottoResultResponse {

    private LottoPrize lottoPrize;
    private Long winningCount;

    public static LottoResultResponse from(LottoPrize lottoPrize, Long winningCount){
        return new LottoResultResponse(lottoPrize, winningCount);
    }

    private LottoResultResponse(LottoPrize lottoPrize, Long winningCount){
        this.lottoPrize = lottoPrize;
        this.winningCount = winningCount;
    }

    @Override
    public String toString(){
        return this.lottoPrize.getViewMessage() + winningCount + "개";
    }

}
