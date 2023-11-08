package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.service.BubbleSort;

import java.util.ArrayList;
import java.util.List;

public class ClientLottoNumber {
    public List<List<Integer>> LottoNumberList = new ArrayList<>();
    public int t;

    public List<List<Integer>> NumberGenerator() {
        System.out.println("구입 금액을 알려주세요");
        t = LottoQuantity.Quantity();
        System.out.println("\n" + t + "개를 구매했습니다.");

        for (int i = 0; i < t; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            BubbleSort.bubbleSort(numbers);
            System.out.println(numbers);
            LottoNumberList.add(numbers);
        }


        return LottoNumberList;
    }



}
