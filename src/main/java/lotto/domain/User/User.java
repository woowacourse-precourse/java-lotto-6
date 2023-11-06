package lotto.domain.User;

import lotto.domain.Lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.validator.InputValidator;

public class User {
    private int lottoCount;
    private List<Lotto> lotties = new ArrayList<>();
    InputValidator inputValidator = new InputValidator();

    public User() {
        inputLottoAmount();
        createLotties();
    }

    private void inputLottoAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String lottoAmountInput = Console.readLine();
        //validate
        lottoCount = Integer.parseInt(lottoAmountInput) / 1000;
    }

    public void createLotties() {
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumber = createLottoNumber();
            Lotto lotto = new Lotto(lottoNumber);
            lotties.add(lotto);
        }
    }

    private List<Integer> createLottoNumber() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lottoNumber;
    }
}
