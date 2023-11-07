package UI;

import Domain.WinningLotto;
import lotto.ExceptionMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputWinningLotto {
    private int input = 0;
    WinningLotto winningLotto;

    public WinningLotto inputLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        while (input != 1) {
            String[] lottoNumber = readLine().split(",");
            List<Integer> numbers = new ArrayList<Integer>();
            translateStringToInteger(lottoNumber, numbers);
            Collections.sort(numbers);
            checkInputLotto(numbers);
        }

        System.out.println("보너스 번호를 입력해 주세요.");
        winningLotto.setBonus(Integer.parseInt(readLine()));
        return winningLotto;
    }

    void translateStringToInteger(String[] lottoNumber, List<Integer> numbers) {
        for (int i = 0; i < lottoNumber.length; i++) {
            numbers.add(Integer.parseInt(lottoNumber[i]));
        }
    }

    public void checkInputLotto(List<Integer> numbers) {
        try {
            legalRange(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(ExceptionMessage.ILLEGAL_RANGE.label());
            return;
        }

        try {
            winningLotto = new WinningLotto(numbers);
            input = 1;
        } catch (IllegalArgumentException e) {
            System.out.println(ExceptionMessage.DUPLICATE_OR_NOT6.label());
        }
    }

    public void legalRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++){
            if (numbers.get(i) > 45 || numbers.get(i) < 1){
                throw new IllegalArgumentException();
            }
        }
    }
}
