package lotto;

import java.util.List;


import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.Input;
import lotto.view.Output;
import lotto.Message.GameMessage;

public class GameController {

    public void start() {
        Money count = insertMoney();
        List<Lotto> lottos = generateUserLotto(count);
//        WinningLotto winningLotto = generateWinningLottto();

    }

    private Money insertMoney(){
        Money count = new Money(Integer.parseInt(Input.consoleLine()));
        count.checkmoney();
        return count;
    }

    private List<Lotto> generateUserLotto(Money count){
        List<Lotto> lottos =  Lottos.generateLotto(count);
        return lottos;
    }

    private WinningLotto generateWinningLottto(){
        Output.consoleLine(GameMessage.OUT_REQUEST_WINNING_LOTTO_MESSAGE);
        String numbers = Input.consoleLine();
        //validation 실행
        Output.consoleLine(GameMessage.OUT_REQUEST_BONUS_NUMBER_MESSAGE);
        String bonusNumbers = Input.consoleLine();
        //validationtion실행
//        WinningLotto winningLotto = new WinningLotto();
        //생성
    }
    return

}
