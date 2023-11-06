package lotto.service;

import java.util.List;
import lotto.config.Config;
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





}
