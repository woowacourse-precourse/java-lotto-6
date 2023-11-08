package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

        private static final int LOTTO_PRICE = 1000;

        public static void run() {
                int purchaseAmount = getPurchaseAmount();
                List<Lotto> lottoTickets = generateLottoTickets(purchaseAmount);

                printPurchasedLottoTickets(lottoTickets);

                int[] winningNumbers = getWinningNumbers();
                int bonusNumber = getValidBonusNumber();

                int[] result = calculateResult(lottoTickets, winningNumbers, bonusNumber);
                printResult(result, purchaseAmount);
        }

        private static int getPurchaseAmount() {
                int purchaseAmount;
                while (true) {
                        try {
                                System.out.println("구입 금액을 입력해 주세요.");
                                purchaseAmount = Integer.parseInt(Console.readLine());
                                if (purchaseAmount % LOTTO_PRICE != 0) {
                                        throw new IllegalArgumentException(
                                                "[ERROR] 1000원 단위로 입력해 주세요.");
                                }
                                break;
                        } catch (NumberFormatException e) {
                                System.out.println("[ERROR] 숫자를 입력해 주세요.");
                        } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                        }
                }
                return purchaseAmount;
        }

        private static List<Lotto> generateLottoTickets(int purchaseAmount) {
                int ticketCount = purchaseAmount / LOTTO_PRICE;
                List<Lotto> lottoTickets = new ArrayList<>();
                for (int i = 0; i < ticketCount; i++) {
                        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
                        Lotto lotto = new Lotto(numbers);
                        lottoTickets.add(lotto);
                }
                return lottoTickets;
        }

        private static int[] getWinningNumbers() {
                String input = getInputFromUser();
                return convertInputToArray(input);
        }

        private static String getInputFromUser() {
                String input = null;
                while (true) {
                        try {
                                System.out.println("당첨 번호를 입력해 주세요.");
                                input = Console.readLine();
                                validateInputFormat(input);
                                return input;
                        } catch (NumberFormatException e) {
                                System.out.println("[ERROR] 숫자를 입력해 주세요.");
                        } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                        }
                }
        }

        private static void validateInputFormat(String input) {
                String[] parts = input.split(",");
                if (parts.length != 6) {
                        throw new IllegalArgumentException("[ERROR] 6개의 번호를 입력해 주세요.");
                }
        }

        private static int[] convertInputToArray(String input) {
                String[] parts = input.split(",");
                int[] numbers = new int[6];
                for (int i = 0; i < 6; i++) {
                        numbers[i] = Integer.parseInt(parts[i]);
                }
                return numbers;
        }

        private static int getValidBonusNumber() {
                int bonusNumber;
                while (true) {
                        try {
                                bonusNumber = getBonusNumberFromUser();
                                validateBonusNumber(bonusNumber);
                                return bonusNumber;
                        } catch (NumberFormatException e) {
                                System.out.println("[ERROR] 숫자를 입력해 주세요.");
                        } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                        }
                }
        }

        private static int getBonusNumberFromUser() {
                System.out.println("보너스 번호를 입력해 주세요.");
                return Integer.parseInt(Console.readLine());
        }

        private static void validateBonusNumber(int bonusNumber) {
                if (bonusNumber < 1 || bonusNumber > 45) {
                        throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
                }
        }


        private static void printPurchasedLottoTickets(List<Lotto> lottoTickets) {

                System.out.println(lottoTickets.size() + "개를 구매했습니다.");
                for (Lotto lotto : lottoTickets) {
                        System.out.println(lotto.getNumbers());
                }
        }

        private static int[] calculateResult(List<Lotto> lottoTickets, int[] winningNumbers,
                int bonusNumber) {
                int[] result = new int[6];
                for (Lotto lotto : lottoTickets) {
                        int matchedCount = countMatchingNumbers(lotto.getNumbers(), winningNumbers);
                        boolean hasBonusNumber = lotto.getNumbers().contains(bonusNumber);

                        LotteryWinOption lotteryWinOption = getLotteryWinOption(matchedCount,
                                hasBonusNumber);
                        result[lotteryWinOption.ordinal()]++;
                }

                return result;
        }


        private static void printResult(int[] result, int purchaseAmount) {
                System.out.println("\n당첨 통계\n---");

                for (LotteryWinOption lotteryWinOption : LotteryWinOption.values()) {
                        if (lotteryWinOption != LotteryWinOption.LOSE) {
                                int count = result[lotteryWinOption.ordinal()];
                                System.out.println(
                                        lotteryWinOption.getMessage() + " - " + count + "개");
                        }
                }

                double totalPrizeAmount = 0;
                for (LotteryWinOption lotteryWinOption : LotteryWinOption.values()) {
                        totalPrizeAmount +=
                                result[lotteryWinOption.ordinal()]
                                        * lotteryWinOption.getPrizeAmount();
                }
                double profitRate = (totalPrizeAmount / purchaseAmount) * 100;

                System.out.printf("\n총 수익률은 %.1f%%입니다.\n", profitRate);
        }


        private static LotteryWinOption getLotteryWinOption(int matchedCount,
                boolean hasBonusNumber) {
                if (matchedCount == 6) {
                        return LotteryWinOption.FIRST_PLACE;
                }
                if (matchedCount == 5 && hasBonusNumber) {
                        return LotteryWinOption.SECOND_PLACE;
                }
                if (matchedCount == 5) {
                        return LotteryWinOption.THIRD_PLACE;
                }
                if (matchedCount == 4) {
                        return LotteryWinOption.FOURTH_PLACE;
                }
                if (matchedCount == 3) {
                        return LotteryWinOption.FIFTH_PLACE;
                }
                return LotteryWinOption.LOSE;

        }

        private static int countMatchingNumbers(List<Integer> numbers1, int[] numbers2) {
                int count = 0;
                for (Integer number : numbers1) {
                        if (contains(numbers2, number)) {
                                count++;
                        }
                }
                return count;
        }

        private static boolean contains(int[] numbers, int target) {
                for (int number : numbers) {
                        if (number == target) {
                                return true;
                        }
                }
                return false;
        }

}
