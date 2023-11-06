package lotto.service;

import lotto.enums.ErrorMessage;
import lotto.Lotto;
import lotto.enums.Rank;
import lotto.util.lottoFactory.LottoFactory;
import lotto.util.matcher.NumbersMatcher;
import lotto.util.parser.NumberParser;
import lotto.util.validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class LottoServiceImpl implements LottoService {
    private static final String DELIMITER = ",";

    public LottoServiceImpl(
            LottoFactory lottoFactory,
            Validator validator,
            NumberParser numberParser,
            NumbersMatcher numbersMatcher
    ) {
        this.lottoFactory = lottoFactory;
        this.validator = validator;
        this.numberParser = numberParser;
        this.numbersMatcher = numbersMatcher;
    }

    private final LottoFactory lottoFactory;
    private final Validator validator;
    private final NumberParser numberParser;
    private final NumbersMatcher numbersMatcher;


    @Override
    public int parsePayment(String input) {
        int parsedNumber = numberParser.parse(input);

        if (!validator.isMultiple(parsedNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PAYMENT.getMessage());
        }

        return parsedNumber;
    }

    @Override
    public Lotto parseWinningNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();

        for (String number : input.split(DELIMITER)) {
            int parsedNumber = numberParser.parse(number);

            if (!validator.isInRange(parsedNumber)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage());
            }

            numbers.add(parsedNumber);
        }

        return lottoFactory.generateLotto(numbers);
    }

    @Override
    public int parseBonusNumber(String input, Lotto winningNumbers) {
        int parsedNumber = numberParser.parse(input);

        if (!validator.isInRange(parsedNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage());
        }

        if (winningNumbers.getNumbers().contains(parsedNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_LOTTO_NUMBERS.getMessage());
        }

        return parsedNumber;
    }

    @Override
    public List<Integer> lotteryMatch(List<Lotto> lotteries, Lotto winningNumbers, int bonusNumber) {
        List<Integer> matchResult = initMatchResult();

        for (Lotto lottery : lotteries) {
            int matchCount = numbersMatcher.matches(lottery.getNumbers(), winningNumbers.getNumbers());
            updateMatchResult(matchResult, lottery.getNumbers(), matchCount, bonusNumber);
        }

        return matchResult;
    }

    private List<Integer> initMatchResult() {
        List<Integer> matchResult = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            matchResult.add(0);
        }

        return matchResult;
    }

    private void updateMatchResult(List<Integer> matchResult, List<Integer> purchasedLottery, int matchCount, int bonusNumber) {
        if (matchCount == 6) {
            matchResult.set(0, matchResult.get(0) + 1);
            return;
        }

        if (matchCount == 5 && purchasedLottery.contains(bonusNumber)) {
            matchResult.set(1, matchResult.get(1) + 1);
            return;
        }

        if (matchCount <= 5 && matchCount >= 3) {
            matchResult.set(7 - matchCount, matchResult.get(7 - matchCount) + 1);
        }
    }

    @Override
    public int calculateReward(List<Integer> matchResult) {
        int reward = 0;
        Rank[] ranks = Rank.values();

        for (int i = 0; i < ranks.length; i++) {
            reward = reward + matchResult.get(i) * ranks[i].getReward();
        }

        return reward;
    }

    @Override
    public Lotto generatePurchasedLottery() {
        return lottoFactory.generateLotto();
    }

    @Override
    public double getRateOfReturn(int payment, int reward) {
        double ratio = (double) reward / payment * 1000;
        return Math.round(ratio) / 10.0;
    }
}
