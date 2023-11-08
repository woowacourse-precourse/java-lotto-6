package lotto.view;

import java.util.List;

/**
 * 사용자의 입력을 받는 View의 interface다.
 */
public interface InputView {
  /**
   * 단일 문자를 입력받는다.
   *
   * @return 입력받은 문자
   */
  String inputConstant();

  /**
   * 여러 개의 문자를 입력받는다.
   *
   * @return 구분자로 구분된 여러 개의 문자
   */
  List<String> inputList();
}
