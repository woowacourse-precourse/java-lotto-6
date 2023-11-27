package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoNumberMaker;
import lotto.model.constants.LottoPrize;
import lotto.view.LottoInput;
import lotto.view.LottoOutput;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static lotto.model.constants.LottoPrize.*;

public class LottoController {
    private static final LottoNumberMaker lottoNumberMaker = new LottoNumberMaker();
    private static final LottoInput lottoInput = new LottoInput();
    private static final LottoOutput lottoOutput = new LottoOutput();
    public static void setPrice() {
        lottoNumberMaker.checkInt();
    }

//    static List<LottoPrize> LottoPrizelist= asList(FIFTH_PRIZE,FOURTH_PRIZE,THIRD_PRIZE,SECOND_PRIZE,FIRST_PRIZE);
    public static void setBuyLottoNumberPrint() {
        lottoOutput.buyLottoNumberPrint(lottoNumberMaker.getLottoNumber());
    }

    public static void setPrizeNumberInput() {
        Lotto lotto = new Lotto(lottoInput.prizeNumberInput());
        lotto.checkSame(lottoOutput.bonusNumberInput(),lottoNumberMaker.getLottoNumber());
    }

    public static void winningStatistic() {
        List<String> lottoPrizes = new ArrayList<>();
        for(LottoPrize lottoPrize: LottoPrize.values()){
            lottoPrizes.add(lottoPrize.getText()+lottoPrize.getWinCount()+lottoPrize.getUnit());
        }
        LottoOutput.seeWinningStatstic(lottoPrizes);
    }

    public String askPrice() {
        return lottoInput.askPrice();
    }
}
