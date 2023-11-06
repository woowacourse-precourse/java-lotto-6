package lotto.service.resultcheck;

import java.util.List;
import lotto.domain.Lotto;
import lotto.dto.result.GetLottoResultDto;
import lotto.dto.domain.lottos.GetLottosDto;
import lotto.dto.input.GetBonusNumberDto;
import lotto.dto.input.GetWinningNumberDto;

public class LottoResultCheck implements ResultCheck {
    private static final int EIGHT = 8;
    private static final int SEVEN = 7;
    private static final int SIX = 6;
    private static final int FIVE = 5;
    private static final int FOUR = 4;
    private static final int THREE = 3;
    private static final int ZERO = 0;
    @Override
    public GetLottoResultDto getLottoResult(GetWinningNumberDto getWinningNumberDto,
                                            GetBonusNumberDto getBonusNumberDto,
                                            GetLottosDto getLottosDto) {

        return getGetLottoCalculatedResultDto(getWinningNumberDto, getBonusNumberDto, getLottosDto, getCorrectionCheck());
    }

    private static GetLottoResultDto getGetLottoCalculatedResultDto(GetWinningNumberDto getWinningNumberDto,
                                                                    GetBonusNumberDto getBonusNumberDto,
                                                                    GetLottosDto getLottosDto,
                                                                    int[] correctionCheck) {
        matchingNumbersIteration(getWinningNumberDto, getBonusNumberDto, getLottosDto, correctionCheck);
        return new GetLottoResultDto(
                correctionCheck[THREE],
                correctionCheck[FOUR],
                correctionCheck[FIVE],
                correctionCheck[SEVEN],
                correctionCheck[SIX]
        );
    }

    private static void matchingNumbersIteration(GetWinningNumberDto getWinningNumberDto, GetBonusNumberDto getBonusNumberDto,
                                  GetLottosDto getLottosDto, int[] correctionCheck) {
        for(Lotto lotto: getLottosDto.getLottos()){
            int hits = getHits(getWinningNumberDto, lotto);
            checkBonusNumber(getBonusNumberDto, correctionCheck, lotto, hits);
            correctionCheck[hits]++;
        }
    }

    private static void checkBonusNumber(GetBonusNumberDto getBonusNumberDto, int[] correctionCheck, Lotto lotto, int hits) {
        if(isBonusNumberCheck(getBonusNumberDto, lotto, hits)){
            correctionCheck[SEVEN]++;
        }
    }

    private static boolean isBonusNumberCheck(GetBonusNumberDto getBonusNumberDto, Lotto lotto, int hits) {
        return hasBonusNumber(getBonusNumberDto, lotto) && isFIVE(hits);
    }

    private static boolean isFIVE(int hits) {
        return hits == FIVE;
    }

    private static boolean hasBonusNumber(GetBonusNumberDto getBonusNumberDto, Lotto lotto) {
        return lotto.lotto().contains(getBonusNumberDto.getBonusNumber());
    }

    private static int getHits(GetWinningNumberDto getWinningNumberDto, Lotto lotto) {
        int hits = ZERO;
        hits = getHits(getWinningNumberDto, lotto, hits);
        return hits;
    }

    private static int getHits(GetWinningNumberDto getWinningNumberDto, Lotto lotto, int hits) {
        for (int num: lotto.lotto()){
            hits = checkHits(isContained(getWinningNumberDto.getWinningNumbers(), num), hits);
        }
        return hits;
    }

    private static int checkHits(boolean isContained, int hits) {
        if (isContained) {
            hits++;
        }
        return hits;
    }

    private static boolean isContained(List<Integer> getWinningNumberDto, int num) {
        return getWinningNumberDto.contains(num);
    }

    private static int[] getCorrectionCheck() {
        return new int[EIGHT];
    }
}
