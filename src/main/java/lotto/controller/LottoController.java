package lotto.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import lotto.config.ErrorMessages;
import lotto.config.LottoConfig;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoCost;
import lotto.domain.WinningNumber;
import lotto.service.LottoCompare;
import lotto.service.LottoGenerate;
import lotto.service.RewardChecker;
import lotto.service.ReturnRateCalculator;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {
    private final Input input = new Input();
    private final Output output = new Output();
    private final LottoGenerate lottoGenerate = new LottoGenerate();
    private final LottoCompare lottoCompare = new LottoCompare();
    private final RewardChecker rewardChecker = new RewardChecker();

    public void run() {
        LottoCost lottoCost = inputValueToLottoCost();
        int lottoTicket = lottoCost.getNumberOfLotto();
        output.printNumberOfPurchase(lottoTicket);

        HashMap<Integer, Lotto> lottoNumbers = lottoGenerate.createLottoRepeat(lottoTicket);
        printAllLotto(lottoNumbers);

        WinningNumber winningNumber = inputValueToWinningNumber();
        BonusNumber bonusNumber = inputValueToBonusNumber(winningNumber);
        HashMap<Integer, List<Integer>> compareLottoNumResult =
                lottoCompare.compareLottoToNumber(lottoNumbers, winningNumber, bonusNumber);

        printResult(rewardChecker.countLottoByPrize(compareLottoNumResult), lottoCost.getCost());
    }

    public void printResult(HashMap<String, Integer> countByPrize, int lottoCost) {
        System.out.println(output.printResultMessage());
        printFifthPrizeCount(countByPrize);
        printFourthPrizeCount(countByPrize);
        printThirdPrizeCount(countByPrize);
        printSecondPrizeCount(countByPrize);
        printFirstPrizeCount(countByPrize);
        printReturnRate(countByPrize, lottoCost);
    }

    private LottoCost inputValueToLottoCost() {
        LottoCost lottoCost = null;
        boolean loop = true;

        while (loop) {
            String cost = input.buyLotto();
            try {
                lottoCost = new LottoCost(toNumber(cost));
                loop = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return lottoCost;
    }

    private WinningNumber inputValueToWinningNumber() {
        WinningNumber winningNumber = null;
        boolean loop = true;

        while (loop) {
            List<String> inputWinningNumbers = Arrays.asList(input.winningNumbers().split(LottoConfig.SPLIT_SYMBOL));
            try {
                winningNumber = new WinningNumber(toNumber(inputWinningNumbers));
                loop = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return winningNumber;
    }

    private BonusNumber inputValueToBonusNumber(WinningNumber winningNumber) {
        BonusNumber lottoBonus = null;
        boolean loop = true;

        while (loop) {
            String inputBonusNumber = input.bonusNumber();
            try {
                int bonusNumber = toNumber(inputBonusNumber);
                lottoBonus = new BonusNumber(winningNumber, bonusNumber);
                loop = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return lottoBonus;
    }

    private int toNumber(String inputValue) {
        isNumber(inputValue);
        return Integer.parseInt(inputValue);
    }

    private List<Integer> toNumber(List<String> numbers) {
        isNumber(numbers);
        return numbers.stream().map(Integer::valueOf).toList();
    }

    private void isNumber(String number) {
        boolean hasOnlyNum = !number.isEmpty() && number.chars().allMatch(Character::isDigit);

        if (!hasOnlyNum) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_NOT_NUMBER.getMessage());
        }
    }

    private void isNumber(List<String> numbers) {
        boolean hasOnlyNum;

        for (String number : numbers) {
            hasOnlyNum = !number.isEmpty() && number.chars().allMatch(Character::isDigit);
            if (!hasOnlyNum) {
                throw new IllegalArgumentException(ErrorMessages.ERROR_NOT_NUMBER.getMessage());
            }
        }
    }

    private void printAllLotto(HashMap<Integer, Lotto> allLotto) {
        for (int key : allLotto.keySet()) {
            System.out.println(allLotto.get(key).getLotto());
        }
    }

    private void printReturnRate(HashMap<String, Integer> countByPrize, int lottoCost) {
        ReturnRateCalculator returnRateCalculator = new ReturnRateCalculator();

        System.out.printf(output.printReturnRate(), returnRateCalculator.getReturnRate(countByPrize, lottoCost));
    }

    private void printFirstPrizeCount(HashMap<String, Integer> countByPrize) {
        System.out.printf(output.printCompareLottoNumberResultExceptSecondPrize(),
                LottoConfig.FIRST_PRIZE_HAS_WINNING, LottoConfig.FIRST_PRIZE_REWARD,
                countByPrize.get(LottoConfig.FIRST_PRIZE_REWARD));
    }

    private void printSecondPrizeCount(HashMap<String, Integer> countByPrize) {
        System.out.printf(output.printCompareLottoNumberResultSecondPrize(),
                LottoConfig.SECOND_PRIZE_HAS_WINNING, LottoConfig.SECOND_PRIZE_REWARD,
                countByPrize.get(LottoConfig.SECOND_PRIZE_REWARD));
    }

    private void printThirdPrizeCount(HashMap<String, Integer> countByPrize) {
        System.out.printf(output.printCompareLottoNumberResultExceptSecondPrize(),
                LottoConfig.THIRD_PRIZE_HAS_WINNING, LottoConfig.THIRD_PRIZE_REWARD,
                countByPrize.get(LottoConfig.THIRD_PRIZE_REWARD));
    }

    private void printFourthPrizeCount(HashMap<String, Integer> countByPrize) {
        System.out.printf(output.printCompareLottoNumberResultExceptSecondPrize(),
                LottoConfig.FOURTH_PRIZE_HAS_WINNING, LottoConfig.FOURTH_PRIZE_REWARD,
                countByPrize.get(LottoConfig.FOURTH_PRIZE_REWARD));
    }

    private void printFifthPrizeCount(HashMap<String, Integer> countByPrize) {
        System.out.printf(output.printCompareLottoNumberResultExceptSecondPrize(),
                LottoConfig.FIFTH_PRIZE_HAS_WINNING, LottoConfig.FIFTH_PRIZE_REWARD,
                countByPrize.get(LottoConfig.FIFTH_PRIZE_REWARD));
    }
}
