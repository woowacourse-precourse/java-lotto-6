package lotto.domain;

import lotto.service.DeliverService;
import lotto.service.OrderService;
import lotto.service.SetBonusNumService;
import lotto.service.SetWinningNumService;
import lotto.vo.BonusNumber;
import lotto.vo.Lotto;
import lotto.vo.WinningNumber;

import java.util.List;

public class LottoGame {
    int lottoNumber;
    int money;
    List<Lotto> lottoPackage;
    WinningNumber winningNumber;
    BonusNumber bonusNumber;

    public void start() {
        order();
        deliver();
        setWinningNumAndBonusNum();
        checkWinning();
    }

    private void order() {
        OrderService orderService = new OrderService();
        lottoNumber = orderService.noticeLottoNumForDeliveryLotto();
        money = orderService.noticeMoneyForComputeEarning();
    }

    private void deliver() {
        DeliverService deliverService = new DeliverService(lottoNumber);
        lottoPackage = deliverService.noticeLottoPackageForCheckWinning();
    }

    private void setWinningNumAndBonusNum() {
        SetWinningNumService setWinningNumService = new SetWinningNumService();
        winningNumber = setWinningNumService.noticeWinningNumberCompareWinning();

        SetBonusNumService setBonusNumService = new SetBonusNumService(winningNumber);
        bonusNumber = setBonusNumService.noticeBonusNumberForCompareWinning();
    }

    private void checkWinning() {
        new WinningChecker(winningNumber, bonusNumber, lottoPackage, money);
    }
}
