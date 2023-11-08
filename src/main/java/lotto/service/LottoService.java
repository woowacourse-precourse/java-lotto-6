package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Player;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.validate.InputValidator;
import lotto.service.dto.LottoResultDto;
import lotto.service.dto.PurchaseResultDto;

import java.util.List;

public class LottoService {
    private static final int LOTTO_COST = 1000;
    private final Player player;
    private final Lottos lottos;
    private final InputValidator inputValidator;

    public LottoService(Player player, Lottos lottos, InputValidator inputValidator) {
        this.player = player;
        this.lottos = lottos;
        this.inputValidator = inputValidator;
    }

    public PurchaseResultDto purchaseLotto(String input) {
        inputValidator.validatePurchaseAmount(input);

        int purchaseAmountInput = Integer.parseInt(input);
        player.insertPurchaseAmount(purchaseAmountInput);

        return generateLottos(purchaseAmountInput);
    }

    public void putWinningNumbers(String input) {
        inputValidator.validateWinningNumber(input);
        player.insertWinningNumbers(input);
    }

    public void putBonusNumber(String input) {
        inputValidator.validateBonusNumber(input, player.getWinningNumbers());
        player.insertBonusNumber(input);
    }

    public List<LottoResultDto> getLottoResult() {
        List<LottoResultDto> result =  lottos.matchAll(player.getWinningNumbers(), player.getBonusNumber());
        putRateOfReturn(result);
        return result;
    }

    public double getRateOfReturn() {
        return player.getRateOfReturn();
    }

    private void putRateOfReturn(List<LottoResultDto> result) {
        double totalReturn = 0;

        for (LottoResultDto dto : result) {
            if (dto.matchedAmount() == 6) {
                totalReturn += 2000000000;
            }

            if (dto.matchedAmount() + dto.bonusMatchedAmount() == 6) {
                totalReturn += 30000000;
            }

            if (dto.matchedAmount() + dto.bonusMatchedAmount() == 5) {
                totalReturn += 1500000;
            }

            if (dto.matchedAmount() + dto.bonusMatchedAmount() == 4) {
                totalReturn += 50000;
            }

            if (dto.matchedAmount() + dto.bonusMatchedAmount() == 3) {
                totalReturn += 5000;
            }
        }
        player.calculateRateOfReturn(totalReturn);
    }

    private PurchaseResultDto generateLottos(int purchaseAmountInput) {
        for (int i = 0; i < purchaseAmountInput / LOTTO_COST; i++) {
            Lotto lotto = generateLottoWithRandomNumber();
            lottos.insertLotto(lotto);
        }

        List<List<Integer>> tickets = lottos.getLottoTickets();

        return new PurchaseResultDto(tickets.size(), tickets);
    }

    private Lotto generateLottoWithRandomNumber() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
