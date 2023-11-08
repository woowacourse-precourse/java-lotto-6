## 🎰 로또 기능 명세서

### 📃구현 기능 목록
- 로또 생성
  - ✅ 로또 구입 금액을 입력받는다.
    - <span style="color:orange">[예외 사항]</span> 숫자가 아닌 경우 exception 발생시킨다.
    - <span style="color:orange">[예외 사항]</span> 음수인 경우 exception 발생시킨다.
    - <span style="color:orange">[예외 사항]</span> 1000원 단위가 아닌 경우 exception 발생시킨다.
    - <span style="color:orange">[예외 사항]</span> 공백을 입력할 경우 exception 발생시킨다.
    - exception이 발생하면 다시 입력을 받는다.
  - ✅ 로또 금액만큼 로또 객체를 할당한다.
    - 로또 번호가 오름차순이 아니라면 오름차순으로 정렬한다.
  - ✅ 할당한 로또 번호를 출력한다.
  - ✅ 당첨 번호와 보너스 번호를 입력받는다.
    - <span style="color:orange">[예외 사항]</span> 공백이 들어가면 exception 발생시킨다.
    - <span style="color:orange">[예외 사항]</span> 숫자가 아닌 값이 입력되면 exception 발생시킨다.
    - <span style="color:orange">[예외 사항]</span> 중복된 숫자가 입력되면 exception 발생시킨다.
    - <span style="color:orange">[예외 사항]</span> 숫자가 허용된 범위에서 벗어나면 exception 발생시킨다.
    - exception이 발생하면 다시 입력을 받는다.
-✅ 로또 게임 생성
  - 입력받은 당첨 번호와 보너스 번호를 가지는 로또 객체를 생성한다.
- 당첨 통계 출력
  - ✅ 로또 객체와 게임 객체의 값을 비교한다.
  - ✅ 당첨 결과를 출력한다
  - ✅ 결과를 바탕으로 수익률을 계산한다.
  - ✅ 수익률을 출력한다.