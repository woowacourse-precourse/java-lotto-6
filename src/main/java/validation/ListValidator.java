package validation;

import java.util.List;

public class ListValidator {

  private ListValidator() {
  }

  public static void checkDuplicate(final List<?> list) {
    if (list.size() != list.stream()
        .distinct()
        .count()) {
      throw new IllegalArgumentException("[ERROR] : 중복된 값이 포함되어 있습니다.");
    }
  }
}
