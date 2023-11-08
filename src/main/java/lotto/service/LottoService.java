package lotto.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.config.Config;
import lotto.config.LottoRank;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.util.RandomUtil;
import lotto.util.Validator;


public class LottoService {

    public User user;
    private Lotto winningLotto;
    private final int[] winningCount;

    public LottoService() {
        winningCount = new int[Config.RANK_LOTTO];
    }

    public int initMoneyToCount(String inputMoney) {
        int money = Validator.isNumber(inputMoney);
        return Validator.isDivide(money);
    }

    public void initUser(int count) {
        user = new User(count, makeRandomLotto(count));
    }

    private List<Integer> sorting(List<Integer> randomUniqueNumbers) {
        List<Integer> sortedNumbers = new ArrayList<>(randomUniqueNumbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    private List<Lotto> makeRandomLotto(int count) {
        List<Lotto> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> randomNumbers = sorting(RandomUtil.getRandomUniqueNumbers());
            lottoNumbers.add(new Lotto(randomNumbers));
        }

        return lottoNumbers;
    }

    public void initWinningNumbers(List<Integer> winningNumbers) {
        winningLotto = new Lotto(winningNumbers);
    }

    public List<Integer> parseAndValidateWinningNumbers(String inputWinningNumbers) {
        String[] inputNumbers = inputWinningNumbers.split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        for (String inputNumber : inputNumbers) {
            int num = Validator.validateSingleNumber(inputNumber);
            winningNumbers.add(num);
        }

        return winningNumbers;
    }


    public void initBonusNumber(String inputBonusNumber) {
        int num = Validator.validateSingleNumber(inputBonusNumber);

        List<Integer> lottoNumbers = winningLotto.getNumbers();
        Validator.isDuplicatedBonus(lottoNumbers, num);
        lottoNumbers.add(num);
    }

    public int[] calculateLottoRanks() {
        for (Lotto lotto : user.getLottos()) {
            LottoRank rank = calculateLottoRank(lotto);
            if (rank != null) {
                winningCount[rank.getRank()] += 1;
            }
        }
        return winningCount;
    }

    public LottoRank calculateLottoRank(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningLotto.getNumbers();

        int bonusNumber = winningNumbers.get(winningNumbers.size() - 1);

        long matchingCount = calculateMatchingCount(lottoNumbers, winningNumbers, bonusNumber);

        if (isBonusWin(matchingCount, lottoNumbers, bonusNumber)) {
            return LottoRank.BONUS;
        }

        for (LottoRank rank : LottoRank.values()) {
            if (matchingCount == rank.getMatchingNumbers()) {
                return rank;
            }
        }
        return null;
    }

    private long calculateMatchingCount(List<Integer> lottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        return lottoNumbers.stream()
                .filter(number -> number != bonusNumber)
                .filter(winningNumbers.subList(0, winningNumbers.size() - 1)::contains)
                .count();
    }

    private boolean isBonusWin(long matchingCount, List<Integer> lottoNumbers, int bonusNumber) {
        LottoRank bonusWin = LottoRank.BONUS;
        return matchingCount == bonusWin.getMatchingNumbers() && lottoNumbers.contains(bonusNumber);
    }

    public BigDecimal rateOfReturn() {
        BigDecimal sum = BigDecimal.ZERO;
        BigDecimal totalSpent = BigDecimal.valueOf(user.getCount() * Config.PRICE_UNIT);

        for (LottoRank rank : LottoRank.values()) {
            int count = winningCount[rank.getRank()];
            BigDecimal rankMoney = BigDecimal.valueOf(rank.getMoney());
            sum = sum.add(rankMoney.multiply(BigDecimal.valueOf(count)));
        }

        BigDecimal result = sum.multiply(BigDecimal.valueOf(Config.PERCENT))
                .divide(totalSpent, 1, RoundingMode.HALF_UP);

        return result;
    }


}
