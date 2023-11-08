package view;

import dto.Purchase;
import model.Lotto;

import java.lang.reflect.Array;
import java.util.List;

public class OutputView {
    private static final String BUY_MESSAGE = "개를 구매했습니다.";

    public static void showBuying(Purchase purchase){
        int count = purchase.getCount();
        List<Lotto> lottos = purchase.getLottos();

        System.out.println();
        System.out.println(String.format("%d"+BUY_MESSAGE, count));

        for(Lotto l : lottos) System.out.println(l);
    }

}
