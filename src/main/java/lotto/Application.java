package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.Lotto.*;

public class Application {
    public static void main(String[] args) {
        int bonusNumber = 0;
        // TODO: 프로그램 구현
        // 구입 금액 입력
        int purchaseAmount = 0;
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                purchaseAmount = Integer.parseInt(readLine());
                if (purchaseAmount % 1000 == 0) {
                    break;
                }
                System.out.println("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
            }
            catch(NumberFormatException e){
                System.out.println("[ERROR] 잘못된 입력입니다. 숫자를 입력하세요.");
            }
        }
        // 로또 발행
        int numberOfLotto = purchaseAmount / 1000;
        List<List<Integer>> lottoList = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            lottoList.add(generateRandomLotto());
        }

        //구매했다고 알림
        System.out.println("\n" + numberOfLotto + "개를 구매했습니다.");
        for (int i = 0; i < numberOfLotto; i++) {
            System.out.print("[");
            for (int j = 0; j < 5; j++) {
                System.out.print(lottoList.get(i).get(j) + ", ");
            }
            System.out.println(lottoList.get(i).get(5) + "]");
        }

        // 당첨 번호 입력

        List<Integer> winningNumbers = new ArrayList<>();
        Set<Integer> numbersSet = new LinkedHashSet<>();
        while(true) {
            System.out.println("\n당첨 번호를 입력해 주세요.");
            try {
                String input = readLine();
                String[] numbers = input.split(",");
                if (numbers.length != 6) {
                    throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력하세요.");
                }


                for (int i = 0; i < 6; i++) {
                    winningNumbers.add(Integer.parseInt(numbers[i]));
                    numbersSet.add(Integer.parseInt(numbers[i]));
                    if (winningNumbers.get(i) < 1 || winningNumbers.get(i) > 45) {
                        throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                    }
                }
                if (numbersSet.size() != 6) {
                    throw new IllegalArgumentException("[ERROR] 중복되지 않는 숫자를 입력하세요.");
                }
                System.out.println("\n보너스 번호를 입력해 주세요.");
                bonusNumber = Integer.parseInt(readLine());
                if (bonusNumber < 1 || bonusNumber > 45) {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // 로또 당첨 확인
        int[] results = new int[6];
        for (List<Integer> lotto : lottoList) {
            int matchedNumbers = countMatchedNumbers(lotto, winningNumbers);
            boolean hasBonusNumber = hasBonusNumber(lotto, bonusNumber);
            int prize = getPrize(matchedNumbers, hasBonusNumber);
            if (prize > 0) {
                results[prize]++;
            }
        }

        // 결과 출력
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + results[5] +"개");
        System.out.println("4개 일치 (50,000원) - " + results[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + results[3] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + results[2] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + results[1] + "개");
        double totalPrizeAmount = calculateTotalPrizeAmount(results);
        double profitRate = (totalPrizeAmount / purchaseAmount) * 100;
        String formattedProfitRate = String.format("%,f", profitRate);
        System.out.printf("총 수익률은 %.1f%%입니다.", profitRate);
    }
}
