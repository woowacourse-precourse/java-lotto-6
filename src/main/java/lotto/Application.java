package lotto;

import lotto.constants.Rank;
import lotto.domain.Calculator;
import lotto.domain.Controller;
import lotto.domain.Convertor;
import lotto.domain.Validator;
import lotto.model.GameData;
import lotto.model.GameStatistics;
import lotto.model.Lotto;
import lotto.view.View;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;

import static lotto.constants.Notice.*;

public class Application {
    public static void main(String[] args) {

        GameData gameData = new GameData();
        GameStatistics gameStatistics = new GameStatistics();

        //로또 금액 입력
        View.printMessage(ASK_BUDGET);
        String lottoBudgetInput;
        Integer budget;

        //로또 금액 검증
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

        Integer lotteryCount = Calculator.calculateLotteryCount(budget);
        View.printLotteryCount(lotteryCount);

        //로또 생성
        gameData.generateLottoList();
        List<Lotto> lottoList = gameData.getLottoList();

        for (int i = 0; i < lotteryCount; i++) {
            List<Integer> lotteryNumbers = Lotto.generateLotteryNumbers();
            Controller.sortNumbers(lotteryNumbers);
            lottoList.add(new Lotto(lotteryNumbers));
        }
        for (Lotto lotto : lottoList) {
            List<Integer> numbers = lotto.getNumbers();
            View.printLotteryNumbers(numbers);
        }
        System.out.println();


        //당첨 번호 입력
        View.printMessage(ASK_WINNING_NUMBERS);
        String winningNumbersInput;
        String[] winningNumbersArray;
        List<Integer> winningNumbersTemp;

        //당첨 번호 검증
        while (true) {
            winningNumbersInput = View.getUserInput();
            if (Validator.isInputEmpty(winningNumbersInput)) {
                continue;
            }
            if (Validator.isValidCharacter(winningNumbersInput)) {
                continue;
            }

            winningNumbersArray = Convertor.splitInput(winningNumbersInput);
            if (Validator.areUserInputsOnlyNumbers(winningNumbersArray)) {
                continue;
            }

            winningNumbersTemp = Convertor.convertToList(winningNumbersArray);
            if (Validator.isNumberCountOutOfRange(winningNumbersTemp)) {
                continue;
            }
            if (Validator.areUserInputNumbersOutOfRange(winningNumbersTemp)) {
                continue;
            }
            if (Validator.areUserInputNumberDuplicated(winningNumbersTemp)) {
                continue;
            }
            break;
        }
        gameData.setWinningNumbers(winningNumbersTemp);

        //보너스 번호 입력
        View.printMessage(ASK_BONUS_NUMBERS);
        String bonusNumberInput;
        Integer bonusNumberTemp;

        //보너스 번호 검증
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


        //당첨 통계 산출
        List<Integer> winningNumbers = gameData.getWinningNumbers();
        gameStatistics.generateMatchingNumberCountList();
        List<Integer> matchingNumberCountList = gameStatistics.getMatchingNumberCountList();
        gameStatistics.generateRankList();
        List<Rank> rankList = gameStatistics.getRankList();

        Controller.fillMatchingNumberCountList(lottoList, winningNumbers, matchingNumberCountList);
        Controller.fillRankList(rankList, matchingNumberCountList);

        Integer bonusNumber = gameData.getBonusNumber();
        for (int i = 0; i < rankList.size(); i++) {
            boolean bonusFlag;
            Rank rank = rankList.get(i);

            //3등(번호 5개 일치)인 경우, 보너스 번호 일치 여부 확인 / 2등으로 전환
            if (rank.equals(Rank.THIRD)) {
                Lotto secondRankCandidateLotto = lottoList.get(i);
                List<Integer> secondRankCandidateLottoNumbers = secondRankCandidateLotto.getNumbers();
                bonusFlag = Controller.bonusNumberFlag(secondRankCandidateLottoNumbers, bonusNumber);
                Controller.changeRankByBonusNumber(rankList, bonusFlag, i);
            }
        }


        //당첨통계 출력
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

        Integer totalPrize = Calculator.calculateTotalPrize(rankList);
        Double pricePrizeRatio = Calculator.calculatePricePrizeRatio(totalPrize, budget);
        View.printPricePrizeRatio(pricePrizeRatio);
    }
}
