package lotto.view;

import lotto.constants.WinningAmountOfLottoFloat;
import lotto.constants.WinningAmountOfLottoString;
import lotto.constants.WinningLottoCount;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.nCopies;
import static lotto.constants.LottoWinningResultConstants.*;

public class LottoWinningStatisticsView {
    private List<Integer> lottoStatisticsTable;
    private float lottoReturns;

    public LottoWinningStatisticsView() {
        this.lottoStatisticsTable = new ArrayList<>(nCopies(5, 0));
    }

    public void lottoStatisticsView(List<Integer> lottoStatistics) {
        lottoStatisticsInit(lottoStatistics);
        lottoStatistics();
        float purchaseMoney = lottoStatistics.size() * 1000;
        lottoReturns = lottoReturns / purchaseMoney;
        System.out.printf(LOTTO_RETURNS, lottoReturns * 100);
    }

    private void lottoStatisticsInit(List<Integer> lottoStatistics) {
        lottoReturns = 0;
        System.out.println(LOTTO_STATISTICS_INTERFACE);
        System.out.println(HYPHEN);
        for(Integer i : lottoStatistics) {
            oneLottoStatisticsResult(i);
            haveAdditionNumber(i);
        }
    }

    private void oneLottoStatisticsResult(int index) {
        if (index - 3 >= 0) {
            int lastCount = lottoStatisticsTable.get(index - 3);
            lottoStatisticsTable.set(index - 3, lastCount + 1);
        }
    }

    private void haveAdditionNumber(int index) {
        if(index < 0){
            int lastCount = lottoStatisticsTable.get(ADDITION_NUMBER);
            lottoStatisticsTable.set(ADDITION_NUMBER, lastCount + 1);
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