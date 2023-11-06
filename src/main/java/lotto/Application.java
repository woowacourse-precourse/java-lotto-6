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

        String lottoBudgetInput;
        Integer budget;

        while (true) {
            lottoBudgetInput = View.getUserInput();
            if (Validator.isInputEmpty(lottoBudgetInput)) {
                continue;
            }
            if (Validator.isNumberOnly(lottoBudgetInput)) {
                continue;
            }
            budget = Convertor.convertInputToInteger(lottoBudgetInput);
            if (Validator.isPriceUnder1000(budget)) {
                continue;
            }
            if (Validator.isPriceIndivisible(budget)) {
                continue;
            }
            break;
        }

        Integer lotteryCount = Controller.calculateLotteryCount(budget);
        View.printLotteryCount(lotteryCount);

        gameData.generateLottoList();
        List<Lotto> lottoList = gameData.getLottoList();
        for (int i = 0; i < lotteryCount; i++) {
            List<Integer> lotteryNumbers = Lotto.generateLotteryNumbers();
            Lotto.sortNumbers(lotteryNumbers);
            lottoList.add(new Lotto(lotteryNumbers));
        }

        for (Lotto lotto : lottoList) {
            List<Integer> numbers = lotto.getNumbers();
            View.printLotteryNumbers(numbers);
        }
        System.out.println();

        View.printMessage(ASK_WINNING_NUMBERS);

        String winningNumbersInput;
        String[] winningNumbersArray;
        List<Integer> winningNumbersTemp;
        while (true) {
            winningNumbersInput = View.getUserInput();
            if (Validator.isInputEmpty(winningNumbersInput)) {
                continue;
            }
            if (Validator.isValidCharacter(lottoBudgetInput)) {
                continue;
            }

            winningNumbersArray = Convertor.splitInput(winningNumbersInput);
            if (Controller.validateUserInputIsOnlyNumbers(winningNumbersArray)) {
                continue;
            }

            winningNumbersTemp = Convertor.convertToList(winningNumbersArray);
            if (Validator.isNumberCountOutOfRange(winningNumbersTemp)) {
                continue;
            }
            if (Controller.validateUserInputNumberIsOutOfValidRange(winningNumbersTemp)) {
                continue;
            }
            if (Controller.validateUserInputNumberIsDuplicate(winningNumbersTemp)) {
                continue;
            }

            break;
        }
        gameData.setWinningNumbers(winningNumbersTemp);


        View.printMessage(ASK_BONUS_NUMBERS);
        String bonusNumberInput;
        Integer bonusNumberTemp;

        while (true) {
            bonusNumberInput = View.getUserInput();
            if (Validator.isInputEmpty(bonusNumberInput)) {
                continue;
            }
            if (Validator.isNumberOnly(bonusNumberInput)) {
                continue;
            }

            bonusNumberTemp = Convertor.convertInputToInteger(bonusNumberInput);
            if (Validator.isNumberOnValidRange(bonusNumberTemp)) {
                continue;
            }

            List<Integer> winningNumbers = gameData.getWinningNumbers();
            if (Validator.isBonusNumberDuplicate(bonusNumberTemp, winningNumbers)) {
                continue;
            }
            break;
        }

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
