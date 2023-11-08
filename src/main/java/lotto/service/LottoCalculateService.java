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
    private final OutputView outputView = new OutputView();
    private final HashMap<Winning, Integer> countOfWinning = new HashMap<>();

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

    public void countLottoWinning(User user, List<Integer> numbers, Lotto lotto) {
        int countContainsOfLottoWithoutBonus = countUserNumbersContainsLotto(numbers, lotto.getNumbers());
        if (isNumberMatchedNormal(countContainsOfLottoWithoutBonus)) {
            winLotto(countContainsOfLottoWithoutBonus, user);
            return;
        }
        if (isNumberMatchedFiveWithBonus(countContainsOfLottoWithoutBonus, numbers, lotto)) {
            winLotto(Constants.BONUS_ENUM_LABEL, user);
            return;
        }
        if (isNumberMatchedFive(countContainsOfLottoWithoutBonus, numbers, lotto)) {
            winLotto(countContainsOfLottoWithoutBonus, user);
            return;
        }
    }

    public void winLotto(int value, User user) {
        inputCountOfWinning(Winning.FIND.valueOf(value));
        user.addWinningPrice(Winning.FIND.valueOf(value).getPrice());
    }

    public int countUserNumbersContainsLotto(List<Integer> userNumbers, List<Integer> lottoNumbers) {
        int count = 0;
        for (int i = 0; i < Constants.BEFORE_BONUS_NUMBER_INDEX; i++) {
            if (userNumbers.contains(lottoNumbers.get(i))) {
                count++;
            }
        }
        return count;
    }

    public void inputCountOfWinning(Winning winning) {
        countOfWinning.put(winning, countOfWinning.getOrDefault(winning, 0) + 1);
    }

    public boolean isNumberMatchedNormal(int countContainsOfLotto) {
        if (countContainsOfLotto == Constants.THREE_NUMBER_MATCH || countContainsOfLotto == Constants.FOUR_NUMBER_MATCH
                || countContainsOfLotto == Constants.SIX_NUMBER_MATCH) {
            return true;
        }
        return false;
    }

    public boolean isNumberMatchedFiveWithBonus(int countContainsOfLotto, List<Integer> numbers, Lotto lotto) {
        if (countContainsOfLotto == Constants.FiVE_NUMBER_MATCH && numbers.contains(lotto.getBonusNumber())) {
            return true;
        }
        return false;
    }

    public boolean isNumberMatchedFive(int countContainsOfLotto, List<Integer> numbers, Lotto lotto) {
        if (countContainsOfLotto == Constants.FiVE_NUMBER_MATCH && !numbers.contains(lotto.getBonusNumber())) {
            return true;
        }
        return false;
    }
}
