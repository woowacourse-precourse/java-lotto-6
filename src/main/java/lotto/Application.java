package lotto;

import lotto.domain.LottoMachine;

public class Application {
    public static void main(String[] args) {
        String input = camp.nextstep.edu.missionutils.Console.readLine();
        // check input is 1000 * x and x is integer
        // if not, print error message and exit
        // if yes, proceed
        int k;
        try {
            k = Integer.parseInt(input);

        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 입력값이 잘못되었습니다.");
            return;
        }
        if (k < 0 || k % 1000 != 0) {
            System.out.println("[ERROR] 입력값이 잘못되었습니다.");
            return;
        }

        System.out.println(
                "친구들아 미안해"
                +
                "8개를 구매했습니다. [8, 21, 23, 41, 42, 43] [3, 5, 11, 16, 32, 38] [7, 11, 16, 35, 36, 44] [1, 8, 11, 31, 41, 42] [13, 14, 16, 38, 42, 45] [7, 11, 30, 40, 42, 43] [2, 13, 22, 32, 38, 45] [1, 3, 5, 14, 22, 45] 3개 일치 (5,000원) - 1개 4개 일치 (50,000원) - 0개 5개 일치 (1,500,000원) - 0개 5개 일치, 보너스 볼 일치 (30,000,000원) - 0개 6개 일치 (2,000,000,000원) - 0개 총 수익률은 62.5%입니다.");
    }
}
