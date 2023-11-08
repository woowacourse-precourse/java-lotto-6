package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Broardcaster {

    public List<Integer> choiceLotteryNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputLottoNumbers = Console.readLine();

        try{
            validateInputLottoNumbers(inputLottoNumbers);
        } catch (IllegalArgumentException ie){
            System.out.println(ie.getMessage());
            return choiceLotteryNumbers();
        }
        System.out.println();
        return getListFromArray(inputLottoNumbers.split(","));
    }

    private List<Integer> getListFromArray(String[] split) {
        List<Integer> result = new ArrayList<>();
        Arrays.stream(split)
                .forEach(num -> result.add(Integer.parseInt(num)));
        return result;
    }

    private void validateInputLottoNumbers(String inputLottoNumbers) {
        if(!Validator.validateLottoNumbersAndSize(inputLottoNumbers)){
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자 6개여야 합니다.");
        }
        if (Validator.isDuplicateLottoNumbers(inputLottoNumbers.split(","))) {
            throw new IllegalArgumentException("[ERROR] 중복된 로또 번호가 존재합니다.");
        }
    }

    public int choiceBonusNumber(List<Integer> lottoNumbers) {
        System.out.println("[ERROR] 보너스 번호를 입력해 주세요.");
        String inputBonusNumber = Console.readLine();
        try {
            validateInputBonusNumber(inputBonusNumber, lottoNumbers);
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            return choiceBonusNumber(lottoNumbers);
        }
        System.out.println();
        return Integer.parseInt(inputBonusNumber);
    }

    private void validateInputBonusNumber(String inputBonusNumber, List<Integer> lottoNumbers) {
        if (!Validator.validateBonusNumber(inputBonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자 1개여야 합니다.");
        }
        if (Validator.isDuplicateAllNumbers(lottoNumbers, Integer.parseInt(inputBonusNumber))) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 중 중복된 번호가 존재합니다.");
        }
    }
}
