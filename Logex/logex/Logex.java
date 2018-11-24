package logex;
import java.util.regex.*;
import java.lang.String;

public class Logex{
    // member variable
    private Pattern p; 
    private Matcher m;

    //constructor
    public Logex(){

    }
    public void setExpression(String e, String txt){
        p = Pattern.compile(e);
        m = p.matcher(txt);
    }
    public void matching(StringBuilder s){
        while(m.find()){
            s.append(m.group(0));
        }
    }
}