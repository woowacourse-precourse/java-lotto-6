package lotto;
import java.util.List;
public class LottoView {

    public static void printLottoAmount(int lottoPrice) {
        System.out.println(lottoPrice / 1000 + "개를 구매했습니다.");
    }

    public static void printGeneratedLottos(List<Lotto> boughtLottos) {
        for (Lotto lotto : boughtLottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
