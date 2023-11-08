package lotto.domain;

import lotto.controller.*;
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
    public void start(){

        OrderService orderService = new OrderService();
        OrderController orderController = new OrderController(orderService);
        lottoNumber = orderService.noticeLottoNumForDeliveryLotto();
        money = orderService.noticeMoneyForComputeEarning();

        DeliverService deliverService = new DeliverService();
        DeliverController deliverController = new DeliverController(lottoNumber,deliverService);
        lottoPackage = deliverService.noticeLottoPackageForCheckWinning();

        SetWinningNumService setWinningNumService = new SetWinningNumService();
        SetWinningNumController setWinningNumController = new SetWinningNumController(setWinningNumService);
        winningNumber = setWinningNumService.noticeWinningNumberCompareWinning();

        SetBonusNumService setBonusNumService = new SetBonusNumService();
        SetBonusNumController setBonusNumController = new SetBonusNumController(winningNumber, setBonusNumService);
        bonusNumber = setBonusNumService.noticeBonusNumberForCompareWinning();

        WinningChecker checker = new WinningChecker(winningNumber, bonusNumber, lottoPackage);
        WinningController winningController = new WinningController(checker.getWinningResult(), money);
    }
}
