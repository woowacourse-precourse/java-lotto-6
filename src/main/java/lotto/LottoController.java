package lotto;

import lotto.ioManager.LottoIoManager;

public class LottoController {

    private final LottoIoManager ioManager;

    public LottoController(LottoIoManager ioManager) {
        this.ioManager = ioManager;
    }

    public void run() {
    }

    private WinningLottoWithBonus inputWinningLottoWithBonus() {
        Lotto lotto = inputLotto();
        int bonus = inputBonus();

        try {
            return new WinningLottoWithBonus(lotto, bonus);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
        return inputWinningLottoWithBonus();
    }

    private Lotto inputLotto() {
        try {
            return new Lotto(ioManager.inputLotto());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
        return inputLotto();
    }

    private int inputBonus() {
        try {
            return ioManager.inputBonus();
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
        return inputBonus();
    }

    private Money inputMoney() {
        try {
            return new Money(ioManager.inputMoney());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return inputMoney();
    }
}
