package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.controller.InputController.money;
import static lotto.controller.InputController.validator;

public class IssueLotto {
    public static int amountOfLottoTickets;
    public static List<Lotto> lottoTickets;
    public static void getAmountOfLottoTickets() {
        amountOfLottoTickets = money / 1000;
    }

    public static void makeLottoTickets() {
        lottoTickets = new ArrayList<>();

        for (int i = 0; i < amountOfLottoTickets; i++) {
            List<Integer> numbers = makeARandomNumbersList();
            Collections.sort(numbers);
            Lotto ticketNumbers = new Lotto(numbers);
            lottoTickets.add(ticketNumbers);
        }
    }
    public static List<Integer> makeARandomNumbersList() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        return numbers;
    }
}
