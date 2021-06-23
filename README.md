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

#Mini language Processer(Minila processer)
Front end of Minila processor
Feeding a program in Minila (a source code) into the Minila processor, the source code is stored as an object of class SourceCode. The object makes a list of tokens from sc by receiving the message scan(). A list of tokens is represented as an object of class TokenList. The object makes a parse tree from the list of tokens if the input program obeys the Minila syntax; displays a syntax error message otherwise. A parse tree is represented as an object of one of concrete classes that extends the abstract class StmParseTree.

## Minila Interpreter
Interpreter can translate one statement at a time.

### EmptyParseTree.java
When an object of EmptyParseTree receives interpret(env), it just returns env.

### AssignParseTree.java
When an object of AssignParseTree receives interpret(env),

it sends interpret(env) to exp and obtains the result val,
modifies env such that val is associated with the name of var, making a new environment env', and
returns env'.
### IfParseTree.java
When anIf receives interpret(env1), it sends interpret(env1) to aGt and gets 1; This is why it sends interpret(env1) to anAssign and gets env2; it then returns env2. When anIf receives interpret(env3), it sends interpret(env3) to aGt and gets 0; This is why it sends interpret(env3) to anEmp and gets env3; it then returns env3.

### WhileParseTree
When aWhile receives interpret(env1), it sends interpret(env1) to anNeq and gets 1; This is why it sends interpret(env1) to anAssign and gets env2; it then sends interpret(env2) to itself and gets env3; it finally returns env3. When aWhile receives interpret(env2), it sends interpret(env2) to anNeq and gets 1; This is why it sends interpret(env2) to anAssign and gets env3; it then sends interpret(env3) to itself and gets env3; it finally returns env3. When aWhile receives interpret(env3), it sends interpret(env3) to anNeq and gets 0; This is why it returns env3.

## Minila Compiler
Compiler scans the entire program and translates it as a whole into machine code.

### EmptyParseTree.java
When an object of EmptyParseTree receives compile(), it makes an object of ArrayList (the empty list of commands) and returns the object.

### AssignParseTree.java
When an object of AssignParseTree receives compile(),

it sends compile() to exp and obtains the list cl of commands for exp,
adds cmd to cl at the end, and
returns cl.
### IfParseTree.java
When an object of IfParseTree receives compile(),

it sends compile() to exp, stm1 & stm2 to obtain the lists cl1, cl2 & cl3 of commands,
adds cmd1 & cmd2 to cl1 at the end in this order,
appends cl2 to cl1 at the end,
adds cmd3 to cl1 at the end,
appends cl3 to cl1 at the end, and
returns cl1.
### WhileParseTree
When an object of WhileParseTree receives compile(),

it sends compile() to exp & stm to obtain the lists cl1 & cl2 of commands,
adds cmd1 & cmd2 to cl1 at the end in this order,
appends cl2 to cl1 at the end,
adds cmd3 to cl1 at the end, and
returns cl1.
## Virtual Machine
Using stack to process commands.

name = LT
if n1 < n2 returns 1, otherwise returns 0.

name = GT
if n1 > n2 returns 1, otherwise returns 0.

name = EQ
if n1 = n2 returns 1, otherwise returns 0.

name = NEQ
if n1 != n2 returns 1, otherwise returns 0.

name = AND
if n1 != 0 and n2 != 0 returns 1, otherwise returns 0

name = OR
if n1 != 0 or n2 != 0 returns 1, otherwise returns 0

  



