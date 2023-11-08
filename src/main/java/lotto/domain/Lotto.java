package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoInformation;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateValidation(numbers);
        sortNumbers(numbers);
        this.numbers = numbers;
    }

    public Lotto(String input){
        this.numbers = WinningNumbers(input);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoInformation.LOTTO_NUMBER_TOTAL_SIZE.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_LOTTO_SIZE_MESSAGE.getMessage());
        }
    }

    private void duplicateValidation(List<Integer> numbers) {
        Set<Integer> removeDuplicationNumber = new HashSet<>(numbers);
        if(removeDuplicationNumber.size() != LottoInformation.LOTTO_NUMBER_TOTAL_SIZE.getNumber()){
            throw new IllegalArgumentException(ErrorMessage.IS_DUPLICATION_LOTTO_NUMBER_MESSAGE.getMessage());
        }
    }

    public Lotto getPuschaseLotto() {
        return this;
    }

    public List<Integer> getLottoNumbers(){
        return numbers;
    }

    private void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    private List<Integer> WinningNumbers(String input) {
        String[] splitNumbers = input.replace(" ","").split(",");
        List<Integer> lottoNumbers = changeIntegerNumber(splitNumbers);
        sortNumbers(lottoNumbers);
        return lottoNumbers;
    }

    private List<Integer> changeIntegerNumber(String[] splitNumbers) {
        List<Integer> lottoNumbers = new ArrayList<>();
        for(int attempt = 0; attempt < splitNumbers.length; attempt++){
            lottoNumbers.add(Integer.parseInt(splitNumbers[attempt]));
        }
        return lottoNumbers;
    }

    public boolean checkUserAndLottoNumbers(List<Integer> userLotto, int lottoNumber){
        if(userLotto.contains(lottoNumber)){
            return true;
        }
        return false;
    }
}