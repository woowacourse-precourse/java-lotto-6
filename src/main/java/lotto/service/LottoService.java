package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.InputView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoService {
    
    InputView inputView = new InputView();

    public int getLotteryTicketCount() {
        return inputView.inputPurchasePrice() / 1000;
    }

    public List<Integer> issueLotteryTicket() {
        List<Integer> lotteryTicketNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lotteryTicketNumbers);
        return lotteryTicketNumbers;
    }

    public void getMatchingNumbers() {

    }

    public void getRateOfReturn() {

    }
}
