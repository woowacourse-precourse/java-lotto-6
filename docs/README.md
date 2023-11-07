# 구현할 기능 목록
<hr/>

### Lotto 클래스
> 로또 번호 관련 동작을 수행하는 클래스
> > 필드 :
> > + List numbers

##### Lotto(numbers) 생성자
+ validate 함수를 호출해 번호가 6개인지 확인함
+ numbers에 번호를 저장함
+ 번호를 오름차순으로 정렬함

##### void validate(numbers)  
+ 로또 번호가 6개가 아니라면 IllegalArgumentException 발생시킴

##### int countMatch(Lotto)
+ retainAll 메소드를 사용해 당첨 번호와 일치하는 번호 개수 반환

##### String toString
+ toString 오버라이드해서 출력 형식 맞춤

### Bonus 클래스
> 보너스 번호 관련 동작을 수행하는 클래스
> > 필드 :
> > + int number

##### Bonus(number, Lotto) 생성자
+ validate 함수를 호출함
+ number에 번호를 저장함

##### void validate(number, Lotto)
+ 보너스 번호와 당첨 번호가 중복된다면 IllegalArgumentException 발생시킴

##### boolean isBonusMatch(Lotto)
+ 보너스 번호가 로또 번호에 포함 되는지 여부 반환

### enum WinningDetails 클래스
> 숫자 일치 개수와 상금 포함

### Controller 클래스
> 프로그램을 전체적으로 제어하는 클래스
> > 필드 :
> > + Input input
> > + Output output
> > + Lotto winning
> > + Bonus bonus
> > + List<Lotto//> lottoes
> > + int amount

##### void start()
+ getLottoNumbers 함수 호출
+ getWinningNumbers 함수 호출

+ 크기 5의 배열 선언 (0 초기화)
+ getIndex 호출 후 해당 인덱스 1씩 증가 -> 모든 로또에 대해 반복
+ output.printWinnings 함수 호출
+ getRevenue 함수 호출 후 revenue 저장
+ output.printRevenue 함수 호출

##### void getLottoNumbers()
+ input.inputAmount 함수를 호출하고 amount에 저장함
+ 로또 살 개수만큼 로또 랜덤 생성 반복하고 lottoes에 저장
+ output.printLottoes 함수 호출

##### void getWinningNumbers()
+ input.inputNumbers 함수를 호출하고 winning에 저장함
+ input.inputBonus 함수 호출 후 bonus에 저장

##### int getIndex(Lotto)
+ lotto.countMatch 함수와 bonus.isBonusMatch 함수를 이용해 인덱스 반환

##### double getRevenue(int[])
+ 획득한 상금을 구하고 amount로 나누어 revenue를 반환함

### Input 클래스
> 데이터들을 입력받는 클래스

##### int inputAmount()
+ 로또 구입 금액을 입력받음
+ validateAmount 함수를 호출함

##### void validateAmount(amount)
+ 금액이 1000원 단위로 나누어 떨어지지 않는다면 IllegalArgumentException 발생시킴

##### List inputNumbers()
+ 당첨 번호를 입력 받음
+ validateNumber 함수를 호출함
+ 에러가 발생하지 않으면 무한루프를 멈춤

##### void validateNumber(num)
+ 번호가 1부터 45 사이의 숫자가 아니라면 IllegalArgumentException 발생시킴

##### List splitNumbers(str)
+ str을 ","를 기준으로 나누어 리스트에 추가하고 반환함

##### int inputBonus()
+ 보너스 번호를 입력 받음

### Output 클래스
> 데이터들을 출력하는 클래스

##### void printLottoes(List(Lotto))
+ 로또 번호들을 출력함

##### void printWinnings(int[])
+ 상금과 등수를 출력함

##### void printRevenue(double)
+ 수익률을 출력함

##### void printError(e)
+ 에러 문구를 출력함

### Application 클래스
> 프로그램을 시작시키는 클래스