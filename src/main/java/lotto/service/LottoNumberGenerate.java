package lotto.service;

import lotto.util.RandomNumberGenerate;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberGenerate {
    RandomNumberGenerate randomNumberGenerate = new RandomNumberGenerate();
    public List<List<Integer>> getLottoNumber(int lottoTicket) {
        List<List<Integer>> lottoNumbers = new ArrayList<List<Integer>>();
        for (int i = 0; i < lottoTicket; i++) {
            lottoNumbers.add(randomNumberGenerate.getRandomNumber());
        }
        return lottoNumbers;
    }
}
