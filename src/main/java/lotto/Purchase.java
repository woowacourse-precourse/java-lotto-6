package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Purchase {

    public List<List<Integer>> process(){
        System.out.println("구입금액을 입력해주세요.");
        int money = Integer.parseInt(Console.readLine());

        int lottoCount = checkLottoCount(money);

        return printLotto(lottoCount);
    }

    public int checkLottoCount(int money){
        int lottoCount = money / 1000;
        if(money % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 구입 금액을 확인해주세요. 1장당 1000원");
        }
        System.out.println(lottoCount + "개를 구매했습니다.");
        return lottoCount;
    }

    public List<List<Integer>> printLotto(int lottoCount){
        List<Integer> lottoNumber = null;
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        while (lottoCount > 0){
            lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lottoNumber);
            System.out.println(lottoNumber);
            lottoCount--;
            lottoNumbers.add(lottoNumber);
        }

        return lottoNumbers;
    }
}
