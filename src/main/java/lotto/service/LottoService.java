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

    private int bonusNumber;
    private final int[] winningCount;

    public LottoService() {
        winningCount = new int[Config.RANK_LOTTO];
    }

    public int initMoneyToCount(String inputMoney) {
        int money = Validator.isNumber(inputMoney);
        return Validator.isDivide(money);
    }

    public void initUser(int count) {
        user = new User(count, makeRandomLottos(count));
    }


    private List<Lotto> makeRandomLottos(int count) {
        List<Lotto> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = makeRandomLotto();
            lottoNumbers.add(lotto);
        }

        return lottoNumbers;
    }

    private Lotto makeRandomLotto() {
        List<Integer> randomNumbers = sorting(RandomUtil.getRandomUniqueNumbers());
        return new Lotto(randomNumbers);
    }

    private List<Integer> sorting(List<Integer> randomUniqueNumbers) {
        List<Integer> sortedNumbers = new ArrayList<>(randomUniqueNumbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
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


    public void initBonusNumber(int number) {
        List<Integer> lottoNumbers = winningLotto.getNumbers();
        Validator.isDuplicatedBonus(lottoNumbers, number);

        bonusNumber = number;
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

    private LottoRank calculateLottoRank(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningLotto.getNumbers();

        long matchingCount = calculateMatchingCount(lottoNumbers, winningNumbers);

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

    private long calculateMatchingCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        return lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private boolean isBonusWin(long matchingCount, List<Integer> lottoNumbers, int bonusNumber) {
        LottoRank bonusWin = LottoRank.BONUS;
        return matchingCount == bonusWin.getMatchingNumbers() && lottoNumbers.contains(bonusNumber);
    }

    public BigDecimal rateOfReturn() {
        BigDecimal totalPrize = caculateTotalPrize();
        BigDecimal totalSpent = calculateTotalSpent();

        return calculateRateOfReturn(totalPrize, totalSpent);
    }

    private BigDecimal caculateTotalPrize() {
        BigDecimal sum = BigDecimal.ZERO;
        for (LottoRank rank : LottoRank.values()) {
            int count = winningCount[rank.getRank()];
            BigDecimal rankMoney = BigDecimal.valueOf(rank.getMoney());
            sum = sum.add(rankMoney.multiply(BigDecimal.valueOf(count)));
        }
        return sum;
    }

    private BigDecimal calculateTotalSpent() {
        int totalLottoCount = user.getCount();
        BigDecimal totalSpent = BigDecimal.valueOf(totalLottoCount * Config.PRICE_UNIT);
        return totalSpent;
    }

    private BigDecimal calculateRateOfReturn(BigDecimal totalPrize, BigDecimal totalSpent) {
        BigDecimal result = totalPrize.multiply(BigDecimal.valueOf(Config.PERCENT))
                .divide(totalSpent, 1, RoundingMode.HALF_UP);

        return result;
    }


}
