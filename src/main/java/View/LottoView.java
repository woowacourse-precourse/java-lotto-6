package View;

import lotto.Lotto;

import java.util.List;

public interface LottoView {
    public void printLotteries(List<Lotto> lotteries); //각 로또당 1줄로 하여 출력, 로또 내부의 순서는 오름 차순
}
