package lotto.controller;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    public Lotto lottoCreate(List<Integer> randomNumbers) {
        List<Integer> lottoNumbers = randomNumbers.stream().sorted().collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }

    //List의 사이즈가 로또 발행 개수를 의미
    public List<Lotto> lottoCreateCount(List<List<Integer>> randomNumbers) {
        List<Lotto> lottos = new ArrayList<>();

        for (List<Integer> randomNumber : randomNumbers) {
            lottos.add(lottoCreate(randomNumber));
        }

        return lottos;
    }


}
