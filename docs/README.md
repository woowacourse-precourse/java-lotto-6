# 로또 게임

## 요구사항

### 기능
* [x] 로또 구입 금액을 입력 받는다
  * 입력된 금액이 숫자가 아니거나 0보다 작으면 예외 발생
  * 입력된 금액이 로또 가격으로 나누어지지 않으면 예외 발생


* [x] 입력된 금액만큼 로또를 발행한다
  * 로또 조건 만족해야함 


* [x] 당첨 번호를 입력 받는다 
  * 로또 조건 만족해야함


* [x] 보너스 번호 1개를 입력 받는다
  * 입력한 당첨 번호와 중복되면 안되며 1 ~ 45 사이여함


* [x] 로또 번호를 비교해 당첨 내역과 수익률을 계산한다
  * 수익률은 소수점 둘째 자리에서 반올림
  * 1등 부터 5등까지 있다
    * 1등 : 6개 일치 / 2000000000원
    * 2등 : 5개 일치 + 보너스 번호 일치 / 30000000원 
    * 3등 : 5개 일치 / 1500000원
    * 4등 : 4개 일치 / 50000원
    * 5등 : 3개 일치 / 5000원


* 로또 조건
    * 로또는 1 ~ 45 사이의 숫자 6개로 이루어진다
    * 로또는 중복된 숫자를 가질 수 없다
    * 로또는 숫자가 오름차순으로 정렬되어야 한다


* 사용자가 잘못된 값을 입력할 경우 예외를 발생시키고 해당 부분부터 입력을 다시 받는다.
  * 예외는 명확한 유형이어야 한다
  * "[ERROR]"로 시작하는 에러 메시지를 출력한다

### 커밋 컨벤션

git commit type : git commit message

```
feat (feature) 
fix (bug fix) 
docs (documentation) 
style (formatting, missing semi colons, …) 
refactor 
test (when adding missing tests) 
chore (maintain)
```

[Angular Js Commit Convention](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 차용
