package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.constant.Condition;
import lotto.constant.Message;
import lotto.domain.Lotto;
import lotto.domain.LottoBuyer;
import lotto.domain.Prize;
import lotto.domain.Procedure;

public class LottoService {

    public List<Integer> parseInputToNumberCandidates(String input) throws NumberFormatException{
        return Arrays.stream(input.split(Message.COMMA))
                .map(String::trim)
                .map(Integer::parseUnsignedInt)
                .collect(Collectors.toList());
    }

    public List<Lotto> generateLotto(int count){
        return IntStream.range(Condition.ZERO, count)
                .mapToObj(each -> new Lotto())
                .collect(Collectors.toList());
    }

    public LottoBuyer createLottoBuyer(List<Lotto> purchasedLotto, Lotto winningNumbers, int bonusNumber, int money){
        return new LottoBuyer(purchasedLotto, winningNumbers, bonusNumber, money);
    }

    public String ShowPurchasedLottoNumbers(List<Lotto> lottos){
        StringBuilder lottoNumbers = new StringBuilder(String.format((Message.PURCHASED_LOTTO + "\n"), lottos.size()));
        lottos.forEach(lotto -> lottoNumbers.append(lotto.seeLottoNumber()).append("\n"));
        return lottoNumbers.toString();
    }

    public long calculateInterests(List<Integer> prizes){
        return IntStream.range(Condition.ZERO, prizes.size())
                .filter(idx ->prizes.get(idx) != 0)
                .mapToLong(Prize::getPrizeAmount)
                .sum();
    }


    public String PrizeInfoToString(List<Integer> prizes){
        StringBuilder result = new StringBuilder(Message.RESULT_MESSAGE).append("\n");
        IntStream.range(1, prizes.size())
                .forEach(idx -> result.append(Prize.getPrizeInfo(idx))
                        .append(prizes.get(idx)).append("개\n"));
        return result.toString();
    }
}
