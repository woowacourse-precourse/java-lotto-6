package lotto.service;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidationService {

    public int validationBuyMoney() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String buyMoney = Console.readLine();

                int value = parseToIntOrError(buyMoney);

                return validateLottoPurchaseAmount(value);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int validateLottoPurchaseAmount(int value) {
        if (value % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또는 1000원 단위로만 구매 가능합니다.");
        }
        return value / 1000;
    }

    public List<Integer> validationSuccessLotto() {
        while (true) {
            try {
                System.out.println();
                System.out.println("당첨 번호를 입력해 주세요.");
                String[] successLottoNumbers = Console.readLine().split(",");

                List<Integer> successLotto = validationLotto(successLottoNumbers);
                validate(successLotto);

                return validationLotto(successLotto);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> validationLotto(List<Integer> numbers) {
        Set<Integer> buf = new HashSet<>();

        for (Integer i : numbers) {
            buf.add(i);
        }

        if (buf.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 중복됩니다.");
        }

        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6자리 입니다.");
        }
    }

    private List<Integer> validationLotto(String[] successLottoNumbers) {
        List<Integer> lotto = new ArrayList<>();

        for (String str : successLottoNumbers) {
            int lottoNumber = parseToIntOrError(str);

            validateLottoNumber(lottoNumber);


            lotto.add(lottoNumber);
        }

        return lotto;
    }

    public int validationBonusLotto(List<Integer> successLottoNumbers) {
        while (true) {
            try {
                System.out.println();
                System.out.println("보너스 번호를 입력해 주세요.");
                String bonusLottoNumber = Console.readLine();

                int value = parseToIntOrError(bonusLottoNumber);

                validateLottoNumber(value);
                validateUniqueLottoNumber(successLottoNumbers, value);

                return value;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateUniqueLottoNumber(List<Integer> successLottoNumbers, int value) {
        if (successLottoNumbers.contains(value)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호가 중복되었습니다.");
        }
    }


    private int parseToIntOrError(String str) {
        try {
            int value = Integer.parseInt(str);
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수의 값이 아닙니다.");
        }
    }

    private void validateLottoNumber(int value) {
        if (value < 1 || value > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

}
