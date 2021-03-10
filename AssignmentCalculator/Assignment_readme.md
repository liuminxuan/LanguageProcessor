#### Interpreter & compiler
- Interpreter can translate one statement at a time. Compiler scans the entire program and translates it as a whole into machine code.
- Interpreters usually take less amount of time to analyze the source code. However, the overall execution time is comparatively slower than compilers. Compilers usually take a large amount of time to analyze the source code. However, the overall execution time is comparatively faster than interpreters.
- Interpreter has no intermediate object code is generated, hence are memory efficient. Compiler generates intermediate object code which further requires linking, hence requires more memory.

#### VirtualMachine
In this project, Interpreter and Compiler are both parts of VirtualMachine.

Interpreter use VirtualMachine to directly get result from parse tree. Compiler firstly uses VirtualMachine to compile source code and get code list.

![avator](A11.png)

