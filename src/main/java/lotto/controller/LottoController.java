package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.LottoManager;
import lotto.domain.LottoPrice;
import lotto.domain.Lottos;
import lotto.domain.MatchNumber;
import lotto.util.MatchRanking;
import lotto.view.LottoView;

public class LottoController {
    private static int PRICE_OF_LOTTO = 1000;

    private final LottoView lottoView = new LottoView();
    private Lottos lottos;

    public void init(){
        lottoView.startMessage();
        run();
    }
    public void run(){
        LottoPrice lottoPrice = new LottoPrice(userInput());
        drawLottoNumbers(lottoPrice);

        lottoView.inputMatchNumberMessage();
        MatchNumber matchNumber = new MatchNumber(userInput());
        lottoView.inputBonusNumberMessage();
        BonusNumber bonusNumber = new BonusNumber(userInput(), matchNumber);

        LottoManager lottoManager = matchResult(matchNumber, bonusNumber);
        printMatchStatistics(lottoManager);

    }
    public void printMatchStatistics(LottoManager lottoManager){
        lottoView.matchResultMessage();
        Map<MatchRanking, Integer> rankingCount = lottoManager.getLottoResult();
        lottoView.matchStatisticsMessage(rankingCount);

    }

    public LottoManager matchResult(MatchNumber matchNumber, BonusNumber bonusNumber){
        List<Integer> totalMatchNumbers = matchNumber.getMatchNumbers();
        totalMatchNumbers.add(bonusNumber.getBonusNumber());
        return new LottoManager(lottos, totalMatchNumbers);
    }

    public void drawLottoNumbers(LottoPrice lottoPrice){
        int numberOfLotto = countLotto(lottoPrice);
        lottoView.buyMessage(numberOfLotto);
        lottos = new Lottos(numberOfLotto);
        lottoView.lottosMessage(lottos);
    }

    public int countLotto(LottoPrice lottoPrice){
        return lottoPrice.getLottoPrice()/PRICE_OF_LOTTO;
    }

    private String userInput(){
        return Console.readLine();
    }
}
