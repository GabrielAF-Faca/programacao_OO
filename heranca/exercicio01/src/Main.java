


public class Main extends Usuario{

    public static void main(String[] args) {
        nome = UI.getValue("Infome seu nome:");
        email = UI.getValue("Informe seu e-mail:");
        telefone = UI.getValue("Informe seu telefone:");
        
        UI.showMsg("Nome: " + nome + "\nE-mail: " + email + "\nTelefone: " + telefone);
    }
    
}
