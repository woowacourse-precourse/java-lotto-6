package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.domain.UserLottos;
import lotto.domain.WinningLotto;
import lotto.view.OutputView;

public class CalculateLottoService {
    private static final int THREE_NUMBER_MATCHES = 3;
    private static final int FOUR_NUMBER_MATCHES = 4;
    private static final int FIVE_NUMBER_MATCHES = 5;
    private static final int SIX_NUMBER_MATCHES = 6;
    private static final int BONUS_ENUM_LABEL = 7;
    private static final int BEFORE_BONUS_NUMBER_INDEX = 6;
    private static final String DECIMAL_FORMAT = "###,##0.0";
    private final OutputView outputView = new OutputView();
    private Map<WinningLotto, Integer> winningCount = new HashMap<>();

	public void calculatingWinning(User user, Lotto lotto) {
		calculatingLottoWinning(user, lotto);
        outputView.printWinningStatics(winningCount);
	}

	public void calculatingLottoWinning(User user, Lotto lotto) {
	    List<UserLottos> userLottos = user.getLottos();
	    for (UserLottos userLotto : userLottos) {
	        countLottoWinning(user, userLotto.getLottoNumbers(), lotto);
	    }
	}

}
