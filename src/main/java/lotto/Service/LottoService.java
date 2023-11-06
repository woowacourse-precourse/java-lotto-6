package lotto.Service;

import static lotto.etc.RuleConstant.FIFTH;
import static lotto.etc.RuleConstant.FIRST;
import static lotto.etc.RuleConstant.FOURTH;
import static lotto.etc.RuleConstant.SECOND;
import static lotto.etc.RuleConstant.THIRD;
import static lotto.etc.Validate.validateNumber;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.dto.BonusRequestDTO;
import lotto.dto.LottoRequestDTO;
import lotto.dto.LottoResponseDTO;
import lotto.etc.Validate;

public class LottoService {
    private static LottoService instance = new LottoService();
    private LottoService() {}
    public static LottoService getInstance() {
        return instance;
    }

    public Lottos lottoSell(String money) {
        return new Lottos(money);
    }
    public Lotto createLotto(String numbers){
        return parseLottoNumbers(numbers);
    }
    public int checkBonus(BonusRequestDTO bonusRequestDTO){
        int bonusNumber = validateNumber(bonusRequestDTO.getBonus());
        bonusRequestDTO
                .getLotto()
                .duplicateBonusNumber(bonusNumber);
        return bonusNumber;
    }
    public LottoResponseDTO countScore(LottoRequestDTO lottoRequestDTO) {
        Lotto userLotto = lottoRequestDTO.getLotto();
        Lottos lottos = lottoRequestDTO.getLottos();
        int lottoLength = lottos.getLottoCount();

        int bonus = lottoRequestDTO.getBonus();
        LottoResponseDTO lottoResponseDTO = new LottoResponseDTO();

        for (int i = 0; i < lottoLength; i++) {
            int overlappingNumber = getOverlappingNumber(userLotto, lottos, i);

            checkScore(lottos, bonus, lottoResponseDTO, i, overlappingNumber);
        }
        double rateOfReturn = calculateRateOfReturn(lottoLength, lottoResponseDTO);
        lottoResponseDTO.setRateOfReturn(rateOfReturn);

        return lottoResponseDTO;
    }
    private void checkScore(Lottos lottos, int bonus, LottoResponseDTO lottoResponseDTO, int i, int overlappingNumber) {
        if (overlappingNumber == 3) {
            lottoResponseDTO.plusFifthPlace();
        } else if (overlappingNumber == 4) {
            lottoResponseDTO.plusFourthPlace();
        } else if (overlappingNumber == 5) {
            bonusCheck(lottos, bonus, lottoResponseDTO, i);
        } else if (overlappingNumber == 6) {
            lottoResponseDTO.plusFirstPlace();
        }
    }
    private void bonusCheck(Lottos lottos, int bonus, LottoResponseDTO lottoResponseDTO, int i) {
        if (!isContains(lottos, bonus, i)) {
            lottoResponseDTO.plusThirdPlace();
        } else if (isContains(lottos, bonus, i)) {
            lottoResponseDTO.plusSecondPlace();
        }
    }
    private boolean isContains(Lottos lottos, int bonus, int i) {
        return lottos
                .getLottos()
                .get(i)
                .getNumbers()
                .contains(bonus);
    }
    private double calculateRateOfReturn(int lottoLength, LottoResponseDTO lottoResponseDTO) {
        int sum = 0;
        sum += lottoResponseDTO.getFifthPlace() * FIFTH.toInt();
        sum += lottoResponseDTO.getFourthPlace() * FOURTH.toInt();
        sum += lottoResponseDTO.getThirdPlace() * THIRD.toInt();
        sum += lottoResponseDTO.getSecondPlace() * SECOND.toInt();
        sum += lottoResponseDTO.getFirstPlace() * FIRST.toInt();

        double rateOfReturn = sum / lottoLength;
        return Math.round(rateOfReturn * 10.0) / 100.0;
    }
    private int getOverlappingNumber(Lotto userLotto, Lottos lottos, int index) {
        List<Integer> userNumbers = userLotto
                .getNumbers();
        List<Integer> computerNumbers = lottos
                .getLottos()
                .get(index)
                .getNumbers();
        return calculateOverlappingNumber(userNumbers, computerNumbers);
    }
    private Lotto parseLottoNumbers(String numbers) {
        List<Integer> lottoNumbers = Arrays
                .stream(numbers.split(","))
                .map(Validate::validateNumber)
                .collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }
    private int calculateOverlappingNumber(List<Integer> userNumbers, List<Integer> computerNumbers) {
        Set<Integer> userSet = new HashSet<>(userNumbers);
        Set<Integer> computerSet = new HashSet<>(computerNumbers);

        userSet.retainAll(computerSet);
        return userSet.size();
    }
}