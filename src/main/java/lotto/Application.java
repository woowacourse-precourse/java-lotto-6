package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        //1-1.로또 구입 금액 입력 받기
        System.out.println("구입금액을 입력해 주세요.");
        int purchase_price = Base_Func.Input_Purchase_Price();
        int purchase_num = Base_Func.Purchase_Lotto_Number(purchase_price);
    }
}
