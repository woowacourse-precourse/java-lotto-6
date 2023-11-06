package lotto.Service;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.etc.RuleConstant.*;
import static lotto.etc.Validate.checkOneAndFortyFive;
import static lotto.etc.Validate.validateNumber;

import java.util.*;
import lotto.domain.Lotto;
import lotto.dto.BonusRequestDTO;
import lotto.dto.CountScoreRequestDTO;
import lotto.dto.CountScoreResponseDTO;

public class LottoService {
    private static final LottoService instance = new LottoService();

    private LottoService() {}

    public static LottoService getInstance() {
        return instance;
    }

    public List<Lotto> buyLotto(int time) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < time; i++) {
            List<Integer> numbers = pickUniqueNumbersInRange(START_INCLUSIVE.toInt(), END_INCLUSIVE.toInt(), COUNT.toInt());
            Lotto lotto = createLotto(numbers);
            lottoTickets.add(lotto);
        }
        return lottoTickets;
    }

    public Lotto createLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public int createBonusNumber(BonusRequestDTO bonusRequestDTO) {
        int bonusNumber = validateNumber(bonusRequestDTO.getBonus());
        checkOneAndFortyFive(bonusNumber);
        bonusRequestDTO.getLotto().duplicateBonusNumber(bonusNumber);
        return bonusNumber;
    }

    public CountScoreResponseDTO countScore(CountScoreRequestDTO countScoreRequestDTO) {
        Lotto userLotto = countScoreRequestDTO.getLotto();
        List<Lotto> lottoTickets = countScoreRequestDTO.getLottoTickets();
        int lottoCount = lottoTickets.size();
        int bonus = countScoreRequestDTO.getBonus();
        CountScoreResponseDTO countScoreResponseDTO = new CountScoreResponseDTO();

        checkTickets(userLotto, lottoTickets, bonus, countScoreResponseDTO);

        double rateOfReturn = calculateRateOfReturn(lottoCount, countScoreResponseDTO);
        countScoreResponseDTO.setRateOfReturn(rateOfReturn);

        return countScoreResponseDTO;
    }

    private void checkTickets(Lotto userLotto, List<Lotto> lottoTickets, int bonus, CountScoreResponseDTO countScoreResponseDTO) {
        for (Lotto ticket : lottoTickets) {
            int overlappingNumber = calculateOverlappingNumber(userLotto, ticket);
            calculateScore(ticket, bonus, countScoreResponseDTO, overlappingNumber);
        }
    }

    private void calculateScore(Lotto ticket, int bonus, CountScoreResponseDTO dto, int overlappingNumber) {
        if (overlappingNumber == 3) {
            dto.plusFifthPlace();
        } else if (overlappingNumber == 4) {
            dto.plusFourthPlace();
        } else if (overlappingNumber == 5) {
            checkBonus(ticket, bonus, dto);
        } else if (overlappingNumber == 6) {
            dto.plusFirstPlace();
        }
    }

    private void checkBonus(Lotto ticket, int bonus, CountScoreResponseDTO dto) {
        if (!containsBonus(ticket, bonus)) {
            dto.plusThirdPlace();
        } else if (containsBonus(ticket, bonus)) {
            dto.plusSecondPlace();
        }
    }

    private boolean containsBonus(Lotto ticket, int bonus) {
        return ticket.getNumbers().contains(bonus);
    }

    private double calculateRateOfReturn(int lottoCount, CountScoreResponseDTO countScoreResponseDTO) {
        int sum = countScoreResponseDTO.getFifthPlace() * FIFTH.toInt() +
                countScoreResponseDTO.getFourthPlace() * FOURTH.toInt() +
                countScoreResponseDTO.getThirdPlace() * THIRD.toInt() +
                countScoreResponseDTO.getSecondPlace() * SECOND.toInt() +
                countScoreResponseDTO.getFirstPlace() * FIRST.toInt();

        return Math.round((double) sum / lottoCount * 10) / 100.0;
    }

    private int calculateOverlappingNumber(Lotto userLotto, Lotto lottoTickets) {
        Set<Integer> userNumbers = new HashSet<>(userLotto.getNumbers());
        Set<Integer> computerNumbers = new HashSet<>(lottoTickets.getNumbers());

        userNumbers.retainAll(computerNumbers);
        return userNumbers.size();
    }
}
