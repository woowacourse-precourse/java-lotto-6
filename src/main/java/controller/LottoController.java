package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.Customer;
import domain.WinningLotto;
import service.LottoService;
import util.ControllerOutputManager;

public class LottoController {

    private static final LottoService lottoService = new LottoService();

    private static final ControllerOutputManager controllerOutputManager = new ControllerOutputManager();
    public void execute() {

        int lottoTimes = BuyLotto();
        WinningLotto winningLotto = setWinningNumbers();
        setBonusNumber(winningLotto);


        lottoService.execute(winningLotto,lottoTimes);
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
