package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.assertj.core.util.Arrays;

public class Game {
    int purchaseAmount;
    Lottos lottos;
    LotteryNumbers lotteryNumbers;
    int[] rankCounts = new int[6];
    double rateOfReturn;
    
    void play() {
        calculateNumberOfPurchase();
        showPurchasedLottos();
        setLotteryNumbers();
        showWinningStatistics();
    }
    
    void calculateNumberOfPurchase() {
        while (true) {
            try {
                OutputView.outputPurchaseAmount();
                String inputPurchaseAmount = InputView.inputPurchaseAmount();
                int number = checkInteger(inputPurchaseAmount);
                checkNaturalNumber(number);
                purchaseAmount = checkMultiple(number);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();
    }
    
    int checkInteger(String string) {
        try {
            int number = Integer.parseInt(string);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수가 아닌 입력입니다.");
        }
    }
    
    void checkNaturalNumber(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("[ERROR] 자연수가 아닌 입력입니다.");
        }
    }
    
    int checkMultiple(int number) {
        if(number % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000의 배수가 아닌 입력입니다.");
        }
        return number / 1000;
    }
    
    void showPurchasedLottos() {
        OutputView.outputNumberOfPurchases(purchaseAmount);
        lottos = new Lottos(purchaseAmount);
        lottos.printLottos();
        System.out.println();
    }
    
    void setLotteryNumbers() {
        List<Integer> winningNumbers = setWinningNumbers();
        int bonusNumber = setBonusNumber(winningNumbers);
        lotteryNumbers = new LotteryNumbers(winningNumbers, bonusNumber);
    }
    
    List<Integer> setWinningNumbers() {
        while(true) {
            try {
                OutputView.outputWinningNumbers();
                return checkWinningNumbers(InputView.inputWinningNumbers());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    List<Integer> checkWinningNumbers(String inputWinningNumbers) {
        List<String> parsedWinningNumbers = Pattern.compile(",")
                .splitAsStream(inputWinningNumbers)
                .collect(Collectors.toList());
        List<Integer> convertedWinningNumbers = new ArrayList<>();
        
        checkNumberCount(parsedWinningNumbers);
        for (String number : parsedWinningNumbers) {
            int dummy = checkInteger(number);
            checkLottoNumberRange(dummy);
            convertedWinningNumbers.add(dummy);
        }
        checkDuplication(convertedWinningNumbers);
        System.out.println();
        
        return convertedWinningNumbers;
    }
    
    void checkNumberCount(List<String> string) {
        if (string.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개가 입력되어야 합니다.");
        }
    }
    
    void checkLottoNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 범위는 1 ~ 45 입니다.");
        }
    }
    
    void checkDuplication(List<Integer> number) {
        if(number.size() != number.stream().distinct().count()){
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }
    }
    
    int setBonusNumber(List<Integer> winningNumbers) {
        while(true) {
            try {
                OutputView.outputBonusNumber();
                return checkBonusNumber(InputView.inputBonusNumber(), winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }   
    }
    
    int checkBonusNumber(String inputBonusNumber, List<Integer> winningNumbers) {
        int convertedBonusNumber = checkInteger(inputBonusNumber);
        checkLottoNumberRange(convertedBonusNumber);
        checkDuplication(convertedBonusNumber, winningNumbers);
        System.out.println();
        
        return convertedBonusNumber;
    }
    
    void checkDuplication(int number, List<Integer> winningNumbers) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
    
    void showWinningStatistics() {
        OutputView.outputStartWinningStatistics();
        calculateMatchedCount();
        OutputView.outputWinnintStatistics(rankCounts);
        calculateRateOfReturn();
        OutputView.outputRateOfReturn(rateOfReturn);
    }
    
    void calculateMatchedCount() {
        for (Lotto lotto : lottos.lottos) {
            int matchedCount = lotto.matchedCount(lotteryNumbers.winningNumbers);
            calculateRankCounts(matchedCount, lotto);
        }
    }
    
    void calculateRankCounts(int matchedCount, Lotto lotto) {
        if (matchedCount == 6) {
            rankCounts[1]++;
            return;
        }
        if (matchedCount == 5) {
            determineRank(lotto);
            return;
        }
        if (matchedCount == 4) {
            rankCounts[4]++;
            return;
        }
        if (matchedCount == 3) {
            rankCounts[5]++;
            return;
        }
    }
    
    void determineRank(Lotto lotto) {
        if (lotto.isContain(lotteryNumbers.bonusNumber)) {
            rankCounts[2]++;
            return;
        }
        rankCounts[3]++;
        return;
    }
    
    void calculateRateOfReturn() {
        long prize = rankCounts[1] * 2000000000;
        prize += rankCounts[2] * 30000000;
        prize += rankCounts[3] * 1500000;
        prize += rankCounts[4] * 50000;
        prize += rankCounts[5] * 5000;
        rateOfReturn = (double)prize / (purchaseAmount * 1000) * 100;
    }
}
