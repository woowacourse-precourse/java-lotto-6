package lotto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoDto;
import lotto.domain.lotto.LottoRank;
import lotto.domain.lotto.WinnerLotto;
import lotto.repository.LottoRepository;

public class LottoWinnerService {

    private static final int BONUS_NUMBER_MATCHED = 1;
    private static final int BONUS_NUMBER_UNMATCHED = 0;
    private final LottoRepository lottoRepository = LottoRepository.getInstance();

    //lottoRepository를 싱글톤 , getInstance
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

    public HashMap<LottoRank, Integer> setLottoResult(List<LottoRank> rankResult) {
        int first = Collections.frequency(rankResult, LottoRank.FIRST);
        int second = Collections.frequency(rankResult, LottoRank.SECOND);
        int third = Collections.frequency(rankResult, LottoRank.THIRD);
        int fourth = Collections.frequency(rankResult, LottoRank.FOURTH);
        int fifth = Collections.frequency(rankResult, LottoRank.FIFTH);
        HashMap<LottoRank, Integer> lottoResult = new HashMap<>();

        lottoResult.put(LottoRank.FIRST, first);
        lottoResult.put(LottoRank.SECOND, second);
        lottoResult.put(LottoRank.THIRD, third);
        lottoResult.put(LottoRank.FOURTH, fourth);
        lottoResult.put(LottoRank.FIFTH, fifth);
        return lottoResult;
    }

    private int countMatchNumber(List<Integer> lottoDtoNumber, List<Integer> winner) {
        lottoDtoNumber.retainAll(winner);
        return lottoDtoNumber.size();
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
