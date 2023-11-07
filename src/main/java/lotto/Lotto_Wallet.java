package lotto;
import java.util.ArrayList;
import java.util.List;

public class Lotto_Wallet {
    private List<Lotto> Lottos =  new ArrayList<>();;
    public void setLottos(Lotto lotto) { // 로토를 지갑에 넣기
        Lottos.add(lotto);
    }
}
