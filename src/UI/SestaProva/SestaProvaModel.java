package UI.SestaProva;

public class SestaProvaModel {
    public SestaProvaModel(){

    }

    public boolean checkOK(String string){
        if(string.toLowerCase().equals("o") || string.toLowerCase().equals("lettera o")){
            return true;
        }else{
            return false;
        }
    }
}
