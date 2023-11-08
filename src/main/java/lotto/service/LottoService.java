package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.BonusLotto;
import lotto.domain.Lotto;
import lotto.domain.RandomGenerator;
import lotto.domain.RandomLotto;
import lotto.domain.UserLotto;
import lotto.parse.Parsing;
import lotto.validation.NumberValidation;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoService {
    private static OutputView outputView;
    private static RandomGenerator rg;
    private static RandomLotto rl;
    private static int number;
    private static UserLotto userLotto;
    private static ConsistencyService consistencyService;
    private static int capital;
    private static final String ERROR_STRING = "[ERROR] ";

    public LottoService() {
        outputView = new OutputView();
        rl = new RandomLotto();
    }

    public void purchase() {
        outputView.purchaseComment();
        capital = Parsing.stringToInt(InputView.inputLine());
        number = Parsing.makeDivision(capital);
    }

    public void lottoLists() {
        outputView.purchaseNumberComment(number);
        generateLotto();
        outputView.lottoListsComment(rl.getLottoLists());
    }

    private void generateLotto() {
        rg = new RandomGenerator();
        for (int i = 0; i < number; i++) {
            List<Integer> generatedList = rg.getNumList();
            rl.addLottoLists(generatedList);
        }
    }

    public void userNumber(){
        outputView.userNumberComment();
        List<Integer> list = userNumberList();
        outputView.bonusNumberComment();
        int bonusNumber = Parsing.stringToInt(InputView.inputLine());
        userLotto = new UserLotto(new Lotto(list), new BonusLotto(bonusNumber));
    }

    private static List<Integer> userNumberList() {
        List<Integer> userLottoList = Parsing.makeList(InputView.inputLine());
        return userLottoList;
    }

    public void winner(){
        consistencyService = new ConsistencyService(capital, userLotto);
        List<Integer> totalConsistency = consistencyService.winnerGraph(rl.getLottoLists());
        consistencyService.setRateMoney();
        System.out.println(consistencyService.getRateOfReturn());
        outputView.winnerGraphComment(totalConsistency, consistencyService.getRateOfReturn());
    }

}
