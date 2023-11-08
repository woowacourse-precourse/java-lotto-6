package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.domain.Lotteries;
import lotto.domain.LotteriesGenerator;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.domain.NumbersGeneratorStrategy;
import lotto.domain.Profit;
import lotto.domain.Rank;
import lotto.domain.UserLotto;
import lotto.input.Input;
import lotto.output.Output;

public class GameController {

    private int getNumber(final String inputMessage) {
        Output.print(inputMessage);
        try {
            return Input.getInteger();
        } catch (IllegalArgumentException e) {
            Output.print(e.getMessage());
            return getNumber(inputMessage);
        }
    }

    private List<Integer> getLottoNumbers() {
        Output.print(Output.LOTTO_NUMBERS_INPUT_MESSAGE);
        try {
            String readLine = Input.getLine();
            return Arrays.stream(readLine.split(","))
                    .map(Integer::parseInt)
                    .toList();
        } catch (IllegalArgumentException e) {
            Output.print("[ERROR] 정수와 쉼표만 입력해야 합니다.");
            return getLottoNumbers();
        }
    }

    public void play(final NumbersGeneratorStrategy numbersGeneratorStrategy) {
        Money money = getMoney();
        Lotteries lotteries = getLotteries(numbersGeneratorStrategy, money);
        UserLotto userLotto = UserLotto.from(getLotto(), getBonusLottoNumber());

        Map<Rank, Integer> rankIntegerMap = lotteries.calculateTotalRankCount(userLotto);
        Output.printWinningStatics(rankIntegerMap);

        Profit profit = Profit.from(money, lotteries);
        Output.printProfit(profit, userLotto);
    }

    private Money getMoney() {
        int purchaseAmount = getNumber(Output.PURCHASE_AMOUNT_INPUT_MESSAGE);
        return Money.from(purchaseAmount);
    }

    private Lotteries getLotteries(final NumbersGeneratorStrategy numbersGeneratorStrategy, final Money money) {
        LotteriesGenerator lotteriesGenerator = new LotteriesGenerator(numbersGeneratorStrategy);
        Lotteries lotteries = lotteriesGenerator.createByPurchaseCount(money.calculateLottoPurchaseCount());
        Output.printLotteries(lotteries);
        return lotteries;
    }

    private Lotto getLotto() {
        List<Integer> lottoNumbers = getLottoNumbers();
        return new Lotto(lottoNumbers);
    }

    private LottoNumber getBonusLottoNumber() {
        int bonusNumber = getNumber(Output.BONUS_LOTTO_NUMBER_INPUT_MESSAGE);
        return LottoNumber.valueOf(bonusNumber);
    }
}
