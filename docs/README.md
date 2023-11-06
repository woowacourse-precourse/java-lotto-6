## MVC 패턴을 사용하여 구현
> lotto 클래스(구현전에 명시되어있음)
> >- 로또 번호를 입력 받는다(InputView)

>MODEL:
>> EnumRanking
>> - 등수를 차례대로 RANKING_ARR에 집어넣는다
>> - 당첨을 cnt 5기준으로 2등과 3등을 나눈다, 그 외의 cnt는 개별적으로 함수를만들었음
>> - 당첨금을 나눈 토대로 합산을해 출력한다
>>
> 
>> Player
>>
>>- Player의 멤버변수로 사용할 total(합계)과 matchPoint(번호가 맞을 경우 개수를 여기에 갱신) priec(구입한 금액), count(구입한 금액 / 1000) 횟수 로 나눈다
>>- Player의 메서드에는 값을 업데이트 해주는 기능을 만든다
>>- 초기 price를 입력받는다(InputView)
> 
> 
>CONTROLLER:
>>ControlMain
>>> buyLotto
>>>-  player에서 횟수를 받아 로또를 산다
>>>
>>>
>>>setChoiceLottoNum
>>>- Lotto 클래스를 활용하여 lotto번호 6개를 입력받는다(InputView)
>>>
>>>
>>> bonusNumAdd
>>>
>>>- Lotto 클래스의 Numbers 값과 중복되지 않은 보너스 번호를 입력받는다 (InputView)
>>>
>>>
>>> equalsLottoNum
>>>
>>>- 당첨 번호랑 보너스 번호를 받은 결과를 토대로 같은 값이 몇개 있는지 반환한다 (여기서 ENUM을 활용)
>>>
>>> variableTry
>>>
>>>- 에러값이 반환되면 정상입력 될때까지 시도해준다
> 
>> ErroCheck
>>>- 예외가 생길수있는 입력값을 체크한다(중복, 공백, 값의 범위, 정수 등등)
>
>VIEW:
>> InputView
>>- 로또 구입 금액을 입력받는다 
>>- 당첨 번호를 입력받는다
>>- 보너스 번호를 입력받는다
>>
> 
>> OutputView
>>
>>- 모든 출력을 담당한다
>
> > ErrorMessage
> >- [ERROR]문을 출력해준다 (예외 발생목록)
> >- 중복, 공백, 값의 범위, 정수 등


> 예외테스트 추가 사항   
> 중복값 공백 값의범위 정수등 숫자를 이용해 에러를 유도해준다 그 값에 해당되는 에러일 경우 성공
> 