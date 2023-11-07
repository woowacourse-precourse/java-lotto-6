package lotto.domain;

import java.util.List;

public class LottoResultCalculation {
    public int caculateLottoTicket(int money) {
        if(money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        int ticket = money / 1000;
        return ticket;
    }

    public int checkResult(List<Integer> target, List<Integer> tryLotto) {
        int result = (int) tryLotto.stream()
                .filter(target::contains)
                .count();

        return result;
    }

    public boolean checkBounsNumber(List<Integer> target, int bouns) {
        boolean result = target.contains(bouns);
        return result;
    }
}
