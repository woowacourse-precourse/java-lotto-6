package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class LottoDataService {
    InputView inputView;
    Validation validation;
    public Lotto create_Lotto(){
        List<Integer> lotto_numbers = create_lotto_Numbers(inputView.InputLottoNumbers());
        int bonus_number = create_bonus_number();
        return create_Lotto(lotto_numbers, bonus_number);
    }

    private List<Integer> create_lotto_Numbers(String lotto_numbers){
        List<Integer> lottoNumbers = new ArrayList<>();
        Arrays.stream(lotto_numbers.split(","))
                .map(number -> lottoNumbers.add(Integer.parseInt(number)))
                .collect(Collectors.toList());
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    private int create_bonus_number(){
        String bonus_Number = inputView.InputpurchaseAmount();
        validation.validateNumberType(bonus_Number);
        return Integer.parseInt(bonus_Number);
    }

    private Lotto create_Lotto(List<Integer> lotto_numbers, int bonus_number){
        Lotto lotto = new Lotto(lotto_numbers);
        lotto.addBonusNumber(bonus_number);
        return lotto;
    }
}
