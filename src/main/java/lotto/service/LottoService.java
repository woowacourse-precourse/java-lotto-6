package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.WinNum;
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
            Lotto lotto = new Lotto(lottoList);
            temp.add(lotto);
        }
        return temp;
    }

    public void printMyLottoList(List<Lotto> myLottoList) {
        System.out.println(myLottoList.size()+"개를 구매했습니다.");
        for (Lotto lotto : myLottoList) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public WinNum createWinNum() {
        List<Integer> winNum = lottoRepository.getWinNum();
        int bonusNum = lottoRepository.getBonusNum();
        lottoRepository.distinctCheck(winNum, bonusNum);
        return new WinNum(winNum, bonusNum);
    }

    public Result getResult(List<Lotto> myLottoList, WinNum winNum) {
        Result result = new Result();
        for (Lotto lotto : myLottoList) {
            result.count(lottoRepository.countResult(lotto, winNum));
        }
        return result;
    }

    public void printResult(Result result, int amount) {
        result.printResult(amount);
    }
}
