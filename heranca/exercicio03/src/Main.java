
import java.util.ArrayList;

/**
 *
 * @author laboratorio
 */
public class Main {

    public static final int NUM = 1; 
    public static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
    
    public static void main(String[] args) {
        for (int i = 0; i < NUM; i++){
            UI.showMsg("Cadastre o " + (i+1) + "º funcionário", "Dados pessoais");
            
            String nome = UI.getInput("Informe o nome do funcionário", "Dados pessoais");
            int idade = UI.getInputInt("Informe a idade do funcionário", "Dados pessoais");
            String telefone = UI.getInput("Informe o telefone do funcionário", "Dados pessoais");
            
            Funcionario funcionario = new Funcionario(nome,idade,telefone);
            
            funcionario.setSetor(UI.getInput("Informe o setor de trabalho de "+ nome, "Dados profissionais ("+ nome +")"));
            funcionario.setCargo(UI.getInput("Informe o cargo de "+ nome +" no setor de "+ funcionario.getSetor(), "Dados profissionais ("+ nome +")"));
            funcionario.setFuncao(UI.getInput("Informe a função de " + nome + " no cargo de "+ funcionario.getCargo(), "Dados profissionais ("+ nome +")"));
            
            funcionarios.add(funcionario);
        }
        
        for(int i = 0; i < funcionarios.size(); i++){
            System.out.println(funcionarios.get(i).getInfo());
        }
    }
    
}
