package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoCost;
import lotto.domain.WinningNumber;

public class LottoController {
    private final Input input = new Input();
    private final Output output = new Output();

    public void run() {
        LottoCost lottoCost = inputValueToLottoCost();
        int lottoTicket = lottoCost.getNumberOfLotto();
        output.printNumberOfPurchase(lottoTicket);

        LottoGenerate lottoGenerate = new LottoGenerate();
        HashMap<Integer, Lotto> lottoNumbers = lottoGenerate.createLottoRepeat(lottoTicket);
        printAllLotto(lottoNumbers);

        WinningNumber winningNumber = inputValueToWinningNumber();
        BonusNumber bonusNumber = inputValueToBonusNumber(winningNumber);
        HashMap<Integer, List<Integer>> compareLottoNumResult =
                compareLottoToNumber(lottoNumbers, winningNumber, bonusNumber);

        printResult(checkRewardByLotto(compareLottoNumResult), lottoCost.getCost());
    }

    private void printAllLotto(HashMap<Integer, Lotto> allLotto) {
        for (int key : allLotto.keySet()) {
            System.out.println(allLotto.get(key).getLotto());
        }
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
                System.err.println(e.getMessage());
            }
        }

        return lottoCost;
    }

    private int toNumber(String inputValue) {
        isNumber(inputValue);
        return Integer.parseInt(inputValue);
    }

    private void isNumber(String number) {
        boolean hasOnlyNum = !number.isEmpty() && number.chars().allMatch(Character::isDigit);

        if (!hasOnlyNum) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_NOT_NUMBER.getMessage());
        }
    }

    private WinningNumber inputValueToWinningNumber() {
        WinningNumber winningNumber = null;
        boolean loop = true;

        while (loop) {
            List<String> inputWinningNumbers = Arrays.asList(input.winningNumbers().split(LottoConfig.SPLIT_SYMBOL));
            try {
                isNumber(inputWinningNumbers);
                Lotto lotto = new Lotto(inputWinningNumbers.stream().map(Integer::valueOf).toList());
                winningNumber = new WinningNumber(lotto);
                loop = false;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }

        return winningNumber;
    }

    public void isNumber(List<String> numbers) {
        boolean hasOnlyNum;

        for (String number : numbers) {
            hasOnlyNum = !number.isEmpty() && number.chars().allMatch(Character::isDigit);
            if (!hasOnlyNum) {
                throw new IllegalArgumentException(ErrorMessages.ERROR_NOT_NUMBER.getMessage());
            }
        }
    }

    private BonusNumber inputValueToBonusNumber(WinningNumber winningNumber) {
        BonusNumber lottoBonus = null;
        boolean loop = true;

        while (loop) {
            String inputBonusNumber = input.bonusNumber();
            try {
                int bonusNumber = toNumber(inputBonusNumber);
                checkBonusNumberInWinningNumber(winningNumber.getWinningNumber(), bonusNumber);
                lottoBonus = new BonusNumber(bonusNumber);
                loop = false;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }

        return lottoBonus;
    }

    private void checkBonusNumberInWinningNumber(List<Integer> winingNumber, int bonusNumber) {
        if (winingNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }

    private void printResult(HashMap<String, Integer> countByPrize, int lottoCost) {
        System.out.println(output.printResultMessage());
        printFifthPrizeCount(countByPrize);
        printFourthPrizeCount(countByPrize);
        printThirdPrizeCount(countByPrize);
        printSecondPrizeCount(countByPrize);
        printFirstPrizeCount(countByPrize);
        printReturnRate(countByPrize, lottoCost);
    }

    private void printReturnRate(HashMap<String, Integer> countByPrize, int lottoCost) {
        System.out.printf(output.printReturnRate(), getReturnRate(countByPrize, lottoCost));
    }

    private float getReturnRate(HashMap<String, Integer> countByPrize, int lottoCost) {
        int totalFirstReward = rewardToNumber(LottoConfig.FIRST_PRIZE_REWARD)
                * countByPrize.get(LottoConfig.FIRST_PRIZE_REWARD);
        int totalSecondReward = rewardToNumber(LottoConfig.SECOND_PRIZE_REWARD)
                * countByPrize.get(LottoConfig.SECOND_PRIZE_REWARD);
        int totalThirdReward = rewardToNumber(LottoConfig.THIRD_PRIZE_REWARD)
                * countByPrize.get(LottoConfig.THIRD_PRIZE_REWARD);
        int totalFourthReward = rewardToNumber(LottoConfig.FOURTH_PRIZE_REWARD)
                * countByPrize.get(LottoConfig.FOURTH_PRIZE_REWARD);
        int totalFifthReward = rewardToNumber(LottoConfig.FIFTH_PRIZE_REWARD)
                * countByPrize.get(LottoConfig.FIFTH_PRIZE_REWARD);

        int totalReward = totalFirstReward + totalSecondReward + totalThirdReward
                + totalFourthReward + totalFifthReward;

        return (float) totalReward / lottoCost * LottoConfig.PERCENTAGE;
    }

    private int rewardToNumber(String reward) {
        return Integer.parseInt(reward.replace(LottoConfig.THOUSANDS_SEPARATOR, ""));
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

    //이 아래는 추후 LottoService 클래스로 이동(일부 메서드 접근 제어자 수정 필요)
    private HashMap<String, Integer> checkRewardByLotto(HashMap<Integer, List<Integer>> checkMatchCountResult) {
        HashMap<String, Integer> countByPrize = new HashMap<>();

        countByPrize.put(LottoConfig.FIRST_PRIZE_REWARD,
                checkMatchCountByLotto(checkMatchCountResult, LottoConfig.FIRST_PRIZE_HAS_WINNING));
        countByPrize.put(LottoConfig.SECOND_PRIZE_REWARD,
                checkMatchCountByLotto(checkMatchCountResult, LottoConfig.SECOND_PRIZE_HAS_WINNING,
                        LottoConfig.SECOND_PRIZE_HAS_BONUS));
        countByPrize.put(LottoConfig.THIRD_PRIZE_REWARD,
                checkMatchCountByLotto(checkMatchCountResult, LottoConfig.THIRD_PRIZE_HAS_WINNING));
        countByPrize.put(LottoConfig.FOURTH_PRIZE_REWARD,
                checkMatchCountByLotto(checkMatchCountResult, LottoConfig.FOURTH_PRIZE_HAS_WINNING));
        countByPrize.put(LottoConfig.FIFTH_PRIZE_REWARD,
                checkMatchCountByLotto(checkMatchCountResult, LottoConfig.FIFTH_PRIZE_HAS_WINNING));

        return countByPrize;
    }

    private int checkMatchCountByLotto(HashMap<Integer, List<Integer>> compareNumberResult, int countWinningInLotto) {
        int count = 0;

        for (int key : compareNumberResult.keySet()) {
            List<Integer> compareNumbersResult = compareNumberResult.get(key);

            if (compareNumbersResult.get(LottoConfig.INDEX_WINNING_NUMBER) == countWinningInLotto) {
                count++;
            }
        }

        return count;
    }

    private int checkMatchCountByLotto(HashMap<Integer, List<Integer>> compareNumberResult,
                                   int countWinningInLotto, int countBonusInLotto) {
        int count = 0;

        for (int key : compareNumberResult.keySet()) {
            List<Integer> compareNumbersResult = compareNumberResult.get(key);

            if (compareNumbersResult.get(LottoConfig.INDEX_WINNING_NUMBER) == countWinningInLotto
                    && compareNumbersResult.get(LottoConfig.INDEX_BONUS_NUMBER) == countBonusInLotto) {
                count++;
            }
        }

        return count;
    }

    private HashMap<Integer, List<Integer>> compareLottoToNumber(HashMap<Integer, Lotto> allLotto,
                                                               WinningNumber winningNumber, BonusNumber bonusNumber) {
        HashMap<Integer, List<Integer>> countSameNumbers = new HashMap<>();
        int countWinningInLotto;
        int countBonusInLotto;

        for (int key : allLotto.keySet()) {
            List<Integer> randomLottoNumber = allLotto.get(key).getLotto();
            countWinningInLotto = compareLottoToWinningNumber(randomLottoNumber, winningNumber.getWinningNumber());
            countBonusInLotto = compareLottoToBonusNumber(randomLottoNumber, bonusNumber.getBonusNumber());

            countSameNumbers.put(key, List.of(countWinningInLotto, countBonusInLotto));
        }

        return countSameNumbers;
    }

    private int compareLottoToWinningNumber(List<Integer> lottoNumber, List<Integer> winningNumber) {
        int countSameNumber = 0;

        for (int number : lottoNumber) {
            if (winningNumber.contains(number)) {
                countSameNumber++;
            }
        }

        return countSameNumber;
    }

    private int compareLottoToBonusNumber(List<Integer> lottoNumber, int bonusNumber) {
        int countSameNumber = 0;

        for (int number : lottoNumber) {
            if (number == bonusNumber) {
                countSameNumber++;
            }
        }

        return countSameNumber;
    }
}
