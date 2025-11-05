@echo off
echo Compiling project...

:: Create a 'bin' directory for compiled classes
if not exist bin mkdir bin

:: Find the MySQL JAR file in the 'lib' folder
set CLASSPATH=
for /f "delims=" %%a in ('dir /b /s "lib\*.jar"') do set CLASSPATH=%%a

echo Using Classpath: %CLASSPATH%

:: Compile all .java files from the 'src' directory into the 'bin' directory
javac -d bin -cp "%CLASSPATH%" src\travel\management\system\*.java

echo Compilation finished.
pause