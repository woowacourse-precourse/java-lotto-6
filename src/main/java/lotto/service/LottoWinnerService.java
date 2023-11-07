package lotto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoDto;
import lotto.domain.lotto.LottoRank;
import lotto.domain.lotto.WinnerLotto;
import lotto.repository.LottoRepository;

public class LottoWinnerService {

    private static final int BONUS_NUMBER_MATCHED = 1;
    private static final int BONUS_NUMBER_UNMATCHED = 0;
    private static final int LOTTO_SIZE = 6;
    private final LottoRepository lottoRepository = LottoRepository.getInstance();

    public List<LottoRank> checkRanking(WinnerLotto winnerLotto) {
        List<LottoRank> rankResult = new ArrayList<>();
        List<Integer> winner = winnerLotto.getWinnerLotto();

        for (Lotto lotto : lottoRepository.getLottoTicket()) {
            LottoDto lottoDto = lotto.createDto();
            List<Integer> lottoDtoNumber = lottoDto.getNumbers();
            int bonusNumber = winnerLotto.getBonusNUmber();
            int matchNumberCount = countMatchNumber(lottoDtoNumber, winner);
            int bonusNumberMatch = checkBonusNumber(lottoDtoNumber, bonusNumber);
            LottoRank rank = checkRank(matchNumberCount, bonusNumberMatch);
            rankResult.add(rank);
        }
        return rankResult;
    }

    public Map<LottoRank, Integer> setLottoResult(List<LottoRank> rankResult) {
        Map<LottoRank, Integer> lottoResult = new LinkedHashMap<>(6);

        for (LottoRank lottoRank : LottoRank.values()) {
            int count = 0;
            count = Collections.frequency(rankResult, lottoRank);
            lottoResult.put(lottoRank, count);
        }
        return lottoResult;
    }

    private int countMatchNumber(List<Integer> lottoDtoNumber, List<Integer> winner) {
        int matchNumberCount = 0;

        for (int winnerIndex = 0; winnerIndex < LOTTO_SIZE; winnerIndex++) {
            matchNumberCount = isNumberMatched(lottoDtoNumber, winner.get(winnerIndex),
                matchNumberCount);
        }
        return matchNumberCount;
    }

    private int isNumberMatched(List<Integer> lottoDtoNumber, int winnerNumber,
        int matchNumberCount) {
        if (lottoDtoNumber.contains(winnerNumber)) {
            matchNumberCount++;
        }
        return matchNumberCount;
    }

    private int checkBonusNumber(List<Integer> lottoDtoNumber, int bonusNumber) {
        if (lottoDtoNumber.contains(bonusNumber)) {
            return BONUS_NUMBER_MATCHED;
        }
        return BONUS_NUMBER_UNMATCHED;
    }

    private LottoRank checkRank(int matchNumberCount, int bonusNumberMatch) {
        if (matchNumberCount < 3) {
            return LottoRank.LOSING;
        }
        if (matchNumberCount == 3) {
            return LottoRank.FIFTH;
        }
        if (matchNumberCount == 4) {
            return LottoRank.FOURTH;
        }
        if (matchNumberCount == 5 && bonusNumberMatch == BONUS_NUMBER_UNMATCHED) {
            return LottoRank.THIRD;
        }
        if (matchNumberCount == 5 && bonusNumberMatch == BONUS_NUMBER_MATCHED) {
            return LottoRank.SECOND;
        }
        if (matchNumberCount == 6) {
            return LottoRank.FIRST;
        }
        return LottoRank.LOSING;
    }
}
