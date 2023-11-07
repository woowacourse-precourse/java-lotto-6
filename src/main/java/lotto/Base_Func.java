package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Base_Func {

    public static int Input_Purchase_Price() {
        String tmp_input = Console.readLine();
        int price = -1;
        try {
            price = Integer.parseInt(tmp_input);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 입력 오류 입니다.");
        }
        return price;
    }

    public static int Purchase_Lotto_Number(int price) {
        if (price % 1000 != 0) {
            throw new IllegalStateException("[ERROR] 로또 금액이 1000으로 나누어 지지 않습니다.");
        }
        return price/1000;
    }


}
