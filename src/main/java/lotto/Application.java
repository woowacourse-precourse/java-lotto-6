package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    private static final LottoHandler lottoHandler = new LottoHandler();

    public static void main(String[] args) {
        int numberOfLotto = lottoHandler.lottoCountForPurchasePrice();
        List<Lotto> lottos = lottoHandler.issueLottoNumbers(numberOfLotto);
    }
}
