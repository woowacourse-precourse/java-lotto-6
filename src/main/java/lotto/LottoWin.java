package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoWin {
    private final List<Integer> winnumbers;
    private int bonusNumber;

    public LottoWin() {
        this.winnumbers = new ArrayList<>();
    }

    public List getWinNumbers(){
        return winnumbers;
    }

    public int getBonusNumber(){
        return bonusNumber;
    }

    public void setLottoWinNumbers() {
        String input = Console.readLine();
        String[] numbersString = input.split(",");
        if (numbersString.length != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해야 합니다.");
        }

        List<Integer> tempNumbers = new ArrayList<>();
        for (String number : numbersString) {
            int num = Integer.parseInt(number.trim());
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자를 입력해야 합니다.");
            }
            if (tempNumbers.contains(num)) {
                throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
            }
            tempNumbers.add(num);
        }

        this.winnumbers.clear();
        this.winnumbers.addAll(tempNumbers);
    }

    public void setWinBonusnumber() {
        int input = Integer.parseInt(Console.readLine().trim());

        if (input < 1 || input > 45) {
            throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자를 입력해야 합니다.");
        }

        if (winnumbers.contains(input)) {
            throw new IllegalArgumentException("[ERROR] 이미 선택한 번호입니다.");
        }

        this.bonusNumber = input;
    }
}
