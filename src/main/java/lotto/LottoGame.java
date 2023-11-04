package lotto;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_NUMBERS_COUNT = 6;

    private int gameCount;
    private List<List<Integer>> lottogame;

    public void setLottoGame(int number){
        this.gameCount = number;
    }

    public void validatePurchaseAmount(int price){
        if (price % LOTTO_PRICE == 0){
            setLottoGame(price / LOTTO_PRICE);
        } else {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해 주세요.");
        }
    }

    public void generateLottoNumbers() {
        this.lottogame = new ArrayList<>();
        for (int i = 0; i < this.gameCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBERS_COUNT);
            Collections.sort(numbers);
            lottogame.add(numbers);
        }
        printLotto();
    }

    public void printLotto() {
        for (List<Integer> numbers : this.lottogame){
            System.out.println(numbers.toString());
        }
    }

    public void printLottoWin(LottoWin lottoWin) {
        int match3 = 0;
        int match4 = 0;
        int match5 = 0;
        int match5WithBonus = 0;
        int match6 = 0;
    
        for (List<Integer> numbers : this.lottogame) {
            int matchingNumbers = countMatchingNumbers(numbers, lottoWin.getWinNumbers());
            boolean hasBonusNumber = numbers.contains(lottoWin.getBonusNumber());
    
            if (matchingNumbers == 3) {
                match3++;
            } else if (matchingNumbers == 4) {
                match4++;
            } else if (matchingNumbers == 5 && hasBonusNumber) {
                match5WithBonus++;
            } else if (matchingNumbers == 5) {
                match5++;
            } else if (matchingNumbers == 6) {
                match6++;
            }
        }
    
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + match3 + "개");
        System.out.println("4개 일치 (50,000원) - " + match4 + "개");
        System.out.println("5개 일치 (1,500,000원) - " + match5 + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + match5WithBonus + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + match6 + "개");
    }
    
    private int countMatchingNumbers(List<Integer> userNumbers, List<Integer> winNumbers) {
        int count = 0;
        for (int number : userNumbers) {
            if (winNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }
    

}
