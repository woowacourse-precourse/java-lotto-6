package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.LottoResult;
import lotto.domain.User;
import lotto.domain.WinningNumber;

import java.util.List;

public class LottoService {

    private final User user;

    private final WinningNumber winningNumber;

    private final LottoResult lottoResult;

    public LottoService(User user, WinningNumber winningNumber, LottoResult lottoResult) {
        this.user = user;
        this.winningNumber = winningNumber;
        this.lottoResult = lottoResult;
    }

    public void buyLottoTickets() {
        user.inputMoney();
        user.createLottoTickets();
    }

    public int getTicketCount() {
        return user.getMoney() / 1000;
    }


    public List<Lotto> getLottoTickets() {
        return user.getLottoTickets();
    }


}
