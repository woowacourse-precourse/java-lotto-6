package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoWin {
    private Lotto winNumbers;
    private int bonusNumber;

    public LottoWin() {
        this.winNumbers = new Lotto();
    }

    public Lotto getWinNumbers() {
        return winNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setLottoWinNumbers() {
        while (true) {
            try {
                winNumbers = Lotto.createLottoFromUserInput();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }  

    public void setWinBonusNumber() {
        while (true) {
            try {
                String inputString = Console.readLine().trim();
                if (!inputString.matches("\\d+")) {
                    throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
                }
                int input = Integer.parseInt(inputString);
                Lotto.validateNumberRange(input);
                validateUniqueBonusNumber(input);
                this.bonusNumber = input;
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    private void validateUniqueBonusNumber(int input) {
        for (Integer number : winNumbers.getNumbers()) {
            if (number == input) {
                throw new IllegalArgumentException("[ERROR] 이미 선택한 번호입니다.");
            }
        }
    }
}
