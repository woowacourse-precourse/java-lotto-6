package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Input {
    static List<Integer> lottoNumberL = new ArrayList<>();
    static int lottoBonusNumber;
    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
//        Lotto.validate(money);
        return money;
    }
    public static List<Integer> inputNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
    public static void inputNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] lottoNumber = Console.readLine().split(",");
        for(int i = 0; i<lottoNumber.length; i++){
            lottoNumberL.add(Integer.parseInt(lottoNumber[i]));
        }
        System.out.println();
    }
    public static void inputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        lottoBonusNumber = Integer.parseInt(Console.readLine());
        System.out.println();
    }
}
