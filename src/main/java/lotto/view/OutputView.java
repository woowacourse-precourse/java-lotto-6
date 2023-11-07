package lotto.view;

public interface OutputView {
  void printIntroduction(String introduction);

  void printNotBonusPrize(Integer prize, Integer count);

  void printBonusPrize(Integer prize, Integer count);
}
