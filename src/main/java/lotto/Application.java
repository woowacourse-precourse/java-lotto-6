package lotto;
/*
    2023 11 03 주가해야할 요구사항:
    JUnit 5와 AssertJ,도메인 로직 단위테스트 구현
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.lang.Math;
import java.text.DecimalFormat;

import lotto.Lotto;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;


public class Application {
    final static int[] prices = { 2_000_000_000, 30_000_000, 1_500_000, 50_000, 5_000, 0 };

    enum ErrorType { 
        NUMBERANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."), 
        DUP("[ERROR] 로또 번호는 중복할 수 없습니다."),
        MONEY("[ERROR] 금액은 1000으로 나누어 떨어져야 합니다."),
        NOTINTEGER("[ERROR] 정수를 입력해 주세요.");

        final private String name; 
        public String getName() { 
            return name; 
        } 
        private ErrorType(String name){ 
            this.name = name; 
        } 
    }

    // 랜덤 번호 6개 뽑기
    private static List<Integer> setRandomNumbers() {
        List<Integer> box = new ArrayList<>();
        while (box.size() != 6) {
            int rd = Randoms.pickNumberInRange(1, 45);
            if (box.contains(rd))
                continue;
            box.add(rd);
        }
        Collections.sort(box);
        System.out.println(box);
        return box;
    }

    private static void isBoundary(int n){
        if (n > 45 || n < 0)
            throw new IllegalArgumentException(ErrorType.NUMBERANGE.getName());
    }

    private static int myParseInt(String s){
        int n = 0;
        try {
            n = Integer.parseInt(s);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorType.NOTINTEGER.getName());
        }
        return n;
    }

    private static List<Integer> setNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> box = new ArrayList<>();
        for (String s : Console.readLine().split(",")) {
            int n = myParseInt(s);
            isBoundary(n);
            box.add(Integer.parseInt(s));
        }
        System.out.println();
        return box;
    }

    private static int setBonus(Lotto userNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus = myParseInt(Console.readLine());
        isBoundary(bonus);
        if (userNumbers.lottoContains(bonus))
            throw new IllegalArgumentException(ErrorType.DUP.getName());
        System.out.println();
        return bonus;
    }

    private static int judge(Lotto winNum, Lotto user, int bonus) {
        int ct = winNum.countMatch(user.getNumbers());
        if (ct > 5)  return 0;
        if (ct > 4) {
            if (user.lottoContains(bonus))
                return 1;
            return 2;
        }
        if (ct > 3) return 3;
        if (ct > 2) return 4;
        return 5;
    }

    private static int setMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = myParseInt(Console.readLine());
        if (money % 1000 != 0)
            throw new IllegalArgumentException(ErrorType.MONEY.getName());
        System.out.println();
        return money;
    }

    private static List<Lotto> setUser(int money) {
        int n = money/1000;
        System.out.println(String.format("%d개를 구매했습니다.", n));
        List<Lotto> user = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            user.add(new Lotto(setRandomNumbers()));
        }
        System.out.println();
        return user;
    }

    private static void printres(int[] res) {
        DecimalFormat df = new DecimalFormat("###,###");
        int i = 4;
        System.out.println(String.format("6개 일치 (%s원) - %d개", df.format(prices[i]), res[i--]));
        System.out.println(String.format("5개 일치 (%s원) - %d개", df.format(prices[i]), res[i--]));
        System.out.println(String.format("5개 일치 (%s원) - %d개", df.format(prices[i]), res[i--]));
        System.out.println(String.format("4개 일치, 보너스 볼 일치 (%s원) - %d개", df.format(prices[i]), res[i--]));
        System.out.println(String.format("3개 일치 (%s원) - %d개", df.format(prices[i]), res[i--]));
    }

    public static int[] resultList(List<Lotto> user, Lotto winNumber, int bonus) {
        int[] res = { 0, 0, 0, 0, 0, 0 };
        for (int i = 0; i < user.size(); i++) {
            int idx = judge(winNumber, user.get(i), bonus);
            res[idx]++;
        }        
        return res;
    }

    public static void calulateReturnRate(int[] res, int money) {
        float userPrice = 0;
        for (int i = 0; i < res.length; i++) {
            userPrice += prices[i] * res[i];
        }
        float returnRate = Math.round(userPrice / money * 1000) / 10;
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", returnRate));
    }

    public static void main(String[] args) {
        int m = setMoney();
        List<Lotto> user = setUser(m);
        Lotto winNumber = new Lotto(setNumbers());
        int bonus = setBonus(winNumber);
        int[] res = resultList(user, winNumber, bonus);

        printres(res);
        calulateReturnRate(res, m);
    }
}
