# run in powershell: powershell -ExecutionPolicy ByPass -File .\compile.ps1 
# or
# javac main.java logex\*.java -encoding UTF-8
# java main 

$CC = javac main.java logex\*.java -encoding UTF-8
$run = java main


function Compile{
    return $CC
}
# iex는 명령어를 실행하는 명령
# iex $compile한 결과를 $success에 반환
$CC
$run