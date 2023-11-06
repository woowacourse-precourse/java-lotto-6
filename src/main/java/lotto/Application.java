package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

class money_for_lotto{
    public static int realNumber;

    public static int realMoney(String inputNumber){
        moneyIsNumber(inputNumber);
        realNumber = Integer.parseInt(inputNumber);
        moneyIsOver0(realNumber);
        multipleOfThousand(realNumber);
        return Integer.parseInt(inputNumber);
    }

    public static void moneyIsNumber(String inputNumber){
        try{
            Integer.parseInt(inputNumber);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요");
        }
    }

    public static void moneyIsOver0(int realNumber){
        if(realNumber<1){
            throw new IllegalArgumentException("[ERROR] 0보다 큰 수를 입력하세요");
        }
    }
    public static void multipleOfThousand(int realNumber){
        if(realNumber%1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1000의 배수를 입력하세요");
        }
    }

    public static int repeatTime(int realNumber){
        return realNumber/1000;
    }
}

class random_lotto{
    static final List<List<Integer>> totalLotto = new ArrayList<>();

    public static List<List<Integer>> print_lotto(int repeatTime){
        save_lotto(repeatTime);
        for(int i = 0; i<repeatTime; i++){
            System.out.println(totalLotto.get(i));
        }
        return totalLotto;
    }

    public static void save_lotto(int repeatTime){
        for(int i = 0; i<repeatTime; i++){
            totalLotto.add(pick_lotto());
        }
    }
    public static List<Integer> pick_lotto(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String inputMoney = Console.readLine();
        int realMoney = money_for_lotto.realMoney(inputMoney);
        int repeatTime = money_for_lotto.repeatTime(realMoney);

        System.out.println("\n" + repeatTime + "개를 구매했습니다.");
        List<List<Integer>> totalLotto = random_lotto.print_lotto(repeatTime);

    }
}
