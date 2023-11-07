package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.io.InputHandler;

public class LottoService {
    private final List<Lotto> lotteries = new ArrayList<>();
    private int publishingNumber;

    public List<Integer> magicNumber;
    public int bonusNumber;
    public LottoService() {
        initService();
        runService();
    }

    private void initService() {
        setPublishingNumber(InputHandler.readInputNumber());
        setMagicNumber(InputHandler.readInputTargetNumbers());
        setBonusNumber(InputHandler.readInputNumber());
    }
    private void runService() {
        for(int i = 0; i < publishingNumber; i++){
            this.lotteries.add(publishLotto());
        }
    }
    private Lotto publishLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
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


    public void setPublishingNumber(int amounts) {
        if (amounts % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        this.publishingNumber = amounts / 1000;
    }
    public void setMagicNumber(List<Integer> magicNumber) {
        this.magicNumber = magicNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
