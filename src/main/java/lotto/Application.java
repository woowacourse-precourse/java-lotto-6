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
        printWinningStatistics(lottos, winningNumbers, bonusNumber);
    }

    private static int getPurchaseAmount() {
        // 구매 금액 입력 받기
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine().trim());
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
        return purchaseAmount;
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

    private static void printWinningStatistics(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        // 당첨 통계를 저장할 배열 초기화
        int[] winCounts = new int[6];

        // 각 로또별로 당첨 번호 매칭 검사
        for (Lotto lotto : lottos) {
            int matchCount = 0;
            boolean bonusMatch = false;
            for (int number : lotto.getNumbers()) {
                if (winningNumbers.contains(number)) {
                    matchCount++;
                } else if (number == bonusNumber) {
                    bonusMatch = true;
                }
            }
            // 당첨 결과 업데이트
            updateWinCounts(winCounts, matchCount, bonusMatch);
        }

        // 당첨 결과 출력
        int totalPrize = 0;
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = 0; i < winCounts.length; i++) {
            totalPrize += winCounts[i] * getPrizeMoney(i);
            System.out.println(getMatchMessage(i) + " - " + winCounts[i] + "개");
        }

        // 수익률 계산 및 출력
        double profitRate = calculateProfitRate(totalPrize, lottos.size() * 1000);
        System.out.printf("총 수익률은 %.2f%%입니다.\n", profitRate);
    }

    private static void updateWinCounts(int[] winCounts, int matchCount, boolean bonusMatch) {
        // 매칭된 번호의 수에 따라 당첨 카운트를 업데이트
        switch (matchCount) {
            case 3:
                winCounts[5]++;
                break;
            case 4:
                winCounts[4]++;
                break;
            case 5:
                if (bonusMatch) {
                    winCounts[1]++;
                } else {
                    winCounts[2]++;
                }
                break;
            case 6:
                winCounts[0]++;
                break;
        }
    }

    private static int getPrizeMoney(int matchCount) {
        // 매칭된 번호의 수에 따라 상금을 반환
        switch (matchCount) {
            case 0: return 2000000000; // 1등
            case 1: return 30000000;   // 2등
            case 2: return 1500000;    // 3등
            case 4: return 50000;      // 4등
            case 5: return 5000;       // 5등
            default: return 0;
        }
    }

    private static String getMatchMessage(int matchCount) {
        // 매칭된 번호의 수에 따라 출력 메시지를 반환
        switch (matchCount) {
            case 0: return "6개 일치 (2,000,000,000원)";
            case 1: return "5개 일치, 보너스 볼 일치 (30,000,000원)";
            case 2: return "5개 일치 (1,500,000원)";
            case 4: return "4개 일치 (50,000원)";
            case 5: return "3개 일치 (5,000원)";
            default: return "";
        }
    }

    private static double calculateProfitRate(int totalPrize, int purchaseAmount) {
        // 수익률을 계산
        return (totalPrize - purchaseAmount) / (double) purchaseAmount * 100;
    }

}