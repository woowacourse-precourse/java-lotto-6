package lotto;

import camp.nextstep.edu.missionutils.Console;
import utils.Parse;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    Lotto sixLottoNumbers;
    int bonusNumber;

    public Computer() {
        Output.printLottoNumbersMessage();
        sixLottoNumbers = inputSixLottoNumber();
        Output.printLottoNumbers(sixLottoNumbers.getSixLottoNumbers());

        Output.printBonusNumberMessage();
        bonusNumber = inputBonusNumber();
        Output.printBonusNumber(bonusNumber);
    }

    public Lotto inputSixLottoNumber() {
        while (true) {
            try {
                List<String> sixLottoNumber = new ArrayList<>(List.of(Console.readLine().split(",")));

                validateInputSize(sixLottoNumber);
                validateLottoNumberInputFormat(sixLottoNumber);

                return new Lotto(Parse.parseInteger(sixLottoNumber));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private void validateInputSize(List<String> sixLottoNumbers) {
        if (sixLottoNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호 6개를 입력해주세요.");
        }
    }

    private void validateLottoNumberInputFormat(List<String> numbers) {
        for (String lottoNumber : numbers) {
            if (!lottoNumber.matches("^\\d+$")) {
                throw new IllegalArgumentException("[ERROR] 쉼표(,)를 기준으로 공백없이 입력해야합니다. (ex) 1,8,24,45,35,6");
            }
            if (!lottoNumber.matches("^[1-9][0-9]?$")) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 0으로 시작할 수 없습니다. (ex) 1,8,24,47,35,6");
            }
        }
    }

    public int inputBonusNumber() {
        while (true) {
            try {
                String input = Console.readLine();
                validateBonusNumberInputFormat(input);

                int bonusNumber = Integer.parseInt(input);
                validateDuplicateBonusNumber(bonusNumber);

                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateBonusNumberInputFormat(String bonusNumber) {
        if (!bonusNumber.matches("^\\d+$")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자 1개만 입력해주세요. (ex)7");
        }
        if (!bonusNumber.matches("^[1-9][0-9]?$")) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 0으로 시작할 수 없습니다.  (ex)7");
        }
        if (Integer.parseInt(bonusNumber) < 1 || 45 < Integer.parseInt(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateDuplicateBonusNumber(int bonusNumber) {
        if (sixLottoNumbers.getSixLottoNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 입력한 6개의 로또 당첨 번호와 중복됩니다. 다시 입력해주세요.");
        }
    }
}
