package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6자리여야 합니다.");
        }
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않는 숫자여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<Integer> allCompare(List<Lotto> allLottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        List<Integer> result = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0));
        for (Lotto lottoNumbers : allLottoNumbers) {
            Rank rank = compareResult(lottoNumbers.compare(winningNumbers), bonusNumber);
            result.set(rank.ordinal(), result.get(rank.ordinal()) + 1);
        }
        return result;
    }

    public int compare(List<Integer> winningNumbers) {
        int count = 0;
        for (Integer i : numbers) {
            if (winningNumbers.contains(i)) {
                count++;
            }
        }
        return count;
    }

    public Rank compareResult(int count, int bonusNumber) {
        if (count == 6) {
            return Rank.FIRST_PLACE;
        }
        if (count == 5) {
            if (numbers.contains(bonusNumber)) {
                return Rank.SECOND_PLACE;
            }
            return Rank.THIRD_PLACE;
        }
        if (count == 4) {
            return Rank.FOURTH_PLACE;
        }
        if (count == 3) {
            return Rank.FIFTH_PLACE;
        }
        return Rank.LAST_PLACE;
    }

    public static void lottoPrint(List<Lotto> lottoNumbers, int quantity) {
        System.out.println("\n" + quantity + "개를 구매했습니다.");
        for (Lotto lotto : lottoNumbers) {
            System.out.println(lotto.numbers);
        }
    }

    public static void prizePrint(List<Integer> result) {
        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + result.get(4) + "개");
        System.out.println("4개 일치 (50,000원) - " + result.get(3) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.get(1) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.get(0) + "개");
    }

    public static String profitCalc(List<Integer> result, int money) {
        List<Integer> profit = new ArrayList<>(Arrays.asList(2000000000, 30000000, 1500000, 50000, 5000, 0));
        double sum = 0.0;
        for (int i = 0; i < result.size(); i++) {
            sum += profit.get(i) * result.get(i);
        }
        System.out.println("sum = " + sum);
        return String.format("%.1f", sum / money * 100);
    }
}
