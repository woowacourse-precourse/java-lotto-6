package lotto.service;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoDrawingMachine;
import lotto.domain.Player;
import lotto.domain.Ranking;
import lotto.view.OutputView;

public class LottoCalculateService {
    private static final int BONUS_ENUM_IDX = 7;
    private static final int BEFORE_BONUS_NUMBER_INDEX = 6;
    private static final String DECIMAL_FORMAT = "###,##0.0";
    private Map<Ranking, Integer> countOfWinning = new HashMap<>();

    public void calculateWinning(Player player, LottoDrawingMachine lotto) {
        countLottoWinningCount(player, lotto);
        OutputView.printWinningHistory(countOfWinning);
        OutputView.responseYieldOfLotto(getYieldOfLotto(player, player.getWinningPrice()));
    }

    private void countLottoWinningCount(Player player, LottoDrawingMachine lotto) {
        List<Lotto> playerTicketLotto = player.getLottoTicket();
        playerTicketLotto
                .stream()
                .forEach(userLotto -> countLottoWinning(player, userLotto.getNumbers(), lotto));
    }

    private void countLottoWinning(Player player, List<Integer> numbers,  LottoDrawingMachine lotto) {
        int countContainsOfLottoWithoutBonus = countPlayerNumbersContainLotto(numbers, lotto.getLotto().getNumbers());
        if (isNumberMatchedNormal(countContainsOfLottoWithoutBonus)) {
            winLotto(countContainsOfLottoWithoutBonus, player);
            return;
        }
        if (isNumberMatchedFiveWithBonus(countContainsOfLottoWithoutBonus, numbers, lotto)) {
            winLotto(BONUS_ENUM_IDX, player);
            return;
        }
        if (isNumberMatchedFive(countContainsOfLottoWithoutBonus, numbers, lotto)) {
            winLotto(countContainsOfLottoWithoutBonus, player);
            return;
        }
    }

    private void winLotto(int value, Player player) {
        putValues(Ranking.FIND.valueOf(value));
        player.addWinningPrice(Ranking.FIND.valueOf(value).getPrice());
    }

    private int countPlayerNumbersContainLotto(List<Integer> userNumbers, List<Integer> lottoNumbers) {
        int count = 0;
        for (int i = 0; i < BEFORE_BONUS_NUMBER_INDEX; i++) {
            if (userNumbers.contains(lottoNumbers.get(i))) {
                count++;
            }
        }
        return count;
    }

    private void putValues(Ranking ranking) {
        countOfWinning.put(ranking, countOfWinning.getOrDefault(ranking, 0) + 1);
    }

    private boolean isNumberMatchedNormal(int countContainsOfLotto) {
        if (countContainsOfLotto == Ranking.FIFTH.getMatchedCount()
                || countContainsOfLotto == Ranking.FOURTH.getMatchedCount()
                || countContainsOfLotto == Ranking.FIRST.getMatchedCount()) {
            return true;
        }
        return false;
    }

    private boolean isNumberMatchedFiveWithBonus(int countContainsOfLotto, List<Integer> numbers, LottoDrawingMachine lotto) {
        if (countContainsOfLotto == Ranking.THIRD.getMatchedCount() && numbers.contains(lotto.getLottoBonusBall())) {
            return true;
        }
        return false;
    }

    private boolean isNumberMatchedFive(int countContainsOfLotto, List<Integer> numbers, LottoDrawingMachine lotto) {
        if (countContainsOfLotto == Ranking.THIRD.getMatchedCount() && !numbers.contains(lotto.getLottoBonusBall())) {
            return true;
        }
        return false;
    }

    private String getYieldOfLotto(Player player, int totalPrice) {
        if (player.getPlayerBuyPrice() == 0) {
            return "0.0";
        }
        DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_FORMAT);
        return decimalFormat.format((double) totalPrice / player.getPlayerBuyPrice() * 100);
    }
}