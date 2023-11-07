package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.model.LottoFromUser;
import lotto.model.LottoPurchasingAmount;
import lotto.utils.ErrorMessage;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.parseInt;

public class InputController {
    public LottoPurchasingAmount getLottoPurchasingAmountFromUser() {
        OutputView.askLottoPurchasingAmount();
        try {
            return new LottoPurchasingAmount(Console.readLine());
        } catch (IllegalArgumentException e) {
            return getLottoPurchasingAmountFromUser();
        }
    }

    public void getWinnerNumbersFromUser() {
        Lotto lotto = getLottoNumberFromUser();
        System.out.println(lotto.getLottoNumbers());
    }

    public Lotto getLottoNumberFromUser() {
        OutputView.askLottoNumbers();
        List<Integer> lottoNumbers = new ArrayList<>();
        List<String> splitNumbers = validateLength(Console.readLine());

        for (String number : splitNumbers) {
            System.out.println(number);
            lottoNumbers.add(parseInt(number));
        }

        return new Lotto(lottoNumbers);
    }

    public List<String> validateLength(String lottoNumbersFromUser) {
        List<String> splitNumbersFromUser = Arrays.asList(lottoNumbersFromUser.split(","));

        if (splitNumbersFromUser.size() != 6) {
            ErrorMessage.lottoNumberLengthException();
            throw new IllegalArgumentException();
        }

        return splitNumbersFromUser;
    }
}
