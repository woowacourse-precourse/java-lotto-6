package lotto.controllers;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.views.GameEnd;
import lotto.views.GameInit;
import lotto.views.GameOn;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    private final GameInit gameInit;
    private final GameOn gameOn;
    private final GameEnd gameEnd;

    List<Lotto> lottoes = new ArrayList<Lotto>();

    public MainController(GameInit gameInit, GameOn gameOn, GameEnd gameEnd) {
        this.gameInit = gameInit;
        this.gameOn = gameOn;
        this.gameEnd = gameEnd;
    }

    public void setLotto(){
        int paperSize = gameInit.buyLotto();
        int paperNum = paperSize/1000;
        gameInit.showLotto(paperNum);

        for(int i =0 ; i<paperNum; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottoes.add(lotto);
        }
        for(Lotto lotto:lottoes){
            gameInit.lottoView(lotto.getNumbers());
        }
    }

    public void checkNum(){
        String resultLine = gameOn.showCase();

    }
}
