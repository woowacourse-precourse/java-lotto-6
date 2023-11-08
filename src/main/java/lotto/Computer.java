package lotto;

import camp.nextstep.edu.missionutils.Console;
import utils.Parser;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private Lotto winningLottoNumber;
    private int bonusNumber;

    public Computer() {
        Output.printLottoNumbersMessage();
        winningLottoNumber = inputWinningLottoNumber();
        Output.printLottoNumbers(winningLottoNumber.getLottoNumbers());

        Output.printBonusNumberMessage();
        bonusNumber = inputBonusNumber();
        Output.printBonusNumber(bonusNumber);
    }

    public List<Integer> getWinningLottoNumber() {
        return winningLottoNumber.getLottoNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private Lotto inputWinningLottoNumber() {
        while (true) {
            try {
                List<String> winningLottoNumber = new ArrayList<>(List.of(Console.readLine().split(",")));

                validateLottoNumberInputFormat(winningLottoNumber);

                return new Lotto(Parser.parseInteger(winningLottoNumber));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateLottoNumberInputFormat(List<String> numbers) {
        for (String lottoNumber : numbers) {
            if (!lottoNumber.matches("^\\d+$")) {
                throw new IllegalArgumentException("[ERROR] 쉼표(,) 기준으로 공백없이 숫자를 입력해야합니다.(ex)1,2,3,4,5,6");
            }
            if (!lottoNumber.matches("^[1-9][0-9]?$")) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 0으로 시작할 수 없습니다. (ex)1,2,3,4,5,6");
            }
        }
    }

    private int inputBonusNumber() {
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
        if (winningLottoNumber.getLottoNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 입력한 6개의 로또 당첨 번호와 중복됩니다. 다시 입력해주세요.");
        }
    }
}
