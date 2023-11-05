package lotto;
/*
    2023 11 04 다시 만들기로 결정
*/
import java.util.ArrayList;
import java.util.List;

import java.util.Collections;
import java.lang.Math;
import java.text.DecimalFormat;

import lotto.Lotto;
import net.bytebuddy.description.field.FieldDescription.InGenericShape;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;


public class Application {
    final static int[] prices = { 2_000_000_000, 30_000_000, 1_500_000, 50_000, 5_000, 0 };

    enum ErrorType { 
        NUMBERANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."), 
        DUP("[ERROR] 로또 번호는 중복할 수 없습니다."),
        MONEY("[ERROR] 금액은 1000으로 나누어 떨어지는 정수 입니다."),
        NOTINTEGER("[ERROR] 정수를 입력해 주세요.");

        final private String name; 
        public String getName() { 
            return name; 
        } 
        private ErrorType(String name){ 
            this.name = name; 
        } 
    }

    public static int myParseInt(String s){
        int res;

        try {
            res = Integer.parseInt(s);   
        } catch (Exception e) {
            return -1;
        }

        return res;
    }

    public static int vaildMoney(int m){
        if (m == -1 || m%1000 != 0) {
            System.err.println(m + ErrorType.MONEY.getName());
            return -1;
        }
        return m;
    }

    public static int setMoney(){
        int res = -1;
        while(res == -1) {
            res = myParseInt(Console.readLine());
            res = vaildMoney(res);
            System.out.println();
        }
        return res;
    }

    public static List<Lotto> setUser(int ticketNum){
        System.out.println(String.format("%d개를 구매했습니다.",ticketNum));
        List<Lotto> res = new ArrayList<>();
        for (int index = 0; index < ticketNum; index++) {
            res.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
            System.out.println(res.get(index).getNumbers());
        }
        return res;
    }

    public static void showUser(List<Lotto> user) {
        for (Lotto l : user) {
            System.out.println(l.getNumbers());
        }
    }

    public static List<Integer> strToIntegerList(String userString){
        List<Integer> res = new ArrayList<>(); 
        for (String s : userString.split(",")) {
            int number = myParseInt(s);
            if (number == -1) return new ArrayList<Integer>();
            res.add(number);
        }
        return res;
    }

    public static List<Integer> setWinNumbers(){
        List<Integer> res = new ArrayList<Integer>();
        while(res.isEmpty()) res = strToIntegerList(Console.readLine());
        return res;
    }

    public static void main(String[] args) {
        int money = -1;
        List<Lotto> user;
        Lotto winLotto;
        money = setMoney();
        user = setUser(money/1000);
        showUser(user);
        winLotto = new Lotto(setWinNumbers());
    }
}
