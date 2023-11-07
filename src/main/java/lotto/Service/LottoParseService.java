package lotto.Service;

import static lotto.etc.RuleConstant.LOTTO_PRICE;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.dto.BonusRequestDTO;

public class LottoParseService {
    private static LottoParseService instance = new LottoParseService();
    private ValidateService validateService;
    private LottoParseService() {
        this.validateService = ValidateService.getInstance();
    }
    public static LottoParseService getInstance() {
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
        validateService.checkLengthValidate(number);
        validateService.checkDivideThousand(number);
        return validateService.validateNumber(number) / LOTTO_PRICE.toInt();
    }
    public Lotto parseLotto(List<Integer> numbers){
        return new Lotto(numbers);
    }
    public int parseBonusNumber(BonusRequestDTO bonusRequestDTO){
        int bonusNumber = validateService.validateNumber(bonusRequestDTO.getBonus());
        validateService.checkOneAndFortyFive(bonusNumber);
        validateService.duplicateBonusNumber(bonusRequestDTO);
        return bonusNumber;
    }
}
