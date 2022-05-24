/**
 *
 * @author laboratorio
 */
public class Funcionario extends Pessoa{
    protected static String setor, cargo, funcao;
    
    public Funcionario(String nome, int idade, String telefone){
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
    }

    public static String getSetor() {
        return setor;
    }

    public static void setSetor(String setor) {
        Funcionario.setor = setor;
    }

    public static String getCargo() {
        return cargo;
    }

    public static void setCargo(String cargo) {
        Funcionario.cargo = cargo;
    }

    public static String getFuncao() {
        return funcao;
    }

    public static void setFuncao(String funcao) {
        Funcionario.funcao = funcao;
    }
    
    public static String getInfo(){
        String info = "Nome: " + nome + "\n";
        info += "Idade: " + idade + "\n";
        info += "Telefone: " + telefone + "\n";
        info += "Setor: " + getSetor() + "\n";
        info += "Cargo: " + getCargo() + "\n";
        info += "Função: " + getFuncao() + "\n";

        
        return info;
    }
    
}
