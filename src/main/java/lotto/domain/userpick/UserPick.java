package lotto.domain.userpick;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserPick {

    Validator validator = new Validator();

    public List<Integer> userLottoNumbers() {
        List<Integer> parsedLottoNumbers = pickLottoNumbers();
        System.out.println();

        return parsedLottoNumbers;
    }

    public Integer userBonusNumber(List<Integer> userLottoNumbers) {
        Integer parsedBonusNumber = pickBonusNumber(userLottoNumbers);
        System.out.println();

        return parsedBonusNumber;
    }

    public List<Integer> pickLottoNumbers() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String lottoNumbers = Console.readLine();
            String[] separatedLottoNumbers = lottoNumbers.split(",");
            try {
                validator.validateSeparatedLottoNumbers(separatedLottoNumbers);
                List<Integer> parsedLottoNumbers = parseLottoNumbers(separatedLottoNumbers);
                System.out.println();
                return parsedLottoNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 쉼표(,)를 기준으로 1 이상 45 이하의 서로 다른 6개의 당첨 번호를 입력해주세요");
            }
        }
    }

    public Integer pickBonusNumber(List<Integer> parsedLottoNumbers) {
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            String bonusNumber = Console.readLine();
            try {
                validator.validateBonusNumber(bonusNumber, parsedLottoNumbers);
                Integer parsedBonusNumber = parseBonusNumber(bonusNumber);
                return parsedBonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 당첨 번호와 겹치지 않는 1 이상 45 이하의 수를 입력해주세요.");
            }
        }
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
