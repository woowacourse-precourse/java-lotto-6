package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Payment;
import lotto.domain.Player;
import lotto.domain.WinningBonusLotto;
import lotto.view.ErrorMessage;
import lotto.view.LottoView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoMakingController {
    private static final LottoView view = new LottoView();
    private final String DIVISION_UNIT = ",";

    public int createLottoPayment() {
        while (true) {
            try {
                String input = view.inputMoney();
                validateLottoCount(input);
                return changeStringtoInteger(input);
            } catch (IllegalArgumentException e) {
                view.outputError(e.getMessage());
            }
        }
    }

    public void validateLottoCount(String number) {
        validateIsNumber(number);
    }

    private void validateIsNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_NUMBER_MESSAGE.getValue());
        }
    }

    private int changeStringtoInteger(String string) {
        return Integer.parseInt(string);
    }

    public Player createPlayer() {
        while (true) {
            try {
                int payment = createLottoPayment();
                return new Player(payment);
            } catch (IllegalArgumentException e) {
                view.outputError(e.getMessage());
            }
        }
    }

    public ArrayList<Lotto> createLottos(int payment) {
        ArrayList<Lotto> lottos = new ArrayList<Lotto>();
        for (int i = 0; i < payment / Payment.MONEY_UNIT.getPrize(); i++)
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        view.outputLottos(lottos, lottos.size());
        return lottos;
    }

    //========================================================================================
    public Lotto createWinningNumbers() {
        while (true) {
            try {
                String input = view.inputWinningNumber();
                List<Integer> lotto = new ArrayList<Integer>();
                lotto.addAll(Arrays.asList(changeStringToIntegers(input)));
                Lotto winningNumber = new Lotto(new ArrayList<Integer>(lotto));
                return winningNumber;
            } catch (IllegalArgumentException e) {
                view.outputError(e.getMessage());
            }
        }
    }

    public Integer[] changeStringToIntegers(String input) {
        try {
            String[] n = input.split(DIVISION_UNIT);
            Integer[] numbers = new Integer[n.length];
            for (int i = 0; i < numbers.length; i++)
                numbers[i] = Integer.parseInt(n[i]);
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_NUMBER_MESSAGE.getValue());
        }
    }

    public int createBonusNumber() {
        try {
            String input = view.inputBonusNumber();
            validateIsNumber(input);
            return changeStringtoInteger(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public WinningBonusLotto createWinningAndBonusLotto(Lotto winning) {
        while (true) {
            try {
                return new WinningBonusLotto(winning, createBonusNumber());
            } catch (IllegalArgumentException e) {
                view.outputError(e.getMessage());
            }
        }
    }
}
