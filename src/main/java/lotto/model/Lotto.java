package lotto.model;
import java.util.*;
import lotto.exception.Exceptions;

import static lotto.controller.LottoController.rankCounts;
import static lotto.model.LottoConstantsNumber.*;
import static lotto.view.LottoView.printTotalRate;
import static lotto.view.LottoView.purchaseAmount;

import camp.nextstep.edu.missionutils.Randoms;
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        this.numbers = numbers;
    }
    
    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw Exceptions.exceptionLottoSize();
        }
    }

    public static void validateInputPurchaseAmount(int price) {
        if(price<1000||price%1000!=0) {
            throw Exceptions.exceptionInputPurchaseAmountNotInRange();
        }
    }

    public static void validateInputPurchaseAmountContainCharacter(String inputPurchaseAmount) {

        for(int i=0;i<inputPurchaseAmount.length();i++){
            char partOfInputPurchaseAmount=inputPurchaseAmount.charAt(i);
            if(partOfInputPurchaseAmount-'0'<0||partOfInputPurchaseAmount-'0'>9){
                throw Exceptions.exceptionInputPurchaseAmountContainCharacter();
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static List<Lotto> createLottoList(int price) {
        price /= 1000;
        List<Lotto> LottoList = new ArrayList<>();
        while (price> 0) {
            LottoList.add(createLotto());
            price--;
        }
        return LottoList;
    }

    public static Lotto createLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(lottoMinNumber, lottoMaxNumber, lottoPcs);
        Collections.sort(randomNumbers);
        return new Lotto(randomNumbers);
    }

    public static String[] validateInputWinningNumberInRange(String winningNumber){
        String[] numberStrings = winningNumber.split(",");
        for (String eachNumberStr : numberStrings) {
            int eachNumber=Integer.parseInt(eachNumberStr);
            if(eachNumber<1||eachNumber>45){
                throw Exceptions.exceptionWinningNumberNotInRange();
            }
        }
        return numberStrings;
    }

    public static String[] validateInputWinningNumberDuplication(String[] winningNumbers){
        Set<String> uniqueNumbers = new HashSet<>();
        for (String eachNumber : winningNumbers) {
            if (!uniqueNumbers.add(eachNumber)) {
                throw Exceptions.exceptionWinningNumberDuplication();
            }
        }
        return winningNumbers;
    }

    public static void validateInputBonusNumberInRange(String inputBonusNumber){
        int bonusNumber=Integer.parseInt(inputBonusNumber);
        if(bonusNumber<1||bonusNumber>45){
            throw Exceptions.exceptionBonusNumberNotInRange();
        }

    }

    public static void validateInputBonusNumberDuplication(String inputBonusNumber,String[] winningNumbers){
        for (String eachNumber : winningNumbers) {
            if (eachNumber.equals(inputBonusNumber)) {
                throw Exceptions.exceptionBonusNumberDuplication();
            }
        }
    }

    public enum WinningRank {
        FIRST(6, 2000000000),
        SECOND(5, 30000000),
        THIRD(5, 1_500_000),
        FOURTH(4, 50_000),
        FIFTH(3, 5_000),
        NONE(0,0);
        private final int matchingCount;
        private final int prize;

        WinningRank(int matchingCount, int prize) {
            this.matchingCount = matchingCount;
            this.prize = prize;
        }

        public int getMatchingCount() {
            return matchingCount;
        }

        public int getPrize() {
            return prize;
        }


        public static WinningRank calculateRank(int matchingCount, boolean hasBonusNumber) {
            if (matchingCount == 6) {
                return FIRST;
            }
            if (matchingCount == 5) {
                if (hasBonusNumber) {
                    return SECOND;
                }
                return THIRD;
            }
            if (matchingCount == 4) {
                return FOURTH;
            }
            if (matchingCount == 3) {
                return FIFTH;
            }
            return NONE;
        }

    }


}
