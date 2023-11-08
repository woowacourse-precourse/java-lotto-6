package lotto;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {
    public static int totalPrice;
    public static List<Integer> winningNumber;
    public static int bonusNumber;


    public static void setTotalPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        String strTotalPrice = Console.readLine();
        if(!strTotalPrice.matches("^[0-9]*$")){
            System.out.println("[ERROR] 로또 금액은 숫자로만 입력해주세요.");
            throw new IllegalArgumentException();
        }
        totalPrice = Integer.parseInt(strTotalPrice);
        if (totalPrice % 1000 != 0) {
            System.out.println("[ERROR] 로또 금액을 잘못 입력하였습니다..");
            throw new IllegalArgumentException();
        }
    }

    public static void setWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        numberList(Console.readLine());
    }

    public static void numberList(String winningNumberWithComma) {
        String[] result = winningNumberWithComma.split(",");
        winningNumber = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            winningNumber.add(Integer.parseInt(result[i]));
        }
    }

    public static void setBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber = Integer.parseInt(Console.readLine());
    }
}
