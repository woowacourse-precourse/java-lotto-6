package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.LottoSetUp;
import java.util.Arrays;
import java.util.Scanner;

import static lotto.model.ResultCheck.*;

public class View {
    static int totalCost;
    static int numberOfgetTotalCost;
    static int bonusNumber;
    static String winningNumber;

    public enum PrintOutput {
        START("구입금액을 입력해 주세요."),
        WINNINGNUMBER("당첨 번호를 입력해 주세요."),
        BONUSNUMBER("보너스 번호를 입력해 주세요."),
        STATISTICS("당첨 통계\n" + "---"),
        NUMBEROFLOTTO("개를 구매했습니다."),
        THREEMATCHES("3개 일치 (5,000원) - "),
        FOURMATCHES("4개 일치 (50,000원) - "),
        FIVEMATCHES("5개 일치 (1,500,000원) - "),
        FIVEWITHBONUSMATCHES("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
        SIXMATCHES("6개 일치 (2,000,000,000원) - "),
        TOTALREVENUEFRONT("총 수익률은 "),
        TOTALREVENUEBACK("%입니다."),
        NUMBEROF("개"),
        ;
        private final String label;

        PrintOutput(String label) {
            this.label = label;
        }

        public String label() {
            return label;
        }
    }
    public static void printStartMessage () {
        System.out.println(PrintOutput.START.label);
    }

    public static void printNumberOfLotto () {
        numberOfgetTotalCost = getTotalNumber();
        System.out.println("\n"+ numberOfgetTotalCost + PrintOutput.NUMBEROFLOTTO.label);
    }

    public static void printResultStatistics() {
        String resultRevenue = getResultRevenue();
        System.out.println(PrintOutput.STATISTICS.label);
        System.out.println(PrintOutput.THREEMATCHES.label + threeMatch + PrintOutput.NUMBEROF.label);
        System.out.println(PrintOutput.FOURMATCHES.label + fourMatch + PrintOutput.NUMBEROF.label);
        System.out.println(PrintOutput.FIVEMATCHES.label + fiveMatch + PrintOutput.NUMBEROF.label);
        System.out.println(PrintOutput.FIVEWITHBONUSMATCHES.label + fiveWithBonusMatch + PrintOutput.NUMBEROF.label);
        System.out.println(PrintOutput.SIXMATCHES.label + sixMatch + PrintOutput.NUMBEROF.label);
        System.out.println(PrintOutput.TOTALREVENUEFRONT.label + resultRevenue + PrintOutput.TOTALREVENUEBACK.label);
    }

    public static void printlottos() {
        int[][] lottos = LottoSetUp.toMakeIncreseLotto();
        for(int i = 0; i < numberOfgetTotalCost; i++) {
            System.out.println(Arrays.toString(lottos[i]));
        }
    }

    public static void inputTotalCost () {
         checkValidate();
    }

    public static void checkValidate() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                totalCost = Integer.parseInt(getInput());
                if (totalCost < 0) {
                    throw new IllegalArgumentException("[ERROR] 음수는 입력할 수 없습니다.");
                }
                System.out.println("입력한 값: " + totalCost);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 유효한 정수를 입력하세요.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("[ERROR] 유효한 정수를 입력하세요.");
                scanner.nextLine();
            }
        }
    }


    public static void inputWinningNumber() {
        System.out.println("\n" + PrintOutput.WINNINGNUMBER.label);
        winningNumber = getInput();
    }

    public static void inputBonusNumber() {
        System.out.println("\n" + PrintOutput.BONUSNUMBER.label);
        bonusNumber = Integer.parseInt(getInput());
    }

    public static int getTotalCost () {
        return totalCost;
    }

    public static String getWinningNumber() {
        return winningNumber;
    }
    public static int getTotalNumber () {
        if(totalCost % 10 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요");
        }
        return totalCost / 1000;
    }

    public static int getBonusNumber() {
        return bonusNumber;
    }
    private static String getInput () {
        return Console.readLine();
    }
}
