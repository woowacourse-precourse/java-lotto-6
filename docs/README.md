# 기능 요구 사항
- [v] 로또 구입 금액을 입력 받는다
  - [v] 1,000원으로 나누어 떨어지지 않으면 IllegalArgumentException 예외를 발생시킨다.
  - [v] 0보다 같거나 작으면 IllegalArgumentException 예외를 발생시킨다.
  - [v] 숫자가 아닌 값을 입력해도 IllegalArgumentException 예외를 발생시킨다.
</br></br>
- [v] 발행한 로또 수량 및 번호를 출력한다.
  - [v] 발행한 로또 번호는 오름차순으로 정렬하여 보여준다.

- [v] 당첨 번호 6개를 입력받는다. 번호는 쉼표(,)를 기준으로 구분한다.
  - [v] 입력한 번호 중 중복값이 있으면 IllegalArgumentException 예외를 발생시킨다.
  - [v] 로또 번호의 숫자 범위(1~45)를 벗어나면 IllegalArgumentException 예외를 발생시킨다.
  - [v] 입력한 당첨 번호 중 숫자가 아닌 것이 있으면 IllegalArgumentException 예외를 발생시킨다.
  - [v] 쉼표 앞뒤로 공백은 제거한다.
  - [v] 입력한 숫자가 6개보다 작거나 크면 IllegalArgumentException 예외를 발생시킨다.
    </br></br>
- [v] 보너스 번호 1개를 입력받는다.
  - [v] 입력한 당첨 번호 중에 동일한 값이 있으면 IllegalArgumentException 예외를 발생시킨다.
  - [v] 로또 번호의 숫자 범위(1~45)를 벗어나면 IllegalArgumentException 예외를 발생시킨다.
  - [v] 입력한 보너스 번호 중 숫자가 아닌 것이 있으면 IllegalArgumentException 예외를 발생시킨다.
  - [v] 입력한 보너스 번호가 공백이면 IllegalArgumentException 예외를 발생시킨다.
</br></br>
- [v] 사용자가 구매한 로또 번호와 당첨 번호를 비교하여, 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
  - [v] 당첨 내역 개수를 출력한다.
  - [v] 수익률은 소수점 둘째 자리에서 반올림한다.
## 예외
- [v] 예외 메시지는 "[ERROR]"로 시작한다.
- [v] 사용자 입력값에 대한 예외가 발생하면 예외가 발생한 부분부터 다시 입력을 받는다.
- [] 객체 상태가 메서드 호출을 처리하기에 적절치 않을 때 IllegalStateException을 발생시킨다.

# 프로그래밍 요구 사항
- [v] 인덴트, 들여쓰기 depth는 2까지만 허용한다.
- [v] 3항 연산자를 쓰지 않는다.
- [v] 메서드는 한 가지 일만 하도록, 최대한 작게 만들어라
- [v] JUnit5과 AssertJ를 이용해서 구현한 기능이 정상 작동하는지 테스트 코드를 작성한다.
- [v] 메서드의 길이가 15라인을 넘지 않아야 한다.
- [v] else 예약어를 쓰지 않는다.
  - [v] if 조건절에서 값을 return 한다.
- [v] Enum을 사용한다.
- [v] 도메인 로직에 단위테스트를 구현한다.
- [v] 핵심 로직 부분과 UI를 담당하는 로직을 분리한다.
- [v] Random값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickUniqueNumbersInRange()를 활용한다.
- [v] 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.