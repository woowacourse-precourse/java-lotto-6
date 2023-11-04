package lotto.domain;

import static lotto.constant.CostConstant.UNIT;
import static lotto.constant.LottoConstant.LOTTO_SIZE;
import static lotto.constant.LottoConstant.MAX_NUMBER;
import static lotto.constant.LottoConstant.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

public class MyLotto {
    private final int quantity;
    private final List<List<Integer>> myLottos;

    public MyLotto(int cost) {
        this.quantity = cost/ UNIT.getValue();
        this.myLottos = IntStream.range(0, quantity)
                .mapToObj(q -> generateLottoNumber())
                .toList();
    }

    public int getQuantity(){
        return quantity;
    }
    public List<List<Integer>> getMyLottos(){
        return myLottos;
    }

    private List<Integer> generateLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(
                MIN_NUMBER.getValue(), MAX_NUMBER.getValue(), LOTTO_SIZE.getValue());
    }

}
