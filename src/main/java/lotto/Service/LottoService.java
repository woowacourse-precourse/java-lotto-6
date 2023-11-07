package lotto.Service;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.etc.RuleConstant.COUNT;
import static lotto.etc.RuleConstant.END_INCLUSIVE;
import static lotto.etc.RuleConstant.FIFTH;
import static lotto.etc.RuleConstant.FIRST;
import static lotto.etc.RuleConstant.FIVE_MATCH;
import static lotto.etc.RuleConstant.FORE_MATCH;
import static lotto.etc.RuleConstant.FOURTH;
import static lotto.etc.RuleConstant.SECOND;
import static lotto.etc.RuleConstant.SIX_MATCH;
import static lotto.etc.RuleConstant.START_INCLUSIVE;
import static lotto.etc.RuleConstant.THIRD;
import static lotto.etc.RuleConstant.THREE_MATCH;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;
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
            Lotto lotto = new Lotto(numbers);
            lottoTickets.add(lotto);
        }
        return lottoTickets;
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
        if (overlappingNumber == THREE_MATCH.toInt())
            dto.plusFifthPlace();
        if (overlappingNumber == FORE_MATCH.toInt())
            dto.plusFourthPlace();
        if (overlappingNumber == FIVE_MATCH.toInt() && !containsBonus(ticket, bonus))
            dto.plusThirdPlace();
        if (overlappingNumber == FIVE_MATCH.toInt() && containsBonus(ticket, bonus))
            dto.plusSecondPlace();
        if (overlappingNumber == SIX_MATCH.toInt())
            dto.plusFirstPlace();
    }

    private boolean containsBonus(Lotto ticket, int bonus) {
        return ticket.getNumbers()
                .contains(bonus);
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
