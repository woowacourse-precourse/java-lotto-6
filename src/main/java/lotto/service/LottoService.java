package lotto.service;

import lotto.constant.Constant;
import lotto.constant.Ranking;
import lotto.handler.LottoMatchingHandler;
import lotto.model.*;
import lotto.util.LottoNumberGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class LottoService {
    private Lottos lottos;
    private WinningLotto winningLotto;
    private final RankStatus rankStatus;
    private final LottoNumberGenerator lottoNumberGenerator;
    private final LottoMatchingHandler lottoMatchingHandler;
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

    public void makeLottoByPurchaseAmount(int purchaseAmount) {
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
        return IntStream.range(0, lottoNum)
                .mapToObj(i -> new Lotto(lottoNumberGenerator.makeLottoNumbers()))
                .toList();
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

    public void saveLottoStatus() {
        List<Lotto> lottos1 = lottos.getLottos();
        for (Lotto lotto : lottos1) {
            // 몇등짜리 로또인지 구하기
            Ranking ranking = getRanking(getMatchingNum(lotto, winningLotto), isMatching(lotto, winningLotto));
            // 당첨된 로또의 수익금을 clientInform에서 업데이트
            addWinningReward(ranking.getReward());
            // EnumMap에 각 등수에 update해줌
            updateRankStatus(ranking);
        }
    }

    private int getMatchingNum(Lotto lotto, WinningLotto winningLotto) {
        return lottoMatchingHandler.countMatchingNum(lotto, winningLotto);
    }

    private boolean isMatching(Lotto lotto, WinningLotto winningLotto) {
        return lottoMatchingHandler.isMatchingBonusNum(lotto, winningLotto.getBonusNumber());
    }

    private void addWinningReward(int reward) {
        clientInform.addWinningReward(reward);
    }

    private void updateRankStatus(Ranking ranking) {
        rankStatus.updateRankStatus(ranking);
    }

    private Ranking getRanking(int matchingNum, boolean isMatching) {
        return Ranking.getRanking(matchingNum, isMatching);
    }

    public String generateLottoRate() {
        return rankStatus.makeLottoRate();
    }

    public double getLottoWinningRate() {
        return clientInform.getLottoRate();
    }
}
