package lotto;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_NUMBERS_COUNT = 6;

    private int gameCount;
    private List<Lotto> lottogame;

    public void setLottoGame(int number){
        this.gameCount = number;
    }

    public void validatePurchaseAmount() {
        while (true) {
            try {
                int price = Integer.parseInt(Console.readLine());
                if (price <= 0 || price % LOTTO_PRICE != 0) {
                    System.out.println("[ERROR] 1,000원 단위로 입력해 주세요.");
                    continue; 
                }
                setLottoGame(price / LOTTO_PRICE);
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            }
        }
    }
    

    public void generateLottoNumbers() {
        this.lottogame = new ArrayList<>();
        System.out.println(this.gameCount+"개를 구매했습니다.");
        for (int i = 0; i < this.gameCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBERS_COUNT);
            Lotto lotto = new Lotto(numbers);
            lottogame.add(lotto);
        }
        printLotto();
    }

    public void printLotto() {
        for (Lotto lotto : this.lottogame) {
            List<Integer> sortedNumbers = new ArrayList<>(lotto.getNumbers());
            Collections.sort(sortedNumbers);
            System.out.println(sortedNumbers);
        }
    }

    public void printLottoWin(LottoWin lottoWin) {
        int match3 = 0;
        int match4 = 0;
        int match5 = 0;
        int match5WithBonus = 0;
        int match6 = 0;
    
        for (Lotto numbers : this.lottogame) {
            int matchingNumbers = countMatchingNumbers(numbers, lottoWin.getWinNumbers());
            boolean hasBonusNumber = numbers.containsNumber(lottoWin.getBonusNumber());
    
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

        System.out.println("3개 일치 (5,000원) - " + match3 + "개");
        System.out.println("4개 일치 (50,000원) - " + match4 + "개");
        System.out.println("5개 일치 (1,500,000원) - " + match5 + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + match5WithBonus + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + match6 + "개");

        getEarningRate(match3, match4, match5, match5WithBonus, match6);
    }
    
    private int countMatchingNumbers(Lotto userNumbers,  Lotto winNumbers) {
        int count = 0;
        List<Integer> userNumberList = userNumbers.getNumbers();
        List<Integer> winNumberList = winNumbers.getNumbers();
    
        for (int number : userNumberList) {
            if (winNumberList.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public void getEarningRate(int match3, int match4, int match5, int match5WithBonus, int match6){
        int price = this.gameCount*1000;
        int totalPrice = match3 * 5000 + match4 * 50000 + match5 * 1500000 + match5WithBonus * 30000000 + match6 * 2000000000;
        float earningRate = (totalPrice/(float)price) * 100;
        double roundedEarningRate = Math.round(earningRate * 100.0) / 100.0;
        System.out.println("총 수익률은 " + roundedEarningRate + "%입니다.");
    }

}
