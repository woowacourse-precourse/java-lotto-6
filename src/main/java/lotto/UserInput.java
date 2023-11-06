package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
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

    public int Money() {
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

    public Lotto WinLotto() {
        List<Integer> numbox = new ArrayList<Integer>();
        while (numbox.isEmpty()) {
            numbox = strToIntegerList(Console.readLine());
            if (!numbox.isEmpty())
                break;

            System.out.println(ErrorType.NUMBER.getName());
        }
        return new Lotto(numbox);
    }

    public int Bonus(Lotto winLotto) {
        int res = -1;
        while (res == -1) {
            res = myParseInt(Console.readLine());
            if (res != -1 && !winLotto.lottoContains(res))
                break;

            System.out.println(ErrorType.NUMBER.getName());
        }
        return res;
    }

    public int myParseInt(String s) {
        int res;

        try {
            res = Integer.parseInt(s);
        } catch (Exception e) {
            return -1;
        }

        return res;
    }

    public int vaildMoney(int m) {
        if (m % 1000 != 0) {
            return -1;
        }
        return m;
    }

    public List<Integer> strToIntegerList(String userString) {
        List<Integer> res = new ArrayList<>();
        for (String s : userString.split(",")) {
            int number = myParseInt(s);
            if (number == -1)
                return new ArrayList<Integer>();
            res.add(number);
        }
        return res;
    }
}
