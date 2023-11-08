package lotto.view;

import static lotto.constant.ViewConstant.BONUS_LOTTO_RESULT_MENT;
import static lotto.constant.ViewConstant.ENTER;
import static lotto.constant.ViewConstant.INFORM_LOTTO_PURCHASE_MENT;
import static lotto.constant.ViewConstant.INFORM_TOTAL_YIELD_MENT;
import static lotto.constant.ViewConstant.NORMAL_LOTTO_RESULT_MENT;
import static lotto.constant.ViewConstant.NUMBER_FORMAT;
import static lotto.constant.ViewConstant.WINNING_STATISTICS;
import static lotto.domain.Rank.SECOND;

import java.text.DecimalFormat;
import java.util.Map.Entry;
import java.util.StringJoiner;
import lotto.domain.Rank;
import lotto.domain.WinningLottoTable;
import lotto.dto.LottoBundleDto;

public class OutputView {

    public void printLottoCnt(long lottoCnt) {
        System.out.printf(INFORM_LOTTO_PURCHASE_MENT, lottoCnt);
    }

    public void printLotteries(LottoBundleDto lottoBundleDto) {
        System.out.println(createLotteriesFormat(lottoBundleDto));
    }

    private StringJoiner createLotteriesFormat(LottoBundleDto lottoBundleDto) {
        StringJoiner lotteriesFormat = new StringJoiner(ENTER);
        lottoBundleDto.getLotteries().stream().map(Object::toString).forEach(lotteriesFormat::add);
        return lotteriesFormat;
    }

    public void printWinnerStatisticsMent() {
        System.out.println(WINNING_STATISTICS);
    }

    public void printLottoResult(WinningLottoTable winningLottoTable) {

        for (Entry<Rank, Integer> rankTable : winningLottoTable.getRankTable().entrySet()) {
            SingleLottoResult singleLottoResult = getSingleLottoResult(rankTable);
            if (printBonusResult(singleLottoResult)) {
                continue;
            }
            printNormalResult(singleLottoResult);
        }
    }

    private SingleLottoResult getSingleLottoResult(Entry<Rank, Integer> rankTable) {
        DecimalFormat lotteryWinningsFormat = new DecimalFormat(NUMBER_FORMAT);
        return new SingleLottoResult(rankTable.getKey(), rankTable.getKey().getCountOfMatch(),
                lotteryWinningsFormat.format(rankTable.getKey().getLotteryWinnings()), rankTable.getValue());
    }

    private boolean printBonusResult(SingleLottoResult singleLottoResult) {
        if (isSecond(singleLottoResult)) {
            System.out.printf(BONUS_LOTTO_RESULT_MENT, singleLottoResult.countOfMatch(), singleLottoResult.lotteryWinnings(),
                    singleLottoResult.numberOfRanks());
            return true;
        }
        return false;
    }

    private boolean isSecond(SingleLottoResult singleLottoResult) {
        return singleLottoResult.rank() == SECOND;
    }

    private void printNormalResult(SingleLottoResult singleLottoResult) {
        System.out.printf(NORMAL_LOTTO_RESULT_MENT, singleLottoResult.countOfMatch(), singleLottoResult.lotteryWinnings(),
                singleLottoResult.numberOfRanks());
    }

    public void printTotalYield(String yield) {
        System.out.printf(INFORM_TOTAL_YIELD_MENT, yield);
    }
}
