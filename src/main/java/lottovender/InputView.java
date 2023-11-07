package lottovender;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int inputLottoPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        InputValidator validator = new InputValidator();
        validator.validateAll(input);

        return Integer.parseInt(input);
    }

    private class InputValidator {
        int price;

        private void validateAll(String inputPrice){
            validateBlank(inputPrice);
            validateNumber(inputPrice);
            validateDivision(inputPrice);
        }

        // 공백 입력한 경우 예외 처리
        private void validateBlank(String inputPrice){
            if (inputPrice.trim()=="") throw new IllegalArgumentException("[ERROR] 공백을 입력할 수 없습니다.");
        }

        // 숫자가 아닐경우 예외 처리
        private void validateNumber(String inputPrice){
            try{
                price = Integer.parseInt(inputPrice.replace(",",""));
            }catch(Exception e){
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
            }
        }

        //천원 단위로 나누어떨어지지않는 경우 예외 처리
        private void validateDivision(String inputPrice){
            if (price % 1000 != 0) throw new IllegalArgumentException("[ERROR] 금액은 천원 단위로 입력해주세요.");
        }
    }
}
