@echo off
echo Running Travel Management System...

:: Find the MySQL JAR file in the 'lib' folder
set CLASSPATH=
for /f "delims=" %%a in ('dir /b /s "lib\*.jar"') do set CLASSPATH=%%a

:: Run the main class (Login)
:: We set the classpath to include:
:: 1. "bin" (for .class files)
:: 2. "src" (for .png/.jpg resource files)
:: 3. "%CLASSPATH%" (for the MySQL JAR)
java -cp "bin;src;%CLASSPATH%" travel.management.system.Login

echo Program finished.
pause