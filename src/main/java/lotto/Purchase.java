package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Purchase {

    public void process(){

        System.out.println("구입금액을 입력해주세요.");
        int money = Integer.parseInt(Console.readLine());

        int lottoCount = checkLottoCount(money);

        printLotto(lottoCount);
    }

    public int checkLottoCount(int money){
        int lottoCount = money / 1000;
        if(money % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 구입 금액을 확인해주세요. 1장당 1000원");
        }
        System.out.println(lottoCount + "개를 구매했습니다.");
        return lottoCount;
    }

    public void printLotto(int lottoCount){
        while (lottoCount > 0){
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lottoNumbers);
            System.out.println(lottoNumbers);
            lottoCount--;
        }
    }
}
