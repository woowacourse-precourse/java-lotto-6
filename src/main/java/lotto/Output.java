package lotto;

import java.util.List;
import java.util.ArrayList;
import lotto.LottoGroup;

public class Output {

    public static void showLottoGroupNum(LottoGroup lottoGroup) {
        List<Lotto> lottoList = lottoGroup.getGroupLotto();
        for(int i = 0; i < lottoList.size(); i++) {
            List<Integer>lottoNum = lottoList.get(i).getNumbers();
            System.out.println(lottoNum);
        }

    }
}
