package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.Exception.LottoNumbersException;

public class LottoResultChecker {

    private List<Integer> winNumbers;
    private Integer bonusNumber;

    public void enterWinAndBonusNumbersView() {
        setWinNumbers();
        setBonusNumber();
    }

    private void setWinNumbers() {
        try {
            System.out.println("당첨 번호를 입력해 주세요.");
            winNumbers = numbersSeparator(Console.readLine());
            LottoNumbersException.validateLottoNumbers(winNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setWinNumbers();
        }
    }

    private void setBonusNumber() {
        try {
            System.out.println("보너스 번호를 입력해 주세요.");
            bonusNumber = Integer.parseInt(Console.readLine());
            LottoNumbersException.validateBonusNumber(winNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setBonusNumber();
        }
    }

    private List<Integer> numbersSeparator(String numberString) {
        List<String> separatedNumbersInString = List.of(numberString.split(","));

        List<Integer> separatedNumbers = new ArrayList<Integer>();
        for (String number : separatedNumbersInString) {
            separatedNumbers.add(Integer.parseInt(number));
        }

        return separatedNumbers;
    }

}
