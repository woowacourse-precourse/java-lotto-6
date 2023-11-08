package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.UserInputCheck;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class LottoService {
    UserInputCheck userInputCheck = new UserInputCheck();
    LottoGame lottoGame;

    public void getBuyAmount(String input){
        if (userInputCheck.validBuyAmount(input)){
            lottoGame = new LottoGame(Integer.parseInt(input));
        }
    }

    public LottoGame buyLotto() {
        lottoGame.generateLottos();
        return lottoGame;
    }

    public void getWinNumbers(String input) {
        if (userInputCheck.validWinNumbers(input)){
            List<Integer> numbers = Arrays.stream(input.split(","))
                    .mapToInt(Integer::parseInt)
                    .boxed().collect(Collectors.toList());
            Lotto winLotto = new Lotto(numbers);
            lottoGame.setWinNumbers(winLotto);
        }
    }

    public void getBonusNumbers(String input) {
        if (userInputCheck.validBonusNumber(input, lottoGame.getWinNumbers())){
            lottoGame.setBonusNumber(Integer.parseInt(input));
        }
    }

    public void calculateWinLotto(){

    }
}
