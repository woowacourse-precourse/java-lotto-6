package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    Lotto winningLotto;
    int bonusNumber;

    public Lotto getWinningLottoNumbers() {
        String[] dividedText;
        while (true) {
            List<Integer> winningLottoNumbers = new ArrayList<>();
            try {
                InputGuideMessage.enterWinningNumberMessage();
                String numbers = Console.readLine();
                dividedText = divideWinningNum(numbers);
                validateText(dividedText);
                winningLotto = new Lotto(setWinningLottoNumbers(dividedText));

                break;
            } catch (IllegalArgumentException e) {
                System.out.println();
                System.out.println("[ERROR] 1과 45사이의 숫자를 쉼표(,)로 구분 하여 6개를 입력해 주세요.");
            }
        }
        return winningLotto;
    }

    public String[] divideWinningNum(String numbers) {
        return numbers.split(",", -1);
    }

    public void validateText(String[] divided) {
        for(String num : divided) {
            try {
                int number = Integer.parseInt(num);
            }catch (NumberFormatException e) {
                OutputError.error_not_number();
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Integer> setWinningLottoNumbers(String[] divided) {
        List<Integer> numbers = new ArrayList<>();
        for(String num : divided) {
            numbers.add(Integer.parseInt(num));
        }
        return numbers;
    }

    public int setBonusNumber() {
        while (true) {
            try {
                InputGuideMessage.enterBonusNumberMessage();
                String bonusText = Console.readLine();
                validateBonus(bonusText);
                this.bonusNumber = Integer.parseInt(bonusText);;
                break;
            } catch (IllegalArgumentException e) {

            }
        }

        return bonusNumber;
    }
    public int getBonusNumber() {
        return bonusNumber;
    }


    public void validateBonus(String bonus) {
        int Number = validateBonusIsNumber(bonus);
        validateBonusIs1to45(Number);
        validateBonusNotLottoNumber(Number);
    }
    public int validateBonusIsNumber(String bonus) {
        int number;
        try {
            number = Integer.parseInt(bonus);
        }catch (NumberFormatException e) {
            System.out.println();
            System.out.println("[ERROR] 숫자를 입력해 주세요.");
            throw new IllegalArgumentException();
        }
        return number;
    }

    public void validateBonusIs1to45(int bonus) {
        if(bonus < 1 || bonus > 45) {
            System.out.println();
            System.out.println("[ERROR] 1과 45 사이의 숫자를 입력해 주세요.");
            throw new IllegalArgumentException();
        }
    }

    public void validateBonusNotLottoNumber(int bonus) {
        if(winningLotto.getLotto().contains(bonus)) {
            System.out.println();
            System.out.println("[ERROR] 로또 번호와 중복 되지 않는 숫자를 입력해 주세요");
            throw new IllegalArgumentException();
        }
    }

}
