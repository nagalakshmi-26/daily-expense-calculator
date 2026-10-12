@echo off
echo Compiling Daily Expense Calculator...
javac src/*.java
if %ERRORLEVEL% equ 0 (
    echo Launching application...
    java src.Main
) else (
    echo Compilation failed!
)
pause
