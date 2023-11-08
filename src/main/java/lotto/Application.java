package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        // TODO: 프로그램 구현

        // 1. 구매금액
        System.out.println("구입금액을 입력해 주세요.");
        int price = getInputPrice();
        System.out.println();

        // 2. 구매한 로또 장수
        int lottoPapers = price/1000;
        System.out.println(lottoPapers+"개를 구매했습니다.");

        // 3. 로또번호 생성
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0; i<lottoPapers; i++){
            lottos.add(new Lotto());
        }
        for (Lotto lotto: lottos){
            System.out.println(lotto.myLotto());
        }
        System.out.println();

        // 4. 당첨번호 입력 + 보너스번호 입력
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winNumbers = getWinNumbers();
        System.out.println();

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = getBonusNumber();
        System.out.println();

        // 5. 당첨통계(일치개수, 수익률)

        int[] matchCounts = new int[6]; // 각 등수별 일치 개수 카운트
        int totalWinningAmount = 0; // 총 당첨금액

        for (Lotto lotto : lottos) {
            int matchCount = countMatch(winNumbers, lotto);
            matchCounts[matchCount]++; // 일치 개수별로 카운트 증가
        }

        int totalPurchasedLottos = lottos.size();
        double totalSpent = totalPurchasedLottos * 1000;

        System.out.println("당첨 통계");
        System.out.println("---");

        for (int i = 3; i < matchCounts.length; i++) {
            int count = matchCounts[i];
            int winningAmount = calculateWinningAmount(i);
            totalWinningAmount += winningAmount * count;

            if (winningAmount > 0) {
                System.out.printf("%d개 일치 (%,d원) - %d개%n", i, winningAmount, count);
            }
        }

        double profitRate = totalWinningAmount / totalSpent * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);

    }

    public static int getInputPrice() {
        while (true) {
            String inputPrice = Console.readLine();
            int price;

            try {
                price = Integer.parseInt(inputPrice);

                if (price % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력하세요.");
                } else {
                    return price; // 1000원 단위로 입력된 경우 함수를 빠져나감
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 올바른 숫자를 입력하세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 에러 메시지 출력
            }
        }
    }

    private static List<Integer> separateComma(String input, int count) {
        List<Integer> numbers = new ArrayList<>();

        while (true) {
            String[] numberStrings = input.split(",");

            if (numberStrings.length != count) {
                System.out.println("[ERROR] 6개의 숫자를 입력하세요.");
                input = Console.readLine(); // 다시 입력 받음
            } else {
                for (String numberStr : numberStrings) {
                    numbers.add(checkNumbers(numberStr));
                }
                return numbers;
            }
        }
    }

    private static int checkNumbers(String input) {
        while (true) {
            try {
                int bonusNumber = Integer.parseInt(input);
                if(bonusNumber>=1 && bonusNumber<=45){
                    return bonusNumber;
                }else{
                    System.out.println("[ERROR] 1~45 사이의 숫자를 입력하세요.");
                    input = Console.readLine();
                }
                //return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 1~45 사이의 숫자를 입력하세요.");
                input = Console.readLine(); // 다시 입력 받음
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                input = Console.readLine(); // 다시 입력 받음
            }
        }
    }

    public static List<Integer> getWinNumbers(){
        String winNumbers = Console.readLine();
        return separateComma(winNumbers,6);
    }
    public static int getBonusNumber(){
        String bonusNumber = Console.readLine();
        return checkNumbers(bonusNumber);
    }

    private static int countMatch(List<Integer> winNumbers, Lotto lotto) {
        int matchCount = 0;
        for (int number : lotto.getNumbers()) {
            if (winNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private static int calculateWinningAmount(int matchCount) {
        if (matchCount == 3) {
            return 5000;
        } else if (matchCount == 4) {
            return 50000;
        } else if (matchCount == 5) {
            return 1500000;
        } else if (matchCount == 6) {
            return 2000000000;
        } else {
            return 0;
        }
    }

}
