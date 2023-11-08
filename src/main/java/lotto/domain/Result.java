package lotto.domain;

import lotto.dto.LottoResultDto;
import lotto.utility.enums.Standards;

import java.util.List;

public class Result {
    private int matchThreeWinningCount;
    private int matchFourWinningCount;
    private int matchFiveWinningCount;
    private int matchFiveWinningAndBonusCount;
    private int matchSixWinningCount;

    public Result(List<LottoResultDto> lottosResult) {
        resetCount();
        setWinningResult(lottosResult);
    }

    private void resetCount() {
        matchThreeWinningCount = 0;
        matchFourWinningCount = 0;
        matchFiveWinningCount = 0;
        matchFiveWinningAndBonusCount = 0;
        matchSixWinningCount = 0;
    }

    private void setWinningResult(List<LottoResultDto> lottosResult) {
        setWinningCount(lottosResult);
    }

    private void setWinningCount(List<LottoResultDto> lottosResult){
        for (LottoResultDto lottoResult : lottosResult) {
            checkWinningCount(lottoResult);
        }
    }

    private void checkWinningCount(LottoResultDto lottoResult) {
        if (lottoResult.getWinningNumberCount() == Standards.COUNT_THREE.getNumber()) {
            matchThreeWinningCount++;
            return;
        }
        if (lottoResult.getWinningNumberCount() == Standards.COUNT_FOUR.getNumber()) {
            matchFourWinningCount++;
            return;
        }
        if (lottoResult.getWinningNumberCount() == Standards.COUNT_FIVE.getNumber() && lottoResult.getIsBonusNumberCorrect()) {
            matchFiveWinningAndBonusCount++;
            return;
        }
        if (lottoResult.getWinningNumberCount() == Standards.COUNT_FIVE.getNumber()) {
            matchFiveWinningCount++;
            return;
        }
        if (lottoResult.getWinningNumberCount() == Standards.COUNT_SIX.getNumber()) {
            matchSixWinningCount++;
        }
    }
}
