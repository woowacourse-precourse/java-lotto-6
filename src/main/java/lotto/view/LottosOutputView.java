package lotto.view;

import lotto.Lotto;

import java.util.List;

public class LottosOutputView {

    public LottosOutputView(List<Lotto> lottos){
        System.out.println(lottos.size()+"개를 구매했습니다.");
        for(Lotto lotto:lottos){
            String result="[";
            for(int number:lotto.getNumbers()) {
                result += number + ",";
            }
            result.substring(0,result.length()-1);
            result+="]";
            System.out.println(result);
        }
    }

}
