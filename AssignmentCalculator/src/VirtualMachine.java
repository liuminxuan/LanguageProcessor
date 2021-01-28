/**
 * 2010200 LiuMinxuan 2021.1.15
 */
import java.util.*;
public class VirtualMachine {
    private List<Command> comList; 
    private int pc; 
    private Stack<Integer> stk;
    private Map<String,Integer> env;

    public VirtualMachine(List<Command> cl) { 
        comList = cl; 
    }
    public void reset(int pc, Stack<Integer> stk,  Map<String,Integer> env) { 
        this.pc = pc; 
        this.stk = stk; 
        this.env = env;
    }
    public List<Command> getComList() { 
        return comList; 
    }
    public Map<String,Integer> run() throws VMException {
        while (true) {
            if (pc < 0 || pc >= comList.size()) {
                throw new VMException(pc,comList.size()); 
            }
        Command com = comList.get(pc);
        Integer x, x1, x2;
        switch (com.getName()) {
            case PUSH:
                stk.push(com.getNum());
                pc++;
                break;
            case LOAD:
                if (!env.containsKey(com.getVar())) {
                  throw new VMException(com.getVar());
                }
                x = env.get(com.getVar());
                stk.push(x);
                pc++;
                break;
            case STORE:
                if (stk.size() < 1) {
                  throw new VMException(stk);
                }
                x = stk.pop();
                env.put(com.getVar(), x);
                pc++;
                break;
            case ADD:
                if (stk.size() < 2) {
                    throw new VMException(stk);
                }
                x2 = stk.top();
                stk.pop();
                x1 = stk.top();
                stk.pop();
                x = x1 + x2;
                stk.push(x);
                pc++;
                break;
            case SUB:
                if (stk.size() < 2) {
                    throw new VMException(stk);
                }
                x2 = stk.top();
                stk.pop();
                x1 = stk.top();
                stk.pop();
                x = x1 - x2;
                stk.push(x);
                pc++;
                break;
            case MUL:
                if (stk.size() < 2) {
                    throw new VMException(stk);
                }
                x2 = stk.top();
                stk.pop();
                x1 = stk.top();
                stk.pop();
                x = x1 * x2;
                stk.push(x);
                pc++;
                break;
            case MONE:
                if (stk.size() < 1) {
                  throw new VMException(stk);
                }
                x1 = stk.top();
                stk.pop();
                x = -x1;
                stk.push(x);
                pc++;
                break;
            case REM:
                if (stk.size() < 2) {
                  throw new VMException(stk);
                }
                x2 = stk.top();
                stk.pop();
                x1 = stk.top();
                stk.pop();
                x = x1 % x2;
                stk.push(x);
                pc++;
                break;
            case QUO:
                if (stk.size() < 2) {
                    throw new VMException(stk);
                }
                x2 = stk.top();
                stk.pop();
                x1 = stk.top();
                stk.pop();
                if (x2 == 0) {
                    throw new VMException();
                }
                x = x1 / x2;
                stk.push(x);
                pc++;
                break;
            case QUIT:
                if (stk.size() != 0) {
                    throw new VMException(stk,stk.size());
                }
                return env;
            default:
                throw new IllegalStateException("pc1: " + pc + "cl1: " + comList);
            }
        } 
    }
    public String toString() {
        return "vm()";
    }
}
