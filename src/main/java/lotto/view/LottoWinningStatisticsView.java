package lotto.view;

import lotto.constants.WinningAmountOfLottoFloat;
import lotto.constants.WinningAmountOfLottoString;
import lotto.constants.WinningLottoCount;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.nCopies;
import static lotto.constants.LottoNumberConstants.LOTTO_NUMBER_RANGE;
import static lotto.constants.LottoWinningResultConstants.*;
import static lotto.constants.NumberOfLottoPurchaseConstants.ONE_LOTTO_AMOUNT;

public class LottoWinningStatisticsView {
    private List<Integer> lottoStatisticsTable;
    private float lottoReturns;

    public LottoWinningStatisticsView() {
        this.lottoStatisticsTable = new ArrayList<>(nCopies(5, 0));
    }

    public void lottoStatisticsView(List<Integer> lottoStatistics) {
        lottoStatisticsInit(lottoStatistics);
        lottoStatistics();
        float purchaseMoney = lottoStatistics.size() * ONE_LOTTO_AMOUNT;
        DecimalFormat df = new DecimalFormat(SECOND_DECIMAL_PLACE);
        lottoReturns = lottoReturns / purchaseMoney * PERCENTAGE_FACTOR;
        System.out.printf(LOTTO_RETURNS, df.format(lottoReturns) + PERCENTAGE);
    }

    private void lottoStatisticsInit(List<Integer> lottoStatistics) {
        lottoReturns = 0;
        System.out.println(LOTTO_STATISTICS_INTERFACE);
        System.out.println(HYPHEN);
        for(Integer i : lottoStatistics) {
            oneLottoStatisticsResult(i);
            haveAdditionNumber(i);
            haveFullWinningNumber(i);
        }
    }

    private void oneLottoStatisticsResult(int index) {
        if (index >= MIN_LOTTO_WINNING_NUMBER_COUNT & index != LOTTO_NUMBER_RANGE) {
            int lastCount = lottoStatisticsTable.get(index - MIN_LOTTO_WINNING_NUMBER_COUNT);
            lottoStatisticsTable.set(index - MIN_LOTTO_WINNING_NUMBER_COUNT, lastCount + 1);
        }
    }

    private void haveAdditionNumber(int index) {
        if(index < 0){
            int lastCount = lottoStatisticsTable.get(ADDITION_NUMBER);
            lottoStatisticsTable.set(ADDITION_NUMBER, lastCount + 1);
        }
    }

    private void haveFullWinningNumber(int index){
        if(index == LOTTO_NUMBER_RANGE){
            int lastCount = lottoStatisticsTable.get(MAX_LOTTO_WINNING_NUMBER_INDEX);
            lottoStatisticsTable.set(MAX_LOTTO_WINNING_NUMBER_INDEX, lastCount + 1);
        }
    }

    private void lottoStatistics() {
        for(int i = 0; i < lottoStatisticsTable.size(); i++){
            System.out.printf(STATISTICS,
                    WinningLottoCount.returnWinningByString(i),
                    WinningAmountOfLottoString.returnDataByIndexString(i),
                    lottoStatisticsTable.get(i));
            lottoReturns += lottoStatisticsTable.get(i) * WinningAmountOfLottoFloat.returnDataByIndexFloat(i);
        }
    }
}