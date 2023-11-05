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


    public void sortWinningNumbers(List<Integer> winningNumbers) {
        Collections.sort(winningNumbers);
    }


    public checkDuplicatesInWinningNumbers(List<Integer> winningNumbers) {

    }

    public void hasDuplicates(List<Integer> winningNumbers) {
        Set<Integer> set = new HashSet<>();
        for (Integer number : winningNumbers) {
            if (!set.add(number)) {
                throw new IllegalArgumentException("서로 다른 당첨 번호를 입력해주세요.");
            }
        }
        repeatWinningNumber = false;
    }

    // => while문으로 반복!



    //나중에 main() 아래에서 각 입력값별로 메소드들 묶어서 하나의 메소드화 할꺼임 & while문으로 제대로된 값 입력될때까지 다시 물어보기
//    public getInput(){
//        while(repeatPurchase){
//            int purchaseAmount = getPurchaseAmount();
//
//            validatePurchaseAmount(purchaseAmount);
//    }




}
