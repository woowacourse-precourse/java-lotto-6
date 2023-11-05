package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class UserInput {
    private boolean repeatPurchase = true;
    private boolean repeatWinningNumber = true;

    //구매 금액 입력
    public int getPurchaseAmount() {
        int purchaseAmount = Integer.parseInt(Console.readLine());

        return purchaseAmount;
    }


    public void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % 1000 == 0) {
            repeatPurchase = false;
            return;
        }

        throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요");
    }

////////////////////////////////////////////////////////////////////////////////

    //당첨 번호 입력
    public static List<Integer> getWinningNumbers() {
        String winningNumbersInput = Console.readLine();
        //Array보다는  Collections 사용! - 1주차 피드백

        //변수 이름에 자료형&자료구조 사용하지 마! - 2주차 피드백
        List<String> splittedWinningNumbersInput = Arrays.asList(winningNumbersInput.split(","));

        //나중에 for-each 문 개별 함수화 리팩토링!
        List<Integer> winningNumbers = new ArrayList<>();

        for (var number : splittedWinningNumbersInput) {
            Integer.parseInt(number);
            winningNumbers.add(Integer.valueOf(number));
        }

        //중복 체크

        return winningNumbers;
    }
//
//        }


}
