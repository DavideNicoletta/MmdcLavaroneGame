package UI.SecondaProva;

public class SecondaProvaModel {
    public SecondaProvaModel(){

    }

    public boolean checkOk(String string){
        if(string.equals("sqrt(2), 2sqrt(2)") || string.equals("2sqrt(2), sqrt(2)")){
            return true;
        }else{
            return false;
        }
    }
}
