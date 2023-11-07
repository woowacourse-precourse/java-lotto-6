package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Player;
import lotto.view.ErrorMessage;
import lotto.view.LottoView;

import java.util.ArrayList;
import java.util.Arrays;

public class LottoMakingController {
    private static final LottoView view = new LottoView();
    private final int MONEY_UNIT = 1000;
    private final int LOTTO_COUNT = 6;
    private int money;
    private int lottoCount;

    public void createLottoCount() {
        while (true) {
            try {
                String input = view.inputMoney();
                validateIsNumber(input);
                money = Integer.parseInt(input);
                validateMoneyUnit(money);
                break;
            } catch (NumberFormatException e) {
                view.outputError(ErrorMessage.ERROR_NOT_NUMBER_MESSAGE.getValue());
            } catch (IllegalArgumentException e) {
                view.outputError(e.getMessage());
            }
        }
    }

    private void validateIsNumber(String number) throws NumberFormatException {
        Integer.parseInt(number);
    }

    private void validateMoneyUnit(int money) {
        if (money % MONEY_UNIT != 0)
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_THOUSAND_MESSAGE.getValue());
        lottoCount = money / MONEY_UNIT;
    }

    public ArrayList<Lotto> createLottos() {
        ArrayList<Lotto> lottos = new ArrayList<Lotto>();
        for (int i = 0; i < lottoCount; i++)
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        view.outputLottos(lottos, lottos.size());

        return lottos;
    }

    public Lotto createWinningNumbers() {
        while (true) {
            try {
                String input = view.inputWinningNumber();
                Lotto winningNumber = new Lotto(Arrays.asList(changeStringToInteger(input)));
                return winningNumber;
            } catch (NumberFormatException e) {
                view.outputError(ErrorMessage.ERROR_NOT_NUMBER_MESSAGE.getValue());
            } catch (IllegalArgumentException e) {
                view.outputError(e.getMessage());
            }
        }
    }

    public Integer[] changeStringToInteger(String input) throws NumberFormatException {
        String[] n = input.split(",");
        Integer[] numbers = new Integer[n.length];
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = Integer.parseInt(n[i]);
        return numbers;
    }

    public int createBonusNumber() {
        while (true) {
            try {
                String input = view.inputBonusNumber();
                validateIsNumber(input);
                int bonusNumber = Integer.parseInt(input);
                validateBoundaryNumber(bonusNumber, 1, 45);
                return bonusNumber;
            } catch (NumberFormatException e) {
                view.outputError(ErrorMessage.ERROR_NOT_NUMBER_MESSAGE.getValue());
            } catch (IllegalArgumentException e) {
                view.outputError(e.getMessage());
            }
        }
    }

    public void validateBoundaryNumber(int input, int start, int end) {
        if (input < start || input > end)
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_1_TO_45_MESSAGE.getValue());
    }

}
