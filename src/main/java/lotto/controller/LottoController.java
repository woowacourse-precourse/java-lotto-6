package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.support.RandomLotto;
import lotto.util.ControllerOutputManager;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private static final LottoService lottoService = new LottoService();
    private static final RandomLotto randomLotto = new RandomLotto();

    private static final ControllerOutputManager controllerOutputManager = new ControllerOutputManager();
    public void execute() {

        List<Lotto> lottos = new ArrayList<>();

        int lottoTimes = BuyLotto();
        for (int i = 0; i < lottoTimes; i++) {
            Lotto lotto = new Lotto(randomLotto.getRandomLotto());
            lotto.print();
            lottos.add(lotto);
        }
        WinningLotto winningLotto = setWinningNumbers();
        setBonusNumber(winningLotto);


        lottoService.execute(lottos,winningLotto);
    }

    private void setBonusNumber(WinningLotto winningLotto) {
        controllerOutputManager.BONUS_PRINT();
        String bonusNumber = Console.readLine();
        try {
            winningLotto.setBonus(bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 잘못된 입력입니다.");
            setBonusNumber(winningLotto);

        }

    }

    private WinningLotto setWinningNumbers() {
        WinningLotto winningLotto = null;
        try {
            controllerOutputManager.WINNING_PRINT();
            String winningNumbers = Console.readLine();
            winningLotto = new WinningLotto(winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 잘못된 입력입니다.");
            setWinningNumbers();
        }
        return winningLotto;
    }

    private int BuyLotto() {
        controllerOutputManager.START_PRINT();
        Customer customer = null;
        try {
            //입력을 여기서 받도록 바꾸기
            customer = new Customer();
            controllerOutputManager.BUY_PRINT(customer.getCount());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 잘못된 입력입니다.");
            BuyLotto();
        }
        return customer.getCount();
    }


}
