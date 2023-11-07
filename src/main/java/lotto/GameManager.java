package lotto;


import camp.nextstep.edu.missionutils.Randoms;

import java.text.DecimalFormat;
import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameManager {
    private final int RANDOM_NUMBER_START = 1;
    private final int RANDOM_NUMBER_END = 45;
    private final int RANDOM_NUMBER_COUNT = 6;

    private int bonusNumber;
    private Map<Integer, Boolean> winningNumbers = new HashMap<>();
    private final int THREE_NUMBER_WINNING_MONEY = 5000;
    private final int FOUR_NUMBER_WINNING_MONEY = 50000;
    private final int FIVE_NUMBER_WINNING_MONEY = 1500000;
    private final int SIX_NUMBER_WINNING_MONEY = 2000000000;
    private final int FIVE_NUMBER_WINNING_MONEY_WITH_BONUS_NUMBER = 30000000;

    public List<Integer> createRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(RANDOM_NUMBER_START, RANDOM_NUMBER_END, RANDOM_NUMBER_COUNT);
    }

    public List<Integer> getWinningLottoNumberByRead() {
        String input = readLine();
        return Arrays.stream(input.split(",")).map(Integer::parseInt).toList();
    }

    public Integer getBonusLottoNumberByRead() {
        String input = readLine();
        return Integer.parseInt(input);
    }

    public int getPaymentForLottoByRead(Consumer consumer) {
        int lottoAmount = 0;
        while (true) {
            if (lottoAmount > 0) break;
            try {
                lottoAmount = consumer.payForLotto(readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return lottoAmount;
    }


    public void printWinning(List<Lotto> lottos) {
        Map<Integer, List<Lotto>> lottoByWinningCount = new HashMap<>();
        int winningWithBonusCount = 0;
        for (Lotto lotto : lottos) {
            int winningCount = getWinningCount(lotto);
            if (winningCount > 2) {
                lottoByWinningCount.put(winningCount, new ArrayList<>());
                lottoByWinningCount.get(winningCount).add(lotto);
            }
            if (isWinningCountWithBonusNumber(winningCount, lotto)) {
                winningWithBonusCount += 1;
            }
        }
        printResult(lottoByWinningCount, winningWithBonusCount);
    }

    private void printResult(Map<Integer, List<Lotto>> lottoByWinningCount, int winningWithBonusCount) {
        System.out.println("3개 일치 (5,000원)" + " - " + Optional.ofNullable(lottoByWinningCount.get(3)).stream().count() + "개");
        System.out.println("4개 일치 (50,000원)" + " - " + Optional.ofNullable(lottoByWinningCount.get(4)).stream().count() + "개");
        System.out.println("5개 일치 (1,500,000원)" + " - " + Optional.ofNullable(lottoByWinningCount.get(5)).stream().count() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원)" + " - " + winningWithBonusCount + "개");
        System.out.println("6개 일치 (2,000,000,000원)" + " - " + Optional.ofNullable(lottoByWinningCount.get(6)).stream().count() + "개");
    }

    public String getProfitRate(List<Lotto> lottos, int payment) {
        int winningMoney = 0;
        for (Lotto lotto : lottos) {
            winningMoney += getWinningMoney(lotto);
        }
        Double profit = (double) winningMoney / payment * 100;
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        return decimalFormat.format(profit);
    }

    public void setWinningNumbersAndBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        setBonusNumber(bonusNumber);
        setWinningNumbers(winningNumbers);
    }

    protected int getWinningMoney(Lotto lotto) {
        int money = 0;
        int winningCount = getWinningCount(lotto);
        if(winningCount==3)
            money = THREE_NUMBER_WINNING_MONEY;
        if(winningCount==4)
            money = FOUR_NUMBER_WINNING_MONEY;
        if(winningCount==5)
            money = FIVE_NUMBER_WINNING_MONEY;
        if(winningCount==6)
            money = SIX_NUMBER_WINNING_MONEY;
        if (isWinningCountWithBonusNumber(winningCount, lotto)) {
            money = FIVE_NUMBER_WINNING_MONEY_WITH_BONUS_NUMBER;
        }
        return money;
    }

    private void setBonusNumber(int number) {
        this.bonusNumber = number;
    }

    private void setWinningNumbers(List<Integer> winningNumbers) {
        winningNumbers.forEach(number -> this.winningNumbers.put(number, true));
    }

    public int getWinningCount(Lotto lotto) {
        int winningCount = 0;
        for (int number : lotto.getNumbers()) {
            if (winningNumbers.containsKey(number) || number == bonusNumber) {
                winningCount += 1;
            }
        }
        return winningCount;
    }

    // 5개 번호가 일치하되 보너스 번호가 일치하는 경우
    public boolean isWinningCountWithBonusNumber(int winningCount, Lotto lotto) {
        if (winningCount == 5 && lotto.getNumbers().contains(bonusNumber)) {
            return true;
        }
        return false;
    }

}
