package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.WinNum;
import lotto.enums.LottoEnum;
import lotto.repository.LottoRepository;

import java.util.ArrayList;
import java.util.List;

import static lotto.LottoConst.*;

public class LottoService {

    private final LottoRepository lottoRepository = new LottoRepository();

    public int getAmount() {
        int price = lottoRepository.getPrice();
        return price / LOTTO_PRICE;
    }

    public List<Lotto> createLottoList(int amount) {
        List<Lotto> temp = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            List<Integer> lottoList = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, LOTTO_COUNT);
            temp.add(new Lotto(lottoList));
        }
        return temp;
    }



    public WinNum createWinNum() {
        List<Integer> winNum = lottoRepository.getWinNum();
        int bonusNum = lottoRepository.getBonusNum(winNum);
        return new WinNum(winNum, bonusNum);
    }

    public void getResult(List<Lotto> myLottoList, WinNum winNum) {
        for (Lotto lotto : myLottoList) {
            LottoEnum lottoEnum = lotto.countResult(winNum);
            Result.resultCount(lottoEnum);
        }
    }

}
