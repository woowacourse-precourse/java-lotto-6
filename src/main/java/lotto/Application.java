package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import static org.assertj.core.api.Assertions.extractProperty;

import java.lang.Integer;
import java.util.Collections;
import java.util.List;

public class Application {
    /*
     * public void check1(String except) {
     * if (!except.contains(",")) {
     * throw new IllegalArgumentException("[ERROR] String에 ','가 포함되어야 합니다.")
     * }
     * }// ','체크
     * 
     * public void check2(String except) {
     * try {
     * int number = Integer.parseInt(except);
     * } catch (NumberFormatException e) {
     * System.out.println("[ERROR]" + except + "는 숫자가 아닙니다.");
     * return;
     * }
     * }// 숫자 체크
     * 
     * public void check3(String[] except) {
     * if (except.length != 6) {
     * throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해야 합니다.");
     * }
     * int[] numbers = new int[6];
     * for (int i = 0; i < 6; i++) {
     * check2(except[i]); // 숫자 체크를 수행
     * 
     * numbers[i] = Integer.parseInt(except[i]);
     * 
     * if (numbers[i] < 1 || numbers[i] > 45) {
     * throw new IllegalArgumentException("[ERROR] 숫자는 1부터 45 사이어야 합니다.");
     * }
     * 
     * for (int j = 0; j < i; j++) {
     * if (numbers[i] == numbers[j]) {
     * throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
     * }
     * }
     * }
     * }
     */
    public void check1(int num) {
        if (num % 1000 != 0) {
            throw new IllegalArgumentException("구매가격이 1000으로 나누어 떨어져야 합니다.");
        }
    }

    public static void bonus_divisor(int a, int[] b) {
        if (a == 1) {
            b[1] += 1;
        }
        if (a == 0) {
            b[0] += 1;
        }
    }

    public void check2(String num) {
        if (!num.contains(",")) {
            throw new IllegalArgumentException("','로 나뉘어야 합니다.");
        }
    }

    public static void main(String[] args) {
        Application exception = new Application();
        System.out.println("구입금액을 입력해 주세요.");
        String amount_of_money = Console.readLine();
        int money = Integer.parseInt(amount_of_money) / 1000;
        while (money % 1000 != 0) {
            try {
                exception.check1(money);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
                System.out.println("구입금액을 입력해 주세요.");
                amount_of_money = Console.readLine();
                money = Integer.parseInt(amount_of_money);
            }
        }
        int lotto_tickets = Integer.parseInt(amount_of_money) / 1000;// 예외처리
        System.out.println("");
        System.out.println(lotto_tickets + "개를 구매했습니다.");
        Lotto[] lotto_Array = new Lotto[lotto_tickets];
        for (int i = 0; i < lotto_tickets; i++) {
            List<Integer> rand_Array = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(rand_Array);
            lotto_Array[i] = new Lotto(rand_Array);
            System.out.println(rand_Array);
        }
        System.out.println("");
        System.out.println("당첨 번호를 입력해 주세요.");
        String num1 = Console.readLine();// 1,2,3,4,5,6
        while (!num1.contains(",")) {
            try {
                exception.check2(num1);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
                System.out.println("\n당첨 번호를 입력해 주세요.");
                num1 = Console.readLine();
            }
        }
        String[] winning_number = num1.split(",");
        int[] winning_number_list = new int[winning_number.length];
        for (int i = 0; i < winning_number.length; i++) {
            winning_number_list[i] = Integer.parseInt(winning_number[i]);
        }
        System.out.println("");
        System.out.println("보너스 번호를 입력해 주세요.");
        String num2 = Console.readLine();
        int bonus_number = Integer.parseInt(num2);
        long[] correct_lotto = new long[4];
        int[] arr = new int[2];
        for (int i = 0; i < lotto_tickets; i++) {
            int result = lotto_Array[i].compare(winning_number_list);
            int bonus_result = lotto_Array[i].bonus_compare(bonus_number);
            if (result == 3) {
                correct_lotto[0] += 1;
            }
            if (result == 4) {
                correct_lotto[1] += 1;
            }
            if (result == 5) {
                bonus_divisor(bonus_result, arr);
            }
            if (result == 6) {
                correct_lotto[3] += 1;
            }
        }
        System.out.println("");
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + correct_lotto[0] + "개");
        System.out.println("4개 일치 (50,000원) - " + correct_lotto[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + arr[0] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + arr[1] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + correct_lotto[3] + "개");
        double total_money = (double) (5000 * correct_lotto[0] + 50000 * correct_lotto[1] + 1500000 * arr[0]
                + 30000000 * arr[1] + 2000000000 * correct_lotto[3]) / money;
        double round_total_money = Math.round(total_money);
        System.out.printf("총 수익률은 %.1f%%입니다.", round_total_money / 10);
    }
}
