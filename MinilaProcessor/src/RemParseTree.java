
import java.util.*;

public class RemParseTree implements ExpParseTree {
    private ExpParseTree ept1, ept2;
    public RemParseTree(ExpParseTree e1, ExpParseTree e2){
        ept1 = e1;
        ept2 = e2;
    }
    @Override
    public List<Command> compile() {
        // TODO Auto-generated method stub
        List<Command> cl;
        cl = ept1.compile();
        cl.addAll(ept2.compile());
        cl.add(new Command(CommandName.REM));
        return cl;
    }

    @Override
    public int interpret(Map<String, Integer> env) throws InterpreterException {
        // TODO Auto-generated method stub
        int n1 = ept1.interpret(env);
        int n2 = ept2.interpret(env);
        return n1 % n2;
    }
    
    public String toString() {
        return "rem(" + ept1 + "," + ept2 + ")";
    }
}
