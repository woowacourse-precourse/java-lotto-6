package lotto.view;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private static final String PURCHASED_LOTTO_AMOUNT = "개를 구매했습니다.";

    public static void printPieceOfLottoAmount(int pieceOfLotto){
        System.out.print(pieceOfLotto);
        System.out.println(PURCHASED_LOTTO_AMOUNT);
    }
    public static void printAllLottos(ArrayList<List<String>> allLottos){
        for(List<String> lotto : allLottos){
            System.out.println(lotto);
        }

    }

}
