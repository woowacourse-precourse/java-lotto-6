package lotto.controller;


import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.enums.Message;
import lotto.util.User;

public class LottoMachine {
    List<Lotto> lottoNumbers = new ArrayList<>();
    User user = new User();

    public void buyLotto(){
        Message.AMOUNT_INPUT.getMessage();
        while (true) {
            try {
                user.inputPaymentAmount();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
