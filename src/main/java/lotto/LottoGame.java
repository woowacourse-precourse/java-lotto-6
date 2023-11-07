package lotto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoGame {
    private List<Integer> winningLottoNumbers;
    private int bonusNumber;

    public void inputLottoNumbers(List<Integer> winningNumbers) {
//        try {
            winningLottoNumbers = winningNumbers;
            validateWinningNumberSize();
            validateNumberRange();
            validateDuplicateWinningNumber();
//        } catch (IllegalArgumentException e) {
//            System.out.println("[ERROR] " + e.getMessage());
//        }
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lo : lottos) {
            System.out.println(lo.getNumbers());
        }
    }

    public void checkPrizeNumber(List<Lotto> lottos, int bonusNumber) {
        this.bonusNumber = bonusNumber;
        int totalMoney = lottos.size() * Price.LOTTO.getLottoPrice();
        HashMap<Prize, Integer> map = new HashMap<>();

        for (Prize prize : Prize.values()) {
            map.put(prize, 0);
        }

        for (Lotto lotto : lottos) {
            saveMap(lotto, map);
        }
        PrizePrint(map, totalMoney);
    }

    private void saveMap(Lotto lotto, HashMap<Prize, Integer> map) {
        int count = 0;
        boolean bonusMatch = false;

        for (int number : lotto.getNumbers()) {
            if(winningLottoNumbers.contains(number)) count++;
            if(number == bonusNumber) bonusMatch = true;
        }
        Prize prize = Prize.valueOf(count, bonusMatch);
        map.put(prize, map.get(prize) + 1);
    }

    private void validateWinningNumberSize() {
        if(winningLottoNumbers.size() != 6)
            throw new IllegalArgumentException(",로 구분하여 6개의 숫자를 입력하세요" + winningLottoNumbers);
    }

    private void validateNumberRange() {
        for(int number : winningLottoNumbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다." + winningLottoNumbers);
            }
        }
    }

    private void validateDuplicateWinningNumber() {
        Set<Integer> numbersSet = new HashSet<>();
        for (int number : winningLottoNumbers) {
            if (!numbersSet.add(number)) {
                throw new IllegalArgumentException("중복된 번호가 존재합니다: " + winningLottoNumbers);
            }
        }
    }

    private void PrizePrint(HashMap<Prize, Integer> map, int totalMoney) {
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
        double profitRate = calculateProfit(totalMoney, map);
        String profitRateFormatted = String.format("%.1f", profitRate);
        System.out.println("총 수익률은 " + profitRateFormatted + "%입니다.");
    }

    private double calculateProfit(int totalMoney, HashMap<Prize, Integer> map) {
        long profit = 0;

        for (Map.Entry<Prize, Integer> entry : map.entrySet()) {
            Prize prize = entry.getKey();
            int count = entry.getValue();
            profit += (long) (prize.getPrize()) * count;
        }
        return (profit / (double) totalMoney) * 100;
    }

}
