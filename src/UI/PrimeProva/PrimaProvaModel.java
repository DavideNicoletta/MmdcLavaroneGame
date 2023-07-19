package UI.PrimeProva;

public class PrimaProvaModel {

    public PrimaProvaModel(){

    }

    public boolean checkRisposta(String string){
        String risposta = string.toLowerCase();
        if(risposta.equals("passero")){
            return true;
        }else{
            return false;
        }
    }

}
