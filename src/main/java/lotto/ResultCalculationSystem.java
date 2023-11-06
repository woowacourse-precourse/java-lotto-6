package lotto;

import lotto.dto.Lotto;
import lotto.dto.NumberType;
import lotto.dto.Ranking;
import lotto.message.InputGuideMessage;

import java.text.DecimalFormat;
import java.util.*;

import static lotto.message.InputGuideMessage.*;

public class ResultCalculationSystem {
    private Map<Integer, Ranking> rankingAccumulator = new HashMap<>();
    private double rateOfReturn;

    public ResultCalculationSystem() {
        rankingAccumulator.put(5, new Ranking(5, 3, 0, 5000));
        rankingAccumulator.put(4, new Ranking(4, 4, 0, 50000));
        rankingAccumulator.put(3, new Ranking(3, 5, 0, 1500000));
        rankingAccumulator.put(2, new Ranking(2, 5, 1, 30000000));
        rankingAccumulator.put(1, new Ranking(1, 6, 0, 2000000000));
    }

    public void makeWinningResult(List<Lotto> lottos, List<Integer> lottoWinningNumbers, int bonusNumber) {
        List<Pair> winningAndBonusNumbers = initAndSortWinningAndBonusNumbers(lottoWinningNumbers, bonusNumber);

        for (int i = 0; i < lottos.size(); i++) {
            List<Integer> lottoNumbers = lottos.get(i).getNumbers();
            checkRankingOfLotto(lottoNumbers, winningAndBonusNumbers);
        }
    }

    private List<Pair> initAndSortWinningAndBonusNumbers(List<Integer> lottoWinningNumbers, int bonusNumber) {
        List<Pair> winningAndBonusNumbers = new ArrayList<>();
        lottoWinningNumbers
                .iterator()
                .forEachRemaining(number -> winningAndBonusNumbers.add(new Pair(number, NumberType.WINNING_NUMBER)));
        winningAndBonusNumbers.add(new Pair(bonusNumber, NumberType.BONUS_NUMBER));
        winningAndBonusNumbers.sort((o1, o2) -> o1.getNumber() - o2.getNumber());
        return winningAndBonusNumbers;
    }

    //죄송합니다... 15줄 제한 요구를 지킬 방법이 생각이 나지 않습니다....
    private void checkRankingOfLotto(List<Integer> lottoNumbers, List<Pair> winningAndBonusNumbers) {
        int correctWinningNumber = 0;
        int correctBonusNumber = 0;
        int currentPositionOfWinningAndBonusNumbers = 0;
        int currentPositionOfLottoNumber = 0;
        while (currentPositionOfLottoNumber < 6 && currentPositionOfWinningAndBonusNumbers < 6) {
            int lottoNumber = lottoNumbers.get(currentPositionOfLottoNumber);
            int winningAndBonusNumber = winningAndBonusNumbers.get(currentPositionOfWinningAndBonusNumbers).getNumber();
            NumberType winningAndBonusNumberType = winningAndBonusNumbers.get(currentPositionOfWinningAndBonusNumbers).getType();
            if (winningAndBonusNumber == lottoNumber && winningAndBonusNumberType == NumberType.WINNING_NUMBER) {
                correctWinningNumber++;
                currentPositionOfWinningAndBonusNumbers++;
            }
            if (winningAndBonusNumber == lottoNumber && winningAndBonusNumberType == NumberType.BONUS_NUMBER) {
                correctBonusNumber++;
                currentPositionOfWinningAndBonusNumbers++;
            }
            if (winningAndBonusNumber > lottoNumber){
                currentPositionOfLottoNumber++;
            }
            if (winningAndBonusNumber < lottoNumber) {
                currentPositionOfWinningAndBonusNumbers++;
            }
        }
        int ranking = calculateRanking(correctWinningNumber, correctBonusNumber);
        if (ranking != 0)
            rankingAccumulator.get(ranking).increaseNumberOfWins();
    }

    private int calculateRanking(int correctWinningNumber, int correctBonusNumber) {
        for (Ranking ranking : rankingAccumulator.values()) {
            if (correctWinningNumber == ranking.getMatchedWinningNumberAmount() &&
                    correctBonusNumber == ranking.getMatchedBonusNumberAmount())
                return ranking.getRank();
        }
        return 0;
    }

    public void calculateRateOfReturn(int desiredPurchaseAmount) {
        double totalMoney = 0;
        for (int i = 1; i <= 5; i++) {
            totalMoney = (double) rankingAccumulator.get(i).getRewardMoney() * rankingAccumulator.get(i).getNumberOfWins();
        }

        rateOfReturn = (totalMoney / desiredPurchaseAmount * 100);
    }

    public void printWinningResult() {
        DecimalFormat decimalFormat = new DecimalFormat("###,###.#");

        System.out.println(INFORM_WINNING_STATICS_MESSAGE.getMessage());
        for (int i = 5; i > 0; i--) {
            Ranking ranking = rankingAccumulator.get(i);
            String formattedAmount = decimalFormat.format(ranking.getRewardMoney());
            String additionalMessage = INFORM_BONUS_NUMBER_CORRECT_MESSAGE.getMessage();
            if (ranking.getMatchedBonusNumberAmount() == 0)
                additionalMessage = "";
            System.out.printf(INFORM_RANK_AND_WINNING_COUNT_MESSAGE.getMessage(),
                    ranking.getMatchedWinningNumberAmount(), additionalMessage, formattedAmount, ranking.getNumberOfWins());
        }
        String formattedRateOfReturn = decimalFormat.format(rateOfReturn);
        System.out.printf(INFORM_TOTAL_RATE_OF_RETURN.getMessage(), formattedRateOfReturn);
    }

    private class Pair {
        int number;
        NumberType type;

        private Pair(int number, NumberType type) {
            this.number = number;
            this.type = type;
        }

        public int getNumber() {
            return number;
        }

        public NumberType getType() {
            return type;
        }
    }
}
