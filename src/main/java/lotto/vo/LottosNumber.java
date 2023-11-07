package lotto.vo;

import java.util.List;
import lotto.vo.Lotto;

public class LottosNumber {
    private static List<Lotto> lottos;
    
    public static void SetLottos(List<Lotto> Lottos) {
        lottos = Lottos;
    }

    public static List<Lotto> GetLottos() {
        return lottos;
    }
}
