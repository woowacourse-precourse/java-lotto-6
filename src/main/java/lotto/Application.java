package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {
        // 로또 게임 실행 로직을 여기에 구현합니다.
        int purchaseAmount = getPurchaseAmount();
        int numberOfLottos = purchaseAmount / 1000;
        List<Lotto> lottos = purchaseLottos(numberOfLottos);

        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);

        // 결과 출력
        printLottos(lottos);
        printWinningStatistics(lottos, winningNumbers, bonusNumber, purchaseAmount);
    }

    private static int getPurchaseAmount() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String input = Console.readLine().trim();
            try {
                int purchaseAmount = Integer.parseInt(input);
                if (purchaseAmount % 1000 != 0) {
                    System.out.println("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
                    continue; // 잘못된 입력이면 반복문을 계속 실행합니다.
                }
                return purchaseAmount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 구입 금액은 숫자여야 합니다.");
                // 숫자가 아닌 입력을 받았을 경우 다시 입력을 요청합니다.
            }
        }
    }

    private static List<Lotto> purchaseLottos(int numberOfLottos) {
        // 로또 구매
        return IntStream.range(0, numberOfLottos)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
                .collect(Collectors.toList());
    }

    private static List<Integer> getWinningNumbers() {
        // 당첨 번호 입력 받기
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] winningNumberStrings = Console.readLine().split(",");
        return validateAndParseNumbers(winningNumberStrings);
    }

    private static int getBonusNumber(List<Integer> winningNumbers) {
        // 보너스 번호 입력 받기
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine().trim());
        if (bonusNumber < 1 || bonusNumber > 45 || winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 유효한 숫자여야 합니다.");
        }
        return bonusNumber;
    }

    private static List<Integer> validateAndParseNumbers(String[] numberStrings) {
        // 입력 번호 유효성 검증 및 파싱
        List<Integer> numbers = new ArrayList<>();
        for (String numberString : numberStrings) {
            int number = Integer.parseInt(numberString.trim());
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            numbers.add(number);
        }
        return numbers;
    }

    private static void printLottos(List<Lotto> lottos) {
        // 구매한 로또 출력
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            List<Integer> sortedNumbers = new ArrayList<>(lotto.getNumbers());
            Collections.sort(sortedNumbers);
            System.out.println(sortedNumbers);
        }
    }

    private static void printWinningStatistics(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber, int purchaseAmount) {
        int[] winCounts = new int[6];
        int totalPrize = 0;

        for (Lotto lotto : lottos) {
            int matchCount = 0;
            boolean bonusMatch = false;
            for (int number : lotto.getNumbers()) {
                if (winningNumbers.contains(number)) {
                    matchCount++;
                }
            }
            if (lotto.getNumbers().contains(bonusNumber) && matchCount == 5) {
                bonusMatch = true;
            }
            updateWinCounts(winCounts, matchCount, bonusMatch);
        }

        System.out.println("당첨 통계");
        System.out.println("---");
        // 모든 당첨 결과를 출력합니다. 실제로 매칭된 경우가 없어도 0개로 표시합니다.
        System.out.println("3개 일치 (5,000원) - " + winCounts[0] + "개");
        System.out.println("4개 일치 (50,000원) - " + winCounts[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winCounts[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winCounts[3] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winCounts[4] + "개");

        for (int i = winCounts.length - 1; i >= 0; i--) {
            if (winCounts[i] > 0) {
                System.out.println(getMatchMessage(i) + " - " + winCounts[i] + "개");
                totalPrize += winCounts[i] * getPrizeMoney(i);
            }
        }

        // 총 수익률 계산 시 구입 금액이 0인 경우를 방지
        double profitRate = purchaseAmount > 0 ? (double) totalPrize / purchaseAmount * 100 : 0;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
    private static void updateWinCounts(int[] winCounts, int matchCount, boolean bonusMatch) {
        if (matchCount < 3) return; // no prize for less than 3 matches
        if (matchCount == 5 && bonusMatch) {
            winCounts[3]++; // index 3 is for 5+bonus
        } else if (matchCount == 5) {
            winCounts[2]++; // index 2 is for 5 matches without bonus
        } else {
            winCounts[matchCount - 3]++; // subtract 3 to get the index for 3 or 4 matches
        }
        if (matchCount == 6) {
            winCounts[4]++; // index 4 is for 6 matches
        }
    }

    private static int getPrizeMoney(int matchIndex) {
        // matchIndex is from 0 to 5 where 5 indicates 5+bonus matches
        switch (matchIndex) {
            case 0: return 5000;       // 3개 일치
            case 1: return 50000;      // 4개 일치
            case 2: return 1500000;    // 5개 일치
            case 3: return 30000000;   // 5개 번호 + 보너스 볼 일치
            case 4: return 2000000000; // 6개 일치
            default: return 0;
        }
    }

    private static String getMatchMessage(int matchCount) {
        // matchCount is expected to be from 0 to 5 where 5 indicates 5+bonus matches
        switch (matchCount) {
            case 0: return "3개 일치 (5,000원)";
            case 1: return "4개 일치 (50,000원)";
            case 2: return "5개 일치 (1,500,000원)";
            case 3: return "5개 번호 + 보너스 볼 일치 (30,000,000원)";
            case 4: return "6개 일치 (2,000,000,000원)";
            default: return "";
        }
    }

    private static double calculateProfitRate(int totalPrize, int purchaseAmount) {
        if (purchaseAmount <= 0) {
            return 0.0;
        }
        // 총 상금에서 구입 금액을 뺀 다음, 구입 금액으로 나눠서 수익률을 계산합니다.
        double profit = (totalPrize - purchaseAmount) / (double) purchaseAmount;
        // 수익률을 퍼센트로 변환합니다.
        return profit * 100;
    }

}