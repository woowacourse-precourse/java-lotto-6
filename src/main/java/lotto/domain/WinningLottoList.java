package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinningLottoList {

    private int listSize;
    private final List<WinningLotto> winningLottos = new ArrayList<>();

    public WinningLottoList(int size) {
        this.listSize = size;
    }


    public void printWinningLottoList(){
        createLotteryList();

        for(WinningLotto data : winningLottos){
            Collections.sort(data.getLotto().getNumbers());
            System.out.println(data.getLotto().getNumbers());
        }
    }

    private void createLotteryList(){
        while(listSize>0){
            addLottery();
            listSize--;
        }
    }


    private void addLottery(){
            winningLottos.add(new WinningLotto());
    }


}
