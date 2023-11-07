package lotto;

import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.NumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final LottoController lottoController = new LottoController();

        lottoController.lottoStart();
    }
}
