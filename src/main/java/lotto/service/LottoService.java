package lotto.service;

import java.util.EnumMap;
import java.util.Map;
import lotto.constants.LottoRules;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoData;
import lotto.domain.User;
import lotto.domain.Winning;
import lotto.utils.NumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoService {
    private final NumberGenerator numberGenerator;
    private final Map<Winning, Integer> winningCounts = new EnumMap<>(Winning.class);

    public LottoService(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public LottoData generateWinningNumbers(Lotto winningNumbers, BonusNumber bonusNumber) {
        return new LottoData(winningNumbers, bonusNumber);
    }

    public void buyLottoTickets(User user) {
        int purchaseAmount = user.getPurchaseAmount().amount();
        int lottoCount = purchaseAmount / LottoRules.LOTTO_PRICE.getValue();

        IntStream.range(0, lottoCount)
                .forEach(i -> buySingleLottoTicket(user));
    }

    private void buySingleLottoTicket(User user) {
        Lotto lotto = generateRandomLotto();
        user.addLotto(lotto);
    }

    private Lotto generateRandomLotto() {
        List<Integer> lottoNumbers = new ArrayList<>(
                numberGenerator.generateNumbers(LottoRules.MIN_LOTTO_NUMBER.getValue(),
                        LottoRules.MAX_LOTTO_NUMBER.getValue(), LottoRules.LOTTO_NUMBER_COUNT.getValue()));
        return new Lotto(lottoNumbers);
    }

    private int countMatchingNumbers(LottoData lottoData, Lotto userLotto) {
        return calculateMatchCount(lottoData.winningNumbers(), userLotto);
    }

    private boolean hasBonusMatch(LottoData lottoData, Lotto userLotto) {
        return calculateBonusMatch(lottoData.bonusNumber(), userLotto);
    }

    private int calculateMatchCount(Lotto winningNumbers, Lotto userLotto) {
        List<Integer> winningNumbersList = winningNumbers.getNumbers();
        List<Integer> userLottoList = userLotto.getNumbers();
        return (int) userLottoList.stream().filter(winningNumbersList::contains).count();
    }

    public boolean calculateBonusMatch(BonusNumber bonusNumber, Lotto userLotto) {
        return bonusNumber.equals(userLotto.getNumbers());
    }

    public int calculateTotalPrize(Map<Winning, Integer> winningCounts) {
        int totalPrize = 0;

        for (Winning result : Winning.values()) {
            int count = winningCounts.getOrDefault(result, 0);
            int prize = result.getWinningAmount();
            totalPrize += count * prize;
        }

        return totalPrize;
    }

    public void checkWinningsForUserLottos(User user, LottoData lottoData) {
        for (Lotto userLotto : user.getLottos()) {
            Winning result = Winning.checkWinning(countMatchingNumbers(lottoData, userLotto),
                    hasBonusMatch(lottoData, userLotto));
            updateWinningCounts(result);
        }
    }

    private void updateWinningCounts(Winning result) {
        if (winningCounts.containsKey(result)) {
            winningCounts.put(result, winningCounts.get(result) + 1);
        } else {
            winningCounts.put(result, 1);
        }
    }

    public Map<Winning, Integer> getWinningCounts() {
        return winningCounts;
    }
}
