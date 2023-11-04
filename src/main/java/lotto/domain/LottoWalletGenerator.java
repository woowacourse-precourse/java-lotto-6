package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoWalletGenerator {
    public static List<Lotto> generateLottoWallet(int walletSize) {
        List<Lotto> wallet = new ArrayList<>();
        for (int walletIndex = 0; walletIndex < walletSize; walletIndex++) {
            Lotto lotto = new Lotto(LottoNumberGenerator.generateLottoNumber());
            wallet.add(lotto);
        }
        return wallet;
    }
}
