package lotto;

import lotto.common.Validator;
import lotto.engine.manager.LottoFactory;
import lotto.engine.LottoGame;
import lotto.view.LottoGameViewer;
import lotto.view.LottoGameViewerMapper;

public class Application {
    public static void main(String[] args) {
        Validator validator = new Validator();
        LottoGameViewerMapper lottoGameViewerMapper = new LottoGameViewerMapper();
        LottoGameViewer lottoGameViewer = new LottoGameViewer(validator, lottoGameViewerMapper);
        LottoFactory lottoFactory = new LottoFactory();
        LottoGame lottoGame = new LottoGame(lottoGameViewer, lottoFactory);
        lottoGame.start();
    }
}
