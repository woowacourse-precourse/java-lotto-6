package lotto.Controller;

import lotto.Service.Service;
import lotto.View.View;
import lotto.constant.JudgeBonus;
import lotto.constant.LottoRanking;
import lotto.domain.*;
import lotto.mapper.Mapper;
import lotto.utils.RandomLottoGenerator;

import java.util.Arrays;
import java.util.List;

public class Controller {

    private final Service service;
    private final View view;
    private final Mapper mapper;

    public Controller() {
        this.service = new Service();
        this.view = new View();
        this.mapper = new Mapper();
    }

    public void start() {
        PurchaseMoney purchaseMoney = insertMoney();
        List<Lotto> userLottos = purchaseLotto(purchaseMoney);
        WinnerNumbers winnerNumbers = generateWinnerNumbers();
        BonusNumber bonusNumber = generateBonusNumber(winnerNumbers);

        PrizeTotalNUmber prizeTotalNUmber = new PrizeTotalNUmber(winnerNumbers, bonusNumber);
        analysisLottos(userLottos, prizeTotalNUmber);
        calculateEarningRatio(purchaseMoney);
    }

    private PurchaseMoney insertMoney() {
        return service.getPurchaseMoney();
    }

    private List<Lotto> purchaseLotto(PurchaseMoney purchaseMoney) {
        return service.getPurchaseLottos(purchaseMoney.getCount());
    }

    private WinnerNumbers generateWinnerNumbers() {
        return service.getWinnerNumbers();
    }

    private BonusNumber generateBonusNumber(WinnerNumbers winnerNumbers) {
        return service.getBonusNumber(winnerNumbers);
    }

    private void analysisLottos(List<Lotto> userLottos, PrizeTotalNUmber prizeTotalNUmber) {
        for(Lotto lotto : userLottos) {
            compareWinnerNumber(lotto, prizeTotalNUmber);
        }
        view.prizeResult();
    }

    private void compareWinnerNumber(Lotto userLotto, PrizeTotalNUmber prizeTotalNUmber) {
        JudgeBonus judgeBonus = JudgeBonus.BONUS_NO_MATTER;
        Integer matchCount = prizeTotalNUmber.matchWithWinnerNumbers(userLotto);
        if(matchCount == 5) {
            judgeBonus = prizeTotalNUmber.matchWithBonusNumber(userLotto);
        }
        addRankCount(matchCount, judgeBonus);
    }

    private void addRankCount(Integer matchCount, JudgeBonus judgeBonus) {
        Arrays.stream(LottoRanking.values()).forEach(lottoRanking -> lottoRanking.ismatched(matchCount, judgeBonus));
    }


    private void calculateEarningRatio(PurchaseMoney purchaseMoney) {
        Long totalPrize = Arrays.stream(LottoRanking.values())
                .map(LottoRanking::toPrice)
                .reduce((i, j) -> i + j)
                .orElseThrow(IllegalStateException::new);

        double result = (double) totalPrize / purchaseMoney.getMoney() * 100;
        System.out.println(result);
        view.printEarningRatio(result);
    }
}
