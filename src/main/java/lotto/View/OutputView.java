package lotto.View;

import java.util.List;
import lotto.Model.Lotto;

public class OutputView {

    public static String printLottoList(List<Lotto> lottoList){
        String result="";
        for(int i=0; i<lottoList.size();i++){
            result+=lottoList.get(i).printLotto();
        }
        return result;
    }
}
