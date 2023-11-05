# 1. 입력 기능 구현
  - 입력 기능을 담당하는 LottoInput 클래스를 만든다.
  - LottoInput 클래스에 구입 금액을 입력받는 getPurchaseAmount 메소드를 추가한다.
  - getPurchaseAmount 메소드에서 사용자가 1000원 단위로 나누어떨어지지 않는 금액을 입력했을 경우 IllegalArgumentException을 발생시키는 validatePurchaceAmount 메소드를 추가한다.
  - LottoInput 클래스에 당첨 번호를 입력받는 getWinningNumber 메소드를 추가한다.
  - LottoInput 클래스에 보너스 번호를 입력받는 getBonusNumber 메소드를 추가한다.
  - getWinningNumber 메소드와 getBonusNumber 메소드에서 입력 번호가 1-45 안의 범위가 아닐 경우 IllegalArgumentException을 발생시키는 validateNumberRange 메소드를 추가한다.
  - getWinningNumber 메소드와 getBonusNumber 메소드에서 입력 번호가 겹치는 경우 IllegalArgumentException을 발생시키는 validateNumverDuplication 메소드를 추가한다.