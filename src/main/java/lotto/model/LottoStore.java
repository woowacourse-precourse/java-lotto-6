package lotto.model;

import lotto.constant.ErrorConstants;
import lotto.constant.GameConstants;
import lotto.util.LottoNumbersGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    private final List<Lotto> lottos;
    private final int money;

    public LottoStore(String moneyInput) {
        validatePaymentNumberFormat(moneyInput);
        this.money = Integer.parseInt(moneyInput);
        validatePaymentDivisibility(money);
        this.lottos = new ArrayList<>();
    }

    public int automationMachineStart() {
        int lottoCount = money / GameConstants.LOTTO_PRICE;

        for (int count = 0; count < lottoCount; count++) {
            lottos.add(new Lotto(LottoNumbersGenerator.generateNumbers()));
        }

        return lottoCount;
    }

    private void validatePaymentDivisibility(int payment) {
        if (payment % GameConstants.LOTTO_PRICE != 0 || payment == 0) {
            throw new IllegalArgumentException(ErrorConstants.THOUSAND_UNIT);
        }
    }

    private void validatePaymentNumberFormat(String payment) {
        try{
            Integer.parseInt(payment);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorConstants.OVER_INTEGER);
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getMoney() {
        return money;
    }

    public void printLottos() {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

}
