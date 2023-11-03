package user;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    public User() {
    }

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                int money = Integer.parseInt(Console.readLine());
                validateInputMoney(money);
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int validateInputMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또는 1장당 1000원입니다. 1000원 단위로 구매를 진행해주세요.");
        }
        return money;
    }

    public List<String> inputSixLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        while (true) {
            try {
                List<String> sixLottoNumbers = new ArrayList<>(List.of(Console.readLine().split(",")));
                validateSixLottoNumbers(sixLottoNumbers);
                return sixLottoNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<String> validateSixLottoNumbers(List<String> sixLottoNumbers) {
        for (String lottoNumber : sixLottoNumbers) {
            if (1 > Integer.parseInt(lottoNumber) || Integer.parseInt(lottoNumber) > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
        return sixLottoNumbers;
    }
}


