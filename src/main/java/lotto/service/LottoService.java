package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.PickLotto;
import lotto.domain.Player;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private List<Lotto> lottos = new ArrayList<>();

    public Player createPlayer(){
        int quantity = Integer.parseInt(inputView.enterMoney());
        Player player = new Player(quantity);
        return player;
    }

    public void createLotto(){
        int quantity = createPlayer().getQuantity();

        for(int i = 0 ; i<quantity; i++){
            lottos.add(new Lotto(new PickLotto().getNumbers()));
        }
    }

    public void printLottos(){
        for(int i = 0 ; i< lottos.size(); i++){
            List<Integer> list = lottos.get(i).getNumbers();
            Collections.sort(list);
            outputView.printLottos(list);
        }
    }

    public String [] winningLotto(){
        String [] lotto = inputView.enterWinningLotto().split(",");
        return lotto;
    }

    public int bonusNum(){
        int bonusNum = Integer.parseInt(inputView.enterBonus());
        return bonusNum;
    }

    public void correctCheck(){
        String [] winningLotto = winningLotto();

        for(int i = 0 ; i < lottos.size(); i++) {
            int cnt = 0;
            for (int k = 0; k < winningLotto.length; k++) {
                if (lottos.get(i).getNumbers().contains(winningLotto[k]))
                    cnt++;
            }
            outputView.printCount(cnt);
        }
    }


}

