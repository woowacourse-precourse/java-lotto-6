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

        if (!validator.isMultipleOf(parsedNumber)) {
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
        List<Integer> matchResult = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            matchResult.add(0);
        }

        for (Lotto lottery : lotteries) {
            int matchCount = numbersMatcher.matches(lottery.getNumbers(), winningNumbers.getNumbers());

            if (matchCount == 6) {
                matchResult.add(0, matchResult.get(0) + 1);
                continue;
            }
            if (matchCount == 5 && lottery.getNumbers().contains(bonusNumber)) {
                matchResult.add(1, matchResult.get(1) + 1);
                continue;
            }
            if (matchCount == 5) {
                matchResult.add(2, matchResult.get(2) + 1);
                continue;
            }
            if (matchCount == 4) {
                matchResult.add(3, matchResult.get(3) + 1);
                continue;
            }
            if (matchCount == 3) {
                matchResult.add(4, matchResult.get(4) + 1);
            }
        }

        return matchResult;
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
        double ratio = (double) reward / payment * 10000;
        return toPercentage(ratio);
    }

    private double toPercentage(double ratio) {
        return Math.round(ratio) / 100.0;
    }
}
