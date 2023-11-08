package lotto;

import java.util.ArrayList;
import java.util.List;

public class Print {

    public void printLottos(List<List<Integer>> lottos) {
        List<Integer> lottoNumbers = null;
        List<Integer> eachLottoNumber = null;

        for (var lotto : lottos) {
//            eachLottoNumber = lotto.getLottoNumbers();
            System.out.println(lotto);
        }
    }


}
