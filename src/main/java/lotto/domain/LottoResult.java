package lotto.domain;

import java.util.List;
import lotto.domain.repository.BonusNumberRepository;
import lotto.domain.repository.LottoRepository;
import lotto.domain.repository.LottoResultRepository;
import lotto.domain.repository.WinningLottoRepository;
import lotto.util.Util;
import lotto.util.enums.LottoRank;

public class LottoResult {
    private static final int MATCH_THREE = 3;
    private static final int MATCH_FOUR = 4;
    private static final int MATCH_FIVE = 5;
    private static final int MATCH_SIX = 6;

    public void compare() {
        List<Integer> winningNumbers = WinningLottoRepository.findWinningNumbers();
        for (Lotto lotto : LottoRepository.lotties()) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            int match = compareWithOneLotto(lottoNumbers, winningNumbers);
            saveWinningResult(match, lottoNumbers);
        }
    }

    private int compareWithOneLotto(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int match = 0; // 숫자 일치 개수
        for (int number : lottoNumbers) {
            if (isMatch(number, winningNumbers)) {
                match++;
            }
        }
        return match;
    }

    // 카운트 3개 이상 -> winningResults 추가
    private void saveWinningResult(int match, List<Integer> lottoNumbers) {
        switch (match) {
            case MATCH_THREE -> LottoResultRepository.add(LottoRank.FIFTH);
            case MATCH_FOUR -> LottoResultRepository.add(LottoRank.FOURTH);
            case MATCH_FIVE -> compareWithBonusNumber(lottoNumbers);
            case MATCH_SIX -> LottoResultRepository.add(LottoRank.FIRST);
        }
    }

    private boolean isMatch(int number, List<Integer> winningNumbers) {
        for (Integer winning : winningNumbers) {
            if (Util.isEqual(number, winning)) {
                return true;
            }
        }
        return false;
    }

    private void compareWithBonusNumber(List<Integer> lottoNumbers) {
        if (isMatchWithBonusNumber(lottoNumbers)) {
            LottoResultRepository.add(LottoRank.SECOND);
            return;
        }
        LottoResultRepository.add(LottoRank.THIRD);
    }

    private boolean isMatchWithBonusNumber(List<Integer> numbers) {
        int bonus = BonusNumberRepository.findBonusNumber();
        for (int number : numbers) {
            if (Util.isEqual(number, bonus)) {
                return true;
            }
        }
        return false;
    }
}
