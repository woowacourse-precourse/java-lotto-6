package lotto;

import java.util.*;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            int money = scanner.nextInt();
            if (money < LOTTO_PRICE) {
                throw new IllegalArgumentException("[ERROR] 로또 구입 금액이 부족합니다.");
            }

            int numberOfLottos = money / LOTTO_PRICE;
            List<Lotto> lottos = purchaseLottos(numberOfLottos);

            System.out.println(numberOfLottos + "개를 구매했습니다.");
            for (Lotto lotto : lottos) {
                System.out.println(lotto.getNumbers());
            }

            System.out.println("당첨 번호를 입력해 주세요.");
            List<Integer> winningNumbers = readNumbers();
            System.out.println("보너스 번호를 입력해 주세요.");
            int bonusNumber = scanner.nextInt();
            if (bonusNumber < 1 || bonusNumber > 45 || winningNumbers.contains(bonusNumber)) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 보너스 번호입니다.");
            }
            printStatistics(lottos, winningNumbers, bonusNumber, money);
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<Lotto> purchaseLottos(int numberOfLottos) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(new Lotto(generateRandomNumbers()));
        }
        return lottos;
    }

    private static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return new ArrayList<>(numbers.subList(0, 6));
    }

    private static List<Integer> readNumbers() {
        String[] input = scanner.next().trim().split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String number : input) {
            int num = Integer.parseInt(number.trim());
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("[ERROR] 숫자 범위가 유효하지 않습니다.");
            }
            numbers.add(num);
        }
        if (new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 당첨 번호입니다.");
        }
        return numbers;
    }

    private static void printStatistics(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber, int money) {
        Map<Integer, Integer> matchCount = new HashMap<>();
        for (Lotto lotto : lottos) {
            int match = (int) lotto.getNumbers().stream().filter(winningNumbers::contains).count();
            matchCount.put(match, matchCount.getOrDefault(match, 0) + 1);
        }

        long totalPrize = 0;
        System.out.println("당첨 통계");
        System.out.println("---");
        totalPrize += printMatchCount(matchCount, 3, 5000);
        totalPrize += printMatchCount(matchCount, 4, 50000);
        totalPrize += printMatchCount(matchCount, 5, 1500000);
        totalPrize += printMatchWithBonusCount(lottos, winningNumbers, bonusNumber, 30000000);
        totalPrize += printMatchCount(matchCount, 6, 2000000000);
        double yield = (double) totalPrize / money * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", yield) + "%입니다.");
    }

    private static long printMatchCount(Map<Integer, Integer> matchCount, int match, int prize) {
        int count = matchCount.getOrDefault(match, 0);
        System.out.println(match + "개 일치 (" + prize + "원) - " + count + "개");
        return (long) count * prize;
    }

    private static long printMatchWithBonusCount(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber, int prize) {
        long count = lottos.stream().filter(lotto -> lotto.getNumbers().stream().filter(winningNumbers::contains).count() == 5
                && lotto.getNumbers().contains(bonusNumber)).count();
        System.out.println("5개 일치, 보너스 볼 일치 (" + prize + "원) - " + count + "개");
        return count * prize;
    }
}
