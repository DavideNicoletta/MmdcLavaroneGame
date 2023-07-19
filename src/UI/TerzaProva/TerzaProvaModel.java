package UI.TerzaProva;

public class TerzaProvaModel {
    public TerzaProvaModel(){

    }

    public boolean checkOK(String string){
        String risposta = string.toLowerCase();
        if(risposta.equals("orologio")){
            return true;
        }else{
            return false;
        }
    }
}
