package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Collections;

import camp.nextstep.edu.missionutils.*;

public class Lotto {

    private final List<Integer> numbers;
    
    public Lotto() {
        numbers = new ArrayList<>();
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또는 6개의 숫자만 가능합니다.");
        }
    }

    public int getUserPurchaseAmount() {
        System.out.println("구입금액을 입력해주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine());

        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원단위로 입력하여야 합니다.");
        }

        System.out.println();
        return purchaseAmount;
    }

    public List<Integer> drawLottoNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(randomNumbers);
        System.out.println(randomNumbers);
        return randomNumbers;
    }
    
    public void printPurchaseLottoNumbers() {
        int amount = getUserPurchaseAmount();

        System.out.println((amount / 1000) + "개를 구매했습니다.");

        List<List<Integer>> purchasedLottoNumbers = new ArrayList<>();

        for (int i = 0; i < amount/1000; i++) {
            purchasedLottoNumbers.add(drawLottoNumbers());
        }

        List<Integer> winningNumbers = getWinningNumber();
        int[] matchArr = new int[5];
        int bonusNum = getValidBonusNumber(new HashSet<Integer>(winningNumbers));

        for (List<Integer> lottoNumbers : purchasedLottoNumbers) {
            int matchingNumbers = countMatchingNumbers(lottoNumbers, winningNumbers);
            if(matchingNumbers == 5 && winningNumbers.contains(bonusNum)) {
                matchingNumbers = 7;
            }
            updateMatchArr(matchArr, matchingNumbers);
        }
        
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+matchArr[0]+"개");
        System.out.println("4개 일치 (50,000원) - "+matchArr[1]+"개");
        System.out.println("5개 일치 (1,500,000원) - "+matchArr[2]+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+matchArr[3]+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+matchArr[4]+"개");
        
        int totalPrize = (matchArr[0] * 5000) + (matchArr[1] * 50000) + (matchArr[2] * 1500000) + (matchArr[3] * 30000000) + (matchArr[4] * 200000000);
        double rateOfReturn = Math.round(totalPrize / (double) amount * 1000) / 10;

        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
        
    }
    
    

    private void updateMatchArr(int[] matchArr, int matchingNumbers) {
        switch (matchingNumbers) {
            case 3:
                matchArr[0]++;
                break;
            case 4:
                matchArr[1]++;
                break;
            case 5:
                matchArr[2]++;
                break;
            case 6:
                matchArr[4]++;
                break;
            case 7:
                matchArr[3]++;
                break;
        }
    }
    
    public List<Integer> getWinningNumber() {
        System.out.println();

        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String getNumber = Console.readLine();
                String[] numberList = getNumber.split(",");

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

                validate(new ArrayList<>(winningNumber));

                
                return new ArrayList<>(winningNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getValidBonusNumber(HashSet<Integer> winningNumber) {
        while (true) {
            try {
                System.out.println();
                System.out.println("보너스 번호를 입력해 주세요.");
                int bonusNum = getBonusNumber();
                if (winningNumber.contains(bonusNum)) {
                    throw new IllegalArgumentException("[ERROR] 로또번호와 중복된 보너스 번호가 입력되었습니다. 보너스 번호를 다시 입력하세요.");
                } else if (!winningNumber.contains(bonusNum)) {
                    return bonusNum;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public int countMatchingNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int cnt = 0;
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                cnt++;
            }
        }
        return cnt;
    }

    

    public int getBonusNumber() {
        
        int bonusNum = Integer.parseInt(Console.readLine());
        if (bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return bonusNum;
    }

}
