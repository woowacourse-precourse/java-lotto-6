package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        //1.로또 구입 금액 입력 받기, 구매 갯수 구하기.
        int purchase_price = Base_Func.Input_Purchase_Price();
        int purchase_num = Base_Func.Purchase_Lotto_Number(purchase_price);

        //2.purchase_num 만큼 로또 번호를 생성해 list에 저장하고 출력한다.
        ArrayList<Lotto> Buy_lotto = Make_Buy_Lotto_List(purchase_num);
        Base_Func.Print_Purchased_Lotto_list(Buy_lotto);

        //3.당첨 번호와 보너스 번호를 입력받는다.
        List<Integer> Win_lotto_list = Base_Func.Input_Win_Lotto_List();
        int Win_lotto_bonus_number = Base_Func.Input_Win_Lotto_Bonus_number();

    }

    public static ArrayList<Lotto> Make_Buy_Lotto_List(int purchase_num) {
        ArrayList<Lotto> Buy_lotto = new ArrayList<Lotto>();
        for (int i = 0; i < purchase_num; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto tmp_lotto = new Lotto(numbers);
            Buy_lotto.add(tmp_lotto);
        }
        return Buy_lotto;
    }

}
