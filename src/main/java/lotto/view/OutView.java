package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class OutView {

    public static void outputLottoNumber(List<Lotto> lotto) {
        System.out.println(lotto.size() + "개를 구매했습니다.");
        lotto.stream().map(Lotto::getNumbers).forEach(System.out::println);
    }

}
