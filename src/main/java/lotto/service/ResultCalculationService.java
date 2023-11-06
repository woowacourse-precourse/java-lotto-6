package lotto.service;

import lotto.domain.Buyer;
import lotto.domain.LotteryWinningNumbers;
import lotto.dto.Lotto;
import lotto.enums.NumberType;
import lotto.dto.Ranking;

import java.text.DecimalFormat;
import java.util.*;

import static lotto.enums.GuideMessage.*;

public class ResultCalculationService {
    public void makeWinningResult(Buyer buyer, LotteryWinningNumbers lotteryWinningNumbers) {
        int bonusNumber = lotteryWinningNumbers.getBonusNumber();
        Map<Integer, Ranking> rankingAccumulator = buyer.getRankingAccumulator();
        List<Lotto> lottos = buyer.getLottos();
        List<Integer> lottoWinningNumbers = lotteryWinningNumbers.getWinningNumbers();
        List<Pair> winningAndBonusNumbers = sortWinningPlusBonusNumbers(lottoWinningNumbers, bonusNumber);

        for (int i = 0; i < lottos.size(); i++) {
            List<Integer> lottoNumbers = lottos.get(i).getNumbers();
            checkRankingOfLotto(rankingAccumulator, lottoNumbers, winningAndBonusNumbers);
        }
    }

    private List<Pair> sortWinningPlusBonusNumbers(List<Integer> lottoWinningNumbers, int bonusNumber) {
        List<Pair> winningAndBonusNumbers = new ArrayList<>();

        lottoWinningNumbers
                .iterator()
                .forEachRemaining(number -> winningAndBonusNumbers.add(new Pair(number, NumberType.WINNING_NUMBER)));
        winningAndBonusNumbers.add(new Pair(bonusNumber, NumberType.BONUS_NUMBER));
        winningAndBonusNumbers.sort((o1, o2) -> o1.getNumber() - o2.getNumber());

        return winningAndBonusNumbers;
    }

    //죄송합니다... 15줄 제한 요구를 지킬 방법이 생각이 나지 않습니다....
    private void checkRankingOfLotto(Map<Integer, Ranking> rankingAccumulator, List<Integer> lottoNumbers, List<Pair> winningAndBonusNumbers) {
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

            if (winningAndBonusNumber > lottoNumber) {
                currentPositionOfLottoNumber++;
            }

            if (winningAndBonusNumber < lottoNumber) {
                currentPositionOfWinningAndBonusNumbers++;
            }
        }

        int ranking = calculateRanking(rankingAccumulator, correctWinningNumber, correctBonusNumber);
        if (ranking != 0)
            rankingAccumulator.get(ranking).increaseNumberOfWins();
    }

    private int calculateRanking(Map<Integer, Ranking> rankingAccumulator, int correctWinningNumber, int correctBonusNumber) {
        for (Ranking ranking : rankingAccumulator.values()) {
            if (correctWinningNumber == ranking.getMatchedWinningNumberAmount() &&
                    correctBonusNumber == ranking.getMatchedBonusNumberAmount())
                return ranking.getRank();
        }
        return 0;
    }

    public void calculateRateOfReturn(Buyer buyer) {
        int desiredPurchaseAmount = buyer.getDesiredPurchaseAmount();
        Map<Integer, Ranking> rankingAccumulator = buyer.getRankingAccumulator();
        double totalMoney = 0;

        for (int i = 1; i <= 5; i++) {
            totalMoney = (double) rankingAccumulator.get(i).getRewardMoney() * rankingAccumulator.get(i).getNumberOfWins();
        }

        buyer.setRateOfReturn(totalMoney / desiredPurchaseAmount * 100);
    }

    public List<String> printWinningResult(Buyer buyer) {
        Map<Integer, Ranking> rankingAccumulator = buyer.getRankingAccumulator();
        double rateOfReturn = buyer.getRateOfReturn();
        List<String> messages = new ArrayList<>();

        DecimalFormat decimalFormat = new DecimalFormat("###,###.#");

        messages.add(INFORM_WINNING_STATICS_MESSAGE.getMessage());

        for (int i = 5; i > 0; i--) {
            makeWinningResultMessages(rankingAccumulator, i, decimalFormat, messages);
        }

        String formattedRateOfReturn = decimalFormat.format(rateOfReturn);
        messages.add(String.format(INFORM_TOTAL_RATE_OF_RETURN.getMessage(), formattedRateOfReturn));

        return messages;
    }

    private void makeWinningResultMessages(Map<Integer, Ranking> rankingAccumulator, int i, DecimalFormat decimalFormat, List<String> messages) {
        Ranking ranking = rankingAccumulator.get(i);
        String formattedAmount = decimalFormat.format(ranking.getRewardMoney());
        String additionalMessage = INFORM_BONUS_NUMBER_CORRECT_MESSAGE.getMessage();

        if (ranking.getMatchedBonusNumberAmount() == 0)
            additionalMessage = "";

        messages.add(String.format(INFORM_RANK_AND_WINNING_COUNT_MESSAGE.getMessage(),
                ranking.getMatchedWinningNumberAmount(), additionalMessage, formattedAmount, ranking.getNumberOfWins()));
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
