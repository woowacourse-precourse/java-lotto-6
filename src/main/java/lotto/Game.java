package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.assertj.core.util.Arrays;

public class Game {
    static final int NUMBER_OF_NUMBERS = 6;
    static final int MIN_OF_NUMBER = 1;
    static final int MAX_OF_NUMBER = 45;
    static final int PRICE_OF_LOTTO = 1000;
    
    int purchaseAmount;
    Lottos lottos;
    LotteryNumbers lotteryNumbers;
    LottoResult lottoResult = new LottoResult();
    
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
        if(number % PRICE_OF_LOTTO != 0) {
            throw new IllegalArgumentException("[ERROR] 1000의 배수가 아닌 입력입니다.");
        }
        return number / PRICE_OF_LOTTO;
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
        if (string.size() != NUMBER_OF_NUMBERS) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개가 입력되어야 합니다.");
        }
    }
    
    void checkLottoNumberRange(int number) {
        if (number < MIN_OF_NUMBER || number > MAX_OF_NUMBER) {
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
        OutputView.outputWinnintStatistics(lottoResult.getRankCounts());
        lottoResult.calculateRateOfReturn(purchaseAmount);
        OutputView.outputRateOfReturn(lottoResult.getRateOfReturn());
    }
    
    void calculateMatchedCount() {
        for (Lotto lotto : lottos.lottos) {
            int matchedCount = lotto.matchedCount(lotteryNumbers.winningNumbers);
            boolean isBonus = lotto.isContain(lotteryNumbers.bonusNumber);
            Rank rank = Rank.findRank(matchedCount, isBonus);
            lottoResult.addRankCount(rank);
        }
    }
}
