package lotto.view;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private static final String PURCHASED_LOTTO_AMOUNT = "개를 구매했습니다.";

    public void printPieceOfLottoAmount(int pieceOfLotto){
        System.out.print(pieceOfLotto);
        System.out.println(PURCHASED_LOTTO_AMOUNT);
    }
    public void printAllLottos(ArrayList<List<Integer>> allLottos){
        for(List<Integer> lotto : allLottos){
            System.out.println(lotto);
        }

    }

}
