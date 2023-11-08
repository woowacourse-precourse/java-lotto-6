package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        try {
            int lottoAmount = askAmount();
            List<Lotto> lottos = issueLotto(lottoAmount / 1000);
            printLottos(lottos);
            Lotto winningLotto = askWinningNumber();
            int bonusNumber = askBonusNumber(winningLotto.getNumbers());
            printWinningStatistics(lottos, winningLotto, bonusNumber, lottoAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int askAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = -1;
        try {
            amount = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원으로 나누어 떨어져야 합니다.");
        }
        return amount;
    }

    public static List<Lotto> issueLotto(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public static Lotto askWinningNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String[] splited = Console.readLine().split(",");
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String s : splited) {
            try {
                numbers.add(Integer.parseInt(s));
            } catch(NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
            }
        }
        return new Lotto(numbers);
    }

    public static int askBonusNumber(List<Integer> winningNumbers) {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNumber = -1;
        try {
            bonusNumber = Integer.parseInt(Console.readLine());
            if (bonusNumber < 1 || bonusNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            if (winningNumbers.contains(bonusNumber)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복된 숫자가 있으면 안됩니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }
        return bonusNumber;
    }

    public static void printWinningStatistics(List<Lotto> lottos, Lotto winningLotto, int bonusNumber, int lottoAmount) {
        Map<Rank, Integer> map = calculateMatchingNumbers(lottos, winningLotto, bonusNumber);
        Long total = 0L;
        for(Map.Entry<Rank, Integer> e : map.entrySet()){
            total += e.getKey().getAmount() * e.getValue();
            if (!e.getKey().equals(Rank.MISS)) {
                System.out.println(e.getKey().getPhrase() + e.getValue() + "개");
            }
        }
        double rateOfReturn = (double)total / lottoAmount * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", rateOfReturn) + "%입니다.");
    }

    public static Map<Rank, Integer> calculateMatchingNumbers(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        Map<Rank, Integer> map = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            map.put(rank, 0);
        }
        for (Lotto lotto : lottos) {
            Rank rank = lotto.judgeRank(winningLotto, bonusNumber);
            map.put(rank, map.get(rank) + 1);
        }
        return map;
    }

}
