package lotto.game;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Numbers;
import lotto.type.ErrorCode;
import lotto.type.LottoPayout;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.util.Arrays.stream;

public class Machine {

    private static final int PRICE = 1000;
    private final int count;

    public Machine(String moneyInput) {
        int money = validateMoneyNumber(moneyInput);
        validateMoneyByAmount(money);
        this.count = money / PRICE;
    }
    public int getCount() {
        return count;
    }

    private int validateMoneyNumber(String moneyInput) {
        int money = 0;
        try {
            money = Integer.parseInt(moneyInput);
        } catch (IllegalArgumentException e){
            UserInterface.printOut(ErrorCode.INVALID_MONEY_TO_BUY.getDescription());
        }
        return money;
    }

    private void validateMoneyByAmount(int money) {
        if (money % PRICE != 0) throw new IllegalArgumentException(
                ErrorCode.INVALID_MONEY_TO_BUY.getDescription()
        );
    }

    List<Lotto> createLottoNumbers() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < this.count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                    .stream().sorted().toList();
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    List<Integer> createWinningNumber(String numInput) {
        List<String> numbers = stream(numInput.split(",")).toList();
        List<Integer> winningNumber = numbers.stream()
                .map((num -> Integer.parseInt(num)))
                .toList();
        return winningNumber;
    }

    Numbers createBonusNumber(List<Integer> winningNumber, int bonusNumber) {
        return new Numbers(winningNumber, bonusNumber);
    }

    int[] createMatchResult(List<Lotto> lottos, Numbers numbers) {
        List<int[]> results = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int matchCount;
            int bonusCount = 0;
            matchCount = lotto.getNumbers().stream().filter(o -> (numbers.getWinningNumbers())
                    .stream().anyMatch(Predicate.isEqual(o))).toList().size();
            if (lotto.getNumbers().contains(numbers.getBonusNumber())) {
                bonusCount = 1;
            }
            results.add(new int[]{matchCount, bonusCount});
        }
        return countMatchResult(results);
    }

    private int[] countMatchResult(List<int[]> results) {
        int[] countResult = new int[5];
        for (int[] result : results) {
            if (result[0] == 3) {
                countResult[0]++;
            } else if (result[0] == 4) {
                countResult[1]++;
            } else if (result[0] == 5) {
                if (result[1] == 0) {
                    countResult[2]++;
                } else {
                    countResult[3]++;
                }
            } else if (result[0] == 6) {
                countResult[4]++;
            }
        }
        return countResult;
    }

    double calculateInvestmentResult(int[] matchResult) {
        LottoPayout[] lottoPayout = LottoPayout.values();
        double investmentSum = 0;
        for (int i = 0; i < matchResult.length; i++) {
            investmentSum += (double) (matchResult[i] * lottoPayout[i].getAmount()) / (PRICE * this.count);
        }
        return investmentSum * 100;
    }

}
