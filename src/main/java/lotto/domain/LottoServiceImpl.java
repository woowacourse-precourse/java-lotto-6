package lotto.domain;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.util.Constants;
import lotto.util.RandomUtil;
import lotto.util.WinningCase;
import lotto.util.WinningResult;

public class LottoServiceImpl implements LottoService {

    private User user;

    @Override
    public void saveUser(int amount) {
        user = new User(amount);

        for (int i = 0; i < user.getCount(); i++) {
            List<Integer> lottoTicket = RandomUtil.getRandomDistinctIntegers(
                    Constants.LOTTO_NUMBER_MIN, Constants.LOTTO_NUMBER_MAX, Constants.LOTTO_NUMBER_COUNT);
            user.addLotto(new Lotto(lottoTicket));
        }
    }

    @Override
    public int getCount() {
        return user.getCount();
    }

    @Override
    public List<Lotto> getLottoTickets() {
        return user.getLottoTickets();
    }

    @Override
    public WinningResult checkWinningResult(int[] winningNumbers, int bonusNumber) {
        WinningResult winningResult = new WinningResult();

        for (Lotto ticket : user.getLottoTickets()) {
            WinningCase winningCase = ticket.confirmWin(winningNumbers, bonusNumber);
            if (winningCase == null) {
                continue;
            }
            winningResult.addCount(winningCase);
        }
        winningResult.setEarningRate(user.getAmount());

        return winningResult;
    }
}
