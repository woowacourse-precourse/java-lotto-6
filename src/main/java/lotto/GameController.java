package lotto;

import java.util.List;
import lotto.domain.Count;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.view.Input;

public class GameController {

    public void start() {
        readyToGame();
    }

    private void readyToGame() {
        Count count = insertMoney();
        List<Lotto> lottos = generateUserLotto();


    }

    private Count insertMoney(){
        Count count = new Count(Integer.parseInt(Input.consoleLine()));
        count.checkmoney();

        return count;
    }

    private List<Lotto> generateUserLotto(){
        List<Lotto> lottos =  Lottos.generateLotto();
        return lottos;
    }

    private void generateWinningLottto(){

    }

}
