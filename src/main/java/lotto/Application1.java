package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.text.NumberFormat;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class Application {
    public static void main(String[] args) {
//        public enum PrizeMoney {2_000_000_000, 30_000_000, 1_500_000, 50_000, 5_000, 0}

        try {
            // 사용자로부터 구입 금액을 입력받음
            int purchaseAmount = readPurchaseAmount();
            // 사용자의 구입 금액 토대로 로또 번호 생성
            List<Lotto> lottos = generateLottos(purchaseAmount);
            printLottos(lottos);

            // 사용자로부터 당첨 번호와 보너스 번호를 입력받음
            Lotto winningLotto = readWinningLotto();
            int bonusNumber = readBonusNumber(winningLotto);

            // 총 상금 계산
            int totalPrize = calculateTotalPrize(lottos, winningLotto, bonusNumber);
            printResult(totalPrize, purchaseAmount, lottos, winningLotto, bonusNumber);

        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
//    private static int readPurchaseAmount() {
//        // 사용자에게 올바른 구입 금액을 입력받음
//        while (true) {
//            System.out.print("구입 금액을 입력해 주세요.");
//            String input = Console.readLine();
//
//            try {
//                // 입력값을 검증을 수행
//                int purchaseAmount = parseAndValidateInput(input);
//                // 검증이 통과된 구입 금액을 반환
//                return purchaseAmount;
//            } catch (NumberFormatException e) {
//                // 숫자로 변환할 수 없는 입력값이 들어온 경우 에러 메시지를 출력
//                System.out.println("[ERROR] 구입금액은 숫자만 가능합니다.");
//            } catch (IllegalArgumentException e) {
//                // 구입 금액이 1,000원 단위가 아닌 경우 에러 메시지를 출력
//                System.out.println(e.getMessage());
//            }
//        }
//    }
//
//    private static int parseAndValidateInput(String input) {
//        int purchaseAmount = Integer.parseInt(input);
//        // 입력값이 1,000원 단위인지 검증
//        if (purchaseAmount % 1000 != 0) {
//            // 1,000원 단위가 아닌 경우 예외를 발생
//            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위어야 합니다.");
//        }
//        return purchaseAmount;
//    }


    // 구입 금액을 토대로 로또 번호를 생성
    private static List<Lotto> generateLottos(int purchaseAmount) {
        int numberOfLotto = purchaseAmount / 1000;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }

        return lottos;
    }

    // 랜덤 생성 된 로또 번호를 출력
    private static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");

        lottos.forEach(lotto -> {
            List<Integer> numberList = new ArrayList<>(lotto.getNumbers());
            numberList.sort(Comparator.naturalOrder()); // 번호를 오름차순으로 정렬
            System.out.println("[" + numberList + "]");
        });
    }

//    private static Lotto readWinningLotto() {
//        while (true) {
//            try {
//                System.out.print("당첨 번호를 입력해 주세요. ");
//                String[] winningNumbersStr = Console.readLine().split(",");
//
//                if (winningNumbersStr.length != 6) {
//                    throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개 숫자를 입력해야 합니다.");
//                }
//
//                List<Integer> winningNumbers = parseNumbers(winningNumbersStr);
//
//                if (winningNumbers.stream().anyMatch(number -> number < 1 || number > 45)) {
//                    throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45까지의 숫자로 입력해야 합니다.");
//                }
//
//                if (winningNumbers.stream().distinct().count() != 6) {
//                    throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
//                }
//
//                return new Lotto(winningNumbers);
//            } catch (IllegalArgumentException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//    }
//
//    // 문자열 배열을 정수 리스트로 변환
//    private static List<Integer> parseNumbers(String[] numbersStr) {
//        return List.of(numbersStr).stream()
//                .map(String::trim)
//                .map(Integer::parseInt)
//                .collect(Collectors.toList());
//    }

    private static int readBonusNumberUI() {
        System.out.print("보너스 번호를 입력해 주세요. ");
        String input = Console.readLine().trim();

        // 입력값이 공백인 경우 에러 메시지 출력
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 입력해주세요.");
        }

        return Integer.parseInt(input);
    }

    private static int readBonusNumber(Lotto winningNumber) {
        while (true) {
            try {
                int bonusNumber = readBonusNumberUI();

                if (bonusNumber < 1 || bonusNumber > 45)
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45까지의 숫자로 입력해야 합니다.");

                if (winningNumber.containsNumber(bonusNumber))
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨번호와 중복될 수 없습니다.");

                // 올바른 입력일 경우 보너스 번호 반환
                return bonusNumber;
            } catch (NumberFormatException e) {
                // 숫자로 변환할 수 없는 입력값이 들어온 경우 에러 메시지 출력
                System.out.println("[ERROR] 올바른 숫자를 입력하세요.");
            } catch (IllegalArgumentException e) {
                // 기타 유효성 검사 실패한 경우 에러 메시지 출력 후 다시 입력을 받기 위해 루프 계속 진행
                System.out.println(e.getMessage());
            }
        }
    }

    public class LottoUtils {

        // 총 상금과 구매 금액을 받아 수익률 계산
        public static double calculateProfitRate(int purchaseAmount, int totalPrize) {
            return ((double) totalPrize / purchaseAmount) * 100;
        }

        // 사용자 로또 번호와 당첨 번호 중 일치하는 번호의 개수를 세는 메서드
        private static int countMatchedNumbers(Lotto userLotto, Lotto winningLotto) {
            int count = 0;
            // 사용자 로또 번호 중 당첨 번호와 일치하는 번호의 개수를 세는 반복문
            for (int number : userLotto.getNumbers()) {
                if (winningLotto.containsNumber(number)) {
                    count++;
                }
            }
            return count;
        }
    }

    // 총 상금 계산
    private static int calculateTotalPrize(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {

        return lottos.stream()
                .mapToInt(lotto -> {
                    int matchedNumbers = LottoUtils.countMatchedNumbers(lotto, winningLotto);
                    boolean hasBonusNumber = lotto.containsNumber(bonusNumber);
                    Prize prize = Prize.calculatePrize(matchedNumbers, hasBonusNumber);
                    return prize.getPrizeAmount();
                })
                .sum();
    }


    private static void printWinningStatistics(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        int[] prizeCounts = new int[6];

        for (Lotto lotto : lottos) {
            int matchedNumbers = LottoUtils.countMatchedNumbers(lotto, winningLotto);
            boolean hasBonusNumber = lotto.containsNumber(bonusNumber);
            updatePrizeCounts(prizeCounts, matchedNumbers, hasBonusNumber);
        }

        System.out.println("당첨 통계");
        System.out.println("---");

        printPrize(3, prizeCounts, 4, "5등", 5_000);
        printPrize(4, prizeCounts, 3, "4등", 50_000);
        printPrize(5, prizeCounts, 2, "3등", 1_500_000);
        printPrize(5, prizeCounts, 1, "2등", 30_000_000);
        printPrize(6, prizeCounts, 0, "1등", 2_000_000_000);
        System.out.println("꽝: " + prizeCounts[5] + "개");
    }

    private static void updatePrizeCounts(int[] prizeCounts, int matchedNumbers, boolean hasBonusNumber) {
        if (matchedNumbers == 6)
            prizeCounts[0]++;
        if (matchedNumbers == 5 && hasBonusNumber)
            prizeCounts[1]++;
        if (matchedNumbers == 5 && !hasBonusNumber)
            prizeCounts[2]++;
        if (matchedNumbers == 4)
            prizeCounts[3]++;
        if (matchedNumbers == 3)
            prizeCounts[4]++;
        if (matchedNumbers == 2 || matchedNumbers == 1 || matchedNumbers == 0)
            prizeCounts[5]++;
    }


    private static void printPrize(int sameCount, int[] prizeCounts, int matchedNumbers, String prizeName, int prizeAmount) {
        int count = prizeCounts[matchedNumbers];
        int prizePerThousand = prizeAmount / 1_000;
        if (matchedNumbers == 1) {
            System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + count + "개");
            return;
        }
        System.out.println(sameCount + "개 일치 (" + formatNumberWithCommas(prizeAmount) + "원) - " + count + "개");

    }

    private static String formatNumberWithCommas(int number) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        return numberFormat.format(number);
    }

    // 최종 결과 출력
    private static void printResult(int totalPrize, int purchaseAmount, List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        double profitRate = LottoUtils.calculateProfitRate(purchaseAmount, totalPrize);
        printWinningStatistics(lottos, winningLotto, bonusNumber);
        System.out.println("총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.");
    }
}