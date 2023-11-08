package lotto.service;

import java.util.List;
import lotto.domain.BonusLotto;
import lotto.domain.Lotto;
import lotto.domain.RandomGenerator;
import lotto.domain.RandomLotto;
import lotto.domain.UserLotto;
import lotto.exception.ErrorCode;
import lotto.exception.errorzip.NotAllNumber;
import lotto.parsing.Parsing;
import lotto.validation.NumberValidation;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoService {
    private static OutputView outputView;
    private static RandomGenerator rg;
    private static RandomLotto rl;
    private static int number;
    private static UserLotto userLotto;
    private static Lotto lotto;
    private static ConsistencyService consistencyService;
    private static int capital;
    private static String purchaseNum;

    public LottoService() {
        outputView = new OutputView();
        rl = new RandomLotto();
    }

    public void purchase() {
        outputView.purchaseComment();
        getString();
        capital = Parsing.stringToInt(purchaseNum);
        number = Parsing.makeDivision(capital);
    }

    private static void getString() {
        try{
           purchaseNum = InputView.inputLine();
           NumberValidation.isAllNumber(purchaseNum);
        }catch(IllegalArgumentException e){
            outputView.errorComment(ErrorCode.NOT_ALL_NUMBER);
            getString();
        }
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
        purchaseNum = InputView.inputLine();
        lotto = new Lotto(userNumberList(purchaseNum));
        outputView.bonusNumberComment();
        int bonusNumber = Parsing.stringToInt(InputView.inputLine());
        userLotto = new UserLotto(lotto, new BonusLotto(bonusNumber));
    }

    public List<Integer> userNumberList(String purchaseNum) {
        List<Integer> userLottoList = Parsing.makeList(purchaseNum);
        NumberValidation.isSixSizeOfList(userLottoList);
        return userLottoList;
    }

    public void winner(){
        consistencyService = new ConsistencyService(capital, userLotto);
        List<Integer> totalConsistency = consistencyService.winnerGraph(rl.getLottoLists());
        consistencyService.setRateMoney();
        outputView.winnerGraphComment(totalConsistency, consistencyService.getRateOfReturn());
    }

    public void setPurchaseNum(String input){
        this.purchaseNum = input;
    }

}
