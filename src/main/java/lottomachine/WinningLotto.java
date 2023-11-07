package lottomachine;

import java.util.ArrayList;
import java.util.List;
import service.Inputter;

public class WinningLotto {

    public Lotto requestWinningLottoNumbers(Inputter inputter) {
        Lotto winningLottoNumbers = null;
        try {
            String input = inputter.inputWinningNumbers();
            List<Integer> lottoNumbers = transformStringtoLottoNumberList(input);
            winningLottoNumbers = new Lotto(lottoNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return winningLottoNumbers;
    }

    public int requestBonusNumber(Inputter inputter, Lotto winningLottoNumbers) {
        int bonusNumber = 0;
        try {
            String input = inputter.inputBonusNumber();
            bonusNumber = transformStringtoBonusNumber(input);
            validate(bonusNumber, winningLottoNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[Error] 유효하지 않은 번호 입니다.");
        }
        return bonusNumber;
    }

    private List<Integer> transformStringtoLottoNumberList(String input) {
        List<Integer> numbers = new ArrayList<>();
        String[] tokens = input.split(",");
        for (String token : tokens) {
            try {
                numbers.add(Integer.parseInt(token.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[Error] 잘못된 문자열입니다.");
            }
        }
        return numbers;
    }

    private int transformStringtoBonusNumber(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[Error] 잘못된 보너스 번호입니다.");
        }
        if (number > 46 || number < 1) {
            throw new IllegalArgumentException("[Error] 잘못된 보너스 번호입니다.");
        }
        return number;
    }

    private void validate(int bonusNumber, Lotto winningLottoNumbers) {
        List<Integer> numbers = winningLottoNumbers.getLottoNumbers();
        for (int number : numbers) {
            if (number == bonusNumber) {
                throw new IllegalArgumentException("[Error] 잘못된 번호를 입력하였습니다.");
            }
        }
    }
}
