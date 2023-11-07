#### 1. 구입금액 입력받기
- `camp.nextstep.edu.missionutils.Console`
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`
- [ERROR] 로또 1장의 가격은 1,000원입니다.

#### 2️. 사용자가 구입한 로또 발행하기
- `camp.nextstep.edu.missionutils.Randoms`
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`

#### 3. 당첨번호 입력받기
- `camp.nextstep.edu.missionutils.Console`
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`
- [ERROR] 6개의 숫자를 입력하셔야 합니다.
- [ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
- [ERROR] 중복된 번호를 입력하셨습니다.

#### 4. 보너스번호 입력받기
- `camp.nextstep.edu.missionutils.Console`
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`
- [ERROR] 1개의 숫자를 입력하셔야 합니다.
- [ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
- [ERROR] 당첨번호에 중복된 번호가 존재합니다.

#### 5. 사용자가 구매한 로또번호와 당첨번호 비교하기
- 당첨내역 출력

#### 6. 수익률 출력하기
- 수익률 = (당첨금액 / 구매금액) x 100
- 소수점 둘째 자리 반올림
