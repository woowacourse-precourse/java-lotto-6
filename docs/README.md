# 구현 기능 목록

---
## Prize Enum

- 각 Enum constant 는 prizePrice(상금)을 가지고 있다.
  - FIRST_PRIZE : 2,000,000,000 (6개 번호 일치)
  - SECOND_PRIZE : 30,000,000 (5개 번호 + 보너스 번호 일치)
  - THIRD_PRIZE : 1,500,000 (5개 번호 일치)
  - FOURTH_PRIZE : 50,000 (4개 번호 일치)
  - FIFTH_PRIZE : 5,000 (3개 번호 일치)
  - FAIL : 0 (2개 번호 이하 일치)
## Lotto Class

- validate method
  - 로또 번호가 6개의 숫자로 이루어져 있는지 확인한다.
  - 로또 번호가 6개가 아닐 시 IllegalArgumentException 을 throw 한다.
  - 로또 번호가 겹치는 번호가 존재할 경우 IllegalArgumentException 을 throw 한다.
  - 로또 번호가 1 ~ 45 사이의 번호가 아닐 경우 IllegalArgumentException 을 throw 한다.
- generateLotto method
  - 1 ~ 45 의 오름차순 숫자 6개를 List 형태로 생성한다.
- matchWithBonusNumber method
  - 현재 로또가 파라미터로 주어진 보너스 번호와 일치하는 번호가 있는지 확인한다.
- getScore method
  - 현재 로또가 파라미터로 주어진 1등 로또 번호와 보너스 번호의 기준으로 몇등을 했는지 확인한다.
- toString method
  - 콘솔에 출력할 로또의 번호를 출력할 양식을 반환한다.
## LottoConsole Class

- spendMoney variable
  - 로또를 구매한 금액이다.
- paidLottoCount variable
  - 구입한 로또의 개수이다.
- paidLottos variable
  - 구매한 로또들이다.
- winningLotto variable
  - 1등 로또 번호를 가진 로또이다.
- bonusNumber variable
  - 보너스 번호이다.
- scores variable
  - 구입한 로또의 당첨 내역 리스트이다.
  - 인덱스 순서대로 [1등, 2등, 3등, 4등, 5등, 낙첨] 이다.
- earnedMoney variable
  - 당첨된 로또들의 당첨금 합이다.
- LottoConsole Constructor
  - 멤버 변수들을 초기화 시켜준다.
- play method
  - 로또 게임을 수행하는 메서드이다.
- getSpendMoney method
  - 로또를 구매한 비용을 입력 받는다.
  - 정수인 숫자가 아닌 값을 입력하면 IllegalArgumentException 이 발생하고 메서드가 다시 실행된다.
  - 음의 수가 입력되면 IllegalArgumentException 이 발생하고 메서드가 다시 실행된다.
  - 1,000으로 나눠떨저지지 않는 수를 입력하면 IllegalArgumentException 이 발생하고 메서드가 다시 실행된다.
- buy method
  - 구매 가능한 로또 개수만큼 로또를 구매한다.
- getWinningLotto method
  - 당첨 로또 번호를 입력 받는다.
  - 쉼표(,) 로 구분되는 6개의 정수로 입력이 되지 않는 경우 NumberFormatException 이 발생하여 다시 IllegalArgumentException 을 발생시켜 예외 문구를 출력하고 메서드가 다시 실행된다.
  - 주어진 정수로 Lotto 객체를 만들고 그 과정에서 IllegalArgumentException 이 발생하는 경우 메서드가 다시 실행된다.
- getBonusNumber method
  - 보너스 번호를 입력 받는다.
  - 보너스 번호가 정수 형태로 입력되지 않는경우 NumberFormatException 가 발생하며 IllegalArgumentException 를 다시 발생시켜 예외 문구를 출력하고 메서드가 다시 실행된다.
  - 보너스 번호가 1~45 사이의 정수가 아닌 경우 IllegalArgumentException 가 발생하며 예외 문구가 출력되며 메서드가 다시 실행된다.
  - 보너스 번호가 1등 당첨 로또 번호에 들어있는 경우 IllegalArgumentException 가 발생하며 예외 문구가 출력되며 메서드가 다시 실행된다.
- getScores method
  - 구매한 로또들의 당첨 내역을 계산한다.
- getEarnedMoney method
  - 구매한 로또들의 당첨금의 합을 계산한다.
- showTotalScore method
  - 로또의 당첨 통계와 수익률을 출력한다.
## LottoTest Class

- matchWithBonusNumber Test
  - 보너스 번호가 로또의 번호들에 들어있는지 확인 하는 함수 matchWithBonusNumber 을 테스트한다.
- getScore Test
  - 로또의 당첨 내역을 계산하는 함수 getScore 을 테스트한다.