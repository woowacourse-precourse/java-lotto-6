package lotto;
/*
    유저 입력 관리 클래스
    Money: 돈 입력 매소드
    WinLotto: 당첨 번호 입력 매소드
    Bonus: 보너스 번호 입력 매소드
    myParseInt: 문자열 정수화 매소드
    vaildMoney: 돈입력 입력형식 판별 매소드
    strToIntegerList: 특정 형식의 문자열을 정수List로 변환하는 매소드
*/
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

    //Money: 돈 입력 매소드 - 돈(정수)반환
    public int Money() {
        System.out.println("구입금액을 입력해 주세요.");
        int res = -1;
        while (res == -1) {
            res = myParseInt(Console.readLine());
            res = vaildMoney(res);
            if (res != -1)
                break;

            System.out.println(ErrorType.MONEY.getName());
        }
        System.out.println();
        return res;
    }

    //WinLotto: 당첨 번호 입력 매소드 - 당첨번호(Lotto객체) 반환
    public Lotto WinLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> numbox = new ArrayList<Integer>();
        while (numbox.isEmpty()) {
            numbox = strToIntegerList(Console.readLine());
            if (!numbox.isEmpty())
                break;

            System.out.println(ErrorType.NUMBER.getName());
        }
        System.out.println();
        return new Lotto(numbox);
    }

    //Bonus: 보너스 번호 입력 매소드 - 보너스 번호(정수)반환
    public int Bonus(Lotto winLotto) {
        System.out.println("보너스 번호를 입력해 주세요.");
        int res = -1;
        while (res == -1) {
            res = myParseInt(Console.readLine());
            if (res != -1 && !winLotto.lottoContains(res))
                break;

            System.out.println(ErrorType.NUMBER.getName());
        }
        System.out.println();
        return res;
    }

    //문자열 정수화 매소드 - 정수가 아닐시 에러상태(-1)반환
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
