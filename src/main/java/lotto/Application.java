package lotto;

import lotto.controller.LottoMachineController;
import lotto.domain.LottoMachine;
import lotto.domain.Member;

public class Application {
    public static void main(String[] args) {
        try {
            Member member = new Member();
            LottoMachine lottoMachine = new LottoMachine();
            LottoMachineController lottoMachineController = new LottoMachineController(lottoMachine, member);
            lottoMachineController.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
