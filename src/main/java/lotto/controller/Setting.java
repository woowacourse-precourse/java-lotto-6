package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import lotto.Util.LottoValue;
import lotto.Util.Message;
import lotto.Util.Size;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.view.Input;
import lotto.view.Output;

public class Setting {
    public static User getPayment() {
        Output.printRequestPaymentMessage();

        do {
            try {
                return new User(Input.inputPayment());
            } catch (IllegalArgumentException e) {
                System.out.println(Message
                        .PAYMENT_ERROR_MESSAGE
                        .getMessage());
            }
        } while (true);
    }

    public static Lotto getLotto() {
        Output.printRequestWinningNumbersMessage();

        do {
            try {
                return new Lotto(Input.inputLotto());
            } catch (IllegalArgumentException e) {
                System.out.println(Message
                        .LOTTO_ERROR_MESSAGE
                        .getMessage());
            }
        } while (true);
    }

    public static List<List<Integer>> generateLottoNumbers(int purchaseNumber) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < purchaseNumber; i++) {
            List<Integer> numbers = new ArrayList<>(
                    Randoms.pickUniqueNumbersInRange(Size.MINIMUM_LOTTO_NUMBER.getSize(),
                            Size.MAXIMUM_LOTTO_NUMBER.getSize(),
                            Size.LOTTO_SIZE.getSize()));
            Collections.sort(numbers);
            lottoNumbers.add(numbers);
        }
        return lottoNumbers;
    }

    public static List<Integer> initRankCount() {
        List<Integer> rankCount = new ArrayList<>();

        for (int i = 0; i < Size.RANK_SIZE.getSize(); i++) {
            rankCount.add(0);
        }
        return rankCount;
    }

    public static BonusNumber getBonusNumber(Lotto lotto) {
        Output.printRequestBonusNumberMessage();

        do {
            try {
                return new BonusNumber(Input.inputBonusNumber(), lotto.numbers());
            } catch (IllegalArgumentException e) {
                System.out.println(Message
                        .BONUS_NUMBER_ERROR_MESSAGE
                        .getMessage());
            }
        } while (true);
    }
}
