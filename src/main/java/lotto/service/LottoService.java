package lotto.service;

import lotto.Lotto;

import java.util.List;

public interface LottoService {
    int parsePayment(String input);

    Lotto parseWinningNumbers(String input);

    int parseBonusNumber(String input, Lotto winningLotto);

    List<Integer> lotteryMatch(List<Lotto> lotteries, Lotto winningLotto, int bonusNumber);

    int calculateReward(List<Integer> matchResult);

    Lotto generatePurchasedLottery();

    double getRateOfReturn(int payment, int reward);
}
