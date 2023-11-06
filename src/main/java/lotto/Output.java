package lotto;

import java.util.List;
import java.util.ArrayList;
import lotto.LottoGroup;
import lotto.Input;
public class Output {

    public void showLottoCount(int lottoCount){
        System.out.println(lottoCount+"개를 구매했습니다.");
    }

    public void showLottoGroupNum(LottoGroup lottoGroup) {
        List<Lotto> lottoList = lottoGroup.getGroupLotto();
        for(int i = 0; i < lottoList.size(); i++) {
            List<Integer>lottoNum = lottoList.get(i).getNumbers();
            System.out.println(lottoNum);
        }

    }
}
