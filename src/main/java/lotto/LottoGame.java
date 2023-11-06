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
    private static final int LOTTO_TOTAL_NUMBERS_COUNT = 7;

    private int gameCount;
    public List<Lotto> lottogame;

    public LottoGame() {
        this.lottogame = new ArrayList<>();
    }

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
        int[] prizeCounts = calculatePrizeCounts(lottoWin);
        printPrizeCounts(prizeCounts);
        int totalPrize = calculateTotalPrize(prizeCounts);
    
        float earningRate = (totalPrize / (float) (this.gameCount * 1000)) * 100;
        double roundedEarningRate = Math.round(earningRate * 100.0) / 100.0;
        System.out.println("총 수익률은 " + roundedEarningRate + "%입니다.");
    }

    private int[] calculatePrizeCounts(LottoWin lottoWin) {
        int[] matches = new int[8];
    
        for (Lotto numbers : this.lottogame) {
            int matchingNumbers = countMatchingNumbers(numbers, lottoWin.getWinNumbers());
            boolean hasBonusNumber = numbers.containsNumber(lottoWin.getBonusNumber());
            int index = Math.min(matchingNumbers, 6);
    
            if (matchingNumbers == 5 && hasBonusNumber) {
                index = 7;
            }
    
            matches[index]++;
        }
    
        return matches;
    }    

    private int calculateTotalPrize(int[] prizeCounts) {
        int totalPrize = 0;
        for (int i = 3; i <= LOTTO_NUMBERS_COUNT; i++) {
            totalPrize += prizeCounts[i] * Prize.values()[i - 3].getAmount();
        }
        return totalPrize;
    }

    private void printPrizeCounts(int[] prizeCounts) {
        String[] prizeNames = {
            "", "", "", "3개 일치 (5,000원)", "4개 일치 (50,000원)",
            "5개 일치 (1,500,000원)", "5개 일치, 보너스 볼 일치 (30,000,000원)", "6개 일치 (2,000,000,000원)"
        };
    
        for (int i = 3; i <= LOTTO_TOTAL_NUMBERS_COUNT; i++) {
            System.out.println(prizeNames[i] + " - " + prizeCounts[i] + "개");
        }
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

}
