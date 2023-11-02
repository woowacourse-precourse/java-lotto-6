package lotto.gameUtil;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.view.OutputView;

import java.util.List;

public class GameLogic {
    OutputView outputView = new OutputView();
    public void lottoNumber(int amount){
        int count = amount / 1000;
        outputView.countMessage(count);

        for(int i=0;i<count;i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            numbers.sort((o1, o2)->{
                return o1-o2;
            });
            Lotto lotto = new Lotto(numbers);
            outputView.lottoNumberMessage(lotto.toString());
        }
    }

}
