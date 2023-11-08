package lotto.Input;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoWinningNumber {
    private final List<Integer> numbers;

    public LottoWinningNumber() {
        this.numbers = inputLotto();
    }

    public List<Integer> inputLotto() {
        List<Integer> lottoNumbers = new ArrayList<>();
        while (true) {
            try {
                String input = readLine();
                List<String> list = List.of(input.split(","));
                for (String num : list) {
                    lottoNumbers.add(Integer.parseInt(num));
                }
                new Lotto(lottoNumbers);
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해야 합니다.");
                lottoNumbers.clear();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                lottoNumbers.clear();
            }
        }
        return lottoNumbers;
    }

    public List<Integer> getAnswer() {
        return this.numbers;
    }
}
