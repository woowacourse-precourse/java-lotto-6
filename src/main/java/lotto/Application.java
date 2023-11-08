package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoNum;
import lotto.domain.MakeNumList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String price = Console.readLine();
        LottoNum lottoNum = new LottoNum();
        int buyNum = lottoNum.lottoBuy(Integer.parseInt(price));
        System.out.println(buyNum+"개를 구매했습니다.");
        ArrayList<Integer>[] lottoList = lottoNum.lottoList(buyNum);


        System.out.println("당첨 번호를 입력해 주세요.");
        String numbers = Console.readLine();
        MakeNumList makeNumList = new MakeNumList();
        List<Integer> userList = makeNumList.makeList(numbers);
        Lotto lotto = new Lotto(userList);

        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        System.out.println();
        System.out.println("당첨통계\n---");


    }
}
