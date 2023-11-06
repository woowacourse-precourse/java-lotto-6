package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoDto;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.WinnerLotto;

public class LottoWinnerService {

    private static final int BONUS_NUMBER_MATCHED = 1;
    private static final int BONUS_NUMBER_UNMATCHED = 0;

    public void checkWinner(LottoTicket lottoTicket, WinnerLotto winnerLotto) {
        List<Integer> rankResult = new ArrayList<>();
        LottoDto lottoDto;
        List<Integer> lottoDtoNumber;
        List<Integer> winner = winnerLotto.getWinnerLotto();

        for (Lotto lotto : lottoTicket.getLottoTicket()) {
            lottoDto = lotto.createDto();
            lottoDtoNumber = lottoDto.getNumbers();
            int bonusNumber = winnerLotto.getBonusNUmber();
            int matchNumberCount = countMatchNumber(lottoDtoNumber, winner);
            int bonusNumberMatch = checkBonusNumber(lottoDtoNumber, bonusNumber);
            int rank = checkRank(matchNumberCount, bonusNumberMatch);


        }

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

    private int checkRank(int matchNumberCount, int bonusNumberMatch) {
        if ()

    }


}
