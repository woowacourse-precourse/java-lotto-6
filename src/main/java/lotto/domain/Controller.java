package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoTicket;
import lotto.model.Purchase;
import lotto.validator.ValidatorPurchaseAmount;
import lotto.view.View;

public class Controller {
    public Controller() {
    }

    public void lotto_Logic() {
        View view = new View();
        view.inputPurchaseAmount();
        Purchase purchase = new Purchase(view.input());

        ValidatorPurchaseAmount validatorPurchaseAmount = new ValidatorPurchaseAmount();

        while (!validatorPurchaseAmount.processPurchaseAmountError(purchase)) {
            validatorPurchaseAmount.processErrorResult();

            purchase = new Purchase(view.input());
            validatorPurchaseAmount = new ValidatorPurchaseAmount();
        }

        LottoTicket lottoTicket = new LottoTicket(calculateLottoTicketCount(purchase));
        view.displayPurchaseQuantityMessage(lottoTicket);

        displayLottoNumbers(generateLottoNumbersList(generateLottoTickets(lottoTicket)));
    }

    public int calculateLottoTicketCount(Purchase purchase) {
        return Integer.parseInt(purchase.getPurchaseAmount()) / 1000;
    }

    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Lotto> generateLottoTickets(LottoTicket lottoTicket) {
        List<Lotto> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < lottoTicket.getLottoTicketCount(); i++) {
            List<Integer> numbers = generateLottoNumbers();
            Lotto lotto = new Lotto(numbers);
            lottoNumbers.add(lotto);
        }
        return lottoNumbers; //user class 에 저장해야하나 ?
    }

    public List<Object> generateLottoNumbersList(List<Lotto> lottoNumbers) {
        List<Object> numbers = new ArrayList<>();
        for (int i = 0; i < lottoNumbers.size(); i++) {
            Lotto lotto = lottoNumbers.get(i);
            numbers.add(lotto.getLottoNumbers());
        }
        return numbers;
    }

    public void displayLottoNumbers(List<Object> numbers) {
        for (Object number : numbers) {
            System.out.println(number);
        }
    }

}
