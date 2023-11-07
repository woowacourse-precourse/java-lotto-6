package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.LottoGet;
import lotto.model.LottoSetUp;

import java.util.ArrayList;
import java.util.Arrays;

public class View {
    static int totalCost;
    static int numberOfgetTotalCost;
    public enum PrintOutput {
        START("구입금액을 입력해 주세요."),
        WINNINGNUMBER("당첨 번호를 입력해 주세요."),
        BONUSNUMBER("보너스 번호를 입력해 주세요."),
        STATISTICS("당첨 통계"),
        NUMBEROFLOTTO("개를 구매했습니다."),
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
        System.out.println(numberOfgetTotalCost + PrintOutput.NUMBEROFLOTTO.label);
    }

    public static void printlottos() {
        int[][] lottos = LottoSetUp.toMakeIncreseLotto();
        for(int i = 0; i < numberOfgetTotalCost; i++) {
            System.out.println(Arrays.toString(lottos[i]));
        }
    }

    public static void inputTotalCost () {
         totalCost = Integer.parseInt(getInput());
    }

    public static int getTotalCost () {
        return totalCost;
    }

    public static int getTotalNumber () {
        if(totalCost % 10 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요");
        }
        return totalCost / 1000;
    }

    private static String getInput () {
        return Console.readLine();
    }
}
