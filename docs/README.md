## 목표
입력한 금액만큼 로또를 구매하고 중복되지 않는 6개의 숫자와 보너스 번호를 입력받아 당첨 로또를 정해주면
1등~5등까지 개수와 총 수익률을 보여주도록 하는 게임을 만들자.
다만, 메소드가 15라인을 넘지 않도록 구현하며 else를 사용하지 않는다.

## 기능 목록
- 구입 금액 입력
  - 1000 단위로 정확히 나누어 떨어지지 않는 다면 `IllegalArgumentException` 발생
  - 숫자 이외의 값의 경우 `IllegalArgumentException` 발생
- 구입한 개수만큼 로또 출력
- 당첨 번호 입력
  - 1~45 이외의 값을 입력하는 경우 `IllegalArgumentException` 발생
  - 숫자 이외의 값을 입력하는 경우 `IllegalArgumentException` 발생
- 보너스 번호 입력
  - 1~45 이외의 값을 입력하는 경우 `IllegalArgumentException` 발생
- 당첨 통계
- 수익률 계산
- `IllegalArgumentException` 예외 발생시 "[ERROR]" 메시지 포함하도록 구현 후 해당 부분부터 다시 진행