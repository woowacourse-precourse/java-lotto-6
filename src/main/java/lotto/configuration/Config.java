package lotto.configuration;

import lotto.controller.LottoGameController;
import lotto.repository.Repository;
import lotto.service.LottoGameService;
import lotto.view.InputView;
import lotto.view.OutputView;

public interface Config {

    LottoGameController lottoGameController();

    LottoGameService lottoGameService();

    InputView inputView();

    OutputView outputView();

    Repository lottoGameRepository();
}
