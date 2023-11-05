package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int money = getInputMoney();
        int numberOfTicket = unsafeDivideBy1000(money);

        List<Lotto> lotto = makeLottos(numberOfTicket);
        printLotto(lotto);


    }

    public static void printLotto(List<Lotto> lotto) {
        String temp;
        System.out.println(lotto.size() + "개를 구매했습니다.");
        for (Lotto value : lotto) {
            var item = value.getNumbers();
            var strLotto = list2String(item);
            System.out.println(strLotto);
        }
    }


    private static String list2String(List<Integer> item) {
        StringBuilder sb = new StringBuilder();

        sb.append('[');
        sb.append(item.get(0));
        for (int k = 1; k < item.size(); ++k) {
            sb.append(", ");
            sb.append(item.get(k));
        }
        sb.append(']');
        return sb.toString();
    }

    public static List<Lotto> makeLottos(int numberOfLotto) {
        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; ++i) {
            lotto.add(makeLotto());
        }

        return lotto;
    }

    public static Lotto makeLotto() {
        List<Integer> num = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(num);
        return new Lotto(num);
    }

    public static int getInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        var input = Console.readLine();
        return unsafeString2Int(input);
    }

    public static int unsafeString2Int(String str) {
        int money;
        try {
            money = Integer.parseInt(str);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return money;
    }

    public static int unsafeDivideBy1000(int num) {
        if (num % 1000 != 0) {
            throw new IllegalArgumentException();
        }

        return num / 1000;
    }

}
