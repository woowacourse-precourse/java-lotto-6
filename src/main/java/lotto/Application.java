package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.util.Strings;

public class Application {
    public static void main(String[] args) {
        int money = getInputMoney();
        int numberOfTicket = unsafeDivideBy1000(money);

    }

    public static int getInputMoney() {
        var input = Console.readLine();
        System.out.println("구입금액을 입력해 주세요.");
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
