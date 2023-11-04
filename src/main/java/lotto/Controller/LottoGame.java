package lotto.Controller;

import java.util.ArrayList;
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
        int lottoQuantity = findLottoQuantity();
        User user = findUser(lottoQuantity);
        List<Integer> lottoWinningNumbers = findWinningNumbers();
        int bonusNumber = findBonusNumber();
        List<Rank> resultRanks = user.findAllResult(lottoWinningNumbers, bonusNumber);
        List<Integer> resultCount = user.countTotalResult(resultRanks);
        int resultPrize = user.TotalPrize(resultCount);
        OutputView.printResultHead();
        transmitOutput(resultCount);
        double profitRate = calculateProfitRate(lottoQuantity, resultPrize);
        OutputView.printProfitRate(profitRate);
    }

    private int findBonusNumber() {
        while (true) {
            try {
                String bonusInput = InputView.requestBonusNumber();
                int bonusNumber = Validator.validateParseInt(bonusInput);
                Validator.validateNumberRange(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
            	OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private List<Integer> findWinningNumbers() {
        while (true) {
            try {
                String input = InputView.requestWinningNumbers();
                Validator.validateLastComma(input);
                List<Integer> lottoWinningNumbers = Parser.parseWinningNumbers(input);
                Validator.valiateDuplicateNums(lottoWinningNumbers);
                Validator.validateSize(lottoWinningNumbers);
                Validator.validateNumbersRange(lottoWinningNumbers);
                return lottoWinningNumbers;
            } catch (IllegalArgumentException e) {
            	OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private int findLottoQuantity() {
        while (true) {
            try {
                String userInput = InputView.requestLottoPurchaseAmount();
                int lottoQuantity = calculateLottoQuantity(Parser.parsePurchaseAmount(userInput));
                OutputView.printPurchaseLottoAmount(lottoQuantity);
                return lottoQuantity;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private User findUser(int lottoQuantity) {
        User user;
        while (true) {		
            try {
                List<Lotto> lottos = makeLottos(lottoQuantity);
                user = new User(lottos);
                break;
            } catch (IllegalArgumentException e) {
            	OutputView.printErrorMessage(e.getMessage());
            }
        }
        return user;
    }

    private double calculateProfitRate(int lottoQuantity, int resultPrize) {
        return resultPrize / (lottoQuantity * 10.0);
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
                lottoSort(numbers);
                lottos.add(makeLotto(numbers));
                OutputView.printLottoNums(Parser.parseIntToString(numbers));
            } catch (IllegalArgumentException e) {
                i--;
            }
        }
        return lottos;
    }

    private void lottoSort(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                minSwap(numbers, i, j);
            }
        }
    }

    private void minSwap(List<Integer> numbers, int i, int j) {
        if (numbers.get(i) > numbers.get(j)) {
            int tmp = numbers.get(i);
            numbers.set(i, numbers.get(j));
            numbers.set(j, tmp);
        }
    }
}
