package lotto.service;

import lotto.domain.*;

import java.util.EnumMap;
import java.util.List;

public class LottoService {
    public User buyLottoTicket(int buyAmount) {
        Money money = new Money(buyAmount);
        LottoTicket lottoTicket = new LottoTicket(money.getNumberOfPurchase());
        User user = new User(money, lottoTicket);
        user.spendAllMoney();
        return user;
    }

    public EnumMap<LottoPrize, Integer> calculateLottoResult(User user, List<Integer> winningNumbers, int bonusNumber) {
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningNumbers, bonusNumber);
        List<Lotto> userLottoTicket = user.getLottoTicket();
        LottoResult lottoResult = new LottoResult(userLottoTicket, winningLottoNumbers);
        return lottoResult.getLottoResult();
    }
}