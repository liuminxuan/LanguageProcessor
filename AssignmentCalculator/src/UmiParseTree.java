import java.util.*;
public class UmiParseTree implements ExpParseTree{
    private ExpParseTree ept1;
    public UmiParseTree(ExpParseTree e1) {
        ept1 = e1;
    }

    @Override
    public List<Command> compile() {
        // TODO Auto-generated method stub
        List<Command> cl;
        cl = ept1.compile();
        cl.add(new Command(CommandName.MONE));
        return cl;
    }

    @Override
    public int interpret(Map<String, Integer> env) throws InterpreterException {
        // TODO Auto-generated method stub
        int n1 = ept1.interpret(env);
        return - n1;
    }

    public String toString() {
        return "umi(" + ept1 + ")";
    }
}
