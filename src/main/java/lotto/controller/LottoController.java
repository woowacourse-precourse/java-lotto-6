package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.support.RandomLotto;
import lotto.util.ControllerOutputManager;
import lotto.util.Converter;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.LottoConst.WRONG_NUMBER;

public class LottoController {

    private static final LottoService lottoService = new LottoService();
    private static final RandomLotto randomLotto = new RandomLotto();

    private static final ControllerOutputManager controllerOutputManager = new ControllerOutputManager();
    public void execute() {

        int lottoTimes = BuyLotto();
        List<Lotto> lottos = RandomLottos(lottoTimes);
        WinningLotto winningLotto = setWinningNumbers();

        lottoService.execute(lottos,winningLotto);
    }

    private static List<Lotto> RandomLottos(int lottoTimes) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoTimes; i++) {
            Lotto lotto = new Lotto(randomLotto.getRandomLotto());
            lotto.print();
            lottos.add(lotto);
        }
        return lottos;
    }


    private WinningLotto setWinningNumbers() {
        WinningLotto winningLotto = null;
        try {
            List<Integer> winning = getWinningNumbers();
            String bonusNumber = getBonus();
            winningLotto = new WinningLotto(winning, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(WRONG_NUMBER);
            setWinningNumbers();
        }
        return winningLotto;
    }

    private static String getBonus() {
        controllerOutputManager.BONUS_PRINT();
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }

    private static List<Integer> getWinningNumbers() {
        controllerOutputManager.WINNING_PRINT();
        String winningNumbers = Console.readLine();
        List<Integer> integers = Converter.to(winningNumbers);
        return integers;
    }

    private int BuyLotto() {
        controllerOutputManager.START_PRINT();
        Customer customer = null;
        try {
            //입력을 여기서 받도록 바꾸기
            customer = new Customer();
            controllerOutputManager.BUY_PRINT(customer.getCount());
        } catch (IllegalArgumentException e) {
            System.out.println(WRONG_NUMBER);
            BuyLotto();
        }
        return customer.getCount();
    }


}
