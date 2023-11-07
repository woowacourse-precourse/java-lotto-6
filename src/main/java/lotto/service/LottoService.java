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

    public LottoData setWinningNumbers(Lotto winningNumbers, BonusNumber bonusNumber) {
        return new LottoData(winningNumbers, bonusNumber);
    }

    public void buyLottoAll(User user) {
        int purchaseAmount = user.getPurchaseAmount().amount();
        int lottoCount = purchaseAmount / LottoRules.LOTTO_PRICE.getValue();

        IntStream.range(0, lottoCount)
                .forEach(i -> buyLottoOne(user));
    }

    private void buyLottoOne(User user) {
        Lotto lotto = generateLottoNumber();
        user.addLotto(lotto);
    }

    private Lotto generateLottoNumber() {
        List<Integer> lottoNumbers = new ArrayList<>(
                numberGenerator.generateNumbers(LottoRules.MIN_LOTTO_NUMBER.getValue(),
                        LottoRules.MAX_LOTTO_NUMBER.getValue(), LottoRules.LOTTO_NUMBER_COUNT.getValue()));
        return new Lotto(lottoNumbers);
    }

    public Winning checkWinning(LottoData lottoData, Lotto userLotto) {
        int matchCount = calculateMatchCount(lottoData.winningNumbers(), userLotto);
        boolean bonusMatch = calculateBonusMatch(lottoData.bonusNumber(), userLotto);

        if (matchCount == 6) {
            return Winning.SIXTH;
        }
        if (matchCount == 5 && bonusMatch) {
            return Winning.FIFTH_BONUS;
        }
        if (matchCount == 5) {
            return Winning.FIFTH;
        }
        if (matchCount == 4) {
            return Winning.FOURTH;
        }
        if (matchCount == 3) {
            return Winning.THIRD;
        }
        return Winning.DEFAULT;
    }

    private int calculateMatchCount(Lotto winningNumbers, Lotto userLotto) {
        List<Integer> winningNumbersList = winningNumbers.getNumbers();
        List<Integer> userLottoList = userLotto.getNumbers();
        return (int) userLottoList.stream().filter(winningNumbersList::contains).count();
    }

    public boolean calculateBonusMatch(BonusNumber bonusNumber, Lotto userLotto) {
        return bonusNumber.equals(userLotto.getNumbers());
    }

    public void checkWinningsForUserLottos(User user, LottoData lottoData) {
        for (Lotto userLotto : user.getLottos()) {
            Winning result = checkWinning(lottoData, userLotto);
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