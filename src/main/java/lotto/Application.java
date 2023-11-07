package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoService lottoService = new LottoService();

        int times = lottoService.purchaseLotto();
        List<Lotto> lottoList = lottoService.issueLotto(times);

        Lotto winningLotto = lottoService.drawLotto();
        int bonusNumber = lottoService.drawBonus(winningLotto);

        lottoService.award(winningLotto, bonusNumber, lottoList);
    }
}
