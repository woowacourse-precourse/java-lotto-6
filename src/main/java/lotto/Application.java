package lotto;

import java.util.ArrayList;
import java.util.List;

import java.lang.Math;
import java.text.DecimalFormat;

import lotto.Lotto;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    final static int[] prices = { 5_000, 50_000, 1_500_000, 30_000_000, 2_000_000_000 };

    enum ErrorType {
        NUMBER("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
        MONEY("[ERROR] 금액은 1000으로 나누어 떨어지는 정수 입니다."),;

        final private String name;

        public String getName() {
            return name;
        }

        private ErrorType(String name) {
            this.name = name;
        }
    }

    public static int myParseInt(String s) {
        int res;

        try {
            res = Integer.parseInt(s);
        } catch (Exception e) {
            return -1;
        }

        return res;
    }

    public static int vaildMoney(int m) {
        if (m == -1 || m % 1000 != 0) {
            return -1;
        }
        return m;
    }

    public static int setMoney() {
        int res = -1;
        while (res == -1) {
            res = myParseInt(Console.readLine());
            res = vaildMoney(res);
            System.out.println();
            if (res != -1)
                break;

            System.out.println(ErrorType.MONEY.getName());
        }
        return res;
    }

    public static List<List<Integer>> setUser(int ticketNum) {
        System.out.println(String.format("%d개를 구매했습니다.", ticketNum));
        List<List<Integer>> res = new ArrayList<>();
        for (int index = 0; index < ticketNum; index++) {
            res.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        return res;
    }

    public static void showUser(List<List<Integer>> user) {
        for (List<Integer> l : user) {
            System.out.println(l);
        }
    }

    public static List<Integer> strToIntegerList(String userString) {
        List<Integer> res = new ArrayList<>();
        for (String s : userString.split(",")) {
            int number = myParseInt(s);
            if (number == -1)
                return new ArrayList<Integer>();
            res.add(number);
        }
        return res;
    }

    public static List<Integer> setWinNumbers() {
        List<Integer> res = new ArrayList<Integer>();
        while (res.isEmpty()) {
            res = strToIntegerList(Console.readLine());
            if (!res.isEmpty())
                break;

            System.out.println(ErrorType.NUMBER.getName());
        }
        return res;
    }

    public static int setBonus(Lotto winLotto) {
        int res = -1;
        while (res == -1) {
            res = myParseInt(Console.readLine());
            if (res != -1 && !winLotto.lottoContains(res))
                break;

            System.out.println(ErrorType.NUMBER.getName());
        }
        return res;
    }

    public static int judge(Lotto winLotto, List<Integer> L, int bonus) {
        int count = winLotto.countMatch(L) - 3;
        if (count == 2 && winLotto.lottoContains(bonus))
            return count + 1;
        if (count == 3)
            return count + 1;
        return count;
    }

    public static int[] lottery(Lotto winLotto, List<List<Integer>> user, int bonus) {
        int[] res = { 0, 0, 0, 0, 0 };
        for (List<Integer> L : user) {
            int grade = judge(winLotto, L, bonus);
            if (grade >= 0)
                res[grade]++;
        }
        return res;
    }

    public static void printResult(int[] result) {
        DecimalFormat df = new DecimalFormat("###,###");
        int i = 0;
        System.out.println(
                String.format("%d개 일치 (%s원) - %d개\n", i + 3, df.format(prices[i]), result[i++])
                        + String.format("%d개 일치 (%s원) - %d개\n", i + 3, df.format(prices[i]), result[i++])
                        + String.format("%d개 일치 (%s원) - %d개\n", i + 3, df.format(prices[i]), result[i++])
                        + String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n", i + 2, df.format(prices[i]), result[i++])
                        + String.format("%d개 일치 (%s원) - %d개", i + 2, df.format(prices[i]), result[i++]));
    }

    public static void showReturnRate(int[] result, float money) {
        float profit = 0;
        for (int i = 0; i < result.length; i++) {
            profit += result[i] * prices[i];
        }
        float tmp = Math.round(profit / money * 1000);
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", tmp / 10));
    }

    public static void main(String[] args) {
        int money = -1, bonus;
        List<List<Integer>> user;
        Lotto winLotto;
        int[] Lottery_result;

        money = setMoney();
        user = setUser(money / 1000);
        showUser(user);
        winLotto = new Lotto(setWinNumbers());
        bonus = setBonus(winLotto);
        Lottery_result = lottery(winLotto, user, bonus);
        printResult(Lottery_result);
        showReturnRate(Lottery_result, money);
    }
}
