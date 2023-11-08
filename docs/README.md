<h1> 🎰 로또 </h1>

- 작성자 : [GaGa-Kim](https://github.com/GaGa-Kim/java-lotto-6/tree/GaGa-Kim)
- 미션 진행 및 회고글 : [기술 블로그](https://gaga-kim.tistory.com/1677) (미션 종료 후 공개될 예정입니다.)

<br>

<h2> 📍 게임 설명 </h2>
<pre>
1) 로또 구입 금액을 입력하여 구입 금액에 해당하는 로또를 발행
2) 당첨 번호와 보너스 번호를 입력 받아 비교
3) 당첨 내역 및 수익률을 출력하고 로또 게임을 종료
</pre>

<br>

<h2> 🖨 출력 예시 </h2>

<pre>
구입금액을 입력해 주세요.
8000

8개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[1, 3, 5, 14, 22, 45]

당첨 번호를 입력해 주세요.
1,2,3,4,5,6

보너스 번호를 입력해 주세요.
7

당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
</pre>

<br>

<h2> 📄 구현할 기능 목록 </h2>
<pre>

**1) 게임이 시작되면 로또 구입 금액을 입력받기 위해 '구입금액을 입력해 주세요.'를 출력**

**2) 로또 구입 금액 저장**
로또 1장의 가격은 1000원이므로 1000원 단위로 입력 받으며 구입 금액에 해당하는 로또 수량 계산
**[예외]**
숫자가 아닐 때
1000원보다 작을 때
1000원으로 나누어 떨어지지 않을 때
→ 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고
&nbsp;&nbsp;'[ERROR]'로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받음

**3) 로또 발행**
1 ~ 45까지의 숫자를 가지고 중복되지 않은 6개의 숫자를 뽑아 구입한 로또 수량만큼 발행 로또 번호 오름차순 정렬

**4) 발행된 로또 출력**
오름차순으로 정렬된 로또 출력

**5) 당첨 번호를 입력받기 위해 '당첨 번호를 입력해 주세요.'를 출력**

**6) 당첨 번호 저장**
중복되지 않는 숫자 6개
**[예외]**
쉼표(,)로 구분되지 않을 때
1 ~ 45 범위의 숫자가 아닐 때 (문자, 음수, 소수, 0이 아닐 때)
숫자가 중복될 때 
→ 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고
&nbsp;&nbsp;'[ERROR]'로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받음

**7) 보너스 번호를 입력받기 위해 '보너스 번호를 입력해 주세요.'를 출력**

**8) 보너스 번호 저장**
당첨 번호와 중복되지 않는 숫자 1개
**[예외]**
1 ~ 45 범위의 숫자가 아닐 때 (문자, 음수, 소수, 0이 아닐 때)
당첨 번호와 중복될 때 
→ 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고
&nbsp;&nbsp;'[ERROR]'로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받음

**9) 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률 계산**
3개 일치, 4개 일치, 5개 일치, 5개 일치 및 보너스 볼 일치, 6개 일치 비교 계산
수익률 계산 = (총 수익 / 로또 구매 비용) * 100

**10) 당첨 통계 출력**

**11) 총 수익률 출력**
소수점 둘째 자리에서 반올림하여 출력
</pre>
<br>

<h2> 🗂 MVC 패턴을 적용한 디렉토리 구조 </h2>
<pre>

**model**
|- lotto
&nbsp;&nbsp;|- Lotto : 로또 객체 Domain
&nbsp;&nbsp;|- Player : 사용자 객체 Domain
&nbsp;&nbsp;|- PlayerAmount : 사용자의 로또 구매 수량 객체 Domain
&nbsp;&nbsp;|- Winning : 당첨 번호 객체 Domain
|- result
&nbsp;&nbsp;|- Prize : 상금 객체 Domain
&nbsp;&nbsp;|- Result : 결과 객체 Domain

**view**
|- InputView.java : 사용자 입력 View
|- OutputView.java : 사용자 출력 View

**controller**
|- MainController : 메인 시작 Controller
|- PlayerController : 사용자 관련 Controller
|- WinningController : 당첨 번호 관련 Controller
|- ResultController : 결과 관련 Controller

**exception**
|- InvalidNonNumericInputException : 숫자가 아닐 때 예외처리
|- InvalidCommaMissingException : 쉼표가 없을 때 예외처리
|- InvalidMinimumAmountException : 구입 금액의 최소 금액보다 작을 때 예외처리
|- InvalidDivisionAmountException : 구입 금액이 1000원 단위가 아니어서 나누어지지 않을 때 예외처리
|- InvalidDuplicateLottoNumberException : 로또 숫자 중복 예외처리
|- InvalidLottoNumberCountException : 로또 숫자 갯수 예외처리
|- InvalidLottoNumberRangeException : 로또 숫자 범위 예외처리

**utils**
|- Constant : 룰과 관련된 상수 Constant
|- Generator : 로또 발행값 생성 Util
|- InputParser : 입력값 형변환 Util
|- Validator : 입력 변수 예외처리 Util

**Application.java**
</pre>
