package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.InputView;

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
        setPublishingNumber(InputView.readInputNumber());
        setMagicNumber(InputView.readInputTargetNumbers());
        setBonusNumber(InputView.readInputNumber());
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
