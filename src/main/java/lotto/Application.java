package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import lotto.util.LottoManager;

public class Application {

  public static void main(String[] args) {
    LottoManager lottoManager = new LottoManager();
    lottoManager.runLotto();
  }
}
