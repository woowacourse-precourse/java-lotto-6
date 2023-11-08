package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Application {

    public static void main(String[] args) {
        print("구입금액을 입력해 주세요");

        int money = inputMoney();
        print("");

        int count = money / 1000;
        List<Lotto> lottos = new ArrayList<>();

        print(count + "개를 구매했습니다.");
        for (int i = 0; i < count; i++) {
            Lotto lotto = buyLotto();
            print(lotto.toString());
            lottos.add(lotto);
        }

        print("");
        print("당첨 번호를 입력해 주세요.");
        List<Integer> lottoNumber = inputLottoNumber();

        print("");
        print("보너스 번호를 입력해 주세요.");
        int bonus = inputBonus();
        int[] win = new int[5];
        for(Lotto lotto : lottos) {
            checkWin(lotto, lottoNumber, bonus, win);
        }
        int[] moneyList = new int[5];
        setMoney(moneyList);

        print("");
        print("당첨 통계");
        print("---");
        int earn = printTotal(win, moneyList);
        print("총 수익률은 " + calRevenue(money, earn) + "%입니다.");
    }

    private static String calRevenue(int money, int earn) {
        double revenue = 0;
        revenue += earn;
        revenue *= 100;
        revenue /= money;
        return String.format("%.1f", revenue);
    }

    private static int printTotal(int[] win, int[] moneyList) {
        int sum = 0;
        for(int i = 0; i < 5; i++) {
            print(i + 3 + "개 일치 (" + moneyFormat(moneyList[i]) + "원) - " + win[i] + "개");
            sum += moneyList[i] * win[i];
        }
        return sum;
    }

    private static String moneyFormat(int money) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        return formatter.format(money);
    }

    private static void setMoney(int[] moneyList) {
        moneyList[0] = 5000;
        moneyList[1] = 50000;
        moneyList[2] = 15000000;
        moneyList[3] = 30000000;
        moneyList[4] = 2000000000;
    }

    private static void checkWin(Lotto lotto, List<Integer> lottoNumber, int bonus, int[] win) {
        int cnt = 0;
        boolean bonusCheck = false;
        for(Integer num : lotto.getNumbers()) {
            if(lottoNumber.contains(num)) cnt++;
            if(num == bonus) bonusCheck = true;
        }

        calWin(cnt, bonusCheck, win);
    }

    private static void calWin(int cnt, boolean bonusCheck, int[] win) {
        if(cnt < 3) return;
        if(cnt == 3) win[0]++;
        if(cnt == 4) win[1]++;
        if(cnt == 5 && !bonusCheck) win[2]++;
        if(cnt == 5 && bonusCheck) win[3]++;
        if(cnt == 6) win[4]++;

    }

    private static int inputBonus() {
        int bonus = 0;

        try {
            bonus = Integer.parseInt(Console.readLine());
            if(bonus < 0 || bonus > 45) {
                try {
                    exception("보너스 번호는 1~45의 숫자입니다.");
                } catch (IllegalArgumentException exception) {
                    return inputBonus();
                }
            }
        } catch (IllegalArgumentException e) {
            try {
                exception("하나의 숫자만 입력해주세요.");
            } catch (IllegalArgumentException exception) {
                return inputBonus();
            }
        }
        return bonus;
    }

    private static List<Integer> inputLottoNumber() {
        String line = Console.readLine();
        StringTokenizer st = new StringTokenizer(line,",");

        List<Integer> lottoNumber = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            checkNumber(lottoNumber, st);
        }
        return lottoNumber;
    }

    private static void checkNumber(List<Integer> lottoNumber, StringTokenizer st) {
        try {
            int num = Integer.parseInt(st.nextToken());
            if (num < 0 || num > 45) {
                try {

                } catch (IllegalArgumentException exception) {
                    exception("당첨 번호는 1~45의 숫자입니다.");
                    checkNumber(lottoNumber, st);
                }
            }
            if (lottoNumber.contains(num)) {
                try {

                }catch (IllegalArgumentException exception) {
                    exception("중복된 숫자입니다.");
                    checkNumber(lottoNumber, st);
                }
            }
            lottoNumber.add(num);
        } catch (IllegalArgumentException e) {
            try {

            } catch (IllegalArgumentException exception) {
                exception("6개의 숫자를 입력해주세요");
                checkNumber(lottoNumber, st);
            }
        }
    }

    private static Lotto buyLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }

    private static int inputMoney() {
        int money = 0;
        try {
            money = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            try{
                exception("숫자만 입력해주세요");
            }
            catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                return inputMoney();
            }
        }
        if (money % 1000 != 0 || money / 1000 == 0) {
            try {
                exception("금액은 1000원 단위로 입력해주세요");
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                return inputMoney();
            }
        }
        return money;
    }

    private static void exception(String string) {
        throw new IllegalArgumentException("[ERROR] " + string);
    }

    private static void print(String string) {
        System.out.println(string);
    }
}
