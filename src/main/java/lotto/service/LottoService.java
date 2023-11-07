package lotto.service;

import java.util.List;
import lotto.domain.BonusLotto;
import lotto.domain.Lotto;
import lotto.domain.RandomGenerator;
import lotto.domain.RandomLotto;
import lotto.domain.UserLotto;
import lotto.parse.Parsing;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoService {
    private static OutputView outputView;
    private static RandomGenerator rg;
    private static RandomLotto rl;
    private static int number;
    private static UserLotto userLotto;

    public LottoService() {
        outputView = new OutputView();
        rg = new RandomGenerator();
    }

    public void purchase() {
        outputView.purchaseComment();
        number = Parsing.stringToInt(InputView.inputLine());
        number = Parsing.isDivisible(number);
    }

    public void lottoLists() {
        outputView.purchaseNumberComment(number);
        generateLotto();
        outputView.lottoListsComment(rl.getLottoLists());
    }

    private void generateLotto() {
        for (int i = 0; i < number; i++) {
            List<Integer> generatedList = rg.getNumList();
            rl.addLottoLists(generatedList);
        }
    }

    public void userNumber(){
        outputView.userNumberComment();
        List<Integer> userLottoList = Parsing.makeList(InputView.inputLine());
        int bonusNumber = Parsing.stringToInt(InputView.inputLine());
        userLotto = new UserLotto(new Lotto(userLottoList), new BonusLotto(bonusNumber));
    }

    
}
