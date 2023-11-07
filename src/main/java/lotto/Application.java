package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoTicketGenerator generator = new LottoTicketGenerator();
        Payment payment = UserIO.scanPayment();

        Lottos lottos = generator.generate(payment);
        lottos.printLottos();

        Lotto winningsLotto = UserIO.scanWinningsLotto();
        BonusNumber bonusNumber = UserIO.scanBonusNumber(winningsLotto);
        LottoWinningChecker lottoWinningChecker = new LottoWinningChecker(winningsLotto, bonusNumber);
        lottos.checkLottos(lottoWinningChecker);

        LottoResultManager lottoResultManager = lottoWinningChecker.getLottoResultManager();
        lottoResultManager.printLottoResult();
    }
}
