package UI.PrimeProva;

public class PrimaProvaModel {

    public PrimaProvaModel(){

    }

    public boolean checkRisposta(String string){
        String risposta = string.toLowerCase();
        return risposta.contains("passero");
    }

}
