package lotto.Service;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.etc.RuleConstant.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.dto.CountScoreResponseDTO;

public class LottoService {
    private static LottoService instance;
    private ValidateService validateService;
    private List<Lotto> lottoTickets;
    private Lotto userLotto;
    private int bonus;

    private LottoService() {
        this.validateService = ValidateService.getInstance();
    }
    public static LottoService getInstance() {
        if (instance == null) instance = new LottoService();
        return instance;
    }

    public List<Lotto> buyLotto(int money) {
        validateService.checkLengthValidate(money);
        validateService.checkDivideThousand(money);
        int time = money / LOTTO_PRICE.toInt();
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < time; i++) {
            List<Integer> numbers = pickUniqueNumbersInRange(START_INCLUSIVE.toInt(), END_INCLUSIVE.toInt(), COUNT.toInt());
            Lotto lotto = new Lotto(numbers);
            lottoTickets.add(lotto);
        }
        this.lottoTickets = lottoTickets;
        return lottoTickets;
    }
    public void setUserLotto(Lotto lotto){
        this.userLotto = lotto;
    }
    public void setBonus(int bonus){
        validateService.checkOneAndFortyFive(bonus);
        validateService.duplicateBonusNumber(userLotto,bonus);
        this.bonus = bonus;
    }
    public CountScoreResponseDTO countScore() {
        CountScoreResponseDTO dto = new CountScoreResponseDTO();
        checkTickets(dto);

        double rateOfReturn = calculateRateOfReturn(dto);
        dto.setRateOfReturn(rateOfReturn);

        return dto;
    }
    public void cleanData(){
        this.lottoTickets = null;
        this.userLotto = null;
        this.bonus = -1;
    }

    private void checkTickets(CountScoreResponseDTO dto) {
        for (Lotto ticket : lottoTickets) {
            int overlappingNumber = calculateOverlappingNumber(ticket);
            calculateScore(ticket,dto, overlappingNumber);
        }
    }

    private void calculateScore(Lotto ticket, CountScoreResponseDTO dto, int overlappingNumber) {
        if (overlappingNumber == THREE_MATCH.toInt())
            dto.plusFifthPlace();
        if (overlappingNumber == FORE_MATCH.toInt())
            dto.plusFourthPlace();
        if (overlappingNumber == FIVE_MATCH.toInt() && !containsBonus(ticket))
            dto.plusThirdPlace();
        if (overlappingNumber == FIVE_MATCH.toInt() && containsBonus(ticket))
            dto.plusSecondPlace();
        if (overlappingNumber == SIX_MATCH.toInt())
            dto.plusFirstPlace();
    }

    private boolean containsBonus(Lotto ticket) {
        return ticket.getNumbers()
                .contains(bonus);
    }

    private double calculateRateOfReturn(CountScoreResponseDTO dto) {
        int sum = dto.getFifthPlace() * FIFTH.toInt() +
                dto.getFourthPlace() * FOURTH.toInt() +
                dto.getThirdPlace() * THIRD.toInt() +
                dto.getSecondPlace() * SECOND.toInt() +
                dto.getFirstPlace() * FIRST.toInt();

        return Math.round((double) sum / lottoTickets.size() * 10) / 100.0;
    }

    private int calculateOverlappingNumber(Lotto lottoTickets) {
        Set<Integer> userNumbers = new HashSet<>(userLotto.getNumbers());
        Set<Integer> computerNumbers = new HashSet<>(lottoTickets.getNumbers());

        userNumbers.retainAll(computerNumbers);
        return userNumbers.size();
    }
}
