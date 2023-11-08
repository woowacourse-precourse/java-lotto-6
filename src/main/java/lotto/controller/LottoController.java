package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.LottoManager;
import lotto.domain.LottoPrice;
import lotto.domain.Lottos;
import lotto.domain.MatchNumber;
import lotto.domain.ReturnMoney;
import lotto.util.MatchRanking;
import lotto.view.LottoView;

public class LottoController {
    private static int PRICE_OF_LOTTO = 1000;
    private final LottoView lottoView = new LottoView();

    public void init(){
        lottoView.startMessage();
        run();
    }
    public void run(){
        LottoPrice lottoPrice = new LottoPrice(userInput());
        Lottos lottos = drawLottoNumbers(lottoPrice);

        lottoView.inputMatchNumberMessage();
        MatchNumber matchNumber = new MatchNumber(userInput());
        lottoView.inputBonusNumberMessage();
        BonusNumber bonusNumber = new BonusNumber(userInput(), matchNumber);

        List<Integer> totalMatchNumbers = getTotalMatchNumbers(matchNumber,bonusNumber);
        LottoManager lottoManager = matchResult(lottos, totalMatchNumbers);
        printMatchStatistics(lottoManager, lottoPrice);
    }

    public void printMatchStatistics(LottoManager lottoManager, LottoPrice lottoPrice){
        lottoView.matchResultMessage();
        Map<MatchRanking, Integer> rankingCount = lottoManager.getLottoResult();
        lottoView.matchStatisticsMessage(rankingCount);

        ReturnMoney returnMoney = new ReturnMoney(rankingCount, lottoPrice);
        lottoView.totalReturnMessage(returnMoney.getReturnMoney());
    }

    public List<Integer> getTotalMatchNumbers(MatchNumber matchNumber, BonusNumber bonusNumber){
        List<Integer> totalMatchNumbers = matchNumber.getMatchNumbers();
        totalMatchNumbers.add(bonusNumber.getBonusNumber());
        return totalMatchNumbers;
    }

    public LottoManager matchResult(Lottos lottos, List<Integer> totalMatchNumbers){
        return new LottoManager(lottos, totalMatchNumbers);
    }

    public Lottos drawLottoNumbers(LottoPrice lottoPrice){
        int numberOfLotto = countLotto(lottoPrice);
        lottoView.buyMessage(numberOfLotto);
        Lottos lottos = new Lottos(numberOfLotto);
        lottoView.lottosMessage(lottos);

        return lottos;
    }

    public int countLotto(LottoPrice lottoPrice){
        return lottoPrice.getLottoPrice()/PRICE_OF_LOTTO;
    }

    private String userInput(){
        return Console.readLine();
    }
}
