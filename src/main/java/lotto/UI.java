package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UI {
    public static Integer inputMoney() {
        Integer payment = 0;
        System.out.println("구입금액을 입력해 주세요.");
        String line = readLine();
        System.out.println();
        try {
            payment = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력하지 않았습니다.");
        }
        return payment;
    }


    public static void printPurchases(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            printLotto(lotto);
        }
        System.out.println();
    }

    private static void printLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        List unmodifiableNumbers = Collections.unmodifiableList(numbers);
        List newNumbers = new ArrayList(unmodifiableNumbers);
        Collections.sort(newNumbers);
        newNumbers.sort(Comparator.naturalOrder());

        System.out.print("[");
        for (int i = 0; i < Lotto.size; i++) {
            System.out.print(newNumbers.get(i));
            if (i < Lotto.size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static List<Integer> inputWinningNumbers() {
        List<Integer> numbers = null;
        System.out.println("당첨 번호를 입력해주세요.");
        String line = readLine();
        System.out.println();
        String[] split = line.split(",");
        try {
            numbers = Arrays.stream(split).map(Integer::parseInt).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(",문자 사이사이에 숫자를 입력하셔야 합니다.");
        }

        return numbers;
    }

    public static Integer inputBonusNumber() {
        Integer bonus;
        System.out.println("보너스 번호를 입력해 주세요.");
        String line = readLine();
        System.out.println();
        try {
            bonus = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력하지 않았습니다.");
        }
        return bonus;
    }

    public static void printWinningStats(List<Lotto> lottos, LottoDrawResult lottoDrawResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        Map<Grade, Integer> winningFrequency = obtainWinningFrequency(lottos, lottoDrawResult);
        printWinningFrequency(winningFrequency);
        printReturnRate(lottos, lottoDrawResult);
    }

    private static Map<Grade, Integer> obtainWinningFrequency(List<Lotto> lottos, LottoDrawResult lottoDrawResult) {
        Map<Grade, Integer> winningFrequency = new HashMap<>();
        initializeWinningFrequency(winningFrequency);

        for (Lotto lotto : lottos) {
            Grade grade = Calculator.checkWinning(lotto, lottoDrawResult);
            if (grade == Grade.NONE) {
                continue;
            }
            Integer frequency = winningFrequency.get(grade);
            winningFrequency.put(grade, frequency + 1);
        }
        return winningFrequency;
    }

    private static void initializeWinningFrequency(Map<Grade, Integer> winningFrequency) {
        winningFrequency.put(Grade.FIRST, 0);
        winningFrequency.put(Grade.SECOND, 0);
        winningFrequency.put(Grade.THIRD, 0);
        winningFrequency.put(Grade.FOURTH, 0);
        winningFrequency.put(Grade.FIFTH, 0);
    }

    private static void printWinningFrequency(Map<Grade, Integer> winningFrequency) {
        Integer frequency = winningFrequency.get(Grade.FIFTH);
        System.out.println("3개 일치 (5,000원) - " + frequency + "개");
        frequency = winningFrequency.get(Grade.FOURTH);
        System.out.println("4개 일치 (50,000원) - " + frequency + "개");
        frequency = winningFrequency.get(Grade.THIRD);
        System.out.println("5개 일치 (1,500,000원) - " + frequency + "개");
        frequency = winningFrequency.get(Grade.SECOND);
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + frequency + "개");
        frequency = winningFrequency.get(Grade.FIRST);
        System.out.println("6개 일치 (2,000,000,000원) - " + frequency + "개");
    }

    private static void printReturnRate(List<Lotto> lottos, LottoDrawResult lottoDrawResult) {
        Double returnRate = Calculator.returnRate(lottos, lottoDrawResult);
        String returnRateByRound = String.format("%.1f", returnRate);
        System.out.print("총 수익률은 " + returnRateByRound + "%입니다.");
    }
}
