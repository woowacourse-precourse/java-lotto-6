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
    public GetLottoResultDto getLottoResult(final GetWinningNumberDto getWinningNumberDto,
                                            final GetBonusNumberDto getBonusNumberDto,
                                            final GetLottosDto getLottosDto) {

        return getGetLottoCalculatedResultDto(getWinningNumberDto, getBonusNumberDto, getLottosDto, getCorrectionCheck());
    }

    private static GetLottoResultDto getGetLottoCalculatedResultDto(final GetWinningNumberDto getWinningNumberDto,
                                                                    final GetBonusNumberDto getBonusNumberDto,
                                                                    final GetLottosDto getLottosDto,
                                                                    final int[] correctionCheck) {
        matchingNumbersIteration(getWinningNumberDto, getBonusNumberDto, getLottosDto, correctionCheck);
        return new GetLottoResultDto(
                correctionCheck[THREE],
                correctionCheck[FOUR],
                correctionCheck[FIVE],
                correctionCheck[SEVEN],
                correctionCheck[SIX]
        );
    }

    private static void matchingNumbersIteration(final GetWinningNumberDto getWinningNumberDto, final GetBonusNumberDto getBonusNumberDto,
                                  GetLottosDto getLottosDto, int[] correctionCheck) {
        for(Lotto lotto: getLottosDto.getLottos()){
            int hits = getHits(getWinningNumberDto, lotto);
            checkBonusNumber(getBonusNumberDto, correctionCheck, lotto, hits);
            correctionCheck[hits]++;
        }
    }

    private static void checkBonusNumber(final GetBonusNumberDto getBonusNumberDto, final int[] correctionCheck, final Lotto lotto, final int hits) {
        if(isBonusNumberCheck(getBonusNumberDto, lotto, hits)){
            correctionCheck[SEVEN]++;
        }
    }

    private static boolean isBonusNumberCheck(final GetBonusNumberDto getBonusNumberDto, final Lotto lotto, final int hits) {
        return hasBonusNumber(getBonusNumberDto, lotto) && isFIVE(hits);
    }

    private static boolean isFIVE(final int hits) {
        return hits == FIVE;
    }

    private static boolean hasBonusNumber(final GetBonusNumberDto getBonusNumberDto, final Lotto lotto) {
        return lotto.lotto().contains(getBonusNumberDto.getBonusNumber());
    }

    private static int getHits(final GetWinningNumberDto getWinningNumberDto, final Lotto lotto) {
        int hits = ZERO;
        hits = getHits(getWinningNumberDto, lotto, hits);
        return hits;
    }

    private static int getHits(final GetWinningNumberDto getWinningNumberDto, final Lotto lotto, int hits) {
        for (int num: lotto.lotto()){
            hits = checkHits(isContained(getWinningNumberDto.getWinningNumbers(), num), hits);
        }
        return hits;
    }

    private static int checkHits(final boolean isContained, int hits) {
        if (isContained) {
            hits++;
        }
        return hits;
    }

    private static boolean isContained(final List<Integer> getWinningNumberDto, final int num) {
        return getWinningNumberDto.contains(num);
    }

    private static int[] getCorrectionCheck() {
        return new int[EIGHT];
    }
}
