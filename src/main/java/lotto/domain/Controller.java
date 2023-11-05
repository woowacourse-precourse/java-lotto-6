package lotto.domain;

import static java.util.Collections.list;
import static java.util.Collections.sort;

import camp.nextstep.edu.missionutils.Randoms;
import com.sun.security.jgss.GSSUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoTicket;
import lotto.model.Purchase;
import lotto.model.WinningNumbers;
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

        view.inputWinningNumbers();

        //
        String input = view.input();
        String[] inputArray = input.split(",");

        List<Integer> inputWinningNumbers = new ArrayList<>();
        for (String numStr : inputArray) {
            int num = Integer.parseInt(numStr);
            inputWinningNumbers.add(num);
        }

        WinningNumbers winningNumbers = new WinningNumbers(inputWinningNumbers);
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
            sort(numbers);
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
