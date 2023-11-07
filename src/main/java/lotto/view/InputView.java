package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static int getValidLottoPurchaseAmount() {
        boolean hasException = true;
        int validAmount = 0;

        while(hasException){ //exception 발생시 계속 반복
            try{
                validAmount = getLottoPurchaseAmount();
                hasException=false;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        return validAmount;
    }

    public static List<Integer> getValidLottoWinningNumbers(){
        boolean hasException = true;
        List<Integer> validNumbers = null;

        while(hasException){ //exception 발생시 계속 반복
            try{
                validNumbers = getLottoWinningNumbers();
                hasException=false;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        return validNumbers;
    }

    public static int getValidBonusNumber(List<Integer> lottoWinningNumbers){
        boolean hasException = true;
        int vaildBonusNumber = 0;

        while(hasException){
            try{
                vaildBonusNumber = getBonusNumber(lottoWinningNumbers);
                hasException=false;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        return vaildBonusNumber;
    }

    public static int getLottoPurchaseAmount(){
        String input = Console.readLine();
        int lottoPurchaseAmount = checkIntegerFormat(input);
        checkDivisibilityBy1000(lottoPurchaseAmount);
        return lottoPurchaseAmount/1000;
    }
    public static List<Integer> getLottoWinningNumbers(){
        String[] inputs = Console.readLine().split(",");
        List<Integer> lottoWinningNumbers = new ArrayList<>();

        for(String input : inputs) {
            int checkedInput = checkIntegerFormat(input);
            checkRange(checkedInput);
            checkDuplicateNumber(lottoWinningNumbers, checkedInput);
            lottoWinningNumbers.add(checkedInput);
        }
        return lottoWinningNumbers;
    }

    public static int getBonusNumber(List<Integer> lottoWinningNumbers){
        String input = Console.readLine();
        int bonusNumber = checkIntegerFormat(input);
        checkRange(bonusNumber);
        checkDuplicateNumber(lottoWinningNumbers, bonusNumber);
        return bonusNumber;
    }

    private static void checkDuplicateNumber(List<Integer> lottoWinningNumbers, int bonusNumber) {
        if (lottoWinningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private static void checkDivisibilityBy1000(int number) {
        if(number%1000 != 0){
            throw new IllegalArgumentException("[ERROR] 구입 금액을 1000원 단위로 입력해주세요.");
        }
    }
    public static int checkIntegerFormat(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요.");
        }
    }
    public static void checkRange(int number){
        if(number < 1 || number > 45){
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자를 입력학세요.");
        }
    }


}
