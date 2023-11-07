package lotto.controller;

import lotto.domain.Lottos;

import java.util.List;

public class LottosController {
    public Lottos create(List<List<Integer>> numberLists) {
        return new Lottos(numberLists);
    }
}
