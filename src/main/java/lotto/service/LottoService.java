package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.entity.Lotto;
import lotto.entity.LottoScore;

public class LottoService {

    public Integer getCount(int money){
        if(money % 1000 > 0){
            throw new IllegalArgumentException("1000으로 나누어 떨어지는 수를 입력해 주세요.");
        }
        return money / 1000;
    }

    public List<Lotto> lottoGenerate(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
                .map(lotto -> new Lotto(
                        lotto.getNumbers().stream()
                                .sorted()
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

    public Double rateReturn(LottoScore lottoScore, int money) {
        int totalWinnings = (lottoScore.getCorrect3() * 5000) + (lottoScore.getCorrect4() * 50000)
                + (lottoScore.getCorrect5() * 1500000) + (lottoScore.getCorrect5Bonus() * 30000000)
                + (lottoScore.getCorrect6() * 2000000000);

        double rate = ((double) totalWinnings - money) / money;

        double percentReturn = 100.0 + rate * 100.0; // 원금을 100%로 가정하여 백분율로 변환
        return (double) Math.round(percentReturn * 10) / 10; // 반올림하여 소수 첫째 자리까지 표시
    }

}
