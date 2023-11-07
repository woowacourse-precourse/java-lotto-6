package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinningLottoList {

    private final List<WinningLotto> winningLottos;

    public WinningLottoList(int size) {
        this.winningLottos = this.generateLotterys(size);
    }


    public void printWinningLottoList(){
        for(WinningLotto data : winningLottos){
            Collections.sort(data.getLotto().getNumbers());
            System.out.println(data.getLotto().getNumbers());
        }
    }

    private List<WinningLotto> generateLotterys(int size){
        List<WinningLotto> winningLottos = new ArrayList<>();

        while(size>0){
            WinningLotto winningLotto = new WinningLotto();
            winningLottos.add(winningLotto);
            size--;
        }

        return winningLottos;

    }



}
