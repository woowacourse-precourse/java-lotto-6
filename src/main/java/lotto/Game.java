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
    
    void play() {
        calculateNumberOfPurchase();
        showPurchasedLottos();
        setLotteryNumbers();
        calculateRateOfReturn();
    }
    
    void calculateNumberOfPurchase() {
        OutputView.outputPurchaseAmount();
        String inputPurchaseAmount = InputView.inputPurchaseAmount();
        int number = checkInteger(inputPurchaseAmount);
        checkNaturalNumber(number);
        purchaseAmount = checkMultiple(number);
        System.out.println();
    }
    
    int checkInteger(String string) {
        try {
            int number = Integer.parseInt(string);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[Error] 정수가 아닌 입력입니다.");
        }
    }
    
    void checkNaturalNumber(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("[Error] 자연수가 아닌 입력입니다.");
        }
    }
    
    int checkMultiple(int number) {
        if(number % 1000 != 0) {
            throw new IllegalArgumentException("[Error] 1000의 배수가 아닌 입력입니다.");
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
        OutputView.outputWinningNumbers();
        return checkWinningNumbers(InputView.inputWinningNumbers());
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
            throw new IllegalArgumentException("[Error] 당첨 번호는 6개가 입력되어야 합니다.");
        }
    }
    
    void checkLottoNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[Error] 당첨 번호의 범위는 1 ~ 45 입니다.");
        }
    }
    
    void checkDuplication(List<Integer> number) {
        if(number.size() != number.stream().distinct().count()){
            throw new IllegalArgumentException("[Error] 당첨 번호는 중복될 수 없습니다.");
        }
    }
    
    int setBonusNumber(List<Integer> winningNumbers) {
        OutputView.outputBonusNumber();
        return checkBonusNumber(InputView.inputBonusNumber(), winningNumbers);
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
            throw new IllegalArgumentException("[Error] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
    
    void calculateRateOfReturn() {
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
}
