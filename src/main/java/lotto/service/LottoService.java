package lotto.service;

import lotto.constant.Constant;
import lotto.constant.LottoRateConstant;
import lotto.constant.OutputViewMessage;
import lotto.constant.Ranking;
import lotto.handler.LottoMatchingHandler;
import lotto.model.*;
import lotto.util.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoService {
    private Lottos lottos;
    private WinningLotto winningLotto;
    private RankStatus rankStatus;
    private LottoNumberGenerator lottoNumberGenerator;
    private LottoMatchingHandler lottoMatchingHandler;
    private ClientInform clientInform;
    private static LottoService instance;

    private LottoService() {
        lottoNumberGenerator = LottoNumberGenerator.getInstance();
        lottoMatchingHandler = LottoMatchingHandler.getInstance();
        rankStatus = RankStatus.getInstance();
    }

    public static LottoService getInstance() {
        if (instance == null) {
            instance = new LottoService();
        }
        return instance;
    }

    public void makeLottoByPurchaseAmount(int purchaseAmount) throws IllegalArgumentException {
        makeClientInform(purchaseAmount);
        lottos = Lottos.getInstance(makeLotto(getLottoNum()));
    }

    private void makeClientInform(int purchaseAmount) {
        clientInform = ClientInform.getInstance(purchaseAmount);
    }

    public int getLottoNum() {
        return clientInform.getLottoNum();
    }

    private List<Lotto> makeLotto(int lottoNum) {
        List<Lotto> newLottos = new ArrayList<>();
        while (lottoNum-- > 0) {
            newLottos.add(new Lotto(lottoNumberGenerator.makeLottoNumbers()));
        }
        return newLottos;
    }

    public String getLottoNumbers() {
        return lottos.getLottoNumbers();
    }

    public void makeWinningLotto(String winningLottoNumber, String bonusNumber) {
        winningLotto = WinningLotto.getInstance(parsingWinningLotto(winningLottoNumber), parsingBonusNumber(bonusNumber));
    }

    private List<Integer> parsingWinningLotto(String winningLottoNumber) {
        return Arrays.stream(winningLottoNumber.split(Constant.NUMBER_SEPARATOR.getMessage()))
                .map(Integer::parseInt)
                .toList();
    }

    private int parsingBonusNumber(String bonusNumber) {
        return Integer.parseInt(bonusNumber);
    }

    // 로또와 당첨번호로 매칭갯수와 보너스볼을 가지고 자료구조에 저장하기
    public void compareLottoWithWinningLotto() {
        List<Lotto> lottos1 = lottos.getLottos();
        for (Lotto lotto : lottos1) {
            int matchingNum = lottoMatchingHandler.countMatchingNum(lotto, winningLotto);
            boolean isMatching = lottoMatchingHandler.isMatchingBonusNum(lotto, winningLotto.getBonusNumber());
            // 몇등짜리 로또인지 구하기
            Ranking ranking = Ranking.getRanking(matchingNum, isMatching);
            // 당첨된 로또의 수익금을 clientInform에서 업데이트해줌
            clientInform.addWinningReward(ranking.getReward());
            // EnumMap에 각 등수에 update해줌
            rankStatus.updateRankStatus(ranking);
        }
    }

    public String generateLottoRate() {
        return rankStatus.makeLottoRate();
    }

    public double getLottoWinningRate() {
        return clientInform.getLottoRate();
    }
}
