package lotto.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.validation.Validation;
import lotto.View.InputView;
import lotto.domain.Lotto;

public class LottoDataService {
    public Lotto create_official_Lotto() {
        Lotto lotto = create_Lotto_Without_BonusNumber();
        String bonus_number = create_bonus_number(lotto);
        return create_Lotto_With_BonusNumber(lotto, Integer.parseInt(bonus_number));
    }

    private List<Integer> create_lotto_Numbers(String lotto_numbers) {
        Validation.validateLottoNumberType(lotto_numbers);
        List<Integer> lottoNumbers = new ArrayList<>();
        Arrays.stream(lotto_numbers.split(","))
                .map(number -> lottoNumbers.add(Integer.parseInt(number)))
                .collect(Collectors.toList());
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    private Lotto create_Lotto_Without_BonusNumber() {
        while (true) {
            try {
                List<Integer> lottoNumbers = create_lotto_Numbers(InputView.InputLottoNumbers());
                return new Lotto(lottoNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String create_bonus_number(Lotto lotto_numbers){
        while(true)
    {
        try {
            String bonus_Number = InputView.InputBonusNumbers();
            Validation.validateBonusNumber(lotto_numbers, bonus_Number);
            return bonus_Number;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
    private Lotto create_Lotto_With_BonusNumber(Lotto lotto, int bonus_number) {
        lotto.addBonusNumber(bonus_number);
        return lotto;
    }
}
