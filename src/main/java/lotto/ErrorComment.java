package lotto;

public enum ErrorComment {
  PREFIX_ERROR_COMMENT("[ERROR] "),
  INPUT_1000_UNIT(PREFIX_ERROR_COMMENT.getComment() + "구입 금액은 1,000원 단위로 입력해 주셔야 합니다."),
  INPUT_INTEGER(PREFIX_ERROR_COMMENT.getComment() + "구입 금액은 정수로 입력해 주셔야 합니다."),
  NUMBER_OF_LOTTO_6(PREFIX_ERROR_COMMENT.getComment() + "로또 번호의 개수는 6개여야 합니다."),
  NOT_DUPLICATED_NUMBER(PREFIX_ERROR_COMMENT.getComment() + "로또 번호는 중복되지 않는 6개의 숫자여야 합니다."),
  ALL_LOTTO_NUMBERS_1_45(PREFIX_ERROR_COMMENT.getComment() + "6개의 당첨 번호는 모두 1부터 45 사이의 정수여야 합니다."),
  BONUS_NUMBER_NOT_DUPLICATED_NUMBER(PREFIX_ERROR_COMMENT.getComment() + "보너스 번호는 6개의 당첨 번호와 중복되지 않아야 합니다."),
  BONUS_NUMBER_1_45(PREFIX_ERROR_COMMENT.getComment() + "보너스 번호는 6개의 당첨 번호와 중복되지 않아야 합니다.");

  private final String comment;

  ErrorComment(String comment) {
    this.comment = comment;
  }

  public String getComment() {
    return comment;
  }
}
