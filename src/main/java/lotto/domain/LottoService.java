package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.ErrorMessages;
import lotto.io.InputHandler;
import lotto.io.OutputHandler;

public class LottoService {
    private final List<Lotto> lotteries = new ArrayList<>();
    private int publishingNumber;
    private int amount;
    public List<Integer> magicNumber;
    public int bonusNumber;

    public LottoService() {
        initService();
        runService();
    }

    private void initService() {
        OutputHandler.printPurchasePhrase();
        setAmount();
        OutputHandler.printQuantityPurchased(publishingNumber);
    }

    private void runService() {
        addLotteries();
        OutputHandler.printLotteries(lotteries);
        OutputHandler.printMagicNumberPhrase();
        setMagicNumber();
        OutputHandler.printBonusNumberPhrase();
        setBonusNumber();
    }

    private void addLotteries() {
        for (int i = 0; i < publishingNumber; i++) {
            this.lotteries.add(publishLotto());
        }
    }

    private Lotto publishLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public int getAmount() {
        return amount;
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }

    public List<Integer> getMagicNumber() {
        return magicNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void setAmount() {
        try {
            this.amount = InputHandler.readInputNumber();
            setPublishingNumber(amount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setAmount();
        }
    }

    public void setPublishingNumber(int amounts) {
        if (amounts % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessages.ERR_AMOUNT_UNIT.getMessage());
        }
        this.publishingNumber = amounts / 1000;
    }

    public void setMagicNumber() {
        try {
            List<Integer> magicNumber = InputHandler.readInputMagicNumbers();
            this.magicNumber = magicNumber;
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            setMagicNumber();
        }
    }

    private void setBonusNumber() {
        try {
            int bonusNumber = InputHandler.readInputNumber();
            try {
                isContainMagic(bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                setBonusNumber();
            }
            this.bonusNumber = bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setBonusNumber();
        }

    }
    private boolean isContainMagic(int bonusNumber) {
        if (magicNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessages.ERR_BONUS_CONTAIN_IN_MAGIC.getMessage());
        }
        return true;
    }
}
