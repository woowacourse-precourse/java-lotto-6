package lotto.View;
import lotto.Model.Lottos;

public class OutputLottoListView {
    public static void printLottoList(Lottos lottos) {
        lottos.getLottos().forEach(System.out::println);
        System.out.println();
    }
}
