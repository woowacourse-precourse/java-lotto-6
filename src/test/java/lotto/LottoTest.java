package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import Converter.Converter;
import Validator.IntegerValidator;
import Validator.LottoValidator;
import Validator.MoneyValidator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



class LottoTest {

    @DisplayName("공백이 입력되면 예외가 발생한다.")
    @Test
    void createEmptyValue() {
        assertThatThrownBy(() -> IntegerValidator.checkEmptyValue(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("int의 max값 보다 큰 값이 입력되면 예외가 발생한다.")
    @Test
    void createBiggerThanIntMaxValue() {
        assertThatThrownBy(() -> IntegerValidator.checkIntegerMaxValue("9999999999"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("0이상 양의 정수가 아닌 값이 입력되면 예외가 발생한다.")
    @Test
    void createNonPositiveIntValue(){
        assertThatThrownBy(() -> IntegerValidator.checkZeroOrPositiveInteger("-1"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> IntegerValidator.checkZeroOrPositiveInteger("123abc"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> IntegerValidator.checkZeroOrPositiveInteger("abc"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> IntegerValidator.checkZeroOrPositiveInteger("   "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1,000원 단위가 아니면 예외가 발생한다.")
    @Test
    void createNon1000Won(){
        assertThatThrownBy(() -> MoneyValidator.isDividedInto1000(900))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> MoneyValidator.isDividedInto1000(1200))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> MoneyValidator.isDividedInto1000(100001))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액을 바탕으로 로또 발행 횟수를 알아낸다.")
    @Test
    void findLottoIssueNumber(){
        Integer money = 3000;
        Integer issueNumber = Lottos.countNumberOfLottoIssue(money);
        assertThat(issueNumber).isEqualTo(3);
    }

    @DisplayName("입력한 금액 만큼 로또가 발행된다.")
    @Test
    void issueLotto(){
        Integer money = 8000;
        Lottos lottos = Lottos.issueLottos(money);
        assertThat(lottos.getSize()).isEqualTo(8);
    }

    @DisplayName("로또 번호의 범위(1~45)를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoNumberOutOfRange(){
        assertThatThrownBy(() -> Converter.commaStringToLotto("1,2,3,4,5,100"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Converter.commaStringToLotto("0,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호는 오름차 순으로 정렬된다.")
    @Test
    void sortLottoNumberAsAscending(){
        Lotto lotto = Converter.listIntToLotto(List.of(6,5,4,3,2,1));
        assertThat(lotto.getNumber(0)).isEqualTo(1);
        assertThat(lotto.getNumber(1)).isEqualTo(2);
        assertThat(lotto.getNumber(2)).isEqualTo(3);
        assertThat(lotto.getNumber(3)).isEqualTo(4);
        assertThat(lotto.getNumber(4)).isEqualTo(5);
        assertThat(lotto.getNumber(5)).isEqualTo(6);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호의 범위(1~45)를 벗어나면 예외가 발생한다.")
    @Test
    void createLBonusNumberOutOfRange(){
        assertThatThrownBy(() -> Converter.stringToLottoNumber("0"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Converter.stringToLottoNumber("-1"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Converter.stringToLottoNumber("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호와 당첨 번호에 중복값이 있으면 예외가 발생한다.")
    @Test
    void createDuplicatedWinningBetweenBonus(){
        assertThatThrownBy(() -> {
            Lotto winning = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            LottoValidator.checkWinnerAndBonusDuplicatedNumber(winning,5);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 로또 번호 비교 결과 1등")
    @Test
    void compareWinningAndLotto_1st(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto winning = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Integer bonus = 7;
        LottoResult lottoResult = Judge.compareLottoToWinningNumber(lotto, winning, bonus);
        assertThat(lottoResult.getNumberOfMatch()).isEqualTo(Rank.SIX_MATCH.getNumberOfMatch());
    }

    @DisplayName("당첨 번호와 로또 번호 비교 결과 2등")
    @Test
    void compareWinningAndLotto_2st(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto winning = new Lotto(List.of(1,2,3,4,5,10));
        Integer bonus = 6;
        LottoResult lottoResult = Judge.compareLottoToWinningNumber(lotto, winning, bonus);
        assertThat(lottoResult.getNumberOfMatch()).isEqualTo(Rank.FIVE_MATCH_BONUS.getNumberOfMatch());
        assertThat(lottoResult.getBonus()).isEqualTo(Rank.FIVE_MATCH_BONUS.getBonus());
    }

    @DisplayName("당첨 번호와 로또 번호 비교 결과 3등")
    @Test
    void compareWinningAndLotto_3st(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto winning = new Lotto(List.of(1, 2, 3, 4, 5, 10));
        Integer bonus = 10;
        LottoResult lottoResult = Judge.compareLottoToWinningNumber(lotto, winning, bonus);
        assertThat(lottoResult.getNumberOfMatch()).isEqualTo(Rank.FIVE_MATCH.getNumberOfMatch());
        assertThat(lottoResult.getBonus()).isNotEqualTo(Rank.FIVE_MATCH_BONUS.getBonus());

    }

    @DisplayName("순위권에 도달한 로또는 결과에 저장한다.")
    @Test
    void saveWinningLotto(){
        LottoResultWinners lottoResultWinners = new LottoResultWinners();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winning = new Lotto(List.of(1, 2, 3, 43, 44, 45));
        Integer bonus = 7;

        LottoResult lottoResult = Judge.compareLottoToWinningNumber(lotto,winning,bonus);
        lottoResultWinners.add(lottoResult);
        assertThat(lottoResultWinners.getNumberOfAllWinner()).isEqualTo(1);
    }

    @DisplayName("순위권에 없는 로또는 결과에 저장하지 않는다.")
    @Test
    void doNotSaveUnwinnedLotto(){
        LottoResultWinners lottoResultWinners = new LottoResultWinners();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winning = new Lotto(List.of(1, 2, 42, 43, 44, 45));
        Integer bonus = 7;

        LottoResult lottoResult = Judge.compareLottoToWinningNumber(lotto,winning,bonus);
        lottoResultWinners.add(lottoResult);
        assertThat(lottoResultWinners.getNumberOfAllWinner()).isEqualTo(0);

    }

    @DisplayName("당첨되지 않은 로또는 0개, 당첨된 로또는 1개 이상이다.")
    @Test
    void findLottoWinner(){
        LottoResultWinners lottoResultWinners = new LottoResultWinners();
        lottoResultWinners.add(new LottoResult(Rank.SIX_MATCH.getNumberOfMatch(),Rank.SIX_MATCH.getBonus()));
        lottoResultWinners.add(new LottoResult(Rank.FIVE_MATCH_BONUS.getNumberOfMatch(),Rank.FIVE_MATCH_BONUS.getBonus()));
        lottoResultWinners.add(new LottoResult(Rank.FIVE_MATCH_BONUS.getNumberOfMatch(),Rank.FIVE_MATCH_BONUS.getBonus()));
        lottoResultWinners.add(new LottoResult(Rank.THREE_MATCH.getNumberOfMatch(),Rank.THREE_MATCH.getBonus()));

        assertThat(lottoResultWinners.getNumberOfRankWinner(Rank.SIX_MATCH)).isEqualTo(1);
        assertThat(lottoResultWinners.getNumberOfRankWinner(Rank.FIVE_MATCH)).isEqualTo(0);
        assertThat(lottoResultWinners.getNumberOfRankWinner(Rank.FIVE_MATCH_BONUS)).isEqualTo(2);
        assertThat(lottoResultWinners.getNumberOfRankWinner(Rank.THREE_MATCH)).isEqualTo(1);
    }

    @DisplayName("당첨된 로또들의 상금을 종합한다.")
    @Test
    void sumPrizeMoney(){
        LottoResultWinners lottoResultWinners = new LottoResultWinners();
        lottoResultWinners.add(new LottoResult(Rank.FIVE_MATCH_BONUS.getNumberOfMatch(),Rank.FIVE_MATCH_BONUS.getBonus()));
        lottoResultWinners.add(new LottoResult(Rank.THREE_MATCH.getNumberOfMatch(),Rank.THREE_MATCH.getBonus()));

        TotalPrizeMoney totalPrizeMoney = TotalPrizeMoney.findTotalPrizeMoney(lottoResultWinners);
        assertThat(totalPrizeMoney.getTotalPrizeMoney()).isEqualTo(30005000);
    }

    @DisplayName("수익률을 구한다.")
    @Test
    void findEarningRate(){
        Integer money = 3000;LottoResultWinners lottoResultWinners = new LottoResultWinners();
        lottoResultWinners.add(new LottoResult(Rank.THREE_MATCH.getNumberOfMatch(),Rank.THREE_MATCH.getBonus()));
        TotalPrizeMoney totalPrizeMoney = TotalPrizeMoney.findTotalPrizeMoney(lottoResultWinners);
        assertThat(totalPrizeMoney.getEarningRate(money)).isEqualTo(166.7);
    }

    @DisplayName("rank가 5개 매치 및 보너스에 해당되는지 확인한다.")
    @Test
    void checkFiveMatchBonus(){
        assertThat(Rank.isFiveMatchBonusRank(Rank.FIVE_MATCH_BONUS)).isEqualTo(true);
    }

}