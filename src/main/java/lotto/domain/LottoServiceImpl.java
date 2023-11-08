package lotto.domain;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.util.RandomUtil;
import lotto.util.WinningResult;

public class LottoServiceImpl implements LottoService {

    static final int LOTTO_NUMBER_MIN = 1;
    static final int LOTTO_NUMBER_MAX = 45;
    static final int LOTTO_NUMBER_COUNT = 6;

    private User user;

    @Override
    public void saveUser(int amount) {
        user = new User(amount);

        for (int i = 0; i < user.getCount(); i++) {
            List<Integer> lottoTicket = RandomUtil.getRandomDistinctIntegers(
                    LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_COUNT);
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
    public List<WinningResult> checkWinningResult() {
        return null;
    }

    @Override
    public double checkEarningRate(List<WinningResult> results) {
        return 0;
    }
}
