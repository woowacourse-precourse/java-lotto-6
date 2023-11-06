package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoGame {
    private List<Integer> winningLottoNumbers;
    private int bonusNumber;

    public void inputLottoNumbers() {
        winningLottoNumbers = Arrays.stream(Console.readLine().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void inputBonusNumber() {
        bonusNumber = Integer.parseInt(Console.readLine());
    }

    public void printLottos(List<Lotto> lotts) {
        for (Lotto lo : lotts) {
            System.out.println(lo.getNumbers());
        }
    }

    public void checkNumber(List<Lotto> lottos) {
        int totalMoney = lottos.size() * Price.LOTTO.getLottoPrice();
        HashMap<Prize, Integer> map = new HashMap<>();

        for (Prize prize : Prize.values()) {
            map.put(prize, 0);
        }
        
        for (Lotto lotto : lottos) {
            int count = 0;
            boolean bonusMatch = false;
            
            for (int number : lotto.getNumbers()) {
                if(winningLottoNumbers.contains(number)) count++;
                if(number == bonusNumber) bonusMatch = true;
            }
            Prize prize = Prize.valueOf(count, bonusMatch);
            map.put(prize, map.get(prize) + 1);
        }
        printCheck(map, totalMoney);
    }

    private void printCheck(HashMap<Prize, Integer> map, int totalMoney) {
        for (Prize prize : Prize.values()) {
            int count = prize.getCount();
            String prizeAmountFormatted = String.format("%,d", prize.getPrize());

            if(count == 0) continue;
            if(prize == Prize.BONUS) {
                System.out.println(count + "개 일치, 보너스 볼 일치 (" + prizeAmountFormatted + "원) - " + map.get(prize) + "개");
                continue;
            }
            System.out.println(count + "개 일치 (" + prizeAmountFormatted + "원) - " + map.get(prize) + "개");
        }
        double profitRate = calculate(totalMoney, map);
        String profitRateFormatted = String.format("%.1f", profitRate);
        System.out.println("총 수익률은 " + profitRateFormatted + "%입니다.");
    }

    private double calculate(int totalMoney, HashMap<Prize, Integer> map) {
        long profit = 0;

        for (Map.Entry<Prize, Integer> entry : map.entrySet()) {
            Prize prize = entry.getKey();
            int count = entry.getValue();
            profit += (long) (prize.getPrize()) * count;
        }
        return (profit / (double) totalMoney) * 100;
    }

}
