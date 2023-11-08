package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.view.ErrorMessage;
import lotto.view.LottoView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoMakingController {
    private static final LottoView view = new LottoView();
    private final int MONEY_UNIT = 1000;
    private final String DIVISION_UNIT = ",";
    private int payment;
    private int lottoCount;

    private ArrayList<Lotto> lottos;
    private Lotto winningNumbers;
    private int bonusNumber;

    public ArrayList<Lotto> getLottos() {
        return lottos;
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public int getPayment() {
        return payment;
    }

    public void createLottoCount() {
        while (true) {
            try {
                String input = view.inputMoney();
                validateLottoCount(input);
                payment = changeStringtoInteger(input);
                break;
            } catch (IllegalArgumentException e) {
                view.outputError(e.getMessage());
            }
        }
    }

    public void validateLottoCount(String number) {
        validateIsNumber(number);
        validatePaymentUnit(Integer.parseInt(number));
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

    private void validatePaymentUnit(int money) {
        if (money % MONEY_UNIT != 0)
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_THOUSAND_MESSAGE.getValue());
        lottoCount = money / MONEY_UNIT;
    }

    public void createLottos() {
        ArrayList<Lotto> lottos = new ArrayList<Lotto>();
        for (int i = 0; i < lottoCount; i++)
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        view.outputLottos(lottos, lottos.size());
        this.lottos = lottos;
    }

    public void createWinningNumbers() {
        while (true) {
            try {
                String input = view.inputWinningNumber();
                List<Integer> lotto = new ArrayList<Integer>();
                lotto.addAll(Arrays.asList(changeStringToIntegers(input)));
                Lotto winningNumber = new Lotto(new ArrayList<Integer>(lotto));
                this.winningNumbers = winningNumber;
                break;
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

    public void createBonusNumber() {
        while (true) {
            try {
                String input = view.inputBonusNumber();
                validateIsNumber(input);
                int bonusNumber = Integer.parseInt(input);
                validateBoundaryNumber(bonusNumber);
                validateOverlapBonusNumber(winningNumbers, bonusNumber);
                this.bonusNumber = bonusNumber;
                break;
            } catch (IllegalArgumentException e) {
                view.outputError(e.getMessage());
            }
        }
    }

    private void validateBoundaryNumber(int input) {
        if (input < Lotto.LOTTO_START || input > Lotto.LOTTO_END)
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_1_TO_45_MESSAGE.getValue());
    }

    private void validateOverlapBonusNumber(Lotto winningNumbers, int bonusNumber) {
        if (winningNumbers.getNumbers().contains(bonusNumber))
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_OVERLAP_MESSAGE.getValue());
    }

}
