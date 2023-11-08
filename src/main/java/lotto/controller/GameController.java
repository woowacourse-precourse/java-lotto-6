package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotteries;
import lotto.domain.LotteriesGenerator;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.domain.NumbersGeneratorStrategy;
import lotto.domain.Profit;
import lotto.domain.Rank;
import lotto.domain.UserLotto;
import lotto.input.Input;
import lotto.output.Output;
import lotto.utils.IntegerParser;

public class GameController {
    private static final String COMMA = ",";

    public void play(final NumbersGeneratorStrategy numbersGeneratorStrategy) {
        Money money = getMoney();
        Lotteries lotteries = getLotteries(numbersGeneratorStrategy, money);
        Lotto lotto = getLotto();
        UserLotto userLotto = getUserLotto(lotto);

        Map<Rank, Integer> rankIntegerMap = lotteries.calculateTotalRankCount(userLotto);
        Output.printWinningStatics(rankIntegerMap);

        Profit profit = Profit.from(money, lotteries);
        Output.printProfit(profit, userLotto);
    }

    private Money getMoney() {
        Output.printMoneyInputMessage();
        try {
            Integer purchaseAmount = Input.getInteger();
            return Money.from(purchaseAmount);
        } catch (IllegalArgumentException e) {
            Output.print(e.getMessage());
            return getMoney();
        }
    }

    private Lotteries getLotteries(final NumbersGeneratorStrategy numbersGeneratorStrategy, final Money money) {
        LotteriesGenerator lotteriesGenerator = new LotteriesGenerator(numbersGeneratorStrategy);
        Lotteries lotteries = lotteriesGenerator.createByPurchaseCount(money);
        Output.printLotteries(lotteries);
        return lotteries;
    }

    private Lotto getLotto() {
        Output.printLottoNumbersInputMessage();
        try {
            String readLine = Input.getLine();
            List<Integer> lottoNumbers = Arrays.stream(readLine.split(COMMA))
                    .map(IntegerParser::stringToInteger)
                    .toList();
            return new Lotto(lottoNumbers);
        } catch (IllegalArgumentException e) {
            Output.print(e.getMessage());
            return getLotto();
        }
    }

    private UserLotto getUserLotto(final Lotto lotto) {
        Output.printBonusLottoNumberInputMessage();
        try {
            int bonusNumber = Input.getInteger();
            LottoNumber bonusLottoNumber = LottoNumber.valueOf(bonusNumber);
            return UserLotto.from(lotto, bonusLottoNumber);
        } catch (IllegalArgumentException e) {
            Output.print(e.getMessage());
            return getUserLotto(lotto);
        }
    }
}
