package lotto.service;

import lotto.Constants;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.domain.UserLotto;
import lotto.domain.Winning;
import lotto.view.OutputView;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

public class LottoCalculateService {
    private OutputView outputView = new OutputView();
    private HashMap<Winning, Integer> countOfWinning = new HashMap<>();

    public void calculateWinning(User user, Lotto lotto) {
        countLottoWinningCount(user, lotto);
        outputView.responseWinningHistory(countOfWinning);
        outputView.responseYieldOfLotto(getYieldOfLotto(user, user.getWinningPrice()));
    }

    public void countLottoWinningCount(User user, Lotto lotto) {
        List<UserLotto> userLottos = user.getLottos();
        userLottos.stream()
                .forEach(userLotto -> countLottoWinning(user, userLotto.getNumbers(), lotto));
    }

    public String getYieldOfLotto(User user, int totalPrice) {
        if (user.getBuyingPrice() == 0) {
            return "0.0";
        }
        DecimalFormat decimalFormat = new DecimalFormat(Constants.DECIMAL_FORMAT);
        return decimalFormat.format((double) totalPrice / user.getBuyingPrice() * 100);
    }

}
