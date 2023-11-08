package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.dto.ValidateAmountDto;
import lotto.dto.ValidateAmountResponseDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LottoService {

    public int inputAmountAndGetLottoCount(){
        boolean validate = true;
        ValidateAmountResponseDto validateAmountResponseDto = new ValidateAmountResponseDto(0,true);
        while (validate) {
            System.out.println("구입금액을 입력해 주세요.");
            String amountStr = Console.readLine();
            validateAmountResponseDto =validateAmount(ValidateAmountDto.of(validate, amountStr));
            validate = validateAmountResponseDto.isValidate();
        }
        return validateAmountResponseDto.getLottoCount();
    }
    public void inputLottoNum(){
        System.out.println("당첨 번호를 입력하세요.");
        String inputStr = Console.readLine();
        String[] input = inputStr.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String numberStr : input) {
            validateLottoNum(numbers,numberStr);
        }
    }
    public void getUserLottoNum(int lottoCount){
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            lottoNumbers.add(numbers);
        }
        System.out.println(lottoCount + "개를 구매했습니다.");
        for (List<Integer> numbers : lottoNumbers) {
            System.out.println(numbers);
        }
    }
    public int getBonusNum(){
        System.out.println("당첨 번호를 입력하세요.");
        String inputStr = Console.readLine();
        int bonusNum = validateBonusNum(inputStr);
        return bonusNum;
    }
    public void
    private int validateBonusNum(String inputStr){
        int number = 0;
        try {
            number = Integer.parseInt(inputStr);
            if(number>=1 && number<=45){
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 로또 번호입니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return number;
    }
    private List<Integer> validateLottoNum(List<Integer> numbers, String numberStr){
        try {
            int number = Integer.parseInt(numberStr);
            if(number>=1 && number<=45){
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 로또 번호입니다.");
            }
            numbers.add(number);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return numbers;
    }
    private ValidateAmountResponseDto validateAmount(ValidateAmountDto validateAmountDto){
        int lottoCount = 0;
        boolean validate = validateAmountDto.isValidate();
        try {
            int amount = Integer.parseInt(validateAmountDto.getAmountStr());
            if (amount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 금액입니다.");
            }
            lottoCount = amount/1000;
            validate = validateAmountDto.isValidate();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return ValidateAmountResponseDto.of(lottoCount, validate);
    }

}
