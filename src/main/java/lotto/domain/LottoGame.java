package lotto.domain;

import lotto.controller.*;
import lotto.service.OrderService;
import lotto.vo.BonusNumber;
import lotto.vo.Lotto;
import lotto.vo.WinningNumber;

import java.util.List;

public class LottoGame {

    int lottoNumber;
    int money;
    public void start(){

        OrderService orderService = new OrderService();
        OrderController orderController = new OrderController(orderService);

        lottoNumber = orderService.noticeLottoNumForDeliveryLotto();

        DeliverController deliver = new DeliverController(lottoNumber);
        List<Lotto> lottoPackage = deliver.getLottoPackage();

        SetWinningNumController setWinningNumController = new SetWinningNumController();
        WinningNumber w = setWinningNumController.getWinningNumber();

        SetBonusNumController setBonusNumController = new SetBonusNumController(w);
        BonusNumber b = setBonusNumController.getBonusNumber();

        money = orderService.noticeMoneyForComputeEarning();

        WinningChecker checker = new WinningChecker(w,b, lottoPackage);
        WinningController c = new WinningController(checker.getWinningResult(), money);
    }
}
