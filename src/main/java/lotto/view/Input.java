package lotto.view;
import lotto.Exceptions.ManageExceptions;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input extends ManageExceptions {
    public int getCash() {
        String given = readLine();
        int cash = Integer.parseInt(String.valueOf(given));

        cashCheck(cash); // 금액 1000원 단위 체크

        return cash;
    }

    public List<Integer> getWinningNums() {
        String given = readLine();
        List<Integer> winningNums = Arrays.stream(given.split(","))
                .map(Integer::parseInt)
                .toList();

        sizeCheck(winningNums); // 리스트 사이즈 6인지 체크
        for (int i = 0; i < winningNums.size(); i++){ // 1~45 사이의 숫자인지 체크
            rangeCheck(winningNums.get(i));
        }

        duplicationCheck(winningNums);

        return winningNums;
    }

    public int getBonusNum(List<Integer> winningNums) {
        int bonusNum = Integer.parseInt(readLine());
        rangeCheck(bonusNum); // 1~45 사이의 숫자인지 체크

        List<Integer> numbers = new ArrayList<>(winningNums);
        numbers.add(bonusNum);
        duplicationCheck(numbers); // 중복 숫자 있는 지 체크
        return bonusNum;
    }
}
