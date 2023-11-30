package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PlayGame {

    Money money;
    Lotto lotto;
	Bonus bonus;
	
    private final String EA = "개";
    private int sum;
    private double profit;
    private List<Integer> matchingNumbersOfLottoCount = new ArrayList<>();
    private List<Integer> matchingNumberOfBonusCount = new ArrayList<>();

    enum Prize {
        THREE_MATCHED(5000, "3개 일치(5,000원) - "),
        FOUR_MATCHED(50000, "4개 일치(50,000원) - "),
        FIVE_MATCHED(1500000, "5개 일치(1,500,000원) - "),
        FIVE_AND_BONUS_MATCHED(30000000, "5개 일치, 보너스 볼 일치(30,000,000원) - "),
        SIX_MATCHED(2000000000, "6개 일치(2,000,000,000원) - ");

        private final int prizeAmount;
        private final String description;

        Prize(int prizeAmount, String description) {
            this.prizeAmount = prizeAmount;
            this.description = description;
        }

        public int getPrizeAmount() {
            return prizeAmount;
        }

        public String getDescription() {
            return description;
        }
    }

    public PlayGame() { }

	private void checkDuplicatedNumbers() {
        matchingNumbersOfLottoCount = new ArrayList<>();
        matchingNumberOfBonusCount = new ArrayList<>();

        List<Integer> bonusNumberCopy = new ArrayList<>(bonus.getBonusNumber());

        for (int i = 0; i < money.playRound; i++) {
            final int count = i;

            List<Integer> matchingNumbersOfLotto = lotto.getNumbers().stream()
                    .filter(o -> money.collectTotalWinningLottoNumbers.get(count).contains(o)).collect(Collectors.toList());

            matchingNumbersOfLottoCount.add(matchingNumbersOfLotto.size());

            int bonusCount = 0;
            for (Integer bonusNumber : bonusNumberCopy) {
                if (money.collectTotalWinningLottoNumbers.get(count).contains(bonusNumber)) {
                    bonusCount++;
                }
            }
            matchingNumberOfBonusCount.add(bonusCount);
        }

    }

    private void resultOfLottoGame() {

        // 3 ~ 6개씩 로또 번호 매칭 성공한 갯수를 변수에 저장함.
        int threeMatchedNumbers = Collections.frequency(matchingNumbersOfLottoCount, 3);
        int fourMatchedNumbers = Collections.frequency(matchingNumbersOfLottoCount, 4);
        int fiveMatchedNumbers = Collections.frequency(matchingNumbersOfLottoCount, 5);
        int bonusMatchedNumber = Collections.frequency(matchingNumberOfBonusCount, 1);
        int sixMatchedNumbers = Collections.frequency(matchingNumbersOfLottoCount, 6);

        int bothFiveAndBonusNumbers = Math.min(fiveMatchedNumbers, bonusMatchedNumber);
        int onlyFiveMatchedNumbers = fiveMatchedNumbers - bonusMatchedNumber;

        System.out.println("\n당첨 통계");
        System.out.println("---");

        printPrizeResult(Prize.THREE_MATCHED, threeMatchedNumbers);
        printPrizeResult(Prize.FOUR_MATCHED, fourMatchedNumbers);
        printPrizeResult(Prize.FIVE_MATCHED, onlyFiveMatchedNumbers);
        printPrizeResult(Prize.FIVE_AND_BONUS_MATCHED, bothFiveAndBonusNumbers);
        printPrizeResult(Prize.SIX_MATCHED, sixMatchedNumbers);

        sum = (Prize.THREE_MATCHED.getPrizeAmount() * threeMatchedNumbers) +
                (Prize.FOUR_MATCHED.getPrizeAmount() * fourMatchedNumbers) +
                (Prize.FIVE_MATCHED.getPrizeAmount() * onlyFiveMatchedNumbers) +
                (Prize.FIVE_AND_BONUS_MATCHED.getPrizeAmount() * bothFiveAndBonusNumbers) +
                (Prize.SIX_MATCHED.getPrizeAmount() * sixMatchedNumbers);
    }

    private void printPrizeResult(Prize prize, int count) {
        if (count > 0) {
            System.out.println(prize.getDescription() + count + EA);
        } else {
            System.out.println(prize.getDescription() + "0개");
        }
    }

    public void sumOfMoney() {
        money.makeWinningNumbers();
        lotto.getNumbers();
        resultOfLottoGame();

        profit = (double) sum / money.userInputCostOfLotto * 100;
        double calculatedProfitRate = Math.round(profit * 10) / 10.0;

        System.out.println("총 수익률은 " + calculatedProfitRate + "% 입니다.");
    }

}