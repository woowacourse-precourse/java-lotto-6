package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.assertj.core.util.Arrays;

public class Game {
    int purchaseAmount;
    List<Integer> winningNumbers;
    int bonusNumber;
    
    void play() {
        calculateNumberOfPurchase();
        showPurchasedLottos();
        setWinningNumbers();
        setBonusNumber();
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
        Lottos lottos = new Lottos(purchaseAmount);
        lottos.printLottos();
        System.out.println();
    }
    
    void setWinningNumbers() {
        OutputView.outputWinningNumbers();
        winningNumbers = checkWinningNumbers(InputView.inputWinningNumbers());
        System.out.println();
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
    
    void setBonusNumber() {
        OutputView.outputBonusNumber();
        bonusNumber = checkBonusNumber(InputView.inputBonusNumber());
        System.out.println();
    }
    
    int checkBonusNumber(String inputBonusNumber) {
        int convertedBonusNumber = checkInteger(inputBonusNumber);
        checkLottoNumberRange(convertedBonusNumber);
        checkDuplication(convertedBonusNumber);
        
        return convertedBonusNumber;
    }
    
    void checkDuplication(int number) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException("[Error] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
