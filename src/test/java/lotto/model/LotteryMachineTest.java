package lotto.model;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import lotto.model.enums.WinningMoney;
import lotto.util.NumbersGenerator;
import lotto.util.TestFixNumbersGenerator;
import lotto.util.TestRandomNumbersGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryMachineTest {

  private NumbersGenerator randomNumbersGenerator;
  private NumbersGenerator fixNumbersGenerator;

  @BeforeEach
  void setup() {
    randomNumbersGenerator = new TestRandomNumbersGenerator();
    fixNumbersGenerator = new TestFixNumbersGenerator();
  }

  @Test
  @DisplayName("로또를 추첨한다.")
  void test() {
    int money = 22000;
    PurchaseMoney purchasedMoney = new PurchaseMoney(money);
    PersonLotto personLotto = new PersonLotto(randomNumbersGenerator, purchasedMoney);
    Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
    WinningLotto winningLotto = new WinningLotto(lotto);
    LotteryMachine lotteryMachine = new LotteryMachine(personLotto, winningLotto);

    int bonusNumber = 7;
    Bonus bonus = new Bonus(new Number(bonusNumber), winningLotto);

    Map<WinningMoney, Integer> store = lotteryMachine.drawingLotto(bonus);

    assertThat(store.size()).isGreaterThanOrEqualTo(1);
  }

  @Test
  @DisplayName("모든 로또는 꽝이다.")
  void testNonMatch() {
    int money = 6000;
    PurchaseMoney purchasedMoney = new PurchaseMoney(money);
    Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 31, 41, 42, 43)));
    WinningLotto winningLotto = new WinningLotto(lotto);
    PersonLotto personLotto = new PersonLotto(fixNumbersGenerator, purchasedMoney);
    LotteryMachine lotteryMachine = new LotteryMachine(personLotto, winningLotto);

    int bonusNumber = 6;
    Bonus bonus = new Bonus(new Number(bonusNumber), winningLotto);

    Map<WinningMoney, Integer> store = lotteryMachine.drawingLotto(bonus);

    assertThat(store.size()).isGreaterThanOrEqualTo(1);
    assertThat(store).containsEntry(WinningMoney.NON_MATCH, purchasedMoney.getPurchaseAmount());
    assertThat(store.get(WinningMoney.THREE_MATCH)).isNull();
    assertThat(store.get(WinningMoney.FOUR_MATCH)).isNull();
    assertThat(store.get(WinningMoney.FIVE_MATCH)).isNull();
    assertThat(store.get(WinningMoney.FIVE_MATCH_BONUS)).isNull();
    assertThat(store.get(WinningMoney.SIX_MATCH)).isNull();
  }

  @Test
  @DisplayName("모든 로또는 번호 3개 당첨이다.")
  void testOnlyTreeMatch() {
    int money = 6000;
    PurchaseMoney purchasedMoney = new PurchaseMoney(money);
    Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 23, 24, 25)));
    WinningLotto winningLotto = new WinningLotto(lotto);
    PersonLotto personLotto = new PersonLotto(fixNumbersGenerator, purchasedMoney);
    LotteryMachine lotteryMachine = new LotteryMachine(personLotto, winningLotto);

    int bonusNumber = 45;
    Bonus bonus = new Bonus(new Number(bonusNumber), winningLotto);

    Map<WinningMoney, Integer> store = lotteryMachine.drawingLotto(bonus);

    assertThat(store.size()).isGreaterThanOrEqualTo(1);
    assertThat(store).containsEntry(WinningMoney.THREE_MATCH, purchasedMoney.getPurchaseAmount());
    assertThat(store.get(WinningMoney.NON_MATCH)).isNull();
    assertThat(store.get(WinningMoney.FIVE_MATCH)).isNull();
    assertThat(store.get(WinningMoney.FIVE_MATCH_BONUS)).isNull();
    assertThat(store.get(WinningMoney.SIX_MATCH)).isNull();
  }

  @Test
  @DisplayName("모든 로또는 번호 4개 당첨이다.")
  void testOnlyFourMatch() {
    int money = 6000;
    PurchaseMoney purchasedMoney = new PurchaseMoney(money);
    Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 24, 25)));
    WinningLotto winningLotto = new WinningLotto(lotto);
    PersonLotto personLotto = new PersonLotto(fixNumbersGenerator, purchasedMoney);
    LotteryMachine lotteryMachine = new LotteryMachine(personLotto, winningLotto);

    int bonusNumber = 45;
    Bonus bonus = new Bonus(new Number(bonusNumber), winningLotto);

    Map<WinningMoney, Integer> store = lotteryMachine.drawingLotto(bonus);

    assertThat(store.size()).isGreaterThanOrEqualTo(1);
    assertThat(store).containsEntry(WinningMoney.FOUR_MATCH, purchasedMoney.getPurchaseAmount());
    assertThat(store.get(WinningMoney.NON_MATCH)).isNull();
    assertThat(store.get(WinningMoney.THREE_MATCH)).isNull();
    assertThat(store.get(WinningMoney.FIVE_MATCH)).isNull();
    assertThat(store.get(WinningMoney.FIVE_MATCH_BONUS)).isNull();
    assertThat(store.get(WinningMoney.SIX_MATCH)).isNull();
  }

  @Test
  @DisplayName("모든 로또는 번호 5개 당첨이다.")
  void testOnlyFiveMatch() {
    int money = 6000;
    PurchaseMoney purchasedMoney = new PurchaseMoney(money);
    Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 25)));
    WinningLotto winningLotto = new WinningLotto(lotto);
    PersonLotto personLotto = new PersonLotto(fixNumbersGenerator, purchasedMoney);
    LotteryMachine lotteryMachine = new LotteryMachine(personLotto, winningLotto);

    int bonusNumber = 45;
    Bonus bonus = new Bonus(new Number(bonusNumber), winningLotto);

    Map<WinningMoney, Integer> store = lotteryMachine.drawingLotto(bonus);

    assertThat(store.size()).isGreaterThanOrEqualTo(1);
    assertThat(store).containsEntry(WinningMoney.FIVE_MATCH, purchasedMoney.getPurchaseAmount());
    assertThat(store.get(WinningMoney.NON_MATCH)).isNull();
    assertThat(store.get(WinningMoney.THREE_MATCH)).isNull();
    assertThat(store.get(WinningMoney.FOUR_MATCH)).isNull();
    assertThat(store.get(WinningMoney.FIVE_MATCH_BONUS)).isNull();
    assertThat(store.get(WinningMoney.SIX_MATCH)).isNull();
  }

  @Test
  @DisplayName("모든 로또는 보너스 볼과 번호 5개 당첨이다.")
  void testFiveAndBonusMatch() {
    int money = 6000;
    PurchaseMoney purchasedMoney = new PurchaseMoney(money);
    Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 25)));
    WinningLotto winningLotto = new WinningLotto(lotto);
    PersonLotto personLotto = new PersonLotto(fixNumbersGenerator, purchasedMoney);
    LotteryMachine lotteryMachine = new LotteryMachine(personLotto, winningLotto);

    int bonusNumber = 6;
    Bonus bonus = new Bonus(new Number(bonusNumber), winningLotto);

    Map<WinningMoney, Integer> store = lotteryMachine.drawingLotto(bonus);

    assertThat(store.size()).isGreaterThanOrEqualTo(1);
    assertThat(store).containsEntry(WinningMoney.FIVE_MATCH_BONUS, purchasedMoney.getPurchaseAmount());
    assertThat(store.get(WinningMoney.NON_MATCH)).isNull();
    assertThat(store.get(WinningMoney.THREE_MATCH)).isNull();
    assertThat(store.get(WinningMoney.FOUR_MATCH)).isNull();
    assertThat(store.get(WinningMoney.FIVE_MATCH)).isNull();
    assertThat(store.get(WinningMoney.SIX_MATCH)).isNull();
  }

  @Test
  @DisplayName("모든 로또는 번호 6개 당첨이다.")
  void testOnlySixMatch() {
    int money = 6000;
    PurchaseMoney purchasedMoney = new PurchaseMoney(money);
    Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
    WinningLotto winningLotto = new WinningLotto(lotto);
    PersonLotto personLotto = new PersonLotto(fixNumbersGenerator, purchasedMoney);
    LotteryMachine lotteryMachine = new LotteryMachine(personLotto, winningLotto);

    int bonusNumber = 8;
    Bonus bonus = new Bonus(new Number(bonusNumber), winningLotto);

    Map<WinningMoney, Integer> store = lotteryMachine.drawingLotto(bonus);

    assertThat(store.size()).isGreaterThanOrEqualTo(1);
    assertThat(store).containsEntry(WinningMoney.SIX_MATCH, purchasedMoney.getPurchaseAmount());
    assertThat(store.get(WinningMoney.NON_MATCH)).isNull();
    assertThat(store.get(WinningMoney.THREE_MATCH)).isNull();
    assertThat(store.get(WinningMoney.FOUR_MATCH)).isNull();
    assertThat(store.get(WinningMoney.FIVE_MATCH)).isNull();
    assertThat(store.get(WinningMoney.FIVE_MATCH_BONUS)).isNull();
  }
}