package lotto.controller;

import lotto.model.DHLottery;
import lotto.model.Lotto;
import lotto.model.Member;
import lotto.model.ScoreType;
import lotto.view.Print;

public class LottoController {
    private DHLottery dhLottery;
    private Member member;
    private CheckLottoService checkLottoService;
    private ScoreType scoreType;

    public LottoController(DHLottery dhLottery, Member member) {
        this.dhLottery = dhLottery;
        this.member = member;
    }

    public void run() {
        member.setAmount();
        member.setLottos();
        Print.howManyBuyLottos(member);

        dhLottery.setWinningNumber();
        dhLottery.setBonusNumber();

        matchRanking();

        member.setProfit(calculateProfit());

        Print.lottoResult(member);
    }

    public void matchRanking() {
        for (Lotto l: this.member.getLottos()) {
            checkLottoService = new CheckLottoService();
            checkLottoService.checkLotto(this.dhLottery, l);
            checkLottoService.rankLotto().setCount();
        }
    }

    public Double calculateProfit() {
        long sum = ((ScoreType.FIRST.getMoney() * ScoreType.FIRST.getCount()
                + ScoreType.SECOND.getMoney() * ScoreType.SECOND.getCount()
                + ScoreType.THIRD.getMoney() * ScoreType.THIRD.getCount()
                + ScoreType.FOURTH.getMoney() * ScoreType.FOURTH.getCount()
                + ScoreType.FIFTH.getMoney() * ScoreType.FIFTH.getCount())
        );
        int buyingCost = member.getAmount()*1000;

        return ((double) sum / buyingCost * 100);
    }
}
