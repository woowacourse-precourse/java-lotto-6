package lotto;

import java.lang.reflect.Array;
import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;


public class Application {

    static String lottoPurchaseAmount = "";
    static int lottoPurchaseCount;
    static List<Integer> lottoNumbersDrawn = new ArrayList<>();
    static List<List<Integer>> lottoNumbersDrawnContainer = new ArrayList<>();
    static String lottoWinnerInputNum;
    static List<Integer> lottoWinnerNum = new ArrayList<>();
    static String lottoWinnerBonusNum = "";
    static int matchCount = 0;
    static int bonusMatchCount = 0;
    static int Match_3_Count = 0;
    static int Match_4_Count = 0;
    static int Match_5_Count = 0;
    static int Match_5_AndBonusCount = 0;
    static int Match_6_Count = 0;
    static long totalPrizeMoney;

    public static void main(String[] args) {
        getLottoPurchaseAmount();
        generateLottoNumbers();
        getWinningNumbers();
        inputBonusNumber();
        compareNumbers();
        displayWinningStatistics();
        calculateTotalPrizeMoney();
        printProfitability();
    }

    static void getLottoPurchaseAmount() {
        printPurchaseAmountMessage();
        do {
            inputLottoPurchaseAmount();
        } while (validatePurchaseAmount());
    }

    static void printPurchaseAmountMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    static void inputLottoPurchaseAmount() {
        lottoPurchaseAmount = Console.readLine();
    }

    static boolean validatePurchaseAmount() {
        for (int i = 0; i < lottoPurchaseAmount.length(); i++) {
            try {
                if (lottoPurchaseAmount.charAt(i) < '0' || lottoPurchaseAmount.charAt(i) > '9') {
                    throw new IllegalArgumentException();
                }
                if (lottoPurchaseAmount.charAt(0) == '0') {
                    throw new IllegalArgumentException();
                }
                if (Integer.parseInt(lottoPurchaseAmount) % 1000 != 0) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 1,000원 단위의 숫자를 입력해주세요.");
                return true;
            }
        }
        return false;
    }

    static void generateLottoNumbers() {
        lottoPurchaseCount = Integer.parseInt(lottoPurchaseAmount) / 1000;
        printLottoPurchaseCountMessage();
        generateRandomLottoNumbers();

    }

    static void generateRandomLottoNumbers() {
        for (int i = 0; i < lottoPurchaseCount; i++) {
            lottoNumbersDrawn = new ArrayList<>();
            while (lottoNumbersDrawn.size() < 6) {
                int randomAddNum = Randoms.pickNumberInRange(1, 45);
                if (!lottoNumbersDrawn.contains(randomAddNum)) {
                    lottoNumbersDrawn.add(randomAddNum);
                }
            }
            Collections.sort(lottoNumbersDrawn);
            lottoNumbersDrawnContainer.add(lottoNumbersDrawn);
            printLottoNumbers();
        }
    }

    static void printLottoPurchaseCountMessage() {
        System.out.printf("%n%d개를 구매했습니다.%n", lottoPurchaseCount);
    }

    static void printLottoNumbers() {
        System.out.printf(lottoNumbersDrawn + "%n");
    }

    static void printInputWinningNumbersMessage() {
        System.out.printf("%n당첨 번호를 입력해 주세요.%n");
    }

    static void inputWinningNumbers() {
        lottoWinnerInputNum = Console.readLine();
    }

    static boolean validateWinningNum() {
        // 1,2,3,4,5,6
        String[] lottoWinnerInputNumTemp = lottoWinnerInputNum.split(",");
        for (int i = 0; i < 6; i++) {
            try {
                if (lottoWinnerNum.contains(Integer.parseInt(lottoWinnerInputNumTemp[i]))) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 중복된 값은 입력 불가합니다.");
                return true;
            }
            try {
                if (1 > Integer.parseInt(lottoWinnerInputNumTemp[i])
                        || Integer.parseInt(lottoWinnerInputNumTemp[i]) > 45) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                return true;
            }
            try {
                if (lottoWinnerInputNumTemp.length != 6) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 여섯 개의 숫자를 입력해주세요.");
                return true;
            }
            lottoWinnerNum.add(Integer.parseInt(lottoWinnerInputNumTemp[i]));
        }
        Collections.sort(lottoWinnerNum);
        return false;
    }

    static void getWinningNumbers() {
        printInputWinningNumbersMessage();
        do {
            inputWinningNumbers();
        } while (validateWinningNum());
    }

    static void printInputBonusNumberMessage() {
        System.out.printf("%n보너스 번호를 입력해 주세요.%n");
    }

    static void inputBonusNumber() {
        printInputBonusNumberMessage();
        do {
            lottoWinnerBonusNum = Console.readLine();
        } while (validateBonusNum());
    }

    static boolean validateBonusNum() {
        try {
            if ((1 > Integer.parseInt(lottoWinnerBonusNum) || Integer.parseInt(lottoWinnerBonusNum) > 45)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            return true;
        }
        try {
            if (lottoWinnerNum.contains(Integer.parseInt(lottoWinnerBonusNum))) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 당첨 번호와 중복되지 않는 숫자여야 합니다.");
            return true;
        }
        return false;
    }

    static void printWinningStatisticsMessage() {
        System.out.printf("%n당첨 통계%n");
        System.out.printf("---%n");
    }

    static void compareNumbers() {
        for (int i = 0; i < lottoPurchaseCount; i++) {
            matchCount = 0;
            bonusMatchCount = 0;
            for (int j = 0; j < 6; j++) {
                if (lottoWinnerNum.contains(lottoNumbersDrawnContainer.get(i).get(j))) {
                    matchCount++;
                }
                if ((lottoNumbersDrawnContainer.get(i).get(j)).equals(Integer.parseInt(lottoWinnerBonusNum))) {
                    bonusMatchCount++;
                }
            }
            if (matchCount == 3) {
                Match_3_Count = Match_3_Count + 1;
            }
            if (matchCount == 4) {
                Match_4_Count = Match_4_Count + 1;
            }
            if (matchCount == 5) {
                Match_5_Count = Match_5_Count + 1;
            }
            if (matchCount == 5 && bonusMatchCount == 1) {
                Match_5_AndBonusCount = Match_5_AndBonusCount + 1;
            }
            if (matchCount == 6) {
                Match_6_Count = Match_6_Count + 1;
            }
        }
    }

    static void displayWinningStatistics() {
        printWinningStatisticsMessage();
        System.out.printf("3개 일치 (5,000원) - %d개%n", Match_3_Count);
        System.out.printf("4개 일치 (50,000원) - %d개%n", Match_4_Count);
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", Match_5_Count);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", Match_5_AndBonusCount);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", Match_6_Count);


    }

    static void calculateTotalPrizeMoney() {
        totalPrizeMoney = Match_3_Count * 5000L + Match_4_Count * 50000L + Match_5_Count * 1500000L
                + Match_5_AndBonusCount * 30000000L + Match_6_Count * 2000000000L;
    }

    static void printProfitability() {
        System.out.printf("총 수익률은 %.1f%%입니다.",
                (float) totalPrizeMoney * 100 / (Integer.parseInt(lottoPurchaseAmount)));
    }
}