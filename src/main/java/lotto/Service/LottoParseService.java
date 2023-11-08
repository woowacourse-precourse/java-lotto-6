package lotto.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class LottoParseService {
    private static LottoParseService instance;
    private ValidateService validateService;
    private LottoParseService() {
        this.validateService = ValidateService.getInstance();
    }
    public static LottoParseService getInstance() {
        if (instance == null) instance = new LottoParseService();
        return instance;
    }

    public List<Integer> parseList(String numbers) {
        List<Integer> lottoNumbers = Arrays
                .stream(numbers.split(","))
                .map(number -> validateService.validateNumber(number))
                .map(number -> validateService.checkOneAndFortyFive(number))
                .collect(Collectors.toList());
        return lottoNumbers;
    }
    public int parseTimes(String number){
        return validateService.validateNumber(number);
    }
    public Lotto parseLotto(List<Integer> numbers){
        return new Lotto(numbers);
    }
    public int parseBonusNumber(String bonus){
        return validateService.validateNumber(bonus);
    }
}
