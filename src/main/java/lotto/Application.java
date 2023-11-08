package lotto;

import java.util.*;

public class Application {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int LOTTO_PRICE = 1000;
    private static final int NUMBER_OF_LOTTO_NUMBERS = 6;

    public static void main(String[] args) {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            int purchaseAmount = Integer.parseInt(scanner.nextLine());
            validatePurchaseAmount(purchaseAmount);

            int numberOfTickets = purchaseAmount / LOTTO_PRICE;
            System.out.println(numberOfTickets + "개를 구매했습니다.");

            List<Lotto> lottoTickets = generateLottoTickets(numberOfTickets);
            for (Lotto lotto : lottoTickets) {
                System.out.println(lotto.getNumbers());
            }

            System.out.println("당첨 번호를 입력해 주세요.");
            List<Integer> winningNumbers = readLottoNumbers();

            System.out.println("보너스 번호를 입력해 주세요.");
            int bonusNumber = readBonusNumber(winningNumbers);

            printStatistics(lottoTickets, winningNumbers, bonusNumber, purchaseAmount);

        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 입력 값이 유효한 정수가 아닙니다: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    private static void validatePurchaseAmount(int amount) {
        if (amount <= 0 || amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
        }
    }

    private static List<Lotto> generateLottoTickets(int numberOfTickets) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
            lottoTickets.add(new Lotto(generateRandomLottoNumbers()));
        }
        return lottoTickets;
    }

    private static List<Integer> generateRandomLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return new ArrayList<>(numbers.subList(0, NUMBER_OF_LOTTO_NUMBERS));
    }

    private static List<Integer> readLottoNumbers() {
        String[] tokens = scanner.nextLine().split(",");
        if (tokens.length != NUMBER_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개 입력해야 합니다.");
        }

        Set<Integer> numbers = new HashSet<>();
        for (String token : tokens) {
            int number = Integer.parseInt(token.trim());
            validateLottoNumber(number);
            numbers.add(number);
        }

        if (numbers.size() != NUMBER_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }

        return new ArrayList<>(numbers);
    }

    private static int readBonusNumber(List<Integer> winningNumbers) {
        int bonusNumber = Integer.parseInt(scanner.nextLine().trim());
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
        }
        validateLottoNumber(bonusNumber);
        return bonusNumber;
    }

    private static void validateLottoNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static void printStatistics(List<Lotto> lottoTickets, List<Integer> winningNumbers, int bonusNumber, int purchaseAmount) {
        int[] matchCounts = new int[NUMBER_OF_LOTTO_NUMBERS + 2];
        boolean bonusMatch = false;

        for (Lotto lotto : lottoTickets) {
            int matchCount = lotto.countMatches(winningNumbers);
            matchCounts[matchCount]++;

            if (matchCount == 5 && lotto.getNumbers().contains(bonusNumber)) {
                bonusMatch = true;
                matchCounts[5]--;
                matchCounts[6]++;
            }
        }

        int totalWinnings = 0;
        // 당첨 통계 출력
        System.out.println("당첨 통계\n---");
        for (int i = 3; i <= 6; i++) {
            boolean isBonusMatch = i == 6 && bonusMatch;
            int winnings = getWinningsForMatchCount(i, isBonusMatch);
            if (i == 6 && bonusMatch) {
                System.out.println("5개 일치, 보너스 볼 일치 (" + winnings + "원) - " + matchCounts[i] + "개");
            } else {
                System.out.println(i + "개 일치 (" + winnings + "원) - " + matchCounts[i] + "개");
            }
            totalWinnings += winnings * matchCounts[i];
        }

        double profitRate = ((double) totalWinnings / purchaseAmount) * 100;
        System.out.printf("총 수익률은 %.2f%%입니다.\n", profitRate);
    }

    private static int getWinningsForMatchCount(int matchCount, boolean isBonusMatched) {
        if (matchCount == 6 && isBonusMatched) {
            return 30000000;
        }
        switch (matchCount) {
            case 3: return 5000;
            case 4: return 50000;
            case 5: return 1500000;
            case 6: return 2000000000;

        }
        return 0;
    }

}
