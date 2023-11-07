package lotto;
import java.util.List;

public class Lotto_Wallet {
    private List<Lotto> Lottos;

    public void setLottos(Lotto lottos) { // 로토를 지갑에 넣기
        Lottos.add(lottos);
    }
}
