package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoGameConfig;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validationDuplicateNumbers(numbers);
        sortNumbers(numbers);
        this.numbers = numbers;
    }

    public Lotto(String input){
        this.numbers = WinningNumbers(input);
    }
    public Lotto getPuschaseLotto() {
        return this;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoGameConfig.LOTTO_NUMBER_COUNT.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE_ERROR.getMessage());
        }
    }

    private void validationDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != LottoGameConfig.LOTTO_NUMBER_COUNT.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER_ERROR.getMessage());
        }
    }

    public List<Integer> getLottoNumbers(){
        return new ArrayList<>(numbers);
    }

    private void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    private List<Integer> WinningNumbers(String input) {
        String[] splitNumbers = input.replace(" ","").split(",");
        List<Integer> lottoNumbers = convertToIntegerList(splitNumbers);
        sortNumbers(lottoNumbers);
        return lottoNumbers;
    }

    private List<Integer> convertToIntegerList(String[] splitNumbers) {
        List<Integer> lottoNumbers = new ArrayList<>();
        for(int i = 0; i < splitNumbers.length; i++){
            lottoNumbers.add(Integer.parseInt(splitNumbers[i]));
        }
        return lottoNumbers;
    }

    public boolean checkUserAndLottoNumbers(List<Integer> userLotto, int lottoNumber) {
        return userLotto.contains(lottoNumber);
    }
}