package lotto.domain.User;

import lotto.domain.Lotto.Lotto;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Result.Result;
import lotto.domain.WinningNumber.WinningNumber;
import lotto.validator.InputValidator;

public class User {
    private int lottoCount;
    private List<Lotto> lotties = new ArrayList<>();
    InputValidator inputValidator = new InputValidator();
    WinningNumber winningNumber = new WinningNumber();
    Result result = new Result();

    public User() {
        inputLottoAmount();
        createLotties();
        printLotties();
        //validate
        winningNumber.setWinningNumbers();
        winningNumber.setBonusNumber();
        result.printResult(lotties, winningNumber);
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

    private void printLotties() {
        System.out.println();
        System.out.println(lottoCount + "개를 구매했습니다.");
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> sortedNumbers = new ArrayList<>(lotties.get(i).getNumbers());
            Collections.sort(sortedNumbers);
            System.out.println(sortedNumbers);
        }
    }

    private List<Integer> createLottoNumber() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lottoNumber;
    }

}
