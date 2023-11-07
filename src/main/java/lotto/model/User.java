package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.ErrorMessage;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Price;

import java.util.Arrays;
import java.util.stream.Collectors;

public class User {
    public Price requestPurchasePrice() {
        while (true) {
            try {
                Price price = new Price(Console.readLine());
                return price;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 당첨 번호 입력 받기
    public Lotto requestWinningNums() {
        while (true) {
            try {
                String[] userInput = Console.readLine().split(",");
                Lotto winningNums = new Lotto(Arrays.stream(userInput).map(e -> Integer.parseInt(e)).collect(Collectors.toList()));

                return winningNums;
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.NOT_NUMBER.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 보너스 번호 입력 받기
    public LottoNumber requestBonusNum(Lotto winningNums) {
        while (true) {
            try {
                LottoNumber bonusNum = new LottoNumber(Console.readLine());
                validateDuplicate(winningNums, bonusNum);

                return bonusNum;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 보너스 번호 중복 검사
    private void validateDuplicate(Lotto winningNums, LottoNumber bonusNum) {
        if (winningNums.getNumbers().stream().anyMatch(e -> e.getNumber() == bonusNum.getNumber())) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUM.getMessage());
        }
    }
}
