package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoWalletGenerator {
    public static List<Lotto> generateLottoWallet(long walletSize) {
        List<Lotto> wallet = new ArrayList<>();
        for (long walletIndex = 0L; walletIndex < walletSize; walletIndex++) {
            Lotto lotto = new Lotto(LottoNumberGenerator.generateLottoNumber());
            wallet.add(lotto);
        }
        return wallet;
    }
}
