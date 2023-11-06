package lotto.service;

import java.util.List;
import lotto.config.Config;
import lotto.config.LottoRank;
import lotto.model.Lotto;
import lotto.model.User;

public class RankService {
    private final User user;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final int[] winningCount;

    public RankService(User user, List<Integer> winningNumbers, int bonusNumber) {
        this.user = user;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        winningCount = new int[Config.RANK_LOTTO];
    }


    public LottoRank calculateLottoRank(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        long matchingCount = lottoNumbers.stream().filter(winningNumbers::contains).count();
        LottoRank bonusWin = LottoRank.BONUS;

        for (int i = 0; i < Config.RANK_LOTTO; i++) {
            LottoRank rank = LottoRank.values()[i];
            if (matchingCount == rank.getMatchingNumbers()) {
                if (matchingCount == bonusWin.getMatchingNumbers() && lottoNumbers.contains(bonusNumber)) {
                    return bonusWin;
                }
                return rank;
            }
        }
        return null;
    }



}
