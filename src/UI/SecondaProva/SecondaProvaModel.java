package UI.SecondaProva;

public class SecondaProvaModel {
    public SecondaProvaModel(){

    }

    public boolean checkOk(String string){
        return string.toLowerCase().contains("2sqrt(2)") && string.toLowerCase().contains("sqrt(2)");
    }
}
