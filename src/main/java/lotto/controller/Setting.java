package lotto.controller;

import lotto.constant.Announcer;
import lotto.constant.Error;
import lotto.constant.LottoAnnouncer;
import lotto.domain.Jackpot;
import lotto.domain.Lotto;
import lotto.exception.PurchaseException;
import lotto.view.Input;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.List;

public class Setting {

    private Input input = Input.getInput();
    private Output output = Output.getOutput();
    private ProviderRandomValue providerRandomValue;

    public Setting() {
        providerRandomValue = new ProviderRandomValue();
    }

    public int purchaseLotto() {
        output.printMessage(Announcer.PURCHASE_PAYMENT.getMessage());
        String payment = input.inputFromUser();

        manageException(payment);

        int purchaseNumber = Integer.parseInt(payment) / 1000;

        output.printMessage(Announcer.PURCHASE_COUNT.getFormat(purchaseNumber));

        return purchaseNumber;
    }

    private void manageException(String payment) {
        try {
            isMinimumPayment(payment);
            isUnitOfThousane(payment);
        } catch (IllegalArgumentException e){
            purchaseLotto();
        }
    }

    private void isMinimumPayment(String payment) {
        if (Integer.parseInt(payment) < 1000) {
            new PurchaseException(Error.MINIMUM_PAYMENT);
        }
    }

    private void isUnitOfThousane(String payment) {
        int value = Integer.parseInt(payment) % 1000;

        if (value != 0) {
            new PurchaseException(Error.ONLY_VALUE_THOUSAND);
        }
    }

    public List<Lotto> pickLottos(int repetitions) {
        List<Integer> numbers;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < repetitions; i++) {
            numbers = providerRandomValue.provideLotto();
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);

            output.printMessage(LottoAnnouncer.LOTTO_LIST.getListFormat(numbers));
        }

        return lottos;
    }

    public Jackpot pickJackpot() {
        output.printMessage(Announcer.LOTTO_NUMBER.getMessage());
        List<Integer> jackpot = input.splitSeperator();
        Lotto lotto = new Lotto(jackpot);

        return new Jackpot(jackpot, pickbonus());
    }

    private int pickbonus() {
        output.printMessage(Announcer.LOTTO_BONUS_NUMBER.getMessage());
        return Integer.parseInt(input.inputFromUser());
    }
}
