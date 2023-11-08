package lotto;
import java.util.ArrayList;
import java.util.List;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoStore lottoStore = new LottoStore();
        lottoStore.buy_Lotto();

        List<Lotto> Lottos = lottoStore.getLotto();
        lottoStore.showLotto();

        LottoService lottoService = new LottoService(Lottos);
        lottoService.Lotto_Result();
    }
}
