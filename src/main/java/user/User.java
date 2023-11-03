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
                validateInputSizeSix(sixLottoNumbers);
                validateCommaSeparatedInput(sixLottoNumbers);
                validateSixLottoNumbers(sixLottoNumbers);
                validateNoDuplicateNumbers(sixLottoNumbers);
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

    private void validateNoDuplicateNumbers(List<String> sixLottoNumbers){
        List<String> uniqueNumbers = new ArrayList<>();
        for (String lottoNumber : sixLottoNumbers) {
            if (uniqueNumbers.contains(lottoNumber)) {
                throw new IllegalArgumentException("[ERROR] 중복된 번호가 입력되었습니다.");
            }
            uniqueNumbers.add(lottoNumber);
        }
    }

    private void validateCommaSeparatedInput(List<String> sixLottoNumbers){
        for (String lottoNumber : sixLottoNumbers) {
            if (!lottoNumber.matches("[0-9]+")){
                throw new IllegalArgumentException("[ERROR] 쉼표(,)를 기준으로 공백없이 입력해야합니다.");
            }
        }
    }

    private void validateInputSizeSix(List<String> sixLottoNumbers){
        if (sixLottoNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호 6개를 입력해주세요.");
        }
    }
}


