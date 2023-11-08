package lotto.View;

import java.util.List;
import lotto.Model.Lotto;

public class OutputView {

    public static void printLottoList(Integer count, List<Lotto> lottoList){
        System.out.println(count + "개를 구매했습니다.");
        String result="";
        for(int i=0; i<lottoList.size();i++){
            result+=lottoList.get(i).printLotto()+"\n";
        }
        System.out.println(result);
    }
}
