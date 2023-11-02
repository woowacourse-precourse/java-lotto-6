package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // 구입 금액 입력
        System.out.println("구입금액을 입력해 주세요.");
        String inputCost = Console.readLine();
        int buyCost = Integer.parseInt(inputCost);
        int count = buyCost / 1000;

        // 구입한 로또 수량 및 번호 출력
        System.out.println();
        System.out.println(count + "개를 구매했습니다.");
        List<List<Integer>> manyLotto = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> oneLotto = Randoms.pickUniqueNumbersInRange(1, 45,6);
            Collections.sort(oneLotto);
            manyLotto.add(oneLotto);
        }
        for (List<Integer> oneLotto : manyLotto) {
            System.out.print("[" + oneLotto.get(0));
            for (int i = 1; i < oneLotto.size(); i++) {
                System.out.print(", "+oneLotto.get(i));
            }
            System.out.println("]");
        }

        // 당첨 번호 입력
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputWinningNumber = Console.readLine();
        List<Integer> winningNum = new ArrayList<>();
        for (String token : inputWinningNumber.split(",")) {
            int oneNum = Integer.parseInt(token);
            winningNum.add(oneNum);
        }

        // 보너스 번호 입력
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonusNum = Console.readLine();
        int bonusNum = Integer.parseInt(inputBonusNum);

        // 각 로또마다 당첨번호와 일치하는 숫자 개수, 보너스 숫자와의 일치 여부 구하기
        List<Integer> matchedNumber = new ArrayList<>();
        List<Boolean> matchedBonusNum = new ArrayList<>();
        for (List<Integer> oneLotto : manyLotto) {
            int matched = 0;
            for (Integer num : oneLotto) {
                if (winningNum.contains(num)) {
                    matched++;
                }
            }
            matchedNumber.add(matched);
            if (oneLotto.contains(bonusNum)) {
                matchedBonusNum.add(true);
            }
            if (!oneLotto.contains(bonusNum)) {
                matchedBonusNum.add(false);
            }
        }

        // 각 로또의 당첨금별 일치하는 숫자 개수 구하기
        Map<Integer, Integer> winnerCount = new LinkedHashMap<>();
        winnerCount.put(5000, 0);
        winnerCount.put(50000, 0);
        winnerCount.put(1500000, 0);
        winnerCount.put(30000000, 0);
        winnerCount.put(2000000000, 0);

        for (int i = 0; i < matchedNumber.size(); i++) {
            int num = matchedNumber.get(i);
            int lottoCounts;
            if (num == 3) {
                winnerCount.put(5000, winnerCount.get(5000)+1);
            }
            else if (num == 4) {
                winnerCount.put(50000, winnerCount.get(50000)+1);
            }
            else if (num == 5 && !matchedBonusNum.get(i)) {
                winnerCount.put(1500000, winnerCount.get(1500000)+1);
            }
            else if (num == 5 && matchedBonusNum.get(i)) {
                winnerCount.put(30000000, winnerCount.get(30000000)+1);
            }
            else if (num == 6) {
                winnerCount.put(2000000000, winnerCount.get(2000000000)+1);
            }
        }

        // 당첨 통계 산출 결과 출력하기
        System.out.println();
        System.out.println("당첨 통계\n---");
        DecimalFormat prize = new DecimalFormat("###,###");
        for (Integer key : winnerCount.keySet()) {
            System.out.println(key + "원 - " + winnerCount.get(key) + "개");
        }

        // 수익률 산출 및 출력하기
        long totalPrize = 0;
        for (Integer key : winnerCount.keySet()) {
            totalPrize += (long)key * winnerCount.get(key);
        }
        double returnRates = (double)totalPrize*100/buyCost;
        System.out.println("총 수익률은 " + String.format("%.1f", returnRates) + "%입니다.");
        Console.close();
    }
}
