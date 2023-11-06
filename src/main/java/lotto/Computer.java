package lotto;

import camp.nextstep.edu.missionutils.Console;
import utils.Parse;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    List<Integer> sixLottoNumbers;
    int bonusNumber;
    public Computer(){
        Output.printLottoNumbersMessage();
        List<Integer> sixLottoNumbers = inputSixLottoNumbers();
        Output.printLottoNumbers(sixLottoNumbers);

        Output.printBonusNumberMessage();
        int bonusNumber = inputBonusNumber();
        Output.printBonusNumber(bonusNumber);
    }
    public List<Integer> inputSixLottoNumbers() {
        while (true) {
            try {
                List<String> sixLottoNumbers = new ArrayList<>(List.of(Console.readLine().split(",")));
                validateInputSizeSix(sixLottoNumbers);
                validateCommaSeparatedInput(sixLottoNumbers);
                validateSixLottoNumbers(sixLottoNumbers);
                validateNoDuplicateNumbers(sixLottoNumbers);
                return Parse.parseInteger(sixLottoNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private void validateInputSizeSix(List<String> sixLottoNumbers ) {
        if (sixLottoNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호 6개를 입력해주세요.");
        }
    }

    private void validateCommaSeparatedInput(List<String> sixLottoNumbers ) {
        for (String lottoNumber : sixLottoNumbers) {
            if (!lottoNumber.matches("^\\d+$")) {
                throw new IllegalArgumentException("[ERROR] 쉼표(,)를 기준으로 공백없이 입력해야합니다. (ex) 1,8,24,47,35,6");
            }
        }
    }

    private void validateSixLottoNumbers(List<String> sixLottoNumbers ) {
        for (String lottoNumber : sixLottoNumbers) {
            if (1 > Integer.parseInt(lottoNumber) || Integer.parseInt(lottoNumber) > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            if (!lottoNumber.matches("^[1-9][0-9]?$")) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 0으로 시작할 수 없습니다. (ex) 1,8,24,47,35,6");
            }
        }
    }

    private void validateNoDuplicateNumbers(List<String> sixLottoNumbers ) {
        List<String> uniqueNumbers = new ArrayList<>();
        for (String lottoNumber : sixLottoNumbers) {
            if (uniqueNumbers.contains(lottoNumber)) {
                throw new IllegalArgumentException("[ERROR] 중복된 번호가 입력되었습니다.");
            }
            uniqueNumbers.add(lottoNumber);
        }
    }

    public int inputBonusNumber() {
        while (true) {
            try {
                String bonusNumber = Console.readLine();
                validateSingleNumberInput(bonusNumber);
                return Integer.parseInt(bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateSingleNumberInput(String bonusNumber) {
        if (!bonusNumber.matches("^\\d+$")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자 1개만 입력해주세요. (ex) 7");
        }
        if (!bonusNumber.matches("^[1-9][0-9]?$")) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 0으로 시작할 수 없습니다.  (ex) 7");
        }
        if (1 > Integer.parseInt(bonusNumber) || Integer.parseInt(bonusNumber) > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (sixLottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 입력한 6개의 로또 당첨 번호와 중복됩니다. 다시 입력해주세요.");
        }
    }
}
