package lotto.domain.converter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Money;
import lotto.domain.Purchase;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.number.CompareLottoNumber;
import lotto.domain.result.LottoPrize;
import lotto.dto.request.PurchaseRequest;
import lotto.dto.request.WinningLottoRequest;
import lotto.dto.response.LottoNumbersResponse;
import lotto.dto.response.LottoWinningStatsResponse;
import lotto.dto.response.WinningStatsResponse;

public class LottoConverter {

    public Purchase moneyConvertToPurchase(Money money) {
        return new Purchase(money.getMoney());
    }

    public Money purchaseRequestConvertToMoney(PurchaseRequest request) {
        return new Money(request.getMoney());
    }

    public List<LottoNumbersResponse> lottoTicketConvertToLottoNumberResponses(
        List<Lotto> lottoTicket) {
        return lottoTicket.stream()
            .map(lotto -> new LottoNumbersResponse(lotto.getNumbers()))
            .collect(Collectors.toList());
    }

    public WinningLotto winningLottoRequestConvertToWinningLotto(WinningLottoRequest request) {
        return new WinningLotto(
            new Lotto(request)
        );
    }

    public List<Integer> winningLottoConvertToList(String winningLotto) {
        return Arrays.stream(winningLotto.split(","))
            .map(String::trim)
            .map(Integer::valueOf)
            .collect(Collectors.toList());
    }

    public Map<Integer, WinningStatsResponse> convertToWinningStatsResponse(
        CompareLottoNumber compare) {
        Map<Integer, WinningStatsResponse> result = new HashMap<>();

        for (Map.Entry<LottoPrize, Integer> entry : compare.getDeterminePrizeMap().entrySet()) {
            result.put(
                entry.getKey().getNumberOfMatches(),
                new WinningStatsResponse(entry.getValue())
            );
        }
        return result;
    }

    public LottoWinningStatsResponse convertToLottoWinningStatsResponse(
        Map<Integer, WinningStatsResponse> winningStatsResponses,
        double totalProfit
    ) {
        return new LottoWinningStatsResponse(winningStatsResponses, totalProfit);
    }
}