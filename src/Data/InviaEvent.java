package Data;

import java.util.EventObject;

public class InviaEvent extends EventObject {

    boolean checkOk;
    public InviaEvent(Object source){
        super(source);
    }

    public InviaEvent(Object source, boolean checkOk){
        super(source);
        this.checkOk = checkOk;
    }

    public boolean isCheckOk(){
        return checkOk;
    }

}
