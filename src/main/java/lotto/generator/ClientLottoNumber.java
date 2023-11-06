package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClientLottoNumber {
    public List<List<Integer>> LottoNumberList = new ArrayList<>();
    public List NumberGenerator(){
        System.out.println("구입 금액을 알려주세요");
        int t=LottoQuantity.Quantity();
        System.out.println("\n"+t+"개를 구매했습니다.");
        for(int i=0;i<t;i++) {
            List<Integer> LottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(LottoNumber);
            System.out.println(LottoNumber);
            LottoNumberList.add(LottoNumber);
        }
        System.out.println("사이즈");
        System.out.println(LottoNumberList.size());
        return LottoNumberList;
    }
}
