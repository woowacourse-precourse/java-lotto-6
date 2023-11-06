package lotto;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;

import static lotto.Notice.*;

public class Application {
    public static void main(String[] args) {

        GameData gameData = new GameData();
        GameStatistics gameStatistics = new GameStatistics();

        View.printMessage(ASK_BUDGET);

        String lottoBudgetInput = "";

        while (true) {
            lottoBudgetInput = View.getUserInput();
//            Validator.validationFlag = Validator.isInputEmpty(lottoBudgetInput);
            if (Validator.isInputEmpty(lottoBudgetInput)) {
                continue;
            }
//            Validator.validationFlag = Validator.isNumber(lottoBudgetInput);
            if (Validator.isNumber(lottoBudgetInput)) {
                continue;
            }
//            Validator.validationFlag = Validator.isPriceUnder1000(lottoBudgetInput);
            if (Validator.isPriceUnder1000(lottoBudgetInput)) {
                continue;
            }
//            Validator.validationFlag = Validator.isPriceIndivisible(lottoBudgetInput);
            if (Validator.isPriceIndivisible(lottoBudgetInput)) {
                continue;
            }

            if (!Validator.validationFlag) {
                break;
            }
        }


        Integer budget = Convertor.convertInputToInteger(lottoBudgetInput);
        Integer lotteryCount = Controller.calculateLotteryCount(budget);
        View.printLotteryCount(lotteryCount);

        gameData.generateLottoList();
        List<Lotto> lottoList = gameData.getLottoList();
        for (int i = 0; i < lotteryCount; i++) {
            List<Integer> lotteryNumbers = Lotto.generateLotteryNumbers();
            Lotto.sortLotteryNumbers(lotteryNumbers);
            lottoList.add(new Lotto(lotteryNumbers));
        }

        for (Lotto lotto : lottoList) {
            List<Integer> numbers = lotto.getNumbers();
            View.printLotteryNumbers(numbers);
        }
        System.out.println();

        View.printMessage(ASK_WINNING_NUMBERS);
        String winningNumbersInput = View.getUserInput();
        String[] winningNumbersArray = Convertor.splitInput(winningNumbersInput);
        List<Integer> winningNumbersTemp = Convertor.convertToList(winningNumbersArray);
        gameData.setWinningNumbers(winningNumbersTemp);

        View.printMessage(ASK_BONUS_NUMBERS);
        String bonusNumberInput = View.getUserInput();
        Integer bonusNumberTemp = Convertor.convertInputToInteger(bonusNumberInput);
        gameData.setBonusNumber(bonusNumberTemp);

        List<Integer> winningNumbers = gameData.getWinningNumbers();
        gameStatistics.generateMatchingNumberCountList();
        List<Integer> matchingNumberCountList = gameStatistics.getSameNumberCountList();
        gameStatistics.generateRankList();
        List<Rank> rankList = gameStatistics.getRankList();

        for (Lotto lotto : lottoList) {
            int countTemp = 0;
            List<Integer> lottoNumbers = lotto.getNumbers();
            for (Integer lottoNumber : lottoNumbers) {
                countTemp += Controller.countMatchingNumbersByLotteryNumber(winningNumbers, lottoNumber);
            }
            matchingNumberCountList.add(countTemp);
        }// 리팩토링 고민해봐야 함.

        Controller.setRankOnList(rankList, matchingNumberCountList);

        Integer bonusNumber = gameData.getBonusNumber();
        for (int i = 0; i < rankList.size(); i++) {
            boolean bonusFlag;
            Rank rank = rankList.get(i);
            if (rank.equals(Rank.THIRD)) {
                Lotto secondRankCandidateLotto = lottoList.get(i);
                List<Integer> secondRankCandidateLottoNumbers = secondRankCandidateLotto.getNumbers();
                bonusFlag = Controller.bonusNumberFlag(secondRankCandidateLottoNumbers, bonusNumber);
                Controller.changeRankByBonusNumber(rankList, bonusFlag, i);
            }
        }

        View.printMessage(GAME_STATISTICS);
        View.printMessage(SEPARATE_LINE);

        for (Rank rank : Rank.values()) {
            DecimalFormat df = new DecimalFormat("###,###");
            Integer matchingCount = Collections.frequency(rankList, rank);
            if (rank.equals(Rank.FAIL)) {
                continue;
            }
            if (rank.equals(Rank.SECOND)) {
                View.print2ndRankPrize(rank, matchingCount, df);
            }
            if (!(rank.equals(Rank.SECOND))) {
                View.printPrize(rank, matchingCount, df);
            }
        }

        Integer totalPrize = Controller.calculateTotalPrize(rankList);
        Double pricePrizeRatio = Controller.calculatePricePrizeRatio(totalPrize, budget);
        View.printPricePrizeRatio(pricePrizeRatio);

    }

}
