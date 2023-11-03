package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.Lotto;

public class Computer {

    public String getInput() {
        return Console.readLine();
    }

    public void checkNumber(String userInput) {

        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 숫자만(소수점 제외) 입력해주세요.");
        }
    }

    public void checkRemainder(Integer userInput) {
        if ((userInput % 1000) != 0) {
            throw new IllegalArgumentException("[ERROR] 1000단위의 숫자를 입력해주세요.");
        }
    }

    public void checkZero(String userInput) {
        if (userInput.charAt(0) == '0') {
            throw new IllegalArgumentException("[ERROR] 숫자 앞에 0을 입력하지 마세요.");
        }
    }


    // 2. 로또 수량 계산 로직
    public Integer calculateLotto(Integer money) {
        Integer lottoCount = money / 1000;
        System.out.println(lottoCount + "개를 구매했습니다.");
        return lottoCount;
    }

    public Lotto calculateLottoNumber() {

        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));

    }

    public void checkRange(Integer userInput) {

        if ((userInput < 1) || (userInput > 45)) {
            throw new IllegalArgumentException("[ERROR] 1~45 범위의 숫자를 입력 하세요.");
        }

    }

    public void checkDuplication(List<Integer> userInput) {
        if (userInput.size() != new HashSet<>(userInput).size()) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 숫자를 입력해 주세요.");
        }
    }

    public void isIncluding(List<Integer> lottoNumbers, Integer bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 숫자를 입력해 주세요.");
        }
    }

    public void checkSize(List<String> userInputs) {
        if (userInputs.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해 주세요.");
        }
    }


}
