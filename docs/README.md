# 1. 입력 기능 구현
  - 입력 기능을 담당하는 LottoInput 클래스를 만든다.
  - LottoInput 클래스에 구입 금액을 입력받는 getPurchaseAmount 메소드를 추가한다.
  - getPurchaseAmount 메소드에서 사용자가 1000원 단위로 나누어떨어지지 않는 금액을 입력했을 경우 IllegalArgumentException을 발생시키는 validatePurchaceAmount 메소드를 추가한다.
  - LottoInput 클래스에 당첨 번호를 입력받는 getWinningNumber 메소드를 추가한다.
  - LottoInput 클래스에 보너스 번호를 입력받는 getBonusNumber 메소드를 추가한다.
  - getWinningNumber 메소드와 getBonusNumber 메소드에서 입력 번호가 1-45 안의 범위가 아닐 경우 IllegalArgumentException을 발생시키는 validateNumberRange 메소드를 추가한다.
  - getWinningNumber 메소드와 getBonusNumber 메소드에서 입력 번호가 겹치는 경우 IllegalArgumentException을 발생시키는 validateNumverDuplication 메소드를 추가한다.
  
## 1-1 구현 중 수정사항
  - 주어진 Lotto 클래스에서 입력값을 검증하는 메소드가 존재하기 때문에, LottoInput 클래스에서 검증 기능을 담당하는 메소드를 Lotto 클래스로 이동시킨다.
  
## 1-2 입력 기능 테스트
  - 테스트는 각 검증이 제대로 이루어지는지 확인하는 것을 목표로 한다.
  - 1000으로 나누어 떨어지는 수가 입력되지 않았을 경우 IllegalArgumentException이 발생하는지 확인하는 테스트를 추가한다.
  - 당첨 숫자의 개수가 6이 아닌 입력이 들어왔을 경우 IllegalArgumentException이 발생하는지 확인하는 테스트를 추가한다.
  - 당첨 숫자의 범위가 1부터 45에 포함되지 않을 경우 IllegalArgumentException이 발생하는지 확인하는 테스트를 추가한다.
  - 중복된 당첨 숫자가 입력되었을 경우 IllegalArgumentException이 발생하는지 확인하는 테스트를 추가한다.
  - 보너스 숫자의 범위가 1부터 45에 포함되지 않을 경우 IllegalArgumentException이 발생하는지 확인하는 테스트를 추가한다.
  - 보너스 숫자가 기존에 입력된 당첨 번호와 중복될 경우 IllegalArgumentException이 발생하는지 확인하는 테스트를 추가한다.