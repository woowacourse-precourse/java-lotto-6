package lotto.domain.userpick;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserPick {

    Validator validator = new Validator();

    public List<Object> pickNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> parsedLottoNumbers = pickLottoNumbers();
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        Integer parsedBonusNumber = pickBonusNumber(parsedLottoNumbers);
        System.out.println();

        List<Object> pickedNumbers = new ArrayList<>();
        pickedNumbers.add(parsedLottoNumbers);
        pickedNumbers.add(parsedBonusNumber);

        return pickedNumbers;
    }

    public List<Integer> pickLottoNumbers() {
        while (true) {
            String lottoNumbers = Console.readLine();
            String[] separatedLottoNumbers = lottoNumbers.split(",");
            try {
                validator.validateSeparatedLottoNumbers(separatedLottoNumbers);
                List<Integer> parsedLottoNumbers = parseLottoNumbers(separatedLottoNumbers);
                System.out.println();
                return parsedLottoNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 쉼표(,)를 기준으로 6개의 당첨 번호를 입력해주세요");
            }
        }
    }

    public Integer pickBonusNumber(List<Integer> parsedLottoNumbers) {
        Integer parsedBonusNumber;
        while (true) {
            String bonusNumber = Console.readLine();
            try {
                validator.validateBonusNumber(bonusNumber, parsedLottoNumbers);
                parsedBonusNumber = parseBonusNumber(bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 보너스 번호는 당첨 번호와 겹칠 수 없습니다.");
            }
        }

        return parsedBonusNumber;
    }

    public List<Integer> parseLottoNumbers(String[] separatedLottoNumbers) {

        List<Integer> parsedLottoNumbers = new ArrayList<>();

        try {
            for (String separatedLottoNumber : separatedLottoNumbers) {
                parsedLottoNumbers.add(Integer.parseInt(separatedLottoNumber));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("1 이상 45 이하의 수 6개를 입력해주세요.");
        }

        return parsedLottoNumbers;
    }


    public Integer parseBonusNumber(String bonusNumber) {

        Integer parsedBonusNumber;

        try {
            parsedBonusNumber = Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("1 이상 45 이하의 당첨 번호를 제외한 수 하나를 입력해주세요.");
        }

        return parsedBonusNumber;
    }
}
