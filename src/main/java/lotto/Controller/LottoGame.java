package lotto.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Parser;
import lotto.Domain.Lotto;
import lotto.Domain.Rank;
import lotto.Domain.User;
import lotto.Validator.Validator;
import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOW_NUMBER = 1;
    private static final int HIGH_NUMBER = 45;
    private static final int NUMBER_COUNT = 6;

    public void start() {
        while (true) {
            try {
                String userInput = InputView.requestLottoPurchaseAmount();
                int lottoQuantity = calculateLottoQuantity(Parser.parsePurchaseAmount(userInput));
                OutputView.printPurchaseLottoAmount(lottoQuantity);
                List<Lotto> lottos = makeLottos(lottoQuantity);
                User user = new User(lottos);
                System.out.println();
                String input = InputView.requestWinningNumbers();
                Validator.validateLastComma(input);
                List<Integer> lottoWinningNumbers = Parser.parseWinningNumbers(input);
                Validator.valiateDuplicateNums(lottoWinningNumbers);
                Validator.validateSize(lottoWinningNumbers);
                Validator.validateNumbersRange(lottoWinningNumbers);
                System.out.println();
                String bonusInput = InputView.requestBonusNumber();
                int bonusNumber = Validator.validateParseInt(bonusInput);
                Validator.validateNumberRange(bonusNumber);
                List<Rank> resultRanks = user.findAllResult(lottoWinningNumbers, bonusNumber);
                List<Integer> resultCount = user.countTotalResult(resultRanks);
                int resultPrize = user.TotalPrize(resultCount);
                OutputView.printResultHead();
                transmitOutput(resultCount);
                break;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    private void transmitOutput(List<Integer> resultCount) {
        Rank[] ranks = Rank.values();
        for (int i = 1; i < resultCount.size(); i++) {
            OutputView.printResult(ranks[i].getPrintString(), resultCount.get(i));
        }
    }

    private int calculateLottoQuantity(int purchaseAmount) {
        Validator.validateDivisibleBy1000(purchaseAmount);
        return purchaseAmount / LOTTO_PRICE;
    }

    private List<Integer> makeRandomNums() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOW_NUMBER, HIGH_NUMBER, NUMBER_COUNT);
        return numbers;
    }

    private Lotto makeLotto(List<Integer> numbers) {
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }

    private List<Lotto> makeLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            try {
                List<Integer> numbers = makeRandomNums();
                Validator.valiateDuplicateNums(numbers);
                Collections.sort(numbers);
                lottos.add(makeLotto(numbers));
                OutputView.printLottoNums(Parser.parseIntToString(numbers));
            } catch (IllegalArgumentException e) {
                i--;
            }
        }
        return lottos;
    }
}
