package lotto.service;

import java.util.List;
import lotto.domain.RandomGenerator;
import lotto.domain.RandomLotto;
import lotto.parse.Parsing;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoService {
    private static OutputView outputView;
    private static RandomGenerator rg;
    private static RandomLotto rl;
    private static int number;

    public LottoService(){
        outputView = new OutputView();
        rg = new RandomGenerator();
    }

    public void purchase(){
        outputView.purchaseComment();
        number = Parsing.stringToInt(InputView.inputLine());
        Parsing.isDivisible(number);
    }

    public void lottoLists(){
        outputView.purchaseNumberComment(number);
        generateLotto();

    }

    private static void generateLotto() {
        for(int i=0;i<number;i++){
            List<Integer> generatedList = rg.getNumList();
            rl.addLottoLists(generatedList);
        }
    }
}
