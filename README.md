# LanguageProcessor
Using Virtual Machine to interpret and compile simple program

## Interpreter & compiler
- Interpreter can translate one statement at a time. Compiler scans the entire program and translates it as a whole into machine code.
- Interpreters usually take less amount of time to analyze the source code. However, the overall execution time is comparatively slower than compilers. Compilers usually take a large amount of time to analyze the source code. However, the overall execution time is comparatively faster than interpreters.
- Interpreter has no intermediate object code is generated, hence are memory efficient. Compiler generates intermediate object code which further requires linking, hence requires more memory.

## VirtualMachine
In this project, Interpreter and Compiler are both parts of VirtualMachine.

Interpreter use VirtualMachine to directly get result from parse tree. Compiler firstly uses VirtualMachine to compile source code and get code list.

## Assignment calculator
https://liuminxuan.github.io/2021/01/28/%E3%80%90%E5%B0%8F%E9%A1%B9%E7%9B%AE%E3%80%91Java%E5%AE%9E%E7%8E%B0%E7%BC%96%E8%AF%91%E5%99%A8%E5%92%8C%E8%A7%A3%E9%87%8A%E5%99%A8/



