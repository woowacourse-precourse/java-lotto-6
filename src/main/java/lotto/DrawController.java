package lotto;

import java.util.List;
import lotto.domain.LottoDraw;
import lotto.domain.Rank;
import lotto.domain.RankStatistics;
import lotto.port.InputPort;
import lotto.port.OutputPort;

public class DrawController {

    private final static int TICKET_PRICE = 1000;

    private InputPort inputPort;
    private OutputPort outputPort;

    private LottoDraw lottoDraw;

    public DrawController(InputPort inputPort, OutputPort outputPort) {
        this.inputPort = inputPort;
        this.outputPort = outputPort;
        lottoDraw = new LottoDraw();
    }

    public void draw() {
        Integer purchaseAmount = inputPort.readPurchaseAmount();
        lottoDraw.createLottos(purchaseAmount, TICKET_PRICE);
        outputPort.printLottos(lottoDraw.getLottos());


        List<Integer> drawNumbers = inputPort.readDrawNumbers();
        lottoDraw.setDrawNumbers(drawNumbers);

        Integer bonusNumber = inputPort.readBonusNumber();
        lottoDraw.setBonusNumber(bonusNumber);


        List<Rank> ranks = lottoDraw.getRanks();
        RankStatistics rankStatistics = new RankStatistics(ranks, purchaseAmount);
        outputPort.printRankStatistics(rankStatistics.getRankInfos());

        outputPort.printProfitRate(rankStatistics.getProfitRate());
    }

}
