package lotto;

import lotto.common.Validator;
import lotto.engine.LottoGame;
import lotto.view.LottoGameViewer;
import lotto.view.LottoGameViewerMapper;

public class Application {
    public static void main(String[] args) {
        LottoGameViewerMapper lottoGameViewerMapper = new LottoGameViewerMapper();
        LottoGameViewer lottoGameViewer = new LottoGameViewer(lottoGameViewerMapper);
        LottoGame lottoGame = new LottoGame(lottoGameViewer);
        lottoGame.start();
    }
}
