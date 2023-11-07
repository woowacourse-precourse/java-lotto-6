package lotto;


import lotto.controller.*;
import lotto.domain.WinningChecker;
import lotto.vo.BonusNumber;
import lotto.vo.Lotto;
import lotto.vo.WinningNumber;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        OrderController order = new OrderController();
        int lottoNumber = order.getLottoNumber();

        DeliverController deliver = new DeliverController(lottoNumber);
        List<Lotto> lottoPackage = deliver.getLottoPackage();

        SetWinningNumController setWinningNumController = new SetWinningNumController();
        WinningNumber w = setWinningNumController.getWinningNumber();

        SetBonusNumController setBonusNumController = new SetBonusNumController(w);
        BonusNumber b = setBonusNumController.getBonusNumber();

        WinningChecker checker = new WinningChecker(w,b, lottoPackage);
        WinningController c = new WinningController(checker.getWinningResult(), order.getWastedMoney());
    }
}
