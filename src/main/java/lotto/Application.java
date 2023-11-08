package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int price = 0;

        while (true) {
            System.out.println("구입 금액을 입력해 주세요.");
            try {
                price = Integer.parseInt(readLine());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 형식이 올바르지 않습니다.");
                continue;
            }
            try {
                if (price % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] IllegalArgumentException");
                } else if (price % 1000 == 0){
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }
        // 구매 출력
        int lottoCnt = price / 1000;
        List<Lotto> lottos = new ArrayList<Lotto>();

        for (int i = 0; i < lottoCnt; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

            lottos.add(new Lotto(new ArrayList<Integer>(numbers)));
        }
        int[] goalCount = new int[10];
        System.out.println(lottoCnt + "개를 구매했습니다.");
        for (int i = 0; i < lottos.size(); i++) {
            lottos.get(i).printNumbers();
        }

        // 당첨 번호 입력받기
        Lotto goal;
        int bonusNumber;
        while (true) {
            List<Integer> numbers = new ArrayList<Integer>();
            System.out.println("당첨 번호를 입력해 주세요.");
            String strInput = readLine();
            String[] strNumbers = strInput.split(",");

            try {
                for (int i = 0; i < strNumbers.length; i++) {
                    int parseNumber = Integer.parseInt(strNumbers[i]);
                    if (parseNumber < 1 || parseNumber > 45) {
                        throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                    }
                    numbers.add(parseNumber);
                }
                System.out.println("보너스 번호를 입력해 주세요.");
                bonusNumber = Integer.parseInt(readLine());
                if (bonusNumber < 1 || bonusNumber > 45) {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                }
                goal = new Lotto(numbers);
                goal.inspectBouns(bonusNumber);

                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }

        int getPrice = 0;
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = 0; i < lottos.size(); i++) {
            int result = Lotto.equalCount(lottos.get(i), goal);
            if (result == 5) {
                goalCount[7]++;
                getPrice += 2000000000;
            } else if (result == 4) {
                goalCount[6]++;
                getPrice += 30000000;
            } else if (result == 3) {
                goalCount[5]++;
                getPrice += 1500000;
            } else if (result == 2) {
                goalCount[4]++;
                getPrice += 50000;
            } else if (result == 1) {
                goalCount[3]++;
                getPrice += 5000;
            }
        }
        System.out.println("3개 일치 (5,000원) - " + goalCount[3] + "개");
        System.out.println("4개 일치 (50,000원) - " + goalCount[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + goalCount[5] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + goalCount[6] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + goalCount[7] + "개");
        double result = ((double) getPrice / (double) price * 100.0);
        result = Math.ceil(result * 100) / 100;
        System.out.println("총 수익률은 " + result + "%입니다.");
    }
}

