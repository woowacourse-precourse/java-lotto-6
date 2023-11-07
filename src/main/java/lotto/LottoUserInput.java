package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class LottoUserInput {
    
    enum MatchType {
        THREE(3, 5000),
        FOUR(4, 50000),
        FIVE(5, 1500000),
        FIVE_WITH_BONUS(5, 30000000),
        SIX(6, 200000000);

        private final int matchingNumbers;
        private final int prize;

        MatchType(int matchingNumbers, int prize) {
            this.matchingNumbers = matchingNumbers;
            this.prize = prize;
        }

        public int getMatchingNumbers() {
            return matchingNumbers;
        }

        public int getPrize() {
            return prize;
        }
    }

    public List<Integer> drawLottoNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(randomNumbers);
        System.out.println(randomNumbers);
        return randomNumbers;
    }

    public List<Integer> printPurchaseLottoNumbers() {
        
        int purchaseAmount = getUserPurchaseAmount();
        int numberOfPurchasedLotto = purchaseAmount / 1000;
        System.out.println(numberOfPurchasedLotto + "개를 구매했습니다.");
        
        List<List<Integer>> purchasedLottoNumbers = new ArrayList<>();
        for (int i = 0; i < numberOfPurchasedLotto; i++) {
            List<Integer> lottoNumbers = drawLottoNumbers();
            purchasedLottoNumbers.add(lottoNumbers);
        }
        
        List<Integer> winningNumbers = getWinningNumber();
        int bonusNumber = getValidBonusNumber(new HashSet<>(winningNumbers));
        
        int[] matchCount = new int[MatchType.values().length];
        
        
        for (List<Integer> numbers : purchasedLottoNumbers) {
            int matchingNumbers = countMatchingNumbers(numbers, winningNumbers, bonusNumber);
            updateMatchArr(matchCount, matchingNumbers);
        }
        
        printMatchStatistics(matchCount);
        
        double rateOfReturn = calculateRateOfReturn(matchCount, purchaseAmount);
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
        return winningNumbers;
    }

    private void updateMatchArr(int[] matchArr, int matchingNumbers) {
        if (matchingNumbers == 7 ) {
            matchArr[MatchType.FIVE_WITH_BONUS.ordinal()]++;
        } else if(matchingNumbers != 7) {
            for (MatchType matchType : MatchType.values()) {
                if (matchingNumbers == matchType.getMatchingNumbers()) {
                    matchArr[matchType.ordinal()]++;
                    break;
                }
            }
        }
    }


    private void printMatchStatistics(int[] matchCount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        NumberFormat nf = NumberFormat.getInstance();
        for (MatchType matchType : MatchType.values()) {
            int prize = matchType.getPrize();
            int count = matchCount[matchType.ordinal()];
            String formattedPrize = nf.format(prize);
            System.out.println(matchType.getMatchingNumbers() + "개 일치 (" + formattedPrize + "원) - " + count + "개");
        }
    }

    private double calculateRateOfReturn(int[] matchCount, int purchaseAmount) {
        int totalPrize = 0;
        
        for (int i = 0; i < matchCount.length; i++) {
            totalPrize += matchCount[i] * MatchType.values()[i].getPrize();
        }
        return Math.round(totalPrize / (double) purchaseAmount * 1000) / 10.0;
    }

    
    public int countMatchingNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        int cnt = 0;
        boolean isBonus = false;
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                cnt++;
            }
            if (number == bonusNumber) {
                isBonus = true;
            }
        }
        if (cnt == 5 && isBonus) {
            return 7;
        }
        return cnt;
    }

    public int getUserPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String purchaseAmount = Console.readLine();
                if (!purchaseAmount.matches("\\d+")) {
                    throw new IllegalArgumentException("[ERROR] 구입금액은 숫자로 입력해야 합니다.");
                }
                int amount = Integer.parseInt(purchaseAmount);
                if (amount % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 구입금액은 1000원단위로 입력해야 합니다.");
                }
                System.out.println();
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> getWinningNumber() {
        System.out.println();
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                String[] numberList = input.split(",");
                HashSet<Integer> winningNumber = new HashSet<>();

                for (String numberValue : numberList) {
                    int number = Integer.parseInt(numberValue.trim());

                    if (number < 1 || number > 45) {
                        throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                    }
                    if (!winningNumber.add(number)) {
                        throw new IllegalArgumentException("[ERROR] 중복된 번호가 입력되었습니다.");
                    }
                }
                return new ArrayList<>(winningNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getValidBonusNumber(HashSet<Integer> winningNumber) {
        while (true) {
            try {
                System.out.println();
                System.out.println("보너스 번호를 입력해 주세요.");
                int bonusNum = Integer.parseInt(Console.readLine());
                System.out.println();
                if (bonusNum < 1 || bonusNum > 45) {
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
                }
                if (winningNumber.contains(bonusNum)) {
                    throw new IllegalArgumentException("[ERROR] 로또 번호와 중복된 보너스 번호가 입력되었습니다. 보너스 번호를 다시 입력하세요.");
                }
                return bonusNum;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
