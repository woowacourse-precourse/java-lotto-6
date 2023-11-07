package lotto.model;

import java.util.ArrayList;

public class LottoGet {
    public static int[][] getLottos () {
        int[][] lottos = LottoSetUp.makeListToGetLottos();
        int numberOfLottos = LottoSetUp.getcols();
        for(int i = 0; i < numberOfLottos; i++) {
            lottos[i] = LottoSetUp.listToIntArray(Lotto.makeLottoNumbers());
        }
        return lottos;
    }
}
