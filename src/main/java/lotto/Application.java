package lotto;

import lotto.domain.*;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        User user = new User();
        List<Lotto> userLottos = user.buyLotto();
        LottoWinningNumber lottoWinningNumber = user.createWinningLottoNumber();

        Referee referee = new Referee(lottoWinningNumber, userLottos);
        referee.showResult();
    }
}