package lotto.controller;

import static lotto.config.LottoConfig.LOTTO_PRICE;
import static lotto.config.WiningRank.RANK1;
import static lotto.config.WiningRank.RANK2;
import static lotto.config.WiningRank.RANK3;
import static lotto.config.WiningRank.RANK4;
import static lotto.config.WiningRank.RANK5;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.config.AppConfig;
import lotto.config.WiningRank;
import lotto.domain.Lotto;
import lotto.domain.RankBoard;
import lotto.service.Judgement;
import lotto.service.Payment;
import lotto.service.Publish;
import lotto.util.MakeList;
import lotto.util.Statistics;
import lotto.view.Input;
import lotto.view.Output;

public class GameProcess {

    Input input = new Input();
    Output output = new Output();

    ArrayList<Lotto> lottos = new ArrayList<>();
    List<Integer> winingNumbers;
    int bonusNumber;
    int buyCount = 0;

    public void buyLotto() {
        Payment payment = new AppConfig().payment();
        output.requestAmount();
        String inputAmount = input.enterAmount();
        //wrongCheckRequire
        int amount = Integer.parseInt(inputAmount);
        buyCount = payment.pay(amount, LOTTO_PRICE.getNum());
        output.printPurchaseCount(buyCount);
    }
    public void publishLotto() {
        Publish publish = new AppConfig().publish();
        for(int i = 0; i < buyCount; i++) {
            List<Integer> list = publish.makeNumbers();
            Lotto lotto = new Lotto(list);
            lottos.add(lotto);
        }
        output.printLottos(lottos);
    }
    public void enterWiningNumber() {
        MakeList makeList = new MakeList();

        output.requestWiningNumber();
        String rawWiningNumber = input.enterWiningNumber();
        //wrongCheckRequire
        winingNumbers = makeList.makeStringToIntegerList(rawWiningNumber);
        output.requestBonusNumber();
        String rawBonusNumber = input.enterBonusNumber();
        //wrongCheckRequire
        bonusNumber = Integer.parseInt(rawBonusNumber);
    }
    public void checkWiningResult() {
        Judgement judgement = new AppConfig().judgement();
        RankBoard rankBoard = new RankBoard();
        Statistics statistics = new Statistics();
        for(Lotto lotto:lottos) {
            int winingCount = judgement.judgeWiningNumber(lotto.getLotto(), winingNumbers);
            boolean bonusCount = judgement.judgeBonusNumber(lotto.getLotto(), bonusNumber);
            WiningRank rank = judgement.judgeRanking(winingCount, bonusCount);
            rankBoard.setRankCount(rank);
        }
        output.printWiningStatisticsStart();
        List<WiningRank> outputSequence = new ArrayList<>(Arrays.asList(RANK5,RANK4,RANK3,RANK2,RANK1));
        for(WiningRank rank:outputSequence) {
            output.printWiningCount(rank, rankBoard);
        }
        double returnMoney = statistics.calculateRateOfReturn(buyCount, rankBoard);
        output.printReturnRate(returnMoney);

    }
}
