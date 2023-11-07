package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;

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
            bubbleSort(numbers);
            System.out.println(numbers);
            LottoNumberList.add(numbers);
        }


        return LottoNumberList;
    }
    private void bubbleSort(List<Integer> list) {
        int randomNumberSize = list.size();
        for (int i = 0; i < randomNumberSize - 1; i++) {
            for (int j = 0; j < randomNumberSize - i - 1; j++) {
                swapTempAndList(list, j);
            }
        }
    }

    private void swapTempAndList(List<Integer> list, int j) {
        if (list.get(j) > list.get(j + 1)) {
            int temp = list.get(j);
            list.set(j, list.get(j + 1));
            list.set(j + 1, temp);
        }
    }
}
